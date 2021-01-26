package com.zhang.zc.test;


import com.zhang.zc.bean.User;
import com.zhang.zc.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.UUID;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.ssm.test
 * @date:2021/1/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestCrud {

    @Autowired
    private UserMapper employeeMapper;

    @Autowired
    private SqlSession sqlSession;




    //批量插入

    /**
     *  <bean name="sessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" >
     *         <constructor-arg name="sqlSessionFactory" ref="factory"/>
     *         <constructor-arg name="executorType" value="BATCH"/>
     *     </bean>
     */
    @Test
    public void test03(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 200; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            User user = new User();
            user.setPassword(uuid+i);
            user.setUsername("test");
            user.setEmail("test"+i+"@qq.com");
            user.setUserAccount(uuid);
            mapper.insert(user);
        }

    }


    /**
     *
     * 模拟mvc请求测试
     */


}
