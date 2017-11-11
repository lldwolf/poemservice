package com.poem.lld.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.poem.lld.model.Poem;

public class PoemDao extends BaseDao implements IPoemDao {

    // private static final Logger logger = LogManager.getLogger(PoemDao.class);
    
    public PoemDao() throws IOException
    {
        super();
    }
    
    public PoemDao(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    /* (non-Javadoc)
     * @see com.poem.lld.dao.IPoemDao#getPoemById(int)
     */
    @Override
    public Poem getPoemById(int id) throws IOException {
        Poem poem = (Poem) queryById("poem.findPoemById", id);
        return poem;
    }
    
    /* (non-Javadoc)
     * @see com.poem.lld.dao.IPoemDao#findPoemByAuthor(java.lang.String)
     */
    @Override
    public List<Poem> findPoemByAuthor(String author) {
        List<Poem> poemList = new ArrayList<Poem>();
        List<Object> queryResult = queryByName("findPoemByAuthor", author);
        queryResult.forEach((item) -> {
            poemList.add((Poem)item);
        });
        return poemList;
    }

    /* (non-Javadoc)
     * @see com.poem.lld.dao.IPoemDao#insertPoem(com.poem.lld.model.Poem)
     */
    @Override
    public int insertPoem(Poem poem) {
        return insert("poem.insertPoem", poem);
    }

    /* (non-Javadoc)
     * @see com.poem.lld.dao.IPoemDao#updatePoem(com.poem.lld.model.Poem)
     */
    @Override
    public int updatePoem(Poem poem) {
        return insert("poem.updatePoem", poem);
    }

    /* (non-Javadoc)
     * @see com.poem.lld.dao.IPoemDao#deletePoem(int)
     */
    @Override
    public int deletePoem(int id) {
        return deleteById("poem.deletePoem", id);
    }

}
