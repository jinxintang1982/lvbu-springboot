package com.sanguo.srpingboot.configuration

import com.sanguo.srpingboot.entity.Robot
import com.sanguo.srpingboot.entity.Zone
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "megvii")
class TypeProperties{
    var serverHost :String? = null
    var wareHouseIds:List<String>? = null
    var zoneInfo:Map<String, Zone>? = null
    var robotInfo:List<Robot>? = null
    var flows:Map<String,List<String>>? = null
}