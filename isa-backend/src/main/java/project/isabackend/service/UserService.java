package project.isabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.isabackend.dto.UserRegistrationDTO;
import project.isabackend.model.RegisteredUser;
import project.isabackend.model.Role;
import project.isabackend.model.User;
import project.isabackend.repository.RegisteredUserRepository;
import project.isabackend.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    public User findOne(long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public RegisteredUser findByEmail(String email) throws UsernameNotFoundException {
        return registeredUserRepository.findByEmail(email);
    }

    public RegisteredUser addRegisteredUser(UserRegistrationDTO userRequest) {
        RegisteredUser user = new RegisteredUser();
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setHospitalInformation(userRequest.getHospitalInformation());
        user.setCity(userRequest.getCity());
        user.setCountry(userRequest.getCountry());
        user.setOccupation(userRequest.getOccupation());

        Set<Role> roles = roleService.findByName("REGISTERED_USER");
        user.setRoles(roles);

        return this.userRepository.save(user);
    }
}
