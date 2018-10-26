package com.youma.dao;

import com.youma.util.Page;
import com.youma.vo.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DrugDao
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/26 11:09
 */
@Mapper
public interface DrugDao {
    public int drugAdd(Drug drug);

    public void drugUpdate(Drug drug);

    public void drugDel(String drugID);

    public int drugCount(@Param("drug") Drug drug);

    public List<Drug> drugAll(@Param("drug") Drug drug, @Param("page") Page page);

    public Drug drugFind(String drugID);
}
