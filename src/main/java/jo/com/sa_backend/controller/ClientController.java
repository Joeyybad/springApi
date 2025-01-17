package jo.com.sa_backend.controller;
import static org.springframework.http.MediaType.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jo.com.sa_backend.entites.Client;
import jo.com.sa_backend.services.ClientService;

@RestController
@RequestMapping(path="client")
public class ClientController {
private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody Client client){
        this.clientService.createClient(client);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> clientResearch(){
        return this.clientService.clientResearch();
    }
    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client read(@PathVariable int id){
        return this.clientService.read(id);
    }

}
