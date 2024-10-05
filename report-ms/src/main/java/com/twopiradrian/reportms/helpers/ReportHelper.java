package com.twopiradrian.reportms.helpers;

import com.twopiradrian.reportms.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ReportHelper {

    @Value("${report.template")
    private String reportTemplate;

    public String readTemplate(Company company) {
        return this.reportTemplate
                .replace("{company}", company.getName())
                .replace("{foundation_date}", company.getFoundationDate().toString())
                .replace("{founder}", company.getFounder())
                .replace("{web_sites}", company.getWebsites().toString());
    }

    public List<String> getPlaceholdersFromTemplate(String template) {
        var split = template.split("\\{");

        return Arrays.stream(split)
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(0, s.indexOf("}")))
                .collect(Collectors.toList());
    }
}
