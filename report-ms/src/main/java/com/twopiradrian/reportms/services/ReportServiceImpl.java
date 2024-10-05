package com.twopiradrian.reportms.services;

import com.twopiradrian.reportms.helpers.ReportHelper;
import com.twopiradrian.reportms.models.Company;
import com.twopiradrian.reportms.models.WebSite;
import com.twopiradrian.reportms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        return reportHelper
                .readTemplate(this.companiesRepository.findByName(name).orElseThrow());
    }

    @Override
    public String saveReport(String report) {
        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeholders = this.reportHelper.getPlaceholdersFromTemplate(report);
        var webSites = Stream.of(placeholders.get(3))
                .map(website -> WebSite.builder().name(website).build())
                .toList();

        var company = Company.builder()
                .name(placeholders.get(0))
                .founder(placeholders.get(1))
                .foundationDate(LocalDate.parse(placeholders.get(2), format))
                .websites(webSites)
                .build();

        this.companiesRepository.saveByName(company);

        return "";
    }

    @Override
    public void deleteReport(String name) {
        this.companiesRepository.deleteByName(name);
    }

}
