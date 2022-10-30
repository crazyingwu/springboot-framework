package com.crazywu.dal.es.entity;

import lombok.Data;

@Data
public class CommonESDocument implements ESDocument{

    String id;
    @Override
    public String getId() {
        return id;
    }


}
