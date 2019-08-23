package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Service.DowJones30Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DowJones30Controller implements StockController {
    @Autowired
    private DowJones30Service dowJones30Service;

    @GetMapping("/stocks/dowJones")
    @Override
    public ArrayList<CompanyBasicInfo> getAllCompanies(){
        return dowJones30Service.findAll();
    }

    @GetMapping("/stocks/dowJones/{symbol}")
    @Override
    public CompanyBasicInfo getCompany(@PathVariable String symbol){
        return dowJones30Service.findBySymbol(symbol);
    }
}
