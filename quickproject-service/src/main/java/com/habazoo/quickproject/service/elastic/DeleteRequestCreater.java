package com.habazoo.quickproject.service.elastic;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.VersionType;

/**
 * @author hbz
 * @version 1.0.0
 * @Description DeleteRequest工厂 + builder
 * @createTime 2020年03月26日 11:10:00
 */
public class DeleteRequestCreater {

    private DeleteRequestCreater(){}

    public static DeleteRequestCreater.DeleteRequestBuilder prepare(String index, String type, String documentID){
        return new DeleteRequestCreater.DeleteRequestBuilder(index,type,documentID);
    }

    public static class DeleteRequestBuilder{

        private DeleteRequest deleteRequest = null;

        public DeleteRequestBuilder(String index, String type, String documentID) {
            this.deleteRequest = new DeleteRequest(index,type,documentID);
        }

        public DeleteRequest creat(){
            return this.deleteRequest;
        }

        public DeleteRequestCreater.DeleteRequestBuilder routing(String routing){
            deleteRequest.routing(routing);
            return this;
        }

        public DeleteRequestCreater.DeleteRequestBuilder parent(String parent){
            deleteRequest.parent(parent);
            return this;
        }

        public DeleteRequestCreater.DeleteRequestBuilder timeout(TimeValue time){
            deleteRequest.timeout(time);
            return this;
        }

        public DeleteRequestCreater.DeleteRequestBuilder refreshPolicy(WriteRequest.RefreshPolicy policy){
            deleteRequest.setRefreshPolicy(policy);
            return this;
        }

        public DeleteRequestCreater.DeleteRequestBuilder version(long version, VersionType versionType){
            deleteRequest.version(version);
            deleteRequest.versionType(versionType);
            return this;
        }

    }

}
