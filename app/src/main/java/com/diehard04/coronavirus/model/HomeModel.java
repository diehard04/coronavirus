package com.diehard04.coronavirus.model;

/**
 * Created by DIPAK on 3/3/2020.
 */
public class HomeModel {

    private String totalCriticalCases;
    private String totalDeathCases;
    private String totalRecoveredCases;
    private String totalCases;

    public HomeModel(String totalCases, String totalCriticalCases, String totalDeathCases, String totalRecoveredCases) {
        this.totalCases = totalCases;
        this.totalCriticalCases = totalCriticalCases;
        this.totalDeathCases = totalDeathCases;
        this.totalRecoveredCases = totalRecoveredCases;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalCriticalCases() {
        return totalCriticalCases;
    }

    public void setTotalCriticalCases(String totalCriticalCases) {
        this.totalCriticalCases = totalCriticalCases;
    }

    public String getTotalDeathCases() {
        return totalDeathCases;
    }

    public void setTotalDeathCases(String totalDeathCases) {
        this.totalDeathCases = totalDeathCases;
    }

    public String getTotalRecoveredCases() {
        return totalRecoveredCases;
    }

    public void setTotalRecoveredCases(String totalRecoveredCases) {
        this.totalRecoveredCases = totalRecoveredCases;
    }
}
