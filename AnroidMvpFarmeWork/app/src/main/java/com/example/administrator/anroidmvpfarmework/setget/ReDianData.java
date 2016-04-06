package com.example.administrator.anroidmvpfarmework.setget;

import java.io.Serializable;

/**
 * 作者：LiShiChuang on 2016/2/20 13:57
 * 邮箱：lschuang@126.com
 */
public class ReDianData implements Serializable {
    String id;
    String keyword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ReDianData(String id, String keyword) {
        this.id = id;
        this.keyword = keyword;
    }
    public ReDianData(){}
}
