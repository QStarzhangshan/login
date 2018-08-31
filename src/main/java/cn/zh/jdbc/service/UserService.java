package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.User;

public interface UserService {

	int add(User user);
	
	int save(User user);

    int update(User user);
    
    int updateInfo(User user);

    int delete(int id);

    User findByUserAndPassword(String username,String password);
    
    User findByUserWorkNumber(String user_work_number);

    int findByUser(String username,String password);
    
    boolean findWorkNumber(String user_work_number);
    
    List<User> findUserList();
    
    List<User> findByCode(String openid);
    
    boolean findByNumberAndEmail(String user_work_number,String user_email);

}
