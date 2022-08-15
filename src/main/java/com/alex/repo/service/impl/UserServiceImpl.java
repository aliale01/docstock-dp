package com.alex.repo.service.impl;

import com.alex.repo.models.Role;
import com.alex.repo.models.User;
import com.alex.repo.repositories.RoleRepository;
import com.alex.repo.repositories.UserRepository;
import com.alex.repo.service.UserService;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //@RequiredArgsConstructor ???
public class UserServiceImpl implements UserService/*, UserDetailsService*/ {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    //private RoleRepository roleRepository;

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername
        return null;
    }*/

    @Override
    @Transactional(readOnly = true)
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    @Qualifier
    public void addRoleToUser(String username, String name) {
        User user = userRepository.findByUsername(username);
        //Role role =roleRepository.findByRoleName(name);
        //user.getRoles().add(role);
    }
}
