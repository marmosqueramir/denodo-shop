package com.denodo.challenge.controller.purchases;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/totalPurchasesForMostRepeatedAgeByDate")
    public ResponseEntity<List<PurchasesForMostRepeatedAgeByDateDTO>> totalPurchasesForMostRepeatedAgeByDate(
            @RequestParam @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date initDateTime,
            @RequestParam @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date endDateTime) {
        try {
            List<PurchasesForMostRepeatedAgeByDateDTO> result =
                    purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
            return ResponseEntity.ok(result);
        } catch(Exception e) {

        }
        return null;
    }

}
