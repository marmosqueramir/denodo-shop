package com.denodo.challenge.service.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseService {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime startDateTime,
        LocalDateTime endDateTime) throws Exception;

}
