package cn.zh.jdbc.dao;


import java.util.List;

import cn.zh.jdbc.domain.ClientByMap;
import cn.zh.jdbc.domain.Location;
import cn.zh.jdbc.domain.MaintenanceByMap;

public interface LocationDao {

    List<Location> getLocation();

	List<ClientByMap> getinfoByMap();

	List<ClientByMap> getclientbymap();

	List<MaintenanceByMap> getmaintenancebymap();

}
