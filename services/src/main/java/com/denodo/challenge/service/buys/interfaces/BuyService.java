package com.denodo.challenge.service.buys.interfaces;

import com.denodo.challenge.dto.BuyDetailsDTO;

import java.util.Date;

public interface BuyService {

    Integer getFrequentAgeInRangeTime(Date initDate, Date endDate);

    BuyDetailsDTO getBuyDetails(Long purchaseId);

}
