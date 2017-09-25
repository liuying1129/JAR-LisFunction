package com.yklis.lisfunction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yklis.lisfunction.dao.WorkerDao;
import com.yklis.lisfunction.entity.WorkerEntity;
import com.yklis.lisfunction.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDao workerDao;
		
	@Override
	public List<WorkerEntity> ifCanLogin(String userId,String passWord){
		
		return workerDao.ifCanLogin(userId, passWord);
	}

}
