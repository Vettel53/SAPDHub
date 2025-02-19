package org.sapd.sapdhub;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "sapd_arrests")
public class Arrest {

    @Id // Primary key
    @Column(name = "report_id", unique=true)
    private BigInteger id;
    private LocalDate report_date;
    private BigInteger person_id;
    private String offense;
    private String severity;
    private String service_area;
    private String report_month;
    private String zip_code;
    private LocalDate datetime;

    // Getters and setters


    public Arrest() {

    }

    public Arrest(BigInteger id, LocalDate report_date, BigInteger person_id, String offense, String severity, String service_area, String report_month, String zip_code, LocalDate datetime) {
        this.id = id;
        this.report_date = report_date;
        this.person_id = person_id;
        this.offense = offense;
        this.severity = severity;
        this.service_area = service_area;
        this.report_month = report_month;
        this.zip_code = zip_code;
        this.datetime = datetime;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public LocalDate getReport_date() {
        return report_date;
    }

    public void setReport_date(LocalDate report_date) {
        this.report_date = report_date;
    }

    public BigInteger getPerson_id() {
        return person_id;
    }

    public void setPerson_id(BigInteger person_id) {
        this.person_id = person_id;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getReport_month() {
        return report_month;
    }

    public void setReport_month(String report_month) {
        this.report_month = report_month;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }
}
