package com.brex.virtual_onsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Company {

    @JsonProperty("company")
    private String name;

    @JsonProperty("created_at")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private LocalDateTime foundationDate;

    @JsonProperty("name")
    private String founderName;

    private ZonedDateTime zonedFoundationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDateTime foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public ZonedDateTime getZonedFoundationDate() {
        return zonedFoundationDate;
    }

    public void setZonedFoundationDate(ZonedDateTime zonedFoundationDate) {
        this.zonedFoundationDate = zonedFoundationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationDate='" + foundationDate + '\'' +
                ", founderName='" + founderName + '\'' +
                '}';
    }

}
