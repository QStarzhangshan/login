package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.ClientDao;
import cn.zh.jdbc.dao.VisitDao;
import cn.zh.jdbc.domain.Client;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.User;
import cn.zh.jdbc.domain.Visit;


@Repository
public class VisitDaoImpl implements VisitDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Visit visit) {
		return jdbcTemplate.update("insert into client_visit(sale_id,visit_topic,client_name,visit_time,"
				+ "visit_content,visit_appointToId,visit_appointName,visit_result,visit_note) values(? , ? , ? , ? , ? , ? , ? , ? , ?)",
				visit.getSale_id(),visit.getVisit_topic(),visit.getClient_name(),visit.getVisit_time(),visit.getVisit_content(),
				visit.getVisit_appointToId(),visit.getVisit_appointName(),visit.getVisit_result(),visit.getVisit_note()
				);
	}

	@Override
	public int update(Visit visit) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE from client_visit where id =?",id);
	}

	@Override
	public List<Visit> findClientList() {
		List<Visit> list = jdbcTemplate.query("select * from client_visit", new Object[]{}, new BeanPropertyRowMapper(Visit.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public List<Visit> findBySaleId(int sale_id) {
		 List<Visit> list = jdbcTemplate.query("select * from client_visit where sale_id = ? ", new Object[]{sale_id}, new BeanPropertyRowMapper(Visit.class));
	        if(list != null && list.size() > 0){
	            return list;
	        }else{
	            return null;
	        }
	}

	

}
