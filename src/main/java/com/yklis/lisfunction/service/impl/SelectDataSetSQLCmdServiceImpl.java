package com.yklis.lisfunction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yklis.lisfunction.service.SelectDataSetSQLCmdService;

@Service
public class SelectDataSetSQLCmdServiceImpl implements SelectDataSetSQLCmdService {

	// 配置容器起动时候加载log4j配置文件
	// 只要将log4j.properties放在classes下，tomcat启动的时候会自动加载log4j的配置信息，
	// 在程式代码不再需要使用PropertyConfigurator.configure("log4j.properties")来加载，
	// 如果用了它反而会出现上面的错误--Could not read configuration file [log4jj.properties]
	// PropertyConfigurator.configure("log4jj.properties");
	private Logger logger = Logger.getLogger(this.getClass());

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

}
