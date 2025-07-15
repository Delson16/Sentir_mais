package com.delson.sentir_mais.service;


import com.delson.sentir_mais.domain.User;
import com.delson.sentir_mais.dto.UserRegisterDto;
import com.delson.sentir_mais.exception.LoginAlreadyExistsException;
import com.delson.sentir_mais.exception.UserNotFoundException;
import com.delson.sentir_mais.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public void register(UserRegisterDto data) {

        if (userRepository.findByLogin(data.login()) != null) {
            throw new LoginAlreadyExistsException();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        var user = new User(
                data.name(),
                data.login(),
                encryptedPassword
        );

        userRepository.save(user);
    }
    
    public User getUser(String id){
        Optional<User> user = userRepository.findById(id);
        
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        
        return user.get();
    }
    

}
