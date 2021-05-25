package com.example.cart.repository.user;

import com.example.cart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    User getUserByName(String name);
}
