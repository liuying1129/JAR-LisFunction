package com.yklis.lisfunction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yklis.lisfunction.dao.ChkValuDao;
import com.yklis.lisfunction.entity.ChkValuEntity;
import com.yklis.lisfunction.service.ChkValuService;

@Service
public class ChkValuServiceImpl implements ChkValuService {

    @Autowired
    private ChkValuDao chkValuDao;
    
    @Override
    public List<ChkValuEntity> selectChkValuImage(ChkValuEntity chkValuEntity) {
        
        return chkValuDao.selectChkValuImage(chkValuEntity);
    }

}
