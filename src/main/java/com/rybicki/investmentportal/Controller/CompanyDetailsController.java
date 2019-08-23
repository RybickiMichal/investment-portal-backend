package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyDetailsController {

    @GetMapping("/stocks/companyDetails/{symbol}")
    public Map<String, Object> getCompanyDetails(@PathVariable String symbol){
        CompanyDetails companyDetails = new CompanyDetails(symbol);
        return  companyDetails.getCompanyDetails();
    }

}
