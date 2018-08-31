package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.zh.jdbc.dao.SaleDao;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.User;

@Repository
public class SaleDaoImpl implements SaleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(Sale sale) {
        return jdbcTemplate.update("insert into user_sale(user_worknumber,client_name,sale_name,sale_create_time) values(?, ? , ? , ?)",
        		sale.getUser_worknumber(),sale.getClient_name(),sale.getSale_name(),sale.getSale_create_time());

    }

    @Override
    public int update(Sale sale) {
    	return jdbcTemplate.update("UPDATE user_sale SET client_name=? ,sale_name=? ,sale_level=? , sale_update_time=? WHERE sale_id=?",
        		sale.getClient_name(),sale.getSale_name(),sale.getSale_level(),sale.getSale_update_time(),sale.getSale_id());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user_sale where sale_id =?",id);
    }

    public List<Sale> findSaleList() {
        List<Sale> list = jdbcTemplate.query("select * from user_sale", new Object[]{}, new BeanPropertyRowMapper(Sale.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

	@Override
	public List<Sale> findBySaleNumber(String user_worknumber) {
		List<Sale> list = jdbcTemplate.query("select * from user_sale where user_worknumber = ? order by sale_id desc", new Object[]{user_worknumber}, new BeanPropertyRowMapper(Sale.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public Sale findByUserWorkNumber(String user_worknumber) {
		 List<Sale> list = jdbcTemplate.query("select * from user_sale where user_worknumber = ? order by sale_id desc", new Object[]{user_worknumber}, new BeanPropertyRowMapper(Sale.class));
	        if(list != null && list.size() > 0){
	            Sale sale = list.get(0);
	            return sale;
	        }else{
	            return null;
	        }
	}

	@Override
	public Sale findBySaleId(int sale_id) {
		List<Sale> list = jdbcTemplate.query("select * from user_sale where sale_id = ?", new Object[]{sale_id}, new BeanPropertyRowMapper(Sale.class));
        if(list != null && list.size() > 0){
            Sale sale = list.get(0);
            return sale;
        }else{
            return null;
        }
	}


}
