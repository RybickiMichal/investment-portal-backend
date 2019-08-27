package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Model.Stocks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StandardAndPoors500Service implements StockService {

    private Stocks stocks = new Stocks();
    private ArrayList<CompanyBasicInfo> standardAndPoors500 = stocks.getStandardAndPoors500();
    private String[] standardAndPoors500Symbols = stocks.getStandardAndPoors500Symbols();

    @Override
    public ArrayList<CompanyBasicInfo> findAll() {
        standardAndPoors500 = stocks.actualizeCompaniesData(standardAndPoors500, standardAndPoors500Symbols);
        return standardAndPoors500;
    }

    @Override
    public CompanyBasicInfo findBySymbol(String symbol) {
        for (CompanyBasicInfo companyBasicInfo : standardAndPoors500) {
            if (companyBasicInfo.getSymbol().equals(symbol)) {
                stocks.actualizeCompanyData(companyBasicInfo);
                return companyBasicInfo;
            }
        }
        return null;
    }
}

