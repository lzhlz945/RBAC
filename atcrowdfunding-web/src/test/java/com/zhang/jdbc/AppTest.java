package com.zhang.jdbc;

import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-context.xml");
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



}
