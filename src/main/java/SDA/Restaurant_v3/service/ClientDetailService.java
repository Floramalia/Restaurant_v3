package SDA.Restaurant_v3.service;

import SDA.Restaurant_v3.entities.ClientModel;
import SDA.Restaurant_v3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ClientDetailService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

     Optional<ClientModel> clientModelOptional= clientRepository.findByEmail(email);
     ClientModel clientModel = clientModelOptional.get();
     String clientEmail = clientModel.getEmail();
     String clientEncodedPass = clientModel.getPassword();
     String role = clientModel.getRole();
     UserDetails userDetails = new User(clientEmail, clientEncodedPass,
             Collections.singletonList(new SimpleGrantedAuthority(role)));

        return userDetails;
    }
}
