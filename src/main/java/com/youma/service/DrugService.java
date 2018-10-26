package com.youma.service;

import com.youma.util.Page;
import com.youma.vo.Drug;

import java.util.List;

/**
 * DrugService
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/26 11:22
 */
public interface DrugService {
    public int drugAdd(Drug drug);

    public void drugUpdate(Drug drug);

    public void drugDel(String drugID);

    public int drugCount(Drug drug);

    public List<Drug> drugAll(Drug drug,Page page);
    public Drug drugFind(String drugID);
}
