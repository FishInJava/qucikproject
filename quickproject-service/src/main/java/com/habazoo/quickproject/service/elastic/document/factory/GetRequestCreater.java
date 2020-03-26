package com.habazoo.quickproject.service.elastic.document.factory;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.index.VersionType;

/**
 * @author hbz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月26日 14:41:00
 */
public class GetRequestCreater {

    private GetRequestCreater(){}

    public static GetRequestCreater.GetRequestCreaterBuilder prepare(String index, String type, String documentID){
        return new GetRequestCreater.GetRequestCreaterBuilder(index,type,documentID);
    }

    public static class GetRequestCreaterBuilder{
        private GetRequest getRequest = null;

        public GetRequestCreaterBuilder(String index, String type, String documentID) {
            this.getRequest = new GetRequest(index,type,documentID);
        }

        public GetRequest creat(){
            return this.getRequest;
        }

        //todo
        public GetRequestCreater.GetRequestCreaterBuilder fetchSourceContext(){
            return this;
        }

        public GetRequestCreater.GetRequestCreaterBuilder routing(String routing){
            getRequest.routing(routing);
            return this;
        }

        public GetRequestCreater.GetRequestCreaterBuilder parent(String parent){
            getRequest.parent(parent);
            return this;
        }
        //todo
        public GetRequestCreater.GetRequestCreaterBuilder preference(){
            return this;
        }
        //todo
        public GetRequestCreater.GetRequestCreaterBuilder realtime(){
            return this;
        }
        //todo
        public GetRequestCreater.GetRequestCreaterBuilder refresh(){
            return this;
        }


        public GetRequestCreater.GetRequestCreaterBuilder version(long version, VersionType versionType){
            getRequest.version(version);
            getRequest.versionType(versionType);
            return this;
        }





    }
}
