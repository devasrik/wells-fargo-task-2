package com.wellsfargo.counselor.entity;

//imported libraries one to one and one to many and local date and set
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

//this is for the portfolio 
@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Long portfolioId;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OneToOne
    private Client client;

    @OneToMany(mappedBy = "portfolio") // added this for relationship type with advisor and client 
    private Set<Security> securities;

    protected Portfolio() {

    }
    
    //added the arguments for the get and set functions
    public Portfolio(LocalDate creationDate, Client client, Set<Security> securities) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = securities;
    }
   //sets and gets
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
