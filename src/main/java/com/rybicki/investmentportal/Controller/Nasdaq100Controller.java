package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Service.IndexBasicInfoService;
import com.rybicki.investmentportal.Service.Nasdaq100Service;
import com.rybicki.investmentportal.Service.RandomCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Nasdaq100Controller implements StockController {

    @Autowired
    private Nasdaq100Service nasdaq100Service;

    @Autowired
    private RandomCompaniesService randomCompaniesService;

    @Autowired
    private IndexBasicInfoService indexBasicInfoService;

    @GetMapping("/stocks/nasdaq")
    @Override
    public ArrayList<CompanyBasicInfo> getAllCompanies() {
        return nasdaq100Service.findAll();
    }

    @GetMapping("/stocks/nasdaq/{symbol}")
    @Override
    public CompanyBasicInfo getCompany(@PathVariable String symbol) {
        return nasdaq100Service.findBySymbol(symbol);
    }

    @GetMapping("/stocks/nasdaq/getIndexInfo")
    @Override
    public CompanyBasicInfo getIndexInfo() {
        return indexBasicInfoService.getIndexBasicInfo("^NDX");
    }

    @GetMapping("/stocks/nasdaq/getRandomCompanies")
    @Override
    public ArrayList<CompanyBasicInfo> getRandomCompanies() {
        return randomCompaniesService.randomizeNasdaq100Companies();
    }
}

