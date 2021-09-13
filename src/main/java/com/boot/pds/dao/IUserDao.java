package com.boot.pds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.pds.entities.User;

public interface IUserDao extends JpaRepository<User, Integer>{

}
