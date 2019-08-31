package com.rybicki.investmentportal.Controller;

import com.rybicki.investmentportal.Model.CompanyBasicInfo;
import com.rybicki.investmentportal.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndexInfoController {

    @Autowired
    private IndexBasicInfoService indexBasicInfoService;

    @GetMapping("/stocks/index/getNasdaq100DowJones30SAndP500Indexes")
    public ArrayList<CompanyBasicInfo> getNasdaq100DowJones30SAndP500Indexes() {
        return indexBasicInfoService.getNasdaq100DowJones30SAndP500Indexes();
    }
}
