package com.denodo.challenge.service.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.util.exceptions.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseService {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime startDateTime,
        LocalDateTime endDateTime) throws ServiceException, IllegalArgumentException;

}
