package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.UserDAO;
import cn.zh.jdbc.domain.User;
import cn.zh.jdbc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public int add(User user) {
        return userDAO.add(user);
    }
    @Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}
    @Override
    public int update(User user) {
        return userDAO.update(user);
    }
    @Override
	public int updateInfo(User user) {
		// TODO Auto-generated method stub
		return userDAO.updateInfo(user);
	}
    @Override
    public int delete(int id) {
        return userDAO.delete(id);
    }

    @Override
    public User findByUserAndPassword(String username,String password) {
        return userDAO.findByUserAndPassword(username,password);
    }

    @Override
    public List<User> findUserList() {
        return userDAO.findUserList();
    }

	@Override
	public int findByUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.findByUser(username,password);
	}

	@Override
	public boolean findByNumberAndEmail(String user_work_number, String user_email) {
		// TODO Auto-generated method stub
		return userDAO.findByNumberAndEmail(user_work_number, user_email);
	}

	@Override
	public boolean findWorkNumber(String user_work_number) {
		// TODO Auto-generated method stub
		return userDAO.findWorkNumber(user_work_number);
	}
	@Override
	public List<User> findByCode(String openid) {
		// TODO Auto-generated method stub
		return userDAO.findByCode(openid);
	}
	@Override
	public User findByUserWorkNumber(String user_work_number) {
		// TODO Auto-generated method stub
		return userDAO.findByUserWorkNumber(user_work_number);
	}

}
