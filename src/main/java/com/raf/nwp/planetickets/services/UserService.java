package com.raf.nwp.planetickets.services;

import com.raf.nwp.planetickets.model.MyUser;
import com.raf.nwp.planetickets.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<MyUser, Long> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MyUser save(MyUser myUser) {
        return userRepository.save(myUser);
    }

    @Override
    public Optional<MyUser> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<MyUser> findAll() {
        return (List<MyUser>) userRepository.findAll();
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
