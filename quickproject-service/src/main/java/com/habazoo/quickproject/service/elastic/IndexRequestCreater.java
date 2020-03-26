package com.habazoo.quickproject.service.elastic;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.VersionType;

import java.util.Map;

/**
 * @author hbz
 * @version 1.0.0
 * @Description IndexRequest工厂 + builder
 * @createTime 2020年03月25日 17:05:00F
 */
public class IndexRequestCreater {
    /**
     * *自动创建index
     * The index operation automatically creates an index if it does not already exist
     * *文档id不存在的情况下才会put
     * put-if-absent（op_type = create）
     * *乐观并发控制：document会有一个版本号
     * Optimistic concurrency control
     * *id自动生成
     * id generated automatically
     * *明确分片：可以对分片命名，插入的时候可以带routing="name"来指明插入分片，默认使用hash（id）来选片
     * explicit routing
     * *有主分片和复制分片（健壮）
     * primary shard 和 replicas
     * *可设置超时时间（响应）
     * *版本号：每个document都有一个版本号，在使用IndexAPI时，用户可以给定版本号，版本号必须是long
     * version_type=external，version="xxx"，数据库中的version > xxx才能更新成功
     * version_type=internal，version="xxx"，数据库中的version = xxx才能更新成功
     * version_type=external_gte，version="xxx"，数据库中的version >= xxx才能更新成功
     * *设置refresh，可控制增，删，改，批量操作后的可见性
     * The Index, Update, Delete, and Bulk APIs support setting refresh
     * to control when changes made by this request are made visible to search.
     * false（默认）：该操作执行完成，并成功响应后，修改后的内容在某个时间点才对外可见
     * true：执行后立马对外可见（还未响应成功）---一般这种会主动调用刷新操作，比较耗费cpu
     * wait_for:该操作执行中（还未响应成功），es刷新后（刷新线程1s执行一次），修改后的内容对外可见
     *
     * Wait For Active Shards？？
     * Noop Updates？？
     */

    private IndexRequestCreater(){}

    public static IndexRequestBuilder prepare(String index, String type, String documentID){
        return new IndexRequestCreater.IndexRequestBuilder(index,type,documentID);
    }

    public static IndexRequestBuilder prepare(String index, String type){
        return new IndexRequestCreater.IndexRequestBuilder(index,type);
    }

    public static class IndexRequestBuilder{

        private IndexRequest indexRequest = null;

        public IndexRequestBuilder(String index,String type,String documentID){
            this.indexRequest = new IndexRequest(index,type,documentID);
        }

        public IndexRequestBuilder(String index,String type){
            this.indexRequest = new IndexRequest(index,type);
        }

        public IndexRequest creat(){
            return this.indexRequest;
        }

        public IndexRequestBuilder data(String jsonStr){
            this.indexRequest.source(jsonStr);
            return this;
        }

        public IndexRequestBuilder data(Map<String,Object> data){
            this.indexRequest.source(data);
            return this;
        }

        public IndexRequestBuilder data(XContentBuilder builder){
            this.indexRequest.source(builder);
            return this;
        }

        public IndexRequestBuilder routing(String routing){
            indexRequest.routing(routing);
            return this;
        }

        //？
        public IndexRequestBuilder parent(String parent){
            indexRequest.parent(parent);
            return this;
        }

        /**
         * Timeout to wait for primary shard to become available
         * TimeValue.timeValueSeconds(1);
         * TimeValue.timeValueMinutes(1);
         * @param time
         * @return
         */
        public IndexRequestBuilder timeout(TimeValue time){
            indexRequest.timeout(time);
            return this;
        }

        /**
         * WriteRequest.RefreshPolicy.WAIT_UNTIL
         * WriteRequest.RefreshPolicy.IMMEDIATE
         * WriteRequest.RefreshPolicy.NONE
         * @param policy
         * @return
         */
        public IndexRequestBuilder refreshPolicy(WriteRequest.RefreshPolicy policy){
            indexRequest.setRefreshPolicy(policy);
            return this;
        }

        public IndexRequestBuilder version(long version,VersionType versionType){
            indexRequest.version(version);
            indexRequest.versionType(versionType);
            return this;
        }

        /**
         * op_type = DocWriteRequest.OpType.CREATE时，
         * 如果插入数据的id存在，则操作失败
         * @param oftype
         * @return
         */
        public IndexRequestBuilder opType(DocWriteRequest.OpType oftype){
            indexRequest.opType(oftype);
            return this;
        }

        /**
         * The name of the ingest pipeline to be executed before indexing the document
         * @param pipeline
         * @return
         */
        public IndexRequestBuilder setPipeline(String pipeline){
            indexRequest.setPipeline(pipeline);
            return this;
        }
    }

}
