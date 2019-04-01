package com.yklis.lisfunction.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yklis.lisfunction.service.ScalarSQLCmdService;

@Service
public class ScalarSQLCmdServiceImpl implements ScalarSQLCmdService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public String ScalarSQLCmd(String sql) {
		
    	if((null == sql)||("".equals(sql))){
                
	        Map<String, Object> mapResponse = new HashMap<>();
	        mapResponse.put("errorCode", -123);
	        mapResponse.put("errorMsg", "sql为空!");
	        
	        Map<String, Object> map = new HashMap<>();
	        map.put("success", false);
	        map.put("response", mapResponse);
	        
	    	return JSON.toJSONString(map);
    	}
    	
    	try{
    		//sql要求：
    		//1、有且仅有一条记录
    		//2、有且仅有一个字段
    		//3、字段在DB中的类型不限
    		String s = jdbcTemplate.queryForObject(sql,String.class);
                
	        Map<String, Object> mapResponse = new HashMap<>();
	        mapResponse.put("result", s);
	        
	        Map<String, Object> map = new HashMap<>();
	        map.put("success", true);
	        map.put("response", mapResponse);
	        
	    	return JSON.toJSONString(map);

    	}catch(Exception e){

                
            Map<String, Object> mapResponse = new HashMap<>();
            mapResponse.put("errorCode", -223);
            mapResponse.put("errorMsg", "sql执行出错:"+e.toString()+"。错误的SQL:"+sql);
            
            Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("response", mapResponse);
            
	    	return JSON.toJSONString(map);
    	}

	}

}
