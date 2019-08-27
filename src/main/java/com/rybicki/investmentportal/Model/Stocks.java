package com.rybicki.investmentportal.Model;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Stocks {
    private ArrayList<CompanyBasicInfo> dowJones30;
    private static String[] dowJones30Symbols = new String[]{"AXP", "AAPL", "BA", "CAT", "CVX", "CSCO", "DIS", "DOW", "GS", "HD", "IBM", "INTC", "JNJ", "JPM", "KO", "MCD", "MMM", "MRK", "MSFT", "NKE", "PFE", "PG", "TRV", "UTX", "UNH", "VZ", "V", "WMT", "WBA", "XOM"};
    private ArrayList<CompanyBasicInfo> standardAndPoors500;
    private static String[] standardAndPoors500Symbols = new String[]{"ABT", "ABBV", "ACN", "ACE", "ADBE", "ADT", "AAP", "AES", "AET", "AFL", "AMG", "A", "GAS", "APD", "ARG", "AKAM", "AA", "AGN", "ALXN", "ALLE", "ADS", "ALL", "ALTR", "MO", "AMZN", "AEE", "AAL", "AEP", "AXP", "AIG", "AMT", "AMP", "ABC", "AME", "AMGN", "APH", "APC", "ADI", "AON", "APA", "AIV", "AMAT", "ADM", "AIZ", "T", "ADSK", "ADP", "AN", "AZO", "AVGO", "AVB", "AVY", "BHI", "BLL", "BAC", "BK", "BCR", "BXLT", "BAX", "BBT", "BDX", "BBBY", "BRK-B", "BBY", "BLX", "HRB", "BA", "BWA", "BXP", "BSK", "BMY", "BRCM", "BF-B", "CHRW", "CA", "CVC", "COG", "CAM", "CPB", "COF", "CAH", "HSIC", "KMX", "CCL", "CAT", "CBG", "CBS", "CELG", "CNP", "CTL", "CERN", "CF", "SCHW", "CHK", "CVX", "CMG", "CB", "CI", "XEC", "CINF", "CTAS", "CSCO", "C", "CTXS", "CLX", "CME", "CMS", "COH", "KO", "CCE", "CTSH", "CL", "CMCSA", "CMA", "CSC", "CAG", "COP", "CNX", "ED", "STZ", "GLW", "COST", "CCI", "CSX", "CMI", "CVS", "DHI", "DHR", "DRI", "DVA", "DE", "DLPH", "DAL", "XRAY", "DVN", "DO", "DTV", "DFS", "DISCA", "DISCK", "DG", "DLTR", "D", "DOV", "DOW", "DPS", "DTE", "DD", "DUK", "DNB", "ETFC", "EMN", "ETN", "EBAY", "ECL", "EIX", "EW", "EA", "EMC", "EMR", "ENDP", "ESV", "ETR", "EOG", "EQT", "EFX", "EQIX", "EQR", "ESS", "EL", "ES", "EXC", "EXPE", "EXPD", "ESRX", "XOM", "FFIV", "FB", "FAST", "FDX", "FIS", "FITB", "FSLR", "FE", "FLIR", "FLS", "FLR", "FMC", "FTI", "F", "FOSL", "BEN", "FCX", "FTR", "GME", "GPS", "GRMN", "GD", "GE", "GGP", "GIS", "GM", "GPC", "GNW", "GILD", "GS", "GT", "GOOGL", "GOOG", "GWW", "HAL", "HBI", "HOG", "HAR", "HRS", "HIG", "HAS", "HCA", "HCP", "HCN", "HP", "HES", "HPQ", "HD", "HON", "HRL", "HSP", "HST", "HCBK", "HUM", "HBAN", "ITW", "IR", "INTC", "ICE", "IBM", "IP", "IPG", "IFF", "INTU", "ISRG", "IVZ", "IRM", "JEC", "JBHT", "JNJ", "JCI", "JOY", "JPM", "JNPR", "KSU", "K", "KEY", "GMCR", "KMB", "KIM", "KMI", "KLAC", "KSS", "KRFT", "KR", "LB", "LLL", "LH", "LRCX", "LM", "LEG", "LEN", "LVLT", "LUK", "LLY", "LNC", "LLTC", "LMT", "L", "LOW", "LYB", "MTB", "MAC", "M", "MNK", "MRO", "MPC", "MAR", "MMC", "MLM", "MAS", "MA", "MAT", "MKC", "MCD", "MHFI", "MCK", "MJN", "MMV", "MDT", "MRK", "MET", "KORS", "MCHP", "MU", "MSFT", "MHK", "TAP", "MDLZ", "MON", "MNST", "MCO", "MS", "MOS", "MSI", "MUR", "MYL", "NDAQ", "NOV", "NAVI", "NTAP", "NFLX", "NWL", "NFX", "NEM", "NWSA", "NEE", "NLSN", "NKE", "NI", "NE", "NBL", "JWN", "NSC", "NTRS", "NOC", "NRG", "NUE", "NVDA", "ORLY", "OXY", "OMC", "OKE", "ORCL", "OI", "PCAR", "PLL", "PH", "PDCO", "PAYX", "PNR", "PBCT", "POM", "PEP", "PKI", "PRGO", "PFE", "PCG", "PM", "PSX", "PNW", "PXD", "PBI", "PCL", "PNC", "RL", "PPG", "PPL", "PX", "PCP", "PCLN", "PFG", "PG", "PGR", "PLD", "PRU", "PEG", "PSA", "PHM", "PVH", "QRVO", "PWR", "QCOM", "DGX", "RRC", "RTN", "O", "RHT", "REGN", "RF", "RSG", "RAI", "RHI", "ROK", "COL", "ROP", "ROST", "RLC", "R", "CRM", "SNDK", "SCG", "SLB", "SNI", "STX", "SEE", "SRE", "SHW", "SIAL", "SPG", "SWKS", "SLG", "SJM", "SNA", "SO", "LUV", "SWN", "SE", "STJ", "SWK", "SPLS", "SBUX", "HOT", "STT", "SRCL", "SYK", "STI", "SYMC", "SYY", "TROW", "TGT", "TEL", "TE", "TGNA", "THC", "TDC", "TSO", "TXN", "TXT", "HSY", "TRV", "TMO", "TIF", "TWX", "TWC", "TJK", "TMK", "TSS", "TSCO", "RIG", "TRIP", "FOXA", "TSN", "TYC", "UA", "UNP", "UNH", "UPS", "URI", "UTX", "UHS", "UNM", "URBN", "VFC", "VLO", "VAR", "VTR", "VRSN", "VZ", "VRTX", "VIAB", "V", "VNO", "VMC", "WMT", "WBA", "DIS", "WM", "WAT", "ANTM", "WFC", "WDC", "WU", "WY", "WHR", "WFM", "WMB", "WEC", "WYN", "WYNN", "XEL", "XRX", "XLNX", "XL", "XYL", "YHOO", "YUM", "ZBH", "ZION", "ZTS"};

    public Stocks() {


    }

    public ArrayList getDowJones30() {
        if (dowJones30 == null) {
            dowJones30 = new ArrayList<CompanyBasicInfo>();
            dowJones30 = this.loadCompanies(dowJones30, dowJones30Symbols);
        }
        return dowJones30;
    }

    public static String[] getDowJones30Symbols() {
        return dowJones30Symbols;
    }

    public ArrayList<CompanyBasicInfo> getStandardAndPoors500() {
        if (standardAndPoors500 == null) {
            standardAndPoors500 = new ArrayList<CompanyBasicInfo>();
            standardAndPoors500 = this.loadCompanies(standardAndPoors500, standardAndPoors500Symbols);
           }
        return standardAndPoors500;
    }

    private ArrayList<CompanyBasicInfo> loadCompanies(ArrayList<CompanyBasicInfo> index, String[] symbols){
        for (int x = 0; x < symbols.length; x++) {
            index.add(new CompanyBasicInfo(symbols[x], false));
        }
        return actualizeCompaniesData(index, symbols);
    }
    public static String[] getStandardAndPoors500Symbols() {
        return standardAndPoors500Symbols;
    }

    public CompanyBasicInfo actualizeCompanyData(CompanyBasicInfo companyBasicInfo) {
        try {
            Stock stock = YahooFinance.get(companyBasicInfo.getSymbol());
            companyBasicInfo.setAnnualYieldDividend(stock.getDividend().getAnnualYield());
            companyBasicInfo.setPrice(stock.getQuote().getPrice());
            companyBasicInfo.setChange(stock.getQuote().getChange());
            companyBasicInfo.setChangeInPercent(stock.getQuote().getChangeInPercent());
            return companyBasicInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CompanyBasicInfo> actualizeCompaniesData(ArrayList<CompanyBasicInfo> companies, String[] symbols) {
        try {
            Map<String, Stock> stock = YahooFinance.get(symbols);
            companies.forEach((company) -> {
                for (int x = 0; x < symbols.length; x++) {
                    if (symbols[x].equals(company.getSymbol())) {
                        company.setAnnualYieldDividend(stock.get(symbols[x]).getDividend().getAnnualYield());
                        company.setPrice(stock.get(symbols[x]).getQuote().getPrice());
                        company.setChange(stock.get(symbols[x]).getQuote().getChange());
                        company.setChangeInPercent(stock.get(symbols[x]).getQuote().getChangeInPercent());
                        if (company.getName() == null || company.getName().isEmpty()) {
                            company.setName(stock.get(symbols[x]).getName());
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
