package org.sapd.sapdhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;

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
        }
        return arrest;
    }

}
