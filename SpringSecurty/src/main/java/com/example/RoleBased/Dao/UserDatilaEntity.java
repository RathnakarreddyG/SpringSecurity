package com.example.RoleBased.Dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.RoleBased.model.User;

public interface UserDatilaEntity extends PagingAndSortingRepository<User, Long> {

}
