package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Sale;

public interface SaleDao {

	int add(Sale sale);

    int update(Sale sale);

    int delete(int id);
    
    List<Sale> findSaleList();
    
    List<Sale> findBySaleNumber(String user_worknumber);
    
    Sale findByUserWorkNumber(String user_worknumber);
    
    Sale findBySaleId(int sale_id);
    
}
