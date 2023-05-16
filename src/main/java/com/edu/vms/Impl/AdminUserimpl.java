package com.edu.vms.Impl;

import com.edu.vms.Entity.AdminUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserimpl extends CrudRepository<AdminUser,Long> {
    AdminUser findAllByUsernameAndAndPassword(String username,String password);
}
