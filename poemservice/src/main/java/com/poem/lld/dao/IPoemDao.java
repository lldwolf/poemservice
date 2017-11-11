package com.poem.lld.dao;

import java.io.IOException;
import java.util.List;

import com.poem.lld.model.Poem;

public interface IPoemDao {

    Poem getPoemById(int id) throws IOException;

    List<Poem> findPoemByAuthor(String author);

    int insertPoem(Poem poem);

    int updatePoem(Poem poem);

    int deletePoem(int id);

}