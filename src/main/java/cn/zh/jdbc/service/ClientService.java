package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.Client;

public interface ClientService {

	int add(Client client);

    int update(Client client);

    int delete(int sale_id);
    
    List<Client> findClientList();
    
    List<Client> findByClientOwnerNumber(String client_owner_worknumber);
    
    Client findByClientId(String client_id);
    
    List<Client> findAllCount(String user_worknumber);
}
