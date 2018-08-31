package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.SignDao;
import cn.zh.jdbc.domain.Sign;

@Repository
public class SignDaoImpl implements SignDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(Sign sign) {
        return jdbcTemplate.update("insert into user_signinfo(sale_id,sign_latitude,sign_longitude,sign_location,sign_time) values(? , ? , ? , ? , ?)",
        		sign.getSale_id(),sign.getSign_latitude(),sign.getSign_longitude(),sign.getSign_location(),sign.getSign_time());

    }
    
    @Override
    public int update(Sign sign) {
//        return jdbcTemplate.update("UPDATE user SET user_name=? ,user_password=? WHERE user_id=?",
//        		user.getUser_name(),user.getUser_password(),user.getUser_id());
    	return 0;
    }
 
    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user_signinfo where sign_id =?",id);
    }

	@Override
	public Sign findByTime(String sign_time) {
		// TODO Auto-generated method stub
		List<Sign> list = jdbcTemplate.query("select * from user_signinfo where sign_time = ?", new Object[]{sign_time}, new BeanPropertyRowMapper(Sign.class));
        if(list != null && list.size() > 0){
            Sign sign = list.get(0);
            return sign;
        }else{
            return null;
        }
	}

	@Override
	public List<Sign> findBySaleId(int sale_id) {
		List<Sign> list = jdbcTemplate.query("select * from user_signinfo where sale_id = ?", new Object[]{sale_id}, new BeanPropertyRowMapper(Sign.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

    

}
