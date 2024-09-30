package com.twopiradrian.reportms.repositories;

import com.twopiradrian.reportms.models.Company;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "companies-crud")
@LoadBalancerClient(name = "companies-crud", configuration = CompaniesRepository.class)
public interface CompaniesRepository {

    @GetMapping("/companies-crud/company/{name}")
    Optional<Company> findByName(@PathVariable String name);
}
