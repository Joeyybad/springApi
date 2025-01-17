package jo.com.sa_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jo.com.sa_backend.entites.Sentiment;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    
}
