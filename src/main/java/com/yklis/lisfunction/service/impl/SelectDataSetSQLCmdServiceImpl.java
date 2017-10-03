package com.yklis.lisfunction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yklis.lisfunction.service.SelectDataSetSQLCmdService;

@Service
public class SelectDataSetSQLCmdServiceImpl implements SelectDataSetSQLCmdService {

	// 注入Bean
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String selectDataSetSQLCmd(String sql) {		
		
    	if((null == sql)||("".equals(sql))){
    		                
            Map<String, Object> mapResponse = new HashMap<>();
            mapResponse.put("errorCode", -123);
            mapResponse.put("errorMsg", "sql为空!");
            
            Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("response", mapResponse);
            
	    	Gson gson = new Gson();
	    	    	      
    		return gson.toJson(map);
    	}

    	try{
    		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
    		                
            Map<String, Object> map = new HashMap<>();
            map.put("success", true);
            map.put("response", list);
            
	    	Gson gson = new Gson();
	    	
	    	return gson.toJson(map);
    	    	
    	}catch(Exception e){
    		                
            Map<String, Object> mapResponse = new HashMap<>();
            mapResponse.put("errorCode", -123);
            mapResponse.put("errorMsg", "sql执行出错:"+e.toString()+"。错误的SQL:"+sql);
            
            Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("response", mapResponse);
            
	    	Gson gson = new Gson();
	    	            
	    	return gson.toJson(map);
	
		//for (Iterator<Map<String, Object>> ite = list.iterator(); ite.hasNext();) {
			
		//}
		
    	}
	}
		
	@Override
	public List<Map<String, Object>> selectDataSetSQLCmd2(String sql){		

    	try{
    		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
    		                	    	
	    	return list;
    	    	
    	}catch(Exception e){    		                
	    	            
	    	return null;
		
    	}
	}

}
