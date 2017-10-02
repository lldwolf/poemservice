package com.poem.lld.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.poem.lld.mapper.PoemMapper;
import com.poem.lld.model.Poem;

import junit.framework.Assert;

public class PoemMapperTest {
    private static final Logger logger = LogManager.getLogger(PoemDaoTest.class);
    private PoemMapper poemMapper;

    @Before
    public void setup() throws IOException {
        logger.info("Start testing PoeMapper");
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        poemMapper = sqlSession.getMapper(PoemMapper.class);
    }

    @Test
    public void testQueryById() throws IOException {
        Poem poem = poemMapper.getPoemById(1001);
        Assert.assertNotNull(poem);
        System.out.println(poem.toString());
    }

    @Test
    public void testQueryByAuthor() throws IOException {
        List<Poem> poemList = poemMapper.findPoemByAuthor("苏轼");
        Assert.assertNotNull(poemList);

        System.out.println("result count: " + poemList.size());
        if (poemList.size() > 0) {
            poemList.forEach(poem -> {
                System.out.println(poem.getTitle());
            });
        }
    }

    @Test
    public void testInsertPoem() throws IOException {
        Poem poem = new Poem();
        poem.setTitle("公安县怀古");
        poem.setAlbum("a");
        poem.setAuthor("杜甫");
        poem.setContent("野旷吕蒙营，江深刘备城。寒天催日短，风浪与云平。洒落君臣契，飞腾战伐名。维舟倚前浦，长啸一含情。");
        poem.setDynasty("唐代");
        poem.setPublicDegree(45);
        poem.setType("诗");
        poem.setUrl("http://so.gushiwen.org/view_11543.aspx");
        int updatedCount = poemMapper.insertPoem(poem);
        Assert.assertEquals(updatedCount, 1);
        System.out.println(poem.toString());

        poem.setTitle(poem.getTitle() + "A");
        poem.setAlbum(poem.getAlbum() + "A");
        poem.setAuthor(poem.getAuthor() + "A");
        poem.setContent(poem.getContent() + "A");
        poem.setDynasty(poem.getDynasty() + "A");
        poem.setPublicDegree(poem.getPublicDegree() + 100);
        poem.setType(poem.getType() + "A");
        poem.setUrl(poem.getUrl() + "A");
        updatedCount = poemMapper.updatePoem(poem);
        Assert.assertEquals(updatedCount, 1);
        Poem newPoem = poemMapper.getPoemById(poem.getId());
        System.out.println(newPoem.toString());

        System.out.println("Delete inserted poem");
        int deleteCount = poemMapper.deletePoem(poem.getId());
        Assert.assertEquals(deleteCount, 1);
        System.out.println(poem.getId() + " is deleted.");
    }

    // @Test
    // public void testDeletePoem() throws IOException {
    // PoemDao dao = new PoemDao();
    // int deleteCount = dao.deletePoem(3107);
    // Assert.assertEquals(deleteCount, 1);
    // }

    // @Test
    // public void testUpdatePoem() throws IOException {
    // PoemDao dao = new PoemDao();
    // Poem poem = dao.getPoemById(3106);
    // poem.setTitle(poem.getTitle() + "A");
    // poem.setAlbum(poem.getAlbum() + "A");
    // poem.setAuthor(poem.getAuthor() + "A");
    // poem.setContent(poem.getContent() + "A");
    // poem.setDynasty(poem.getDynasty() + "A");
    // poem.setPublicDegree(poem.getPublicDegree() + 100);
    // poem.setType(poem.getType() + "A");
    // poem.setUrl(poem.getUrl() + "A");
    // int updatedCount = dao.updatePoem(poem);
    // Assert.assertEquals(updatedCount, 1);
    // Poem newPoem = dao.getPoemById(poem.getId());
    // System.out.println(newPoem.toString());
    // }
}
