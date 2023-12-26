package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(Date initDateTime,
            Date endDateTime) throws Exception {
        if (initDateTime != null && endDateTime != null) {
            if (isDateBefore(initDateTime, endDateTime)) {
                return purchaseDao.totalPurchasesForMostRepeatedAgeByDate(convertToLocalDate(initDateTime),
                        convertToLocalDate(endDateTime), convertToLocalTime(initDateTime), convertToLocalTime(endDateTime));
            } else {
                throw new Exception("El rango de fechas no es válido. La fecha de inicio es posterior a la fecha de fin.");
            }
        } else {
            throw new Exception("Ambos valores del rango deben tener valor asignado.");
        }
    }

    public static LocalTime convertToLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private boolean isDateBefore(Date initDateTime, Date endDateTime) {
        return initDateTime.before(endDateTime);
    }
}
