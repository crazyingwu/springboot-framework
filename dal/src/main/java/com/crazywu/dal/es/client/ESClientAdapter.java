package com.crazywu.dal.es.client;

import com.alibaba.fastjson.JSONObject;
import com.crazywu.dal.es.entity.CommonESDocument;
import com.crazywu.dal.es.entity.ESDocument;
import com.crazywu.dal.es.entity.ESQueryResult;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class ESClientAdapter {
    Logger logger = LoggerFactory.getLogger(ESClientAdapter.class);

    private final RequestOptions options = RequestOptions.DEFAULT;

    @Resource
    private RestHighLevelClient restHighLevelClient;


    public boolean addDocument(String index, ESDocument document) {
        try {
            IndexRequest request = new IndexRequest(index).id(document.getId())
                    .opType(DocWriteRequest.OpType.INDEX).source(JSONObject.toJSONString(document), XContentType.JSON);
            IndexResponse response = restHighLevelClient.index(request, options);
            return response.getResult().getOp() == DocWriteResponse.Result.CREATED.getOp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ESQueryResult search(SearchRequest searchRequest) {
        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest, options);
            ESQueryResult queryResult = new ESQueryResult();
            parseSearchHits(response.getHits(), queryResult);
            return queryResult;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void parseSearchHits(SearchHits hits, ESQueryResult queryResult) {
        if (hits.getTotalHits().value == 0) {
            return;
        }
        queryResult.setTotal((int) hits.getTotalHits().value);
        hits.forEach(hit -> {
            CommonESDocument document = new CommonESDocument();
            document.setId(hit.getId());
            queryResult.addDocument(document);
        });
    }

    public boolean deleteDocument(String index, String id) {
        try {
            IndexRequest request = new IndexRequest(index).id(id)
                    .opType(DocWriteRequest.OpType.DELETE);
            IndexResponse response = restHighLevelClient.index(request, options);
            return response.getResult().getOp() == DocWriteResponse.Result.DELETED.getOp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exitDocument(String index, String id) {
        try {
            GetRequest request = new GetRequest(index, id);
            return restHighLevelClient.exists(request, options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
