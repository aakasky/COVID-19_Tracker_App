package com.example.covid_19tracker;

public class Model {

    String districtName;
    String active;
    String recovered;
    String deceased;
    String confirmed;
    String nActive;
    String nRecovered;
    String nDead;

    public Model(String districtName, String active, String recovered, String deceased, String confirmed, String nActive, String nRecovered, String nDead) {
        this.districtName = districtName;
        this.active = active;
        this.recovered = recovered;
        this.deceased = deceased;
        this.confirmed = confirmed;
        this.nActive = nActive;
        this.nRecovered = nRecovered;
        this.nDead = nDead;
    }

    public Model() {

    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getnActive() {
        return nActive;
    }

    public void setnActive(String nActive) {
        this.nActive = nActive;
    }

    public String getnRecovered() {
        return nRecovered;
    }

    public void setnRecovered(String nRecovered) {
        this.nRecovered = nRecovered;
    }

    public String getnDead() {
        return nDead;
    }

    public void setnDead(String nDead) {
        this.nDead = nDead;
    }


}
