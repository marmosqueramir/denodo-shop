package com.denodo.challenge.controller.buys;

import com.denodo.challenge.dto.BuyDetailsDTO;
import com.denodo.challenge.service.buys.interfaces.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/purchases")
public class BuyController {

    private BuyService buyService;

    @Autowired
    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @GetMapping("/ageRangeByRangeTime")
    public Integer getAgeRangeByRangeTime(@RequestParam Date dateInit, @RequestParam Date dateEnd) {
        try {

        } catch(Exception e) {

        }
        return buyService.getFrequentAgeInRangeTime(new Date(), new Date());
    }

    @GetMapping("/details")
    public BuyDetailsDTO purchaseDetailsById(@RequestParam Long purchaseId) {
        try {
            return buyService.getBuyDetails(purchaseId);
        } catch(Exception e) {

        }
        return new BuyDetailsDTO();
    }
}
