package com.delson.sentir_mais.repository;

import com.delson.sentir_mais.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    
    UserDetails findByLogin(String login);
    
}
