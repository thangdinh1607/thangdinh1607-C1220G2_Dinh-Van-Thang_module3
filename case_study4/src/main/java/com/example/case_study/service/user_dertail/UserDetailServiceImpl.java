//package com.example.case_study.service.user_dertail;
//
//import com.example.case_study.model.User;
//import com.example.case_study.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private IUserRepository iUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=iUserRepository.getUserByName(username);
//        if(user==null){
//            throw new UsernameNotFoundException("can't find user");
//        }
//        return new MyUserDetails(user);
//    }
//
//}