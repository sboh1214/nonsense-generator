package com.jasofalcon.nonsensegenerator.rest;


import com.jasofalcon.nonsensegenerator.dto.ThrillerDto;
import com.jasofalcon.nonsensegenerator.service.ThrillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThrillerController {

    private final ThrillerService thrillerService;

    @Autowired
    public ThrillerController(ThrillerService thrillerService) {
        this.thrillerService = thrillerService;
    }

    @RequestMapping("/nonsense/thriller")
    public ThrillerDto nonsenseThriller(@RequestParam(value = "keyword", required = false) String keyword) { return new ThrillerDto((thrillerService.makeNonsense(keyword)));}
}