package com.zhang.zc.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.bean
 * @date:2021/1/26
 */
@Data
public class Permission {

    private Integer id;
    private Integer pid;
    private String name;
    private String url;
    private String icon;
    private Boolean checked=false;
    private Boolean open=true;
    private List<Permission> children=new ArrayList<Permission>();
}
