package com.jasofalcon.nonsensegenerator.rest;


import com.jasofalcon.nonsensegenerator.dto.NonsenseDto;
import com.jasofalcon.nonsensegenerator.service.NonsenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NonsenseController {

    private final NonsenseService nonsenseService;

    @Autowired
    public NonsenseController(NonsenseService nonsenseService) {
        this.nonsenseService = nonsenseService;
    }

    @RequestMapping("/nonsense")
    public NonsenseDto nonsense() {
        return new NonsenseDto(nonsenseService.makeNonsense());
    }

}
