package com.edu.vms.Impl;

import com.edu.vms.Entity.zc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface zcimpl extends CrudRepository<zc,Long> {
}
