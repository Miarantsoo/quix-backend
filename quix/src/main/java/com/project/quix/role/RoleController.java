package com.project.quix.role;

import com.project.quix.tierces.TypeClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService servRole;

    public RoleController(RoleService servRole){
        this.servRole = servRole;
    }

    @GetMapping("/get-all-role")
    public List<Role> getAllRole() {
        return servRole.getAllRole();
    }
    
}
