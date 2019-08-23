package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Service.UserCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserCompaniesController {
    @Autowired
    private UserCompaniesService userCompaniesService;

    @GetMapping("/stocks/{username}/myCompanies")
    public ArrayList<CompanyBasicInfo> getAllCompanies(@PathVariable String username){
        return userCompaniesService.findAllUserCompanies(username);
    }

    @GetMapping("/stocks/{username}/myCompanies/{symbol}")
    public CompanyBasicInfo getCompany(@PathVariable String symbol, @PathVariable String username){
        return userCompaniesService.findCompanyBasicInfoBySymbol(symbol, username);
    }

    @DeleteMapping("/stocks/{username}/myCompanies/{symbol}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String username, @PathVariable String symbol){
        CompanyBasicInfo companyBasicInfo = userCompaniesService.deleteBySymbol(symbol, username);
        if(companyBasicInfo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/stocks/{username}/myCompanies/{symbol}")
    public ResponseEntity<Void> addCompany(@PathVariable String username, @PathVariable String symbol){
        CompanyBasicInfo createdCompanyBasicInfo = userCompaniesService.addBySymbol(symbol, username);
        if(createdCompanyBasicInfo == null){
            return ResponseEntity.badRequest().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(createdCompanyBasicInfo.getSymbol()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
