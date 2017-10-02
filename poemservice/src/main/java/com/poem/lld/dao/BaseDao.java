package com.poem.lld.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseDao {
    private static final Logger logger = LogManager.getLogger(BaseDao.class);
    private SqlSessionFactory sqlSessionFactory;

    public BaseDao() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    public BaseDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    protected Object queryById(String sqlMapId, int id) {
        logger.debug("[" + sqlMapId + "] query by id: " + id);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object queryResult = sqlSession.selectOne(sqlMapId, id);
        sqlSession.close();
        return queryResult;
    }

    protected List<Object> queryByName(String sqlMapId, String name) {
        logger.debug("[" + sqlMapId + "] query by name: " + name);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> queryResult = sqlSession.selectList(sqlMapId, name);
        sqlSession.close();
        return queryResult;
    }

    protected int insert(String sqlMapId, Object newObj) {
        if (newObj != null) {
            logger.debug("[" + sqlMapId + "] new object: " + newObj.toString());
        } else {
            throw new IllegalArgumentException("Argument is null!");
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();
        int updatedCount = sqlSession.insert(sqlMapId, newObj);
        logger.debug("updated count: " + updatedCount);
        sqlSession.commit();
        sqlSession.close();

        return updatedCount;
    }

    protected int deleteById(String sqlMapId, int id) {
        logger.debug("[" + sqlMapId + "] delete by id: " + id);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int deleteCount = sqlSession.delete(sqlMapId, id);
        sqlSession.commit();
        sqlSession.close();
        return deleteCount;
    }

    protected int update(String sqlMapId, Object updatedObj) {
        if (updatedObj != null) {
            logger.debug("[" + sqlMapId + "] new object: " + updatedObj.toString());
        } else {
            throw new IllegalArgumentException("Argument is null!");
        }

        SqlSession sqlSession = sqlSessionFactory.openSession();
        int updatedCount = sqlSession.update(sqlMapId, updatedObj);
        logger.debug("updated count: " + updatedCount);
        sqlSession.commit();
        sqlSession.close();

        return updatedCount;
    }

}
