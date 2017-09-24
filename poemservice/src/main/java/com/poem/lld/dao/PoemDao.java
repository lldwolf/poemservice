package com.poem.lld.dao;

import java.io.IOException;

import com.poem.lld.model.Poem;

public class PoemDao extends BaseDao {

    // private static final Logger logger = LogManager.getLogger(PoemDao.class);

    public Poem getPoemById(int id) throws IOException {
        Poem poem = (Poem) queryById("poem.findPoemById", id);
        return poem;
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
