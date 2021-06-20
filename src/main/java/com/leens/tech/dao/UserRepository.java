package com.leens.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leens.tech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
