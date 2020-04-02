package com.xinmove.cwt.demo.dao.Impl;

import com.xinmove.cwt.demo.dao.StudentTest1DAO;
import com.xinmove.cwt.demo.dao.StudentTest23DAO;
import com.xinmove.cwt.demo.entry.Student;
import com.xinmove.cwt.demo.entry.StudentTest2;
import com.xinmove.cwt.demo.entry.StudentTest3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: CWT
 * @Date: 2020/4/2 11:50
 * @Description:
 */
@Component
public class StudentTest23DAOImpl implements StudentTest23DAO {
    private static Logger log = LogManager.getLogger(StudentTest23DAOImpl.class);

    @Autowired
    @Qualifier(value = "test2MongoTemplate")
    private MongoTemplate test2MongoTemplate;

    @Autowired
    @Qualifier(value = "test3MongoTemplate")
    private MongoTemplate test3MongoTemplate;

    @Override
    public int add2(StudentTest2 t) throws Exception {
        test2MongoTemplate.insert(t);
        return 1;
    }

    @Override
    public int add2to3(StudentTest2 t) throws Exception {
        test3MongoTemplate.insert(t);
        return 1;
    }

    @Override
    public int add3(StudentTest3 t) throws Exception {
        test3MongoTemplate.insert(t);
        return 1;
    }
    @Override
    public int add3to2(StudentTest3 t) throws Exception {
        test2MongoTemplate.insert(t);
        return 1;
    }



}
