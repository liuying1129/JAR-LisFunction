package com.yklis.lisfunction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yklis.lisfunction.entity.WorkerEntity;

public interface WorkerDao {
	
	/**
	 * mybatis参数注解方式
	 * 判断指定用户、密码是否能登录
	 * @param userId 
	 * @param passWord 
	 * @return
	 */	
	List<WorkerEntity> ifCanLogin(@Param(value="userId") String userId,@Param(value="passWord") String passWord);

}
