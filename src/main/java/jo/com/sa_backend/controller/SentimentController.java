package jo.com.sa_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jo.com.sa_backend.entites.Sentiment;
import jo.com.sa_backend.services.SentimentService;

@RestController
@RequestMapping(path="sentiment", produces= MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;
    
    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }
    @ResponseStatus(HttpStatus.CREATED) 
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public void create(@RequestBody Sentiment sentiment){
        this.sentimentService.create(sentiment); 

    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path="{id}")
    public void delete(@PathVariable int id){
        this.sentimentService.delete(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sentiment> sentimentResearch(){
        return this.sentimentService.sentimentResearch();
    }
}
