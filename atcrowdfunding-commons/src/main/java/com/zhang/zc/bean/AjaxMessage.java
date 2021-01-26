package com.zhang.zc.bean;

import lombok.Data;

@Data
public class AjaxMessage {

    private Boolean success;
    private Object data;
    private Integer count;
}
