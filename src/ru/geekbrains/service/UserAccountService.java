package ru.geekbrains.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.repo.UserRepository;

@Service
public class UserAccountService extends UserService {

    private UserRepository userRepository;

    public UserAccountService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super(userRepository, passwordEncoder);
    }

    public void Withdraw(){
        this.userRepository.withdraw();
    }

    public void Deposite() {
        this.userRepository.deposite();
    }
}
