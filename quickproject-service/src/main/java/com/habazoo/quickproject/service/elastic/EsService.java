package com.habazoo.quickproject.service.elastic;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hbz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月25日 15:51:00
 */
@Service
public class EsService {

    @Autowired
    RestHighLevelClient elasticClient;

    /**
     * 增：
     * 增加一个index
     * 增加一条数据
     * Bulk增
     */
    public void add(){

    }

    /**
     * 删：
     * 删除整个索引
     * 删除索引中一条数据
     * 删除满足条件的多条数据
     * Bulk删
     */

    /**
     * 改：
     * 修改一条数据
     * Bulk改
     * 修改多条满足条件的数据
     */

    /**
     * 查询
     * 很复杂，这块api要好好设计下
     */


}
