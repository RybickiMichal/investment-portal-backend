package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;

import java.util.ArrayList;

public interface StockService {

    ArrayList<CompanyBasicInfo> findAll();

    CompanyBasicInfo findBySymbol(String symbol);

}
