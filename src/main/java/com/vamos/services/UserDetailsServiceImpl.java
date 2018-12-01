package com.vamos.services;

import com.vamos.domain.Driver;
import com.vamos.domain.Student;
import com.vamos.repositories.DriverRepository;
import com.vamos.repositories.StudentRepository;
import com.vamos.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email);

        if(student != null){
            return new UserSS(student.getId(), student.getEmail(), student.getPassword(), student.getPerfis());
        }

        Driver driver = driverRepository.findByEmail(email);

        if(driver != null){
            return new UserSS(driver.getId(), driver.getEmail(), driver.getPassword(), driver.getPerfis());

        }

        throw new UsernameNotFoundException(email);
    }
}
