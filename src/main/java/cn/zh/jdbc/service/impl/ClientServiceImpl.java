package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zh.jdbc.dao.ClientDao;
import cn.zh.jdbc.domain.Client;
import cn.zh.jdbc.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Override
    public int add(Client client) {
        return clientDao.add(client);
    }

    @Override
    public int update(Client client) {
        return clientDao.update(client);
    }

    @Override
    public int delete(int sale_id) {
        return clientDao.delete(sale_id);
    }

    @Override
    public List<Client> findClientList() {
        return clientDao.findClientList();
    }

	@Override
	public List<Client> findByClientOwnerNumber(String client_owner_worknumber) {
		// TODO Auto-generated method stub
		return clientDao.findByClientOwnerNumber(client_owner_worknumber);
	}

	@Override
	public Client findByClientId(String client_id) {
		// TODO Auto-generated method stub
		return clientDao.findByClientId(client_id);
	}

	@Override
	public List<Client> findAllCount(String user_worknumber) {
		// TODO Auto-generated method stub
		return clientDao.findAllCount(user_worknumber);
	}
	
}
