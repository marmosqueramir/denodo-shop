package com.denodo.challenge.controller.purchases;

import com.denodo.challenge.dto.PurchaseDetailsDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/ageRangeByRangeTime")
    public Integer getAgeRangeByRangeTime(@RequestParam Date dateInit, @RequestParam Date dateEnd) {
        try {

        } catch(Exception e) {

        }
        return purchaseService.getFrequentAgeInRangeTime(new Date(), new Date());
    }

    @GetMapping("/details")
    public PurchaseDetailsDTO purchaseDetailsById(@RequestParam Long purchaseId) {
        try {
            return purchaseService.getPurchaseDetails(purchaseId);
        } catch(Exception e) {

        }
        return new PurchaseDetailsDTO();
    }
}
