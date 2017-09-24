package com.poem.lld.dao.test;

import java.io.IOException;

import org.junit.Test;

import com.poem.lld.dao.PoemDao;
import com.poem.lld.model.Poem;

import junit.framework.Assert;

public class PoemDaoTest {
    @Test
    public void testQueryById() throws IOException {
        PoemDao dao = new PoemDao();
        Poem poem = dao.getPoemById(1001);
        Assert.assertNotNull(poem);
        System.out.println(poem.toString());
    }

    @Test
    public void testInsertPoem() throws IOException {
        PoemDao dao = new PoemDao();
        Poem poem = new Poem();
        poem.setTitle("�����ػ���");
        poem.setAlbum("a");
        poem.setAuthor("�Ÿ�");
        poem.setContent("Ұ������Ӫ�����������ǡ�������ն̣���������ƽ�����������������ս������ά����ǰ�֣���Хһ���顣");
        poem.setDynasty("�ƴ�");
        poem.setPublicDegree(45);
        poem.setType("ʫ");
        poem.setUrl("http://so.gushiwen.org/view_11543.aspx");
        int updatedCount = dao.insertPoem(poem);
        Assert.assertEquals(updatedCount, 1);
        System.out.println(poem.toString());
    }

    @Test
    public void testDeletePoem() throws IOException {
        PoemDao dao = new PoemDao();
        int deleteCount = dao.deletePoem(3107);
        Assert.assertEquals(deleteCount, 1);
    }

    @Test
    public void testUpdatePoem() throws IOException {
        PoemDao dao = new PoemDao();
        Poem poem = dao.getPoemById(3106);
        poem.setTitle(poem.getTitle() + "A");
        poem.setAlbum(poem.getAlbum() + "A");
        poem.setAuthor(poem.getAuthor() + "A");
        poem.setContent(poem.getContent() + "A");
        poem.setDynasty(poem.getDynasty() + "A");
        poem.setPublicDegree(poem.getPublicDegree() + 100);
        poem.setType(poem.getType() + "A");
        poem.setUrl(poem.getUrl() + "A");
        int updatedCount = dao.updatePoem(poem);
        Assert.assertEquals(updatedCount, 1);
        Poem newPoem = dao.getPoemById(poem.getId());
        System.out.println(newPoem.toString());
    }
}
