package org.sapd.sapdhub;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Component
public class ArrestService {

    private final ArrestRepository arrestRepository;

    public ArrestService(ArrestRepository arrestRepository) {
        this.arrestRepository = arrestRepository;
    }

    public List<Arrest> getArrestsByFilter(BigInteger id, LocalDate date, BigInteger personId, String offense, String severity, String serviceArea, String month, String zipCode, String keyword) {

        // Build dynamic query for filters | Will only return Arrests that satisfy ALL filters
        Specification<Arrest> spec = Specification
                .where(ArrestSpecification.hasArrestId(id))
                .and(ArrestSpecification.hasArrestDate(date))
                .and(ArrestSpecification.hasArrestPersonId(personId))
                .and(ArrestSpecification.hasArrestReportMonth(month))
                .and(ArrestSpecification.hasArrestZipCode(zipCode))
                .and(ArrestSpecification.hasArrestServiceArea(serviceArea))
                .and(ArrestSpecification.hasArrestKeyword(keyword))
                .and(ArrestSpecification.hasArrestSeverity(severity))
                .and(ArrestSpecification.hasArrestOffense(offense));

        // Pass dynamic query to .findAll
        return arrestRepository.findAll(spec);
    }
//
//    public Optional<Arrest> getArrestById(BigInteger id) {
//        Optional<Arrest> arrest = arrestRepository.findById(id);
//        if (arrest.isPresent()) {
//            System.out.println("Arrest found: " + arrest.get());
//        } else {
//            System.out.println("No arrest found with ID: " + id);
//            return Optional.empty();
//        }
//        return arrest;
//    }
//
//    public List<Arrest> getArrestByDate(LocalDate date) {
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getReport_date().equals(date))
//                .collect(Collectors.toList()
//                );
//    }
//
//    public List<Arrest> getArrestByMonth(String month) {
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getReport_month().equalsIgnoreCase(month))
//                .collect(Collectors.toList()
//                );
//    }
//
//    public List<Arrest> getArrestByZip(String zip) {
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getZip_code().equalsIgnoreCase(zip))
//                .collect(Collectors.toList()
//                );
//    }
//
//    // NORTH, EAST, SOUTH, WEST, CENTRAL, PRUE, DOWNTOWN
//    public List<Arrest> getArrestByServiceArea(String serviceArea) {
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getService_area().equalsIgnoreCase(serviceArea))
//                .collect(Collectors.toList()
//                );
//    }
//
//    public List<Arrest> getArrestByKeyword(String keyword) { // Maybe redo this method to make keyword search through all elements
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getOffense().toLowerCase().contains(keyword.toLowerCase()))
//                .collect(Collectors.toList()
//                );
//    }
//
//    public List<Arrest> getArrestBySeverity(String severity) {
//        // Add error handling/messages
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getSeverity().equalsIgnoreCase(severity))
//                .collect(Collectors.toList()
//                );
//    }
//
//    public List<Arrest> getArrestByOffense(String offense) {
//        return arrestRepository.findAll()
//                .stream()
//                .filter(arrest -> arrest.getOffense().equalsIgnoreCase(offense))
//                .collect(Collectors.toList()
//                );
//    }
}
