package com.denodo.challenge.dao.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.jpa.GenericEntityDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface PurchaseDao extends GenericEntityDao<Purchase, Long> {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime initDate,
        LocalDateTime endDate);
}
