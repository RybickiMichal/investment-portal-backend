package com.rybicki.investmentportal.Model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class CompanySymbol implements Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String symbol;

    @ManyToOne
    @JoinColumn
    private User user;

    public CompanySymbol() {}

    public CompanySymbol(String symbol, User user) {
        this.symbol = symbol;
        this.user = user;
    }

    public CompanySymbol(String symbol, User user, Long id) {
        this.symbol = symbol;
        this.user = user;
        this.id = id;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }


}
