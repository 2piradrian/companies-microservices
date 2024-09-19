package com.twopiardrian.companiescrud.services;

import com.twopiardrian.companiescrud.entities.Company;

public interface CompanyService {

    Company readByName(String name);
    Company create(Company company);
    Company update(Company company, String name);
    void delete(String name);
}
