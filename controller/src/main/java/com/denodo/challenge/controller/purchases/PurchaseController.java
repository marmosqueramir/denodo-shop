package com.denodo.challenge.controller.purchases;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Operation(summary = "Get the user and the value of purchases made by the most frequent age group within a given time range")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Found the data of user and purchase",
                  content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PurchasesForMostRepeatedAgeByDateDTO.class))) })
    })
    @GetMapping("/totalPurchasesForMostRepeatedAgeByDate")
    public ResponseEntity<List<PurchasesForMostRepeatedAgeByDateDTO>> totalPurchasesForMostRepeatedAgeByDate(
            @RequestParam @NotNull @DateTimeFormat(pattern = DATE_FORMAT) Date initDateTime,
            @RequestParam @NotNull @DateTimeFormat(pattern = DATE_FORMAT) Date endDateTime) {
        try {
            List<PurchasesForMostRepeatedAgeByDateDTO> result =
                    purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
            return ResponseEntity.ok(result);
        } catch(Exception e) {

        }
        return null;
    }

}
