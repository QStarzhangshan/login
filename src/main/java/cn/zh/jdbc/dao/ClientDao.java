package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Client;

public interface ClientDao {

	int add(Client client);

    int update(Client client);

    int delete(int id);

    List<Client> findClientList();
    
    List<Client> findByClientOwnerNumber(String client_owner_worknumber);
    
    Client findByClientId(String client_id);
    
    List<Client> findAllCount(String user_worknumber);
}
