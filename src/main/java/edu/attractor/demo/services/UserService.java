package edu.attractor.demo.services;

import edu.attractor.demo.entities.User;
import edu.attractor.demo.enums.UserRole;
import edu.attractor.demo.exceptions.UserAlreadyRegisteredException;
import edu.attractor.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();


    public User findUserById(Long id) throws Exception {
        final Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(Exception::new);
    }
    public User signUpUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyRegisteredException();
        }


        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);
        user.setEmail(user.getEmail().toLowerCase());
        user.setUserRole(UserRole.ROLE_USER);

        User userWithId = userRepository.save(user);

        return userWithId;
    }
    public Optional<User> findUserByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public Optional<User> getUserByName(String name) {
        return this.userRepository.findByName(name);
    }

}
