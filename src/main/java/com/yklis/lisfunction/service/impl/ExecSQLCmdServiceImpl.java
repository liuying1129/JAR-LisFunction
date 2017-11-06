package com.yklis.lisfunction.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yklis.lisfunction.service.ExecSQLCmdService;

@Service
public class ExecSQLCmdServiceImpl implements ExecSQLCmdService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * UPDATE或INSERT SQL
     */
    @Override
    public String ExecSQLCmd(String sql) {
        
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
            jdbcTemplate.update(sql);
                            
            Map<String, Object> mapResponse = new HashMap<>();
            mapResponse.put("id", -1);
            mapResponse.put("msg", "sql执行成功");
            
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
