package com.denodo.challenge.controller.buys;

import com.denodo.challenge.service.buys.interfaces.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/buys")
public class BuyController {

    private BuyService buyService;

    @Autowired
    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @GetMapping("/age")
    public Integer getAge() {

        return buyService.getFrequentAgeInRangeTime(new Date(), new Date());
    }
}
