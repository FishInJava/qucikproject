package com.habazoo.quickproject.service.elastic.api;

import com.habazoo.quickproject.service.elastic.IndexRequestCreater;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author hbz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月25日 16:24:00
 */
@Service
public class IndexAPI {

    /**
     * IndexAPI = 新增/修改操作
     * 注意可选操作的默认值
     * 执行：
     * elasticClient.index 同步
     * elasticClient.indexAsync 异步
     */
    @Autowired
    public RestHighLevelClient elasticClient;

    public IndexResponse insert(String index, String type, String documentID, String jsonData){
        IndexRequest creat = IndexRequestCreater.prepare(index, type, documentID)
                .data(jsonData).creat();
        return null;
    }

    public IndexResponse insert(IndexRequest indexRequest, String jsonData){
        indexRequest.source(jsonData, XContentType.JSON);
        return null;
    }

    public IndexResponse insert(String index,String type,String documentID,Map<String,Object> data){
        IndexRequest request = new IndexRequest(index, type, documentID);
        request.source(data, XContentType.JSON);
        return null;
    }

    public IndexResponse insert(IndexRequest indexRequest, Map<String,Object> data){
        indexRequest.source(data);
        return null;
    }

}
