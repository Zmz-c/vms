package com.edu.vms.Impl;

import com.edu.vms.Entity.tz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tzimpl extends CrudRepository<tz,Long> {
}
