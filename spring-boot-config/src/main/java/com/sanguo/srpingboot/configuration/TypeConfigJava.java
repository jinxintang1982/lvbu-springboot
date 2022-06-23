package com.sanguo.srpingboot.configuration;

import com.sanguo.srpingboot.entity.Robot;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "megvii.person")
public class TypeConfigJava {
    private HashMap<String, ArrayList<String>> flows;
    private ArrayList<Object> wares;
    private HashMap<String, ArrayList<Robot>> nodes;
    public HashMap<String, ArrayList<Robot>> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, ArrayList<Robot>> nodes) {
        this.nodes = nodes;
    }

    public HashMap<String, ArrayList<String>> getFlows() {
        return flows;
    }

    public void setFlows(HashMap<String, ArrayList<String>> flows) {
        this.flows = flows;
    }


    public ArrayList<Object> getWares() {
        return wares;
    }

    public void setWares(ArrayList<Object> wares) {
        this.wares = wares;
    }
}
