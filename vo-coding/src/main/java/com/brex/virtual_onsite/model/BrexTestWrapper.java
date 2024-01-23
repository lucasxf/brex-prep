package com.brex.virtual_onsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrexTestWrapper {

    @JsonProperty("data")
    private List<Company> companies;

    // required by jackson
    public List<Company> getCompanies() {
        return companies;
    }

    // required by jackson
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "BrexTestWrapper{" +
                "data=" + companies +
                '}';
    }

}
