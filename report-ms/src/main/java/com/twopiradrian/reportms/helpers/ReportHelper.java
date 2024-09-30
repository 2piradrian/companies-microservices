package com.twopiradrian.reportms.helpers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportHelper {

    @Value("${report.template")
    private String reportTemplate;

    public String readTemplate() {
        System.out.println(this.reportTemplate);
        return "";
    }
}
