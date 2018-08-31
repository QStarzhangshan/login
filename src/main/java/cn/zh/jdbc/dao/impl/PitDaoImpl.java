package cn.zh.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.zh.jdbc.dao.PitDao;
import cn.zh.jdbc.domain.Pit;

@Repository
public class PitDaoImpl implements PitDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int update(Pit pit) {
		return jdbcTemplate.update("UPDATE pit SET light=?,sudden_stop_switch=?,rovolve_member=?,pond=? WHERE service_id=?",
				pit.getLight(),pit.getSudden_stop_switch(),pit.getRovolve_member(),pit.getPond(),pit.getService_id());
	}

}
