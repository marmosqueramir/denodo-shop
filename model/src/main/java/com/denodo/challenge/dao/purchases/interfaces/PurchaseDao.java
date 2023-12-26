package com.denodo.challenge.dao.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.util.database.GenericEntityDao;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseDao extends GenericEntityDao<Purchase, Long> {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime initDate,
        LocalDateTime endDate);
}
