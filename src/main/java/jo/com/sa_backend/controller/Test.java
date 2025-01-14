package jo.com.sa_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class Test {

    @GetMapping(path="string")
   public String getString(){
    return "Chaine de caractère";
    }
    @GetMapping()
    public List<String> getList(){
     return List.of("Chaine de caractère");
     }
}
