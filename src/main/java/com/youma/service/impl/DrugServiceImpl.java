/**
 * Copyright (C),2015-2018
 * FileNmae: DrugServiceImpl
 * Author:   Administrator
 * Date:     2018/10/26 11:22
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.youma.service.impl;

import com.youma.dao.DrugDao;
import com.youma.service.DrugService;
import com.youma.util.Page;
import com.youma.vo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DrugServiceImpl
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/26 11:22
 */
@Service
public class DrugServiceImpl implements DrugService {
    private DrugDao drugDao;

    public DrugDao getDrugDao() {
        return drugDao;
    }

    @Autowired
    public void setDrugDao(DrugDao drugDao) {
        this.drugDao = drugDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int drugAdd(Drug drug) {
        return drugDao.drugAdd(drug);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void drugUpdate(Drug drug) {
        drugDao.drugUpdate(drug);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void drugDel(String drugID) {
        drugDao.drugDel(drugID);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public int drugCount(Drug drug) {
        return drugDao.drugCount(drug);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<Drug> drugAll(Drug drug,Page page) {
        return drugDao.drugAll(drug,page);
    }

    @Override
    public Drug drugFind(String drugID) {
        return drugDao.drugFind(drugID);
    }
}
