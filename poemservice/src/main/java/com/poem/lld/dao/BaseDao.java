package com.poem.lld.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseDao {
    private static final Logger logger = LogManager.getLogger(BaseDao.class);
    private static SqlSession sqlSession;

    static {
        try {
            sqlSession = getSqlSession();
        } catch (IOException e) {
            logger.error("Failed get MyBatis Sql Session!", e);
        }
    }

    private static SqlSession getSqlSession() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;

        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

    protected Object queryById(String sqlMapId, int id) {
        logger.debug("[" + sqlMapId + "] query by id: " + id);
        Object queryResult = sqlSession.selectOne(sqlMapId, id);
        return queryResult;
    }

    protected int insert(String sqlMapId, Object newObj) {
        if (newObj != null) {
            logger.debug("[" + sqlMapId + "] new object: " + newObj.toString());
        } else {
            throw new IllegalArgumentException("Argument is null!");
        }

        int updatedCount = sqlSession.insert(sqlMapId, newObj);
        logger.debug("updated count: " + updatedCount);
        sqlSession.commit();

        return updatedCount;
    }

    protected int deleteById(String sqlMapId, int id) {
        logger.debug("[" + sqlMapId + "] delete by id: " + id);
        int deleteCount = sqlSession.delete(sqlMapId, id);
        sqlSession.commit();
        return deleteCount;
    }

    protected int update(String sqlMapId, Object updatedObj) {
        if (updatedObj != null) {
            logger.debug("[" + sqlMapId + "] new object: " + updatedObj.toString());
        } else {
            throw new IllegalArgumentException("Argument is null!");
        }

        int updatedCount = sqlSession.update(sqlMapId, updatedObj);
        logger.debug("updated count: " + updatedCount);
        sqlSession.commit();

        return updatedCount;
    }

}
