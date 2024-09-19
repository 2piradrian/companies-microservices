package com.twopiardrian.companiescrud.services;

import com.twopiardrian.companiescrud.entities.Category;
import com.twopiardrian.companiescrud.entities.Company;
import com.twopiardrian.companiescrud.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company readByName(String name) {
        return this.companyRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
    }

    @Override
    public Company create(Company company) {
        company.getWebsites().forEach(website -> {
            if (Objects.isNull(website.getCategory())){
                website.setCategory(Category.NONE);
            }
        });

        return this.companyRepository.save(company);
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFounder(company.getFounder());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setWebsites(company.getWebsites());

        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = this.companyRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));

        this.companyRepository.delete(companyToDelete);
    }

}
