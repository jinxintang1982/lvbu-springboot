package com.sanguo.springboot.elasticsearch.controller;


import com.sanguo.springboot.elasticsearch.entity.GoodsInfo;
import com.sanguo.springboot.elasticsearch.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private GoodsRepository goodsRepository;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(){
        GoodsInfo goodsInfo = new GoodsInfo(1L,
                "good1"+System.currentTimeMillis(),"this is a good");
        goodsRepository.save(goodsInfo);
        return "success";
    }

    @GetMapping("getOne")
    public String getOne(long id){
        //GoodsInfo goodsInfo = goodsRepository.findOne(id);
        //return goodsInfo;
        return "aaa";
    }


//    不使用SpringBoot整合包
//    @GetMapping("save")
//    public String save() throws Exception {
//        ElasticsearchUnit es = new ElasticsearchUnit();
//        es.getClient();
//        es.createIndex_blog();
//        return "success";
//    }
}
