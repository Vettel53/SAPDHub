package org.sapd.sapdhub;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arrests")
public class ArrestController {

    private final ArrestService arrestService;

    public ArrestController(ArrestService arrestService) {
        this.arrestService = arrestService;
    }

    // Use specifications and criteriaBuilder to dynamically create query.
//    @GetMapping("/testing")
//    public void testing(@RequestParam(required = false) BigInteger id,
//                        @RequestParam(required = false) LocalDate date,
//                        @RequestParam(required = false) BigInteger person_id,
//                        @RequestParam(required = false) String offense,
//                        @RequestParam(required = false) String severity,
//                        @RequestParam(required = false) String area,
//                        @RequestParam(required = false) String month,
//                        @RequestParam(required = false) String zip)
//    {
//        if (id != null) {
//            System.out.println("Received ID: " + id);
//
//        }
//        System.out.println("Testing...");
//    }

    @GetMapping("/id")
    public Optional<Arrest> getArrestById(@RequestParam(required = true) BigInteger id) {
        System.out.println("Received ID: " + id);

        return arrestService.getArrestById(id);
    }

    @GetMapping("/date")
    public List<Arrest> getArrestByDate(@RequestParam(required = true) LocalDate date) {
        System.out.println("Received Date: " + date);

        return arrestService.getArrestByDate(date);
    }

    @GetMapping("/month")
    public List<Arrest> getArrestByMonth(@RequestParam(required = true) String month) {
        System.out.println("Received Month: " + month);

        return arrestService.getArrestByMonth(month);
    }

    @GetMapping("/zip")
    public List<Arrest> getArrestByZip(@RequestParam(required = true) String zip) {
        System.out.println("Received Zip Code: " + zip);

        return  arrestService.getArrestByZip(zip);
    }

    @GetMapping("/area")
    public List<Arrest> getArrestByArea(@RequestParam(required = true) String area) {
        System.out.println("Received Area: " + area);

        return  arrestService.getArrestByServiceArea(area);
    }

    @GetMapping("/keyword")
    public List<Arrest> getArrestByKeyword(@RequestParam(required = true) String keyword) {
        System.out.println("Received Keyword: " + keyword);

        return arrestService.getArrestByKeyword(keyword);
    }

    @GetMapping("/severity")
    public List<Arrest> getArrestBySeverity(@RequestParam(required = true) String severity) {
        System.out.println("Received Severity: " + severity);

        return arrestService.getArrestBySeverity(severity);
    }

    @GetMapping("/offense")
    public List<Arrest> getArrestByOffense(@RequestParam(required = true) String offense) {
        System.out.println("Received Offense: " + offense);

        return arrestService.getArrestByOffense(offense);
    }
}
