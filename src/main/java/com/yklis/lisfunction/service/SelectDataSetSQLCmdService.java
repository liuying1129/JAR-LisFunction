package com.yklis.lisfunction.service;

import java.util.List;
import java.util.Map;

public interface SelectDataSetSQLCmdService {
	
	String selectDataSetSQLCmd(String sql);
	
	List<Map<String, Object>> selectDataSetSQLCmd2(String sql);
}
