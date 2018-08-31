package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.UserDAO;
import cn.zh.jdbc.domain.User;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into user(user_work_number,user_name,user_password,user_email) values(?, ? , ? , ?)",
        		user.getUser_work_number(),user.getUser_name(),user.getUser_password(),user.getUser_email());

    }

    @Override
	public int save(User user) {
    	return jdbcTemplate.update("insert into user(user_work_number,user_name,user_password,openid) values(? , ? , ? , ?)",
        		user.getUser_work_number(),user.getUser_name(),user.getUser_password(),user.getOpenid());

	}
    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET user_name=? ,user_password=? WHERE user_id=?",
        		user.getUser_name(),user.getUser_password(),user.getUser_id());
    }
    @Override
	public int updateInfo(User user) {
    	return jdbcTemplate.update("UPDATE user SET user_cellphone=? ,user_email=? ,user_company=? , user_department=? , user_position=? WHERE user_work_number=?",
        		user.getUser_cellphone(),user.getUser_email(),user.getUser_company(),user.getUser_department(),user.getUser_position(),user.getUser_work_number());
	}
    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user where user_id =?",id);
    }

    public User findByUserAndPassword(String username,String password) {
        List<User> list = jdbcTemplate.query("select * from user where user_name = ? and user_password = ?", new Object[]{username,password}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
    }

    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from user", new Object[]{}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public int findByUser(String user_work_number, String password) {
		List<User> list = jdbcTemplate.query("select * from user where user_work_number = ? and user_password = ?", new Object[]{user_work_number,password}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            return 1;
        }else{
            return 0;
        }
	}

	@Override
	public boolean findByNumberAndEmail(String user_work_number, String user_email) {
		List<User> list = jdbcTemplate.query("select * from user where user_work_number = ? and user_email = ?", new Object[]{user_work_number,user_email}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public boolean findWorkNumber(String user_work_number) {
		List<User> list = jdbcTemplate.query("select * from user where user_work_number = ?", new Object[]{user_work_number}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            return true;
        }else{
            return false;
        }
	}

	@Override
	public List<User> findByCode(String openid) {
		List<User> list = jdbcTemplate.query("select user_id,user_work_number,user_name from user where openid = ?", new Object[]{openid}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
             return list;
        }else{
            return null;
        }
	}

	@Override
	public User findByUserWorkNumber(String user_work_number) {
		List<User> list = jdbcTemplate.query("select * from user where user_work_number = ?", new Object[]{user_work_number}, new BeanPropertyRowMapper(User.class));
        if(list != null && list.size() > 0){
            User user = list.get(0);
            return user;
        }else{
            return null;
        }
	}

}
