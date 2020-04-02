package com.xinmove.cwt.demo.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface BaseMongoDAO<T> {
	
	/**
	 * @Title: add 
	 * @Description: 添加数据 
	 * @param  t
	 * @param @return 设定文件 
	 * @return int 返回类型
	 */
	int add(T t) throws Exception;
	
	/**
	 * @Title: add 
	 * @Description:批量添加
	 * @param  list
	 * @param @return 设定文件 
	 * @return int 返回类型
	 */
	int add(List<T> list) throws Exception;
	
	/**
	 * @Title: delete 
	 * @Description: 删除数据 
	 * @param  t
	 * @param @return 设定文件 
	 * @return int 返回类型
	 */
	int delete(T t) throws Exception;
	
	/**
	 * @Title: update 
	 * @Description: 更新数据数据，并返回更新信息 
	 * @param  t
	 * @param @return 设定文件 
	 * @return int 返回类型
	 */
	T update(T t) throws Exception;
	
	/**
	 * @Title: update 
	 * @Description: 指定更新字段
	 * @param  query
	 * @param  update
	 * @param @return
	 * @param @throws ZhiWeiException 设定文件 
	 * @return int 返回类型
	 */
	int update(Query query, Update update) throws Exception;
	
	/**
	 * @Title: findOne 
	 * @Description: 根据id查询详细信息 
	 * @param  id
	 * @param @return 设定文件 
	 * @return T 返回类型
	 */
	T findOne(String id) throws Exception;
	
	/***
	 * @Title: find 
	 * @Description:根据条件查询相应数据
	 * @param  query
	 * @param @return 设定文件 
	 * @return List<T> 返回类型
	 */
	List<T> find(Query query) throws Exception;
	
	/**
	 * @Title: findOne 
	 * @Description: 根据条件查询具体某一条数据
	 * @param  query
	 * @param @return
	 * @param @throws ZhiWeiException 设定文件 
	 * @return T 返回类型
	 */
	T findOne(Query query) throws Exception;
	
	/**
	 * @Title: count 
	 * @Description: 根据相应条件查询数据量 
	 * @param  query
	 * @param @return 设定文件 
	 * @return long 返回类型
	 */
	long count(Query query) throws Exception;

    int delete(Query query) throws Exception;
}
