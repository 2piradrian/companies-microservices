package com.twopiradrian.reportms.services;

import com.twopiradrian.reportms.helpers.ReportHelper;
import com.twopiradrian.reportms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        reportHelper.readTemplate();
        return this.companiesRepository.findByName(name).orElseThrow().getName();
    }

    @Override
    public String saveReport(String nameReport) {
        return "";
    }

    @Override
    public void deleteReport(String name) {

    }

}
