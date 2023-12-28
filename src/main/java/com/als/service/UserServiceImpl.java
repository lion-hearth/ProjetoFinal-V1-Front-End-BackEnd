package com.als.service;

import com.als.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        //  salvar o usuário no banco de dados
        // userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        // buscar o usuário pelo nome de usuário
        // return userRepository.findByUsername(username);
        return null;
    }
}
