package com.example.cart.service.user_detail;

import com.example.cart.model.User;
import com.example.cart.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
     private IUserRepository iUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=iUserRepository.getUserByName(username);
        if(user==null){
            throw new UsernameNotFoundException("can't find user");
        }
        return new MyUserDetails(user);
    }

}
