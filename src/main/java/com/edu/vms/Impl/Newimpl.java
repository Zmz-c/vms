package com.edu.vms.Impl;
import com.edu.vms.Entity.New;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Newimpl extends CrudRepository<New,Long> {
}
