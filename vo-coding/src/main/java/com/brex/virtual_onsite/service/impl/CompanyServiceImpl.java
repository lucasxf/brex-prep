package com.brex.virtual_onsite.service.impl;

import com.brex.virtual_onsite.model.BrexTestWrapper;
import com.brex.virtual_onsite.model.Company;
import com.brex.virtual_onsite.rest.Client;
import com.brex.virtual_onsite.service.CompanyService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Lucas Xavier Ferreira
 * @date 11/06/2024
 */
class CompanyServiceImpl implements CompanyService {

    private static final ZoneId SAO_PAULO_ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private static final ZoneId PST_ZONE_ID = ZoneId.of("PST", ZoneId.SHORT_IDS);

    private final Client client;

    public CompanyServiceImpl() {
        this(new Client());
    }

    public CompanyServiceImpl(Client client) {
        this.client = client;
    }

    @Override
    public List<Company> getCompanies() {
        BrexTestWrapper wrapper = client.performRequest();
        List<Company> companies = wrapper.getCompanies();
        validateResponse(wrapper);
        updateDateTimes(companies);
        System.out.println(companies);
        return companies;
    }

    private void updateDateTimes(List<Company> companies) {
        if (companies.isEmpty()) {
            return;
        }
        companies.forEach(c -> localToZonedDateTime(c, PST_ZONE_ID));
    }

    private void localToZonedDateTime(Company c, ZoneId z) {
        LocalDateTime foundationDate = c.getFoundationDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(foundationDate, z);
        c.setZonedFoundationDate(zonedDateTime);
    }

    private void validateResponse(BrexTestWrapper wrapper) {
        if (wrapper == null || wrapper.getCompanies() == null) {
            throw new RuntimeException("Invalid response");
        }
    }

}
