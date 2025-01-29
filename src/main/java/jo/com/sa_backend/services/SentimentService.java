package jo.com.sa_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jo.com.sa_backend.entites.Client;
import jo.com.sa_backend.entites.Sentiment;
import jo.com.sa_backend.enumeration.sentimentType;
import jo.com.sa_backend.repository.SentimentRepository;

@Service
public class SentimentService {
    private ClientService clientService;
    private SentimentRepository sentimentRepository;
    
    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }
    public List <Sentiment> sentimentResearch(){

        return this.sentimentRepository.findAll();
        
    }
    public void create(Sentiment sentiment){
        Client client  = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);
        
        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(sentimentType.NEGATIF);
        }else{
            sentiment.setType(sentimentType.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }
    
   public void delete(int id){
    this.sentimentRepository.deleteById(id);
   }
}
