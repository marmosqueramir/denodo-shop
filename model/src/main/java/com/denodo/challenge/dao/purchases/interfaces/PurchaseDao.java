package com.denodo.challenge.dao.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.jpa.GenericEntityDao;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface PurchaseDao extends GenericEntityDao<Purchase, Long> {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDate initDate, LocalDate endDate,
                                                                                      LocalTime initHour, LocalTime endHour) throws ParseException;
}
