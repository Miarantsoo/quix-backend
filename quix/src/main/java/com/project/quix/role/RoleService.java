package com.project.quix.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repoRole;
    public RoleService(RoleRepository repoRole){
        this.repoRole = repoRole;
    }

    public List<Role> getAllRole(){
        return repoRole.findAllRole();
    }

}
