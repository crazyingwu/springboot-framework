package com.crazywu.dal.es.entity;

import lombok.Data;

import java.util.List;

@Data
public class ESQueryResult {

    private Integer total;

    private List<ESDocument> documents;

    public void addDocument(ESDocument document) {
        documents.add(document);
    }

}
