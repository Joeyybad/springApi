package jo.com.sa_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jo.com.sa_backend.entites.Client;
import jo.com.sa_backend.repository.ClientRepository;



@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createClient(Client client) {
        Client bddClient = this.clientRepository.findByEmail(client.getEmail());
        if(bddClient == null){
                this.clientRepository.save(client);
        }
        
    }

    public List <Client> clientResearch(){

        return this.clientRepository.findAll();
        
    }

    public Client read(int id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client clientToCreate){
        Client bddClient = this.clientRepository.findByEmail(clientToCreate.getEmail());
        if(bddClient == null){
            bddClient = this.clientRepository.save(clientToCreate);
        }
        return bddClient;
    }
}
