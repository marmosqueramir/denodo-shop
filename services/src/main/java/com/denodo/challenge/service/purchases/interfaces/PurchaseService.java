package com.denodo.challenge.service.purchases.interfaces;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface PurchaseService {

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(Date startDateTime, Date endDateTime) throws Exception;

    List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate1(LocalDate initDate, LocalDate endDate, LocalTime initTime, LocalTime endTime) throws ParseException;
}
