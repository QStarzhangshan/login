package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.User;

public interface UserDAO {

	int add(User user);
	
	int save(User user);

    int update(User user);
    
    int updateInfo(User user);

    int delete(int id);

    User findByUserAndPassword(String username,String password);

    List<User> findUserList();

	int findByUser(String username, String password);
	
	boolean findWorkNumber(String user_work_number);
	
	List<User> findByCode(String openid);
	
	User findByUserWorkNumber(String user_work_number);
	
    boolean findByNumberAndEmail(String user_work_number,String user_email);
}
