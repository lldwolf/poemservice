package com.poem.lld.dao.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.poem.lld.dao.IPoemDao;
import com.poem.lld.dao.PoemDao;
import com.poem.lld.model.Poem;

public class PoemDaoTest {
    // private static final Logger logger = LogManager.getLogger(PoemDaoTest.class);

    @Test
    public void testQueryById() throws IOException {
        IPoemDao dao = new PoemDao();
        Poem poem = dao.getPoemById(1001);
        Assert.assertNotNull(poem);
        System.out.println(poem.toString());
    }

    @Test
    public void testQueryByAuthor() throws IOException {
        IPoemDao dao = new PoemDao();
        List<Poem> poemList = dao.findPoemByAuthor("苏轼");
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
        IPoemDao dao = new PoemDao();
        Poem poem = new Poem();
        poem.setTitle("公安县怀古");
        poem.setAlbum("a");
        poem.setAuthor("杜甫");
        poem.setContent("野旷吕蒙营，江深刘备城。寒天催日短，风浪与云平。洒落君臣契，飞腾战伐名。维舟倚前浦，长啸一含情。");
        poem.setDynasty("唐代");
        poem.setPublicDegree(45);
        poem.setType("诗");
        poem.setUrl("http://so.gushiwen.org/view_11543.aspx");
        int updatedCount = dao.insertPoem(poem);
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
        updatedCount = dao.updatePoem(poem);
        Assert.assertEquals(updatedCount, 1);
        Poem newPoem = dao.getPoemById(poem.getId());
        System.out.println(newPoem.toString());

        System.out.println("Delete inserted poem");
        int deleteCount = dao.deletePoem(poem.getId());
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
