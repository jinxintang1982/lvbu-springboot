package sanguo.zhaoyun.shortcut.customer;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 设置参数校验 spring 配置
 *
 * @company: MEGVII
 * @author: tushiguang
 * @create: 2022/5/23 16:42
 **/
@Configuration
public class ValidatorSpringConfig {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @Bean
    public Validator validator() {
        // 配置hibernate Validator为快速失败返回模式
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true).buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
