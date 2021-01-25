package com.zhang.zc.service.impl;

import com.zhang.zc.bean.Urid;
import com.zhang.zc.dao.UridMapper;
import com.zhang.zc.service.UridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.zc.service.impl
 * @date:2021/1/25
 */

@Service
public class UridServiceImpl implements UridService {

    @Autowired
    private UridMapper uridMapper;

}
