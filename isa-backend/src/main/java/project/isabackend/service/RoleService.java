package project.isabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.isabackend.model.Role;
import project.isabackend.repository.RoleRepository;

import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
