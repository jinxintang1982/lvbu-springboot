package com.sanguo.test.springboot

import com.sanguo.srpingboot.Application
import com.sanguo.srpingboot.configuration.TypeConfigJava
import com.sanguo.srpingboot.configuration.TypeKotlinComplex
import com.sanguo.srpingboot.configuration.TypeProperties
import com.sanguo.srpingboot.entity.Robot
import com.sanguo.srpingboot.entity.Zone
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class TestKotlinConfig {
    @Autowired
    lateinit var typeConfig: TypeProperties

    @Autowired
    lateinit var typeConfigJava: TypeConfigJava

    @Autowired
    internal var typeKotlinComplex: TypeKotlinComplex? = null

    @Test
    fun testComplex(){
        System.out.println("------" + typeKotlinComplex!!.sex)
    }

    @Test
    fun testString() {
        System.out.println("-------$typeConfig.serverHost")
    }

    @Test
    fun testList() {
        typeConfig.wareHouseIds!!.forEach {
            System.out.println("------- $it")
        }
    }

    @Test
    fun testMap() {
        typeConfig.zoneInfo!!.values.forEach {
            System.out.println("-------" +it.zoneId)
        }
    }

    @Test
    fun testListRobot() {
        typeConfig.robotInfo!!.forEach{
            System.out.println("-------" +it.zoneId)
        }
    }

    @Test
    fun testFlows(){
        typeConfig.flows!!.forEach {
            System.out.println(it.key + it.value.size)
        }
    }

}
