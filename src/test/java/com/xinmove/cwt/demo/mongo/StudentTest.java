package com.xinmove.cwt.demo.mongo;

import com.xinmove.cwt.demo.SpringBootMongosDemoApplicationTests;
import com.xinmove.cwt.demo.dao.StudentTest1DAO;
import com.xinmove.cwt.demo.dao.StudentTest23DAO;
import com.xinmove.cwt.demo.entry.Student;
import com.xinmove.cwt.demo.entry.StudentTest2;
import com.xinmove.cwt.demo.entry.StudentTest3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: CWT
 * @Date: 2020/4/1 18:22
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest{

    @Resource
    StudentTest1DAO studentTest1DAO;
    @Resource
    StudentTest23DAO studentTest23DAO;



    @Test
    public void test1T(){

        Student student = new Student();
        student.setId("7");
        student.setName("测试同学");
        student.setLevel("A");
        try {
            studentTest1DAO.add(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2T(){

        StudentTest2 student = new StudentTest2();
        student.setId("22");
        student.setName("测试同学");
        student.setLevel("A");
        try {
            studentTest23DAO.add2(student);
            studentTest23DAO.add2to3(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3T(){

        StudentTest3 student = new StudentTest3();
        student.setId("33");
        student.setName("测试同学");
        student.setLevel("A");
        try {
            studentTest23DAO.add3(student);
            studentTest23DAO.add3to2(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind(){
        studentTest1DAO.find(new Query()).forEach(System.out::println);
    }
}
