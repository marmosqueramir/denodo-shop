package com.denodo.challenge.service.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;

import java.util.Date;
import java.util.List;

public interface PurchaseService {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(Date startDateTime, Date endDateTime) throws Exception;

}
