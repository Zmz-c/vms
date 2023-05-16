package com.edu.vms.Impl;

import com.edu.vms.Entity.VMSP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VmspImpl extends CrudRepository<VMSP,Long> {
    VMSP findAllByVMnameAndPassword(String username, String password);
}
