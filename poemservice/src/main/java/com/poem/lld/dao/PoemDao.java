package com.poem.lld.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.poem.lld.model.Poem;

public class PoemDao extends BaseDao {

    // private static final Logger logger = LogManager.getLogger(PoemDao.class);
    
    public PoemDao() throws IOException
    {
        super();
    }
    
    public PoemDao(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    public Poem getPoemById(int id) throws IOException {
        Poem poem = (Poem) queryById("poem.findPoemById", id);
        return poem;
    }
    
    public List<Poem> findPoemByAuthor(String author) {
        List<Poem> poemList = new ArrayList<Poem>();
        List<Object> queryResult = queryByName("findPoemByAuthor", author);
        queryResult.forEach((item) -> {
            poemList.add((Poem)item);
        });
        return poemList;
    }

    public int insertPoem(Poem poem) {
        return insert("poem.insertPoem", poem);
    }

    public int updatePoem(Poem poem) {
        return insert("poem.updatePoem", poem);
    }

    public int deletePoem(int id) {
        return deleteById("poem.deletePoem", id);
    }

}
