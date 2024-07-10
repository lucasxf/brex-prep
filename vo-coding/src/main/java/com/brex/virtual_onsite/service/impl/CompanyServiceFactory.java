package com.brex.virtual_onsite.service.impl;

import com.brex.virtual_onsite.service.CompanyService;

/**
 * @author Lucas Xavier Ferreira
 * @date 11/06/2024
 */
public final class CompanyServiceFactory {

    public static CompanyService build() {
        return new CompanyServiceImpl();
    }

}


