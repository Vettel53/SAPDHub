package org.sapd.sapdhub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

@RestController
public class ArrestController {

    private final ArrestService arrestService;

    public ArrestController(ArrestService arrestService) {
        this.arrestService = arrestService;
    }

    @GetMapping("/arrests")
    public Optional<Arrest> getArrestById(@RequestParam(required = true) BigInteger id) {
        System.out.println("Received ID: " + id);
        return arrestService.getArrestById(id);
    }

}
