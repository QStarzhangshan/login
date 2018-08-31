package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Visit;

public interface VisitDao {

	int add(Visit visit);

    int update(Visit visit);

    int delete(int id);

    List<Visit> findClientList();
    
    List<Visit> findBySaleId(int sale_id);
    
   
}
