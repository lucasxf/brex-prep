package com.brex.virtual_onsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty("company")
    private String name;

    @JsonProperty("created_at")
    private String foundationDate;

    @JsonProperty("name")
    private String founderName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

}
