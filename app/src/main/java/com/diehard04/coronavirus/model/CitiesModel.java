package com.diehard04.coronavirus.model;

/**
 * Created by DIPAK on 3/5/2020.
 */
public class CitiesModel {

    private String citiesName;
    private String totalCases;
    private String newCases;
    private String totalDeath;
    private String recoveredCases;

    public String getCitiesName() {
        return citiesName;
    }

    public void setCitiesName(String citiesName) {
        this.citiesName = citiesName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(String totalDeath) {
        this.totalDeath = totalDeath;
    }

    public String getRecoveredCases() {
        return recoveredCases;
    }

    public void setRecoveredCases(String recoveredCases) {
        this.recoveredCases = recoveredCases;
    }
}
