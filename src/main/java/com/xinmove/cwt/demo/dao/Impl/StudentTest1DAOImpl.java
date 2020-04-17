package com.xinmove.cwt.demo.dao.Impl;

import com.xinmove.cwt.demo.dao.StudentTest1DAO;
import com.xinmove.cwt.demo.entry.Student;
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
public class StudentTest1DAOImpl implements StudentTest1DAO {
    private static Logger log = LogManager.getLogger(StudentTest1DAOImpl.class);

    @Autowired
    @Qualifier(value = "test1MongoTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public int add(Student t) {
        mongoTemplate.insert(t);
        return 1;
    }

    @Override
    public int add(List<Student> list) {
        mongoTemplate.insertAll(list);
        return 1;
    }

    @Override
    public int delete(Student t) {
        mongoTemplate.remove(t);
        return 1;
    }

    @Override
    public Student update(Student t) {
        return mongoTemplate.save(t);
    }

    @Override
    public Student findOne(String id) {
        return mongoTemplate.findById(id, Student.class);
    }

    @Override
    public List<Student> find(Query query) {
        return mongoTemplate.find(query, Student.class);
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, Student.class);
    }

    @Override
    public Student findOne(Query query) {
        return mongoTemplate.findOne(query, Student.class);
    }

    @Override
    public int update(Query query, Update update) {
        mongoTemplate.updateMulti(query, update, Student.class);
        return 1;
    }

    @Override
    public int delete(Query query) {
        return (int)mongoTemplate.remove(query, Student.class).getDeletedCount();
    }
}
