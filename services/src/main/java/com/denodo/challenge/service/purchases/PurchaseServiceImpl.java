package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static String HOUR_FORMAT = "HH:mm:ss";
    private static String DAY_FORMAT = "yyyy-MM-dd";
    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(Date initDateTime,
            Date endDateTime) throws Exception {
        if (isDateBefore(initDateTime, endDateTime)) {
            return purchaseDao.totalPurchasesForMostRepeatedAgeByDate(convertToLocalDate(initDateTime),
                    convertToLocalDate(endDateTime), convertToLocalTime(initDateTime), convertToLocalTime(endDateTime));
        } else {
            throw new Exception("El rango de fechas no es correcto.");
        }
    }

    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate1(LocalDate initDate, LocalDate endDate, LocalTime initTime, LocalTime endTime) throws ParseException {
        return purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDate, endDate, initTime, endTime);
    }

    public static LocalTime convertToLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDate convertToLocalDate(Date date) {
        // Convierte el objeto Date a Instant
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private boolean isDateBefore(Date initDateTime, Date endDateTime) {
        return initDateTime.before(endDateTime);
    }

    private String getHourFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(HOUR_FORMAT);
        String horaString = sdf.format(date);
        return horaString;
//        try {
//            return sdf.parse(horaString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // TODO: THROW EXCEPTION
//            return null;
//        }
    }

    private String getDayFromDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
        String diaString = sdf.format(date);
        return diaString;
//        try {
//            return sdf.parse(diaString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // TODO: THROW EXCEPTION
//            return null;
//        }
    }
}
