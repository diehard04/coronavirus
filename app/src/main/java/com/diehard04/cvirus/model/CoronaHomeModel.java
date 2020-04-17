package com.diehard04.cvirus.model;

/**
 * Created by DIPAK on 3/3/2020.
 */
public class CoronaHomeModel {
    private String total_cases;
    private String total_critical;
    private String total_death;
    private String total_recovered;

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getTotal_critical() {
        return total_critical;
    }

    public void setTotal_critical(String total_critical) {
        this.total_critical = total_critical;
    }

    public String getTotal_death() {
        return total_death;
    }

    public void setTotal_death(String total_death) {
        this.total_death = total_death;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }
}
