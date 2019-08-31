package com.rybicki.investmentportal.Service;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Model.Stocks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class RandomCompaniesService {
    Stocks stocks = new Stocks();
    String[] dowJones30Symbols;
    String[] standardAndPoors500Symbols;
    String[] nasdaq100Symbols;

    public RandomCompaniesService() {
        dowJones30Symbols = stocks.getDowJones30Symbols();
        standardAndPoors500Symbols = stocks.getStandardAndPoors500Symbols();
        nasdaq100Symbols = stocks.getNasdaq100Symbols();
    }

    public ArrayList<CompanyBasicInfo> randomizeDowJones30Companies(){
        return randomizeCompanies(dowJones30Symbols);
    }

    public ArrayList<CompanyBasicInfo> randomizeNasdaq100Companies(){
        return randomizeCompanies(nasdaq100Symbols);
    }

    public ArrayList<CompanyBasicInfo> randomizeStandardAndPoors500Companies(){
        return randomizeCompanies(standardAndPoors500Symbols);
    }

    private ArrayList<CompanyBasicInfo> randomizeCompanies(String[] companiesSymbols) {
        ArrayList<CompanyBasicInfo> randomCompanies = new ArrayList<>();
        int numberOfCompanies = 4;
        String[] randomCompaniesSymbols = new String[numberOfCompanies];
        Random generator = new Random();
        int numberOfAvailableCompanies = companiesSymbols.length;
        boolean companyexistsInTheList = false;
        do {
            String companySymbol = companiesSymbols[generator.nextInt(numberOfAvailableCompanies)];
                for(CompanyBasicInfo company: randomCompanies){
                    if(company.getSymbol().equals(companySymbol)){
                        companyexistsInTheList = true;
                    }
                }
                if(!companyexistsInTheList) {
                    randomCompanies.add(new CompanyBasicInfo(companySymbol, false));
                }
        } while (randomCompanies.size() != numberOfCompanies);
        int counter = 0;
        for(CompanyBasicInfo company: randomCompanies){
            randomCompaniesSymbols[counter++] = company.getSymbol();
        }
        stocks.actualizeCompaniesData(randomCompanies, randomCompaniesSymbols);
        return randomCompanies;
    }
}
