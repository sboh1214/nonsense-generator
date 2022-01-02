package com.jasofalcon.nonsensegenerator.rest;


import com.jasofalcon.nonsensegenerator.dto.MeloDto;
import com.jasofalcon.nonsensegenerator.service.MeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeloController {

    private final MeloService meloService;

    @Autowired
    public MeloController(MeloService nonsenseService) {
        this.meloService = nonsenseService;
    }

    @RequestMapping("/nonsense/melo")
    public MeloDto nonsenseMelo(@RequestParam(value = "keyword", required = false) String keyword) {
        return new MeloDto(meloService.makeNonsense(keyword));
    }
}
