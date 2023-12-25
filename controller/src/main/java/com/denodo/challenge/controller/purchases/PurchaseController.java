package com.denodo.challenge.controller.purchases;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
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
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date initDateTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date endDateTime) {
        try {
            List<PurchasesForMostRepeatedAgeByDateDTO> result =
                    purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
            return ResponseEntity.ok(result);
        } catch(Exception e) {

        }
        return null;
    }

    @GetMapping("/totalPurchasesForMostRepeatedAgeByDate1")
    public ResponseEntity<List<PurchasesForMostRepeatedAgeByDateDTO>> totalPurchasesForMostRepeatedAgeByDateº(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime initTime,
            @RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime endTime) {
        try {
            List<PurchasesForMostRepeatedAgeByDateDTO> result =
                    purchaseService.totalPurchasesForMostRepeatedAgeByDate1(initDate, endDate, initTime, endTime);
            return ResponseEntity.ok(result);
        } catch(Exception e) {

        }
        return null;
    }
}
