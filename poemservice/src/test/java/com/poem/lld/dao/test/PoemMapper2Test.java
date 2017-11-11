package com.poem.lld.dao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poem.lld.mapper.PoemMapper2;
import com.poem.lld.model.Poem;
import com.poem.lld.model.PoemExample;
import com.poem.lld.model.PoemExample.Criteria;

public class PoemMapper2Test {
    private static final Logger logger = LogManager.getLogger(PoemDaoTest.class);
    private SqlSessionFactory sqlSessionFactory;
    private PoemMapper2 poemMapper;

    @Before
    public void setup() throws IOException {
        logger.info("Start testing PoeMapper");
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        poemMapper = sqlSession.getMapper(PoemMapper2.class);
    }

    @Test
    public void testGetPoemById() {
        Poem poem = poemMapper.selectByPrimaryKey(1001);
        Assert.assertNotNull(poem);
        System.out.println(poem.toString());
    }

    @Test
    public void testQueryPoem() throws IOException {
        PoemExample filter = new PoemExample();
        filter.setDistinct(true);
        filter.setOrderByClause("author");
        Criteria criteria = filter.createCriteria();
        criteria.andDynastyEqualTo("唐代");
        criteria.andAuthorIn(Arrays.asList(new String[] { "李白", "杜甫", "李商隐", "杜牧" }));
        criteria.andContentLike("%月%");
        criteria.andContentLike("%花%");
        Criteria criteria2 = filter.or();
        criteria2.andDynastyEqualTo("宋代");
        criteria2.andAuthorIn(Arrays.asList(new String[] { "苏轼", "辛弃疾", "柳永" }));
        criteria2.andContentLike("%风%");
        criteria2.andContentLike("%雪%");
        List<Poem> poemList = poemMapper.selectByExample(filter);
        Assert.assertNotNull(poemList);

        System.out.println("result count: " + poemList.size());
        if (poemList.size() > 0) {
            poemList.forEach(poem -> {
                System.out.println(poem);
            });
        }
    }
    //
    // @Test
    // public void testSearchFullPoem() throws IOException {
    // PoemQueryCriteria filter = new PoemQueryCriteria();
    // filter.setAuthor("李");
    // filter.setContent("月");
    // filter.setTitle("月");
    // filter.setTypes(Arrays.asList(new String[] { "诗", "词" }));
    // List<Poem> poemList = poemMapper.searchFullPoem(filter);
    // Assert.assertNotNull(poemList);
    //
    // System.out.println("result count: " + poemList.size());
    // if (poemList.size() > 0) {
    // poemList.forEach(poem -> {
    // System.out.println(poem);
    // });
    // }
    // }
    //
    // @Test
    // public void testSearchAuthor() {
    // List<Author> authors = poemMapper.searchAuthor("刘");
    // Assert.assertNotNull(authors);
    // logger.debug("author count: " + authors.size());
    //
    // for (Author author : authors) {
    // System.out.println("*************************************************");
    // System.out.println(author.getName() + " (" + author.getDynasty() + ")");
    // System.out.println("Poems: " + author.getPoems().size());
    //
    // for (Poem poem : author.getPoems()) {
    // System.out.print(poem.getTitle() + ", ");
    // }
    //
    // System.out.println();
    // }
    // }
    //
    // @Test
    // public void testInsertPoem() throws IOException {
    // Poem poem = new Poem();
    // poem.setTitle("公安县怀古");
    // poem.setAlbum("a");
    // poem.setAuthor("杜甫");
    // poem.setContent("野旷吕蒙营，江深刘备城。寒天催日短，风浪与云平。洒落君臣契，飞腾战伐名。维舟倚前浦，长啸一含情。");
    // poem.setDynasty("唐代");
    // poem.setPublicDegree(45);
    // poem.setType("诗");
    // poem.setUrl("http://so.gushiwen.org/view_11543.aspx");
    // int updatedCount = poemMapper.insertPoem(poem);
    // Assert.assertEquals(updatedCount, 1);
    // System.out.println(poem.toString());
    //
    // poem.setTitle(poem.getTitle() + "A");
    // poem.setAlbum(poem.getAlbum() + "A");
    // poem.setAuthor(poem.getAuthor() + "A");
    // poem.setContent(poem.getContent() + "A");
    // poem.setDynasty(poem.getDynasty() + "A");
    // poem.setPublicDegree(poem.getPublicDegree() + 100);
    // poem.setType(poem.getType() + "A");
    // poem.setUrl(poem.getUrl() + "A");
    // updatedCount = poemMapper.updatePoem(poem);
    // Assert.assertEquals(updatedCount, 1);
    // Poem newPoem = poemMapper.getPoemById(poem.getId());
    // System.out.println(newPoem.toString());
    //
    // System.out.println("Delete inserted poem");
    // int deleteCount = poemMapper.deletePoem(poem.getId());
    // Assert.assertEquals(deleteCount, 1);
    // System.out.println(poem.getId() + " is deleted.");
    // }
    //
    // @Test
    // public void testGetPoemByIdLazy() {
    // Poem poem = poemMapper.getPoemByIdLazy(1001);
    // Assert.assertNotNull(poem);
    // System.out.println(poem.toString());
    // // System.out.println(poem.getAuthorEntity().toString());
    // }
    //
    // @Test
    // public void testCache() throws IOException {
    // SqlSession session1 = this.sqlSessionFactory.openSession();
    // PoemMapper mapper1 = session1.getMapper(PoemMapper.class);
    //
    // int poemId = 1001;
    // Poem poem1 = mapper1.getPoemById(poemId);
    // session1.close();
    // System.out.println("url1: " + poem1.getUrl());
    //
    // System.out.println("session 2");
    // SqlSession session2 = this.sqlSessionFactory.openSession();
    // PoemMapper mapper2 = session2.getMapper(PoemMapper.class);
    // Poem poem2 = mapper2.getPoemById(poemId);
    // poem2.setUrl(poem2.getUrl() + "A");
    // // poem2.setUrl("test.com");
    // mapper2.updatePoem(poem2);
    // session2.commit();
    // session2.close();
    // System.out.println("url2: " + poem2.getUrl());
    //
    // System.out.println("session 3");
    // SqlSession session3 = this.sqlSessionFactory.openSession();
    // PoemMapper mapper3 = session3.getMapper(PoemMapper.class);
    // Poem poem3 = mapper3.getPoemById(poemId);
    // System.out.println("url3: " + poem3.getUrl());
    // session3.close();
    // }
}
