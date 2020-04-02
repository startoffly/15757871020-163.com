package com.xinmove.cwt.demo.dao;

import com.xinmove.cwt.demo.entry.StudentTest2;
import com.xinmove.cwt.demo.entry.StudentTest3;

/**
 * @Auther: CWT
 * @Date: 2020/4/2 11:48
 * @Description:
 */
public interface StudentTest23DAO{
    int add2(StudentTest2 t) throws Exception;

    int add2to3(StudentTest2 t) throws Exception;

    int add3(StudentTest3 t) throws Exception;

    int add3to2(StudentTest3 t) throws Exception;
}
