package com.twopiradrian.reportms.repositories;

import com.twopiradrian.reportms.models.Company;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "companies-crud")
@LoadBalancerClient(name = "companies-crud", configuration = CompaniesRepository.class)
public interface CompaniesRepository {

    @GetMapping("/companies-crud/company/{name}")
    Optional<Company> findByName(@PathVariable String name);

    @PostMapping("/companies-crud/company")
    Optional<Company> saveByName(@RequestBody Company company);

    @DeleteMapping("/companies-crud/company/{name}")
    void deleteByName(@PathVariable String name);
}
