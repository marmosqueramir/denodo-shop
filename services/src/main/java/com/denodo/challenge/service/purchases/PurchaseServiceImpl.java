package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime initDateTime,
            LocalDateTime endDateTime) throws Exception {
        if (initDateTime != null && endDateTime != null) {
            if (isDateBefore(initDateTime, endDateTime)) {
                return purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
            } else {
                throw new Exception("El rango de fechas no es válido. La fecha de inicio es posterior a la fecha de fin.");
            }
        } else {
            throw new Exception("Ambos valores del rango deben tener valor asignado.");
        }
    }

    private boolean isDateBefore(LocalDateTime initDateTime, LocalDateTime endDateTime) {
        return initDateTime.isBefore(endDateTime);
    }
}
