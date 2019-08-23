package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanySymbol;
import com.rybicki.investmentportal.Model.User;
import com.rybicki.investmentportal.Repository.CompanyRepository;
import com.rybicki.investmentportal.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.companyRepository=companyRepository;
    }

    @Override
    public void run(String... args) {
//        // Delete all
//        this.userRepository.deleteAll();
//        this.companyRepository.deleteAll();
//
//        // Crete users
//        User dan = new User("username1",passwordEncoder.encode("password"),"USER","");
//        User admin = new User("username2",passwordEncoder.encode("password"),"USER","");
//        User manager = new User("username3",passwordEncoder.encode("password"),"USER","");
//        User user = new User("username4",passwordEncoder.encode("password"),"USER","");
//
//        List<User> users = Arrays.asList(dan,admin,manager, user);
//
//        // Save to db
//        this.userRepository.saveAll(users);
//        companyRepository.save(new CompanySymbol("FB",dan));
//        companyRepository.save(new CompanySymbol("PSC",dan));
//
//        companyRepository.save(new CompanySymbol("CSCO",admin));
//        companyRepository.save(new CompanySymbol("KO",admin));
//
//        companyRepository.save(new CompanySymbol("CSCO",manager));
//        companyRepository.save(new CompanySymbol("PSC",manager));
//
//        companyRepository.save(new CompanySymbol("AXP",user));
//        companyRepository.save(new CompanySymbol("BA",user));
    }
}
