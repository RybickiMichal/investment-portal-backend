package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.*;
import com.rybicki.investmentportal.Repository.CompanyRepository;
import com.rybicki.investmentportal.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCompaniesService {

    private Stocks stocks = new Stocks();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCompaniesService.class);
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    public UserCompaniesService() {
    }

    public UserCompaniesService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public ArrayList<CompanyBasicInfo> findAllUserCompanies(String username) {
        User user = loadUser(username);
        ArrayList<CompanyBasicInfo> companies = loadCompanies(user);
        if (!companies.isEmpty()) {
            companies = stocks.actualizeCompaniesData(companies, getCompanySymbols(companies));
        }
        return companies;
    }

    private String[] getCompanySymbols(ArrayList<CompanyBasicInfo> companies) {
        CompanySymbol companiesArray[] = new CompanySymbol[companies.size()];
        String companiesSymbols[] = new String[companies.size()];
        companies.toArray(companiesArray);
        for (int x = 0; x < companiesArray.length; x++) {
            companiesSymbols[x] = companiesArray[x].getSymbol();
        }
        return companiesSymbols;
    }

    private CompanySymbol findCompanyBySymbol(String symbol, String username) {
        User user = loadUser(username);
        ArrayList<CompanySymbol> companies = loadCompanySymbols(user);
        for (CompanySymbol companyBasicInfo : companies) {
            if (companyBasicInfo.getSymbol().equals(symbol)) {
                return companyBasicInfo;
            }
        }
        return null;
    }

    public CompanyBasicInfo findCompanyBasicInfoBySymbol(String symbol, String username) {
        CompanySymbol companySymbol = findCompanyBySymbol(symbol, username);
        CompanyBasicInfo companyBasicInfo = new CompanyBasicInfo(companySymbol.getSymbol(), false);
        stocks.actualizeCompanyData(companyBasicInfo);
        return companyBasicInfo;
    }

    public CompanyBasicInfo deleteBySymbol(String symbol, String username) {
        User user = loadUser(username);
        ArrayList<CompanyBasicInfo> companies = loadCompanies(user);
        CompanySymbol company = findCompanyBySymbol(symbol, username);
        if (company != null) {
            companyRepository.deleteById(company.getId());
            return new CompanyBasicInfo(company.getSymbol(), false);
        }
        return null;
    }

    public CompanyBasicInfo addBySymbol(String symbol, String username) {
        User user = loadUser(username);
        ArrayList<CompanyBasicInfo> companies = loadCompanies(user);
        for (CompanyBasicInfo companyBasicInfo : companies) {
            if (companyBasicInfo.getSymbol().equals(symbol)) {
                return null;
            }
        }
            CompanyBasicInfo company = new CompanyBasicInfo(symbol, true);
            if (company.getSymbol().equals("CompanyBasicInfo doesn't exist")) {
                return null;
            }
            companyRepository.save(new CompanySymbol(company.getSymbol(), user));
            return company;
    }

    private ArrayList<CompanySymbol> loadCompanySymbols(User user) {
        ArrayList<CompanySymbol> companies = new ArrayList<>();
        List<CompanySymbol> repositoryCompanies = companyRepository.findAll();
        for (CompanySymbol company : repositoryCompanies) {
            Long companyUserId = company.getUser().getId();
            Long repositoryUsernameId = user.getId();
            if (companyUserId == repositoryUsernameId) {
                companies.add(new CompanySymbol(company.getSymbol(), user, company.getId()));
            }
        }
        return companies;
    }

    private ArrayList<CompanyBasicInfo> loadCompanies(User user) {
        return transformCompanySymbolsToCompanyBasicInfo(loadCompanySymbols(user));
    }

    private ArrayList<CompanyBasicInfo> transformCompanySymbolsToCompanyBasicInfo(ArrayList<CompanySymbol> symbols) {
        ArrayList<CompanyBasicInfo> companies = new ArrayList<>();
        for (CompanySymbol companySymbol : symbols) {
            companies.add(new CompanyBasicInfo(companySymbol.getSymbol(), false));
        }
        return companies;
    }

    private User loadUser(String username) {
        List<User> users = userRepository.findAll();
        User user = null;
        for (User userInList : users) {
            if (userInList.getUsername().equals(username)) {
                user = userInList;
            }
        }
        if (user == null) {
            throw new UsernameNotFoundException("User is null");
        }
        return user;
    }
}
