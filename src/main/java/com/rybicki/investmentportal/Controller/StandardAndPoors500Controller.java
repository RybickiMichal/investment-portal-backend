package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Service.DowJones30Service;
import com.rybicki.investmentportal.Service.StandardAndPoors500Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StandardAndPoors500Controller implements StockController {
    @Autowired
    private StandardAndPoors500Service standardAndPoors500Service;

    @GetMapping("/stocks/standardPoors")
    @Override
    public ArrayList<CompanyBasicInfo> getAllCompanies() {
        return standardAndPoors500Service.findAll();
    }

    @GetMapping("/stocks/standardPoors/{symbol}")
    @Override
    public CompanyBasicInfo getCompany(@PathVariable String symbol) {
        return standardAndPoors500Service.findBySymbol(symbol);
    }
}