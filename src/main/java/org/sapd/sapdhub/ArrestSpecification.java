package org.sapd.sapdhub;

import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;
import java.time.LocalDate;

public class ArrestSpecification {

    /**
     * To explain all these methods quickly, each method takes in the filter provided from user.
     * Next, it checks if the filter is NULL, and if so, returns NULL.
     * If it is not NULL, it constructs a condition/predicate to filter the database.
     * @return Query or NULL
     */
    public static Specification <Arrest> hasArrestId(Integer id) {
        return (root, query, cb) -> id == null ? null : cb.equal(root.get("id"), id);
    }

    public static Specification <Arrest> hasArrestReportId(BigInteger report_id) {
        return (root, query, cb) -> report_id == null ? null : cb.equal(root.get("report_id"), report_id);
    }

    public static Specification<Arrest> hasArrestDate(LocalDate date) {
        return (root, query, cb) -> date == null ? null : cb.equal(root.get("report_date"), date);
    }

    public static Specification<Arrest> hasArrestPersonId(BigInteger person_id) {
        return (root, query, cb) -> person_id == null ? null : cb.equal(root.get("person_id"), person_id);
    }

    public static Specification<Arrest> hasArrestReportMonth(String reportMonth) {
        return (root, query, cb) -> reportMonth == null ? null : cb.like(cb.lower(root.get("report_month")), "%" + reportMonth.toLowerCase() + "%");
    }

    public static Specification<Arrest> hasArrestZipCode(String zipCode) {
        return (root, query, cb) -> zipCode == null ? null : cb.like(root.get("zip_code"), "%" + zipCode + "%");
    }

    public static Specification<Arrest> hasArrestServiceArea(String serviceArea) {
        return (root, query, cb) -> serviceArea == null ? null : cb.like(cb.lower(root.get("service_area")), "%" + serviceArea.toLowerCase() + "%");
    }


    public static Specification<Arrest> hasArrestKeyword(String keyword) {

        return (root, query, cb) -> {
            if (keyword == null) {
                return null;
            }

            // Fuzzy search aka "Close Enough" search
            String pattern = "%" + keyword.toLowerCase() + "%";

            // At the moment, only searches for offense and severity are supported
            return cb.or(
                    cb.like(cb.lower(root.get("offense")), pattern),
                    cb.like(cb.lower(root.get("severity")), pattern)
            );
        };
    }

    public static Specification<Arrest> hasArrestSeverity(String severity) {
        return (root, query, cb) -> severity == null ? null : cb.like(cb.lower(root.get("severity")), "%" + severity.toLowerCase() + "%");
    }

    public static Specification<Arrest> hasArrestOffense(String offense) {
        return (root, query, cb) -> offense == null ? null : cb.like(cb.lower(root.get("offense")), "%" + offense.toLowerCase() + "%");
    }

    // public static Specification<Arrest> getAllSpecs()


}
