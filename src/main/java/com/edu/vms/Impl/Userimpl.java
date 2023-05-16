package com.edu.vms.Impl;

import com.edu.vms.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userimpl extends CrudRepository<User,Long> {
    User findAllByUsernameAndAndPassword(String username, String password);
}
