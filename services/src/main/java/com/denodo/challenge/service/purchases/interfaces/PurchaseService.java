package com.denodo.challenge.service.purchases.interfaces;

import com.denodo.challenge.dto.PurchaseDetailsDTO;

import java.util.Date;

public interface PurchaseService {

    Integer getFrequentAgeInRangeTime(Date initDate, Date endDate);

    PurchaseDetailsDTO getPurchaseDetails(Long purchaseId);

}
