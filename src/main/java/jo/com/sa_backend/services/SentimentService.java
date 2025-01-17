package jo.com.sa_backend.services;

import org.springframework.stereotype.Service;

import jo.com.sa_backend.entites.Client;
import jo.com.sa_backend.entites.Sentiment;
import jo.com.sa_backend.repository.SentimentRepository;

@Service
public class SentimentService {
    private ClientService clientService;
    private SentimentRepository sentimentRepository;
    
    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }




    public void create(Sentiment sentiment){
        Client client  = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);
        this.sentimentRepository.save(sentiment);
    }
}
