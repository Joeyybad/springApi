package jo.com.sa_backend.entites;
import jakarta.persistence.*;
import jo.com.sa_backend.enumeration.sentimentType;

@Entity
@Table(name="sentiment")
public class Sentiment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String texte;
    private sentimentType type;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="CLIENT_ID ")
    private Client client;
    
    
    public Sentiment() {
    }


    public Sentiment(int id, String texte, sentimentType type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTexte() {
        return texte;
    }


    public void setTexte(String texte) {
        this.texte = texte;
    }


    public sentimentType getType() {
        return type;
    }


    public void setType(sentimentType type) {
        this.type = type;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }
}
