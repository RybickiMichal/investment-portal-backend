package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public interface StockController {

    ArrayList<CompanyBasicInfo> getAllCompanies();

    CompanyBasicInfo getCompany(@PathVariable String index);

}
