package com.habazoo.quickproject.service.elastic.document.factory;

import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.VersionType;

/**
 * @author hbz
 * @version 1.0.0
 * @Description UpdateRequest工厂 + builder
 * @createTime 2020年03月26日 12:09:00
 */
public class UpdateRequestCreater {

    private UpdateRequestCreater(){}

    public static UpdateRequestCreater.UpdateRequestBuilder prepare(String index, String type, String documentID){
        return new UpdateRequestCreater.UpdateRequestBuilder(index,type,documentID);
    }

    public static class UpdateRequestBuilder{

        private UpdateRequest updateRequest = null;

        public UpdateRequestBuilder(String index,String type,String documentID){
            this.updateRequest = new UpdateRequest(index,type,documentID);
        }

        public UpdateRequest creat(){
            return this.updateRequest;
        }

        public UpdateRequestCreater.UpdateRequestBuilder routing(String routing){
            updateRequest.routing(routing);
            return this;
        }

        //？
        public UpdateRequestCreater.UpdateRequestBuilder parent(String parent){
            updateRequest.parent(parent);
            return this;
        }

        /**
         * Timeout to wait for primary shard to become available
         * TimeValue.timeValueSeconds(1);
         * TimeValue.timeValueMinutes(1);
         * @param time
         * @return
         */
        public UpdateRequestCreater.UpdateRequestBuilder timeout(TimeValue time){
            updateRequest.timeout(time);
            return this;
        }

        public UpdateRequestCreater.UpdateRequestBuilder refreshPolicy(WriteRequest.RefreshPolicy policy){
            updateRequest.setRefreshPolicy(policy);
            return this;
        }

        public UpdateRequestCreater.UpdateRequestBuilder version(long version, VersionType versionType){
            updateRequest.version(version);
            updateRequest.versionType(versionType);
            return this;
        }

        //？
        public UpdateRequestCreater.UpdateRequestBuilder retryOnConflict(int retryOnConflict){
            updateRequest.retryOnConflict(retryOnConflict);
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder retryOnConflict(){
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder fetchSource(){
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder detectNoop(){
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder scriptedUpsert(){
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder docAsUpsert(){
            return this;
        }
        //todo
        public UpdateRequestCreater.UpdateRequestBuilder waitForActiveShards(){
            return this;
        }



    }
}
