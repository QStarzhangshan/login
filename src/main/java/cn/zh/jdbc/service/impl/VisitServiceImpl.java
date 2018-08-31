package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.zh.jdbc.dao.VisitDao;
import cn.zh.jdbc.domain.Visit;
import cn.zh.jdbc.service.VisitService;


@Repository
public class VisitServiceImpl implements VisitService{

	@Autowired
    VisitDao visitDao;
	
    @Override
    public int add(Visit visit) {
        return visitDao.add(visit);
    }

    @Override
    public int update(Visit visit) {
        return visitDao.update(visit);
    }

    @Override
    public int delete(int sale_id) {
        return visitDao.delete(sale_id);
    }

    @Override
    public List<Visit> findClientList() {
        return visitDao.findClientList();
    }

	@Override
	public List<Visit> findBySaleId(int sale_id) {
		// TODO Auto-generated method stub
		return visitDao.findBySaleId(sale_id);
	}
}
