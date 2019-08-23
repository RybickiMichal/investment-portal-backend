package com.rybicki.investmentportal.Repository;

import com.rybicki.investmentportal.Model.CompanySymbol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanySymbol, Long> {

}
