package SDA.Restaurant_v3.controller;

import SDA.Restaurant_v3.entities.CartModel;
import SDA.Restaurant_v3.entities.ClientModel;
import SDA.Restaurant_v3.service.ClientService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("clientRegistration")
    public ResponseEntity clientRegistration(@RequestBody ClientModel clientModel) {
        try {
            clientService.clientRegistration(clientModel);
            return ResponseEntity.ok("Clientul a fost adaugat cu succes.");
        } catch (RuntimeException exception) {
            return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("addProductToCart/{clientId}/{productId}")
    public ResponseEntity addProductToCart(@PathVariable long clientId, @PathVariable long productId){
        try{
            clientService.addToCart(clientId, productId);
            return ResponseEntity.ok("Produsul a fost adaugat cu succes in cos");
        }catch (RuntimeException exception){
            return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @JsonIgnore
    @GetMapping("getCarts/{clientId}")
    public List<CartModel> getCarts (@PathVariable long clientId){
      List<CartModel> cartModelList= clientService.getCart(clientId);
      return cartModelList;
    }

}

