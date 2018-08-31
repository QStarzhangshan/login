package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.ClientByMap;
import cn.zh.jdbc.domain.Location;
import cn.zh.jdbc.domain.MaintenanceByMap;

public interface LocationService {

	List<Location> getLocation();

	List<ClientByMap> getinfobyMap();

	List<ClientByMap> getclientbymap();

	List<MaintenanceByMap> getmaintenancebymap();
}
