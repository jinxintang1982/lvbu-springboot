package com.sanguo.srpingboot.configuration


import com.sanguo.srpingboot.entity.Robot
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "complex")
class TypeKotlinComplex {
    var flows:HashMap<String,List<String>>? = null
    var wares:List<String>? = null
    var nodes:HashMap<String,List<Robot>>? = null
    var sex:Boolean = false
}