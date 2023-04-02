package com.sanguo.springboot.subscribe;

import com.sanguo.springboot.domain.MqttProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

public class MqttConfig {

    private final MqttProperties prop;
    private final MqttInboundMessageHandler mqttInboundMessageHandler;

    public MqttConfig(MqttProperties prop,
                      MqttInboundMessageHandler mqttInboundMessageHandler) {
        this.prop = prop;
        this.mqttInboundMessageHandler = mqttInboundMessageHandler;
    }

    @Bean
    public MessageProducerSupport mqttInbound(MqttPahoClientFactory mqttClientFactory) {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(prop.getClientId() + "-sub-" , mqttClientFactory,
                        "facego/reply");
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInboundChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInboundChannel")
    public MessageHandler InboundMessageHandler() {
        return mqttInboundMessageHandler;
    }

    @Bean
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }

}
