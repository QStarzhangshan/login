package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zh.jdbc.dao.SaleDao;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleDao saleDao;
    @Override
    public int add(Sale sale) {
        return saleDao.add(sale);
    }

    @Override
    public int update(Sale sale) {
        return saleDao.update(sale);
    }

    @Override
    public int delete(int id) {
        return saleDao.delete(id);
    }

    

    @Override
    public List<Sale> findSaleList() {
        return saleDao.findSaleList();
    }

	@Override
	public List<Sale> findBySaleNumber(String user_worknumber) {
		// TODO Auto-generated method stub
		return saleDao.findBySaleNumber(user_worknumber);
	}

	@Override
	public Sale findByUserWorkNumber(String user_worknumber) {
		// TODO Auto-generated method stub
		return saleDao.findByUserWorkNumber(user_worknumber);
	}

	@Override
	public Sale findBySaleId(int sale_id) {
		// TODO Auto-generated method stub
		return saleDao.findBySaleId(sale_id);
	}
	
	
}
