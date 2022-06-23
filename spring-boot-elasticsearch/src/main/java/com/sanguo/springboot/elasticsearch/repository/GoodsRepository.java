package com.sanguo.springboot.elasticsearch.repository;


import com.sanguo.springboot.elasticsearch.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {
}