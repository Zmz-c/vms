package com.edu.vms.Impl;

import com.edu.vms.Entity.VMSUG;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VMSUGimpl extends CrudRepository<VMSUG,Long> {
}
