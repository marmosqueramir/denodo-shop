package com.denodo.challenge.dao.users;

import com.denodo.challenge.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
