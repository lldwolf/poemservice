package com.poem.lld.mapper;

import java.util.List;

import com.poem.lld.model.Poem;

public interface PoemMapper {
    Poem getPoemById(int id);

    List<Poem> findPoemByAuthor(String author);

    int insertPoem(Poem poem);

    int updatePoem(Poem poem);

    int deletePoem(int id);
}
