package com.denodo.challenge.dao.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PurchaseDaoImplTest {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    @Autowired
    private PurchaseDao purchaseDao;

    private static LocalDateTime initDateTime;
    private static LocalDateTime endDateTime;

    @BeforeAll
    public static void setUp() {
        String initDate = "2024-11-25 20:40";
        String endDate = "2025-11-23 23:40";

        // Formateador para parsear la cadena de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        // Configuración de datos de prueba
        initDateTime = LocalDateTime.parse(initDate, formatter);
        endDateTime = LocalDateTime.parse(endDate, formatter);
    }

    @SpringBootApplication(scanBasePackages = "com.denodo.*")
    public static class TestConfiguration {
        // Charge application configs.
    }

    @Test
    void totalPurchasesForMostRepeatedAgeByDate_Ok() {
        List<PurchasesForMostRepeatedAgeByDateDTO> purchasesForMostRepeatedAgeByDateDTOList =
                purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);

        assertEquals(0, purchasesForMostRepeatedAgeByDateDTOList.size());
    }
}
