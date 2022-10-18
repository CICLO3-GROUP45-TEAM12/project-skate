package com.backend.skate.api.persistence;


import com.backend.skate.api.persistence.crud.ClientCrudRepository;
import com.backend.skate.api.persistence.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public ClientRepository() {
    }

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
