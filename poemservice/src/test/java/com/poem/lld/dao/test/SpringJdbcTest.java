package com.poem.lld.dao.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.poem.lld.mapper.PoemMapper;
import com.poem.lld.model.Poem;

public class SpringJdbcTest {

    private static final Logger logger = LogManager.getLogger(PoemDaoTest.class);
    
    @Test
    public void firstTest() throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PoemMapper poemDao = (PoemMapper) ctx.getBean("poemDao");
        Poem poem = poemDao.getPoemById(1001);
        Assert.assertNotNull(poem);
        logger.info(poem.toString());
        ((ConfigurableApplicationContext) ctx).close();

    }
}
