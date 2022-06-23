package com.sanguo.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestForkCarry {

    public static RequestForkCarry creator(String missionType, String fromNode, String toNode) {
        RequestForkCarry result = new RequestForkCarry();
        result.missionrequest = new Missionrequest();
        result.missionrequest.missiontype = missionType;
        result.missionrequest.fromnode = fromNode;
        result.missionrequest.tonode = toNode;
        result.missionrequest.deadline = getCurrentTime();
        result.missionrequest.dispatchtime = getCurrentTime();
        return result;
    }

    private static String getCurrentTime(){
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(new Date());
        data = data.replaceFirst(" ","T");
        data = data.replaceFirst(" ","Z");
        return  data;
    }

    public Missionrequest missionrequest;

    public static class Missionrequest {
        public String requestor = "admin";
        public String missiontype = "7";

        public String fromnode = "fo0";
        public String tonode = "to1";
        public String cardinality = "1";
        public Integer priority = 1;

        public String deadline;//可以将任务分配给车辆的绝对日期"2021-10-25T12:27:41.043Z"
        public String dispatchtime;//任务开始的绝对日期

        public Parameters parameters = new Parameters();
    }

    public static class Parameters {
        public Value value = new Value();
        public String desc = "Mission extension";
        public String type = "org.json.JSONObject";
        public String name = "parameters";
    }

    public static class Value {
        public String payload = "Pallet";
    }
}