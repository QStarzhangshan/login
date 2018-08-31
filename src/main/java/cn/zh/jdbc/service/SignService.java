package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.Sign;

public interface SignService {

	int add(Sign sign);

    int update(Sign sign);
    
    int delete(int id);

    Sign findByTime(String sign_time);
    
    List<Sign> findBySaleId(int sale_id);
}
