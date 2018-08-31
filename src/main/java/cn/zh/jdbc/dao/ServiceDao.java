package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Service;

public interface ServiceDao {

	int add(Service service);

    int update(Service service);

    int delete(int id);
    
    List<Service> findServiceList();
    
    List<Service> findByServiceNumber(String user_number);
    
    Service findByServiceId(int service_id);
    
    List<Service> likeSearch(String usernumber,String elevator_number);
    
    int getCount(String user_number);
    
}
