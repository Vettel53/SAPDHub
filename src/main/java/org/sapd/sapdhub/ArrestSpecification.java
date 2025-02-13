package org.sapd.sapdhub;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;
import java.time.LocalDate;

public class ArrestSpecification {

    public static Specification <Arrest> hasArrestId(BigInteger id) {
        return (root, query, cb) -> id == null ? null : cb.equal(root.get("id"), id);
    }

    public static Specification<Arrest> hasArrestDate(LocalDate date) {
        return (root, query, cb) -> date == null ? null : cb.equal(root.get("report_date"), date);
    }

    public static Specification<Arrest> hasArrestReportMonth(String reportMonth) {
        return (root, query, cb) -> reportMonth == null ? null : cb.equal(root.get("report_month"), reportMonth);
    }

    public static Specification<Arrest> hasArrestZipCode(String zipCode) {
        return (root, query, cb) -> zipCode == null ? null : cb.equal(root.get("zip_code"), zipCode);
    }

    public static Specification<Arrest> hasArrestServiceArea(String serviceArea) {
        return (root, query, cb) -> serviceArea == null ? null : cb.equal(root.get("service_area"), serviceArea);
    }

    public static Specification<Arrest> hasArrestKeyword(String keyword) { // TODO: Change this to look through whole arrest report
        return (root, query, cb) -> keyword == null ? null : cb.equal(root.get("offense"), keyword);
    }

    public static Specification<Arrest> hasArrestSeverity(String severity) {
        return (root, query, cb) -> severity == null ? null : cb.equal(root.get("severity"), severity);
    }

    public static Specification<Arrest> hasArrestOffense(String offense) {
        return (root, query, cb) -> offense == null ? null : cb.equal(root.get("offense"), offense);
    }

    public static Specification<Arrest> getAllSpecs()


}
