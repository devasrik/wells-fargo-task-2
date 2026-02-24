package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OnetoOne
    private Client client;

    @ManytoOne(mappedBy = "portfolio") // added this for relationship type with advisor and client 
    private Set<Security> securities;

    protected Portfolio() {

    }

    public Portfolio(LocalDate creationDate, Client client, Set<Security> securities) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = securities;
    }

   public Long getPortfolioId() {
        return portfolioId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }
}
