package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Model.Stocks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DowJones30Service implements StockService {

    private Stocks stocks = new Stocks();
    private ArrayList<CompanyBasicInfo> dowJones30 = stocks.getDowJones30();
    private String[] dowJones30symbols = stocks.getDowJones30Symbols();

    @Override
    public ArrayList<CompanyBasicInfo> findAll(){
        dowJones30 = stocks.actualizeCompaniesData(dowJones30, dowJones30symbols);
        return dowJones30;
    }

    @Override
    public CompanyBasicInfo findBySymbol(String symbol){
        for(CompanyBasicInfo companyBasicInfo : dowJones30){
            if(companyBasicInfo.getSymbol().equals(symbol)){
                stocks.actualizeCompanyData(companyBasicInfo);
                return companyBasicInfo;
            }
        }
        return null;
    }
}
