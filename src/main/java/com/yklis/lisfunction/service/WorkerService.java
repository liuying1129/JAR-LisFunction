package com.yklis.lisfunction.service;

import java.util.List;

import com.yklis.lisfunction.entity.WorkerEntity;

public interface WorkerService {
		
	List<WorkerEntity> ifCanLogin(String userId,String passWord);

}
