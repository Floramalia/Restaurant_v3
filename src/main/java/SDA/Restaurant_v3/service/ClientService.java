package SDA.Restaurant_v3.service;

import SDA.Restaurant_v3.entities.CartModel;
import SDA.Restaurant_v3.entities.CartStatus;
import SDA.Restaurant_v3.entities.ClientModel;
import SDA.Restaurant_v3.entities.ProductModel;
import SDA.Restaurant_v3.repository.CartRepository;
import SDA.Restaurant_v3.repository.ClientRepository;
import SDA.Restaurant_v3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;


    public void clientRegistration(ClientModel clientModel) {
        String regex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(clientModel.getEmail());
        if (matcher.find()) {
            encodePasswordForClientRegistration(clientModel);
            clientModel.setRole("Admin");
            System.out.println("Correct!");
            clientRepository.save(clientModel);
            System.out.println("Contul a fost creat cu succes.");
        } else {
            throw new RuntimeException("Va rugam sa introduceti o adresa de email valida.");
        }
    }

    public void encodePasswordForClientRegistration(ClientModel clientModel) {
        String getUnencodedPass = clientModel.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(getUnencodedPass);
        clientModel.setPassword(encodedPassword);
    }

    public void addToCart(Long clientId, Long productId) {
        Optional<ProductModel> productModelOptional = productRepository.findById(productId);
        if (productModelOptional.isEmpty()) {
            throw new RuntimeException("Product doesn't exist");
        }
        ProductModel productModel = productModelOptional.get();

        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (clientModelOptional.isEmpty()) {
            throw new RuntimeException("Client doesn't exist");
        }
        ClientModel clientModel = clientModelOptional.get();
        List<CartModel> cartModelList = clientModel.getCartModelList();
        CartModel foundCart = null;

        for (CartModel cart : cartModelList) {
            if (cart.getCartStatus().equals(CartStatus.OPEN)) {
                foundCart = cart;
            }
        }
        if (foundCart == null) {
            foundCart = new CartModel();
            foundCart.setCartStatus(CartStatus.OPEN);
            foundCart.setClientModel(clientModel);
        }
        foundCart.getProductModelList().add(productModel);

        double totalPriceCart = 0.0;
        List<ProductModel> productModelList = foundCart.getProductModelList();
        for (ProductModel products : productModelList) {
            totalPriceCart = totalPriceCart + products.getProductPrice();
        }
        foundCart.setCartTotalPrice(totalPriceCart);

        cartRepository.save(foundCart);
    }

    public List<CartModel> getCart(Long clientId) {
        Optional<ClientModel> clientModelOptional = clientRepository.findById(clientId);
        if (clientModelOptional.isEmpty()) {
            throw new RuntimeException("Client doesn't exist");
        }
        ClientModel clientModel = clientModelOptional.get();
        List<CartModel> cartModelList = clientModel.getCartModelList();

        for (CartModel carts : cartModelList) {
            if (carts != null) {
                List<ProductModel> productModelList = carts.getProductModelList();
                double totalPriceCart = 0.0;
                for (ProductModel products : productModelList) {
                    totalPriceCart = totalPriceCart + products.getProductPrice();
                    if (products != null) {
                        System.out.println("The carts' list are: " + carts.getId() + carts.getCartStatus()
                                + products.getProductName() + totalPriceCart);
                    }
                }
            }
        }
        return cartModelList;

    }

}






