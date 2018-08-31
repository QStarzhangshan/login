package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zh.jdbc.dao.SignDao;
import cn.zh.jdbc.domain.Sign;
import cn.zh.jdbc.service.SignService;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    SignDao signDao;
    
    @Override
    public int add(Sign sign) {
        return signDao.add(sign);
    }
    
    @Override
    public int update(Sign sign) {
        return signDao.update(sign);
    }
    
    @Override
    public int delete(int id) {
        return signDao.delete(id);
    }

	@Override
	public Sign findByTime(String sign_time) {
		// TODO Auto-generated method stub
		return signDao.findByTime(sign_time);
	}

	@Override
	public List<Sign> findBySaleId(int sale_id) {
		// TODO Auto-generated method stub
		return signDao.findBySaleId(sale_id);
	}

    

}
