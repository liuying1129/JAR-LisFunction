package com.yklis.lisfunction.dao;

import java.util.List;

import com.yklis.lisfunction.entity.ChkValuEntity;

public interface ChkValuDao {

    List<ChkValuEntity> selectChkValuImage(ChkValuEntity chkValuEntity);
}
