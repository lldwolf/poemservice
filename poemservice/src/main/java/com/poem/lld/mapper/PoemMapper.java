package com.poem.lld.mapper;

import java.util.List;

import com.poem.lld.model.Poem;
import com.poem.lld.model.PoemQueryCriteria;

public interface PoemMapper {
    Poem getPoemById(int id);

    List<Poem> findPoemByAuthor(String author);
    
    List<Poem> queryPoem(PoemQueryCriteria filter);

    List<Poem> searchFullPoem(PoemQueryCriteria filter);

    int insertPoem(Poem poem);

    int updatePoem(Poem poem);

    int deletePoem(int id);
}
