package com.habazoo.quickproject.service.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hbz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月25日 15:18:00
 */
@Configuration
public class EsConfig {

    @Bean
   public RestHighLevelClient elasticsearchClient() {
        //第一种写法
        return new RestHighLevelClient(RestClient.builder(new HttpHost("115.159.200.13", 9200, "http")));
        /**
         * 第二种写法,依赖依赖
         * <dependency>
         *        <groupId>org.springframework.boot</groupId>
         *        <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
         * </dependency>
         *  ClientConfiguration configuration = ClientConfiguration.builder()
         *                 .connectedTo("115.159.200.13:9200")
         *                 .build();
         *  return RestClients.create(configuration).rest();
         */
    }

}
