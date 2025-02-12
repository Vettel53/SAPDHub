package org.sapd.sapdhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ArrestService {

    private final ArrestRepository arrestRepository;

    @Autowired
    public ArrestService(ArrestRepository arrestRepository) {
        this.arrestRepository = arrestRepository;
    }

    public Optional<Arrest> getArrestById(BigInteger id) {
        Optional<Arrest> arrest = arrestRepository.findById(id);
        if (arrest.isPresent()) {
            System.out.println("Arrest found: " + arrest.get());
        } else {
            System.out.println("No arrest found with ID: " + id);
            return Optional.empty();
        }
        return arrest;
    }

    public List<Arrest> getArrestByDate(LocalDate date) {
        // Add error handling/messages
        return arrestRepository.findAll()
                .stream()
                .filter(arrest -> arrest.getReport_date().equals(date))
                .collect(Collectors.toList()
                );
    }

    public List<Arrest> getArrestByMonth(String month) {
        // Add error handling/messages
        return arrestRepository.findAll()
                .stream()
                .filter(arrest -> arrest.getReport_month().equalsIgnoreCase(month))
                .collect(Collectors.toList()
                );
    }

    public List<Arrest> getArrestByZip(String zip) {
        // Add error handling/messages
        return arrestRepository.findAll()
                .stream()
                .filter(arrest -> arrest.getZip_code().equalsIgnoreCase(zip))
                .collect(Collectors.toList()
                );
    }

    // NORTH, EAST, SOUTH, WEST, CENTRAL, PRUE, DOWNTOWN
    public List<Arrest> getArrestByServiceArea(String serviceArea) {
        // Add error handling/messages
        return arrestRepository.findAll()
                .stream()
                .filter(arrest -> arrest.getService_area().equalsIgnoreCase(serviceArea))
                .collect(Collectors.toList()
                );
    }

    // Find by keyword?
    // Split each offense word in sentence into array then check if the keyword equals any of them

    public List<Arrest> getArrestByKeyword(String keyword) {
        // Add error handling/messages
        return arrestRepository.findAll()
                .stream()
                .filter(arrest -> arrest.getOffense().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList()
                );
    }

}
