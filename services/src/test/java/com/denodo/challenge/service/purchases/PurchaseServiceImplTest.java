package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.util.exceptions.ServiceException;
import com.denodo.challenge.util.tests.JsonParserToObject;
import com.google.gson.reflect.TypeToken;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

import static com.denodo.challenge.service.utils.PurchasesMocks.getPurchasesForMostRepeatedAgeByDateDTOListJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTest {

    @InjectMocks
    private PurchaseServiceImpl purchaseService;
    @Mock
    private PurchaseDao purchaseDao;

    private static LocalDateTime initDateTime;
    private static LocalDateTime endDateTime;

    @BeforeAll
    public static void setUp() {
        // Configuración de datos de prueba
        initDateTime = LocalDateTime.now();
        endDateTime = LocalDateTime.now().plusHours(1);
    }

    @SpringBootApplication(scanBasePackages = "com.denodo.*")
    public static class TestConfiguration {
        // Charge application configs.
    }

    @Test
    void totalPurchasesForMostRepeatedAgeByDate_NullData() {
        assertThrows(IllegalArgumentException.class, () -> {
            purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseService.totalPurchasesForMostRepeatedAgeByDate(null, endDateTime);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseService.totalPurchasesForMostRepeatedAgeByDate(null, null);
        });
    }

    @Test
    void totalPurchasesForMostRepeatedAgeByDate_DateBeforeInvalid() {
        // Configuración de datos de prueba
        LocalDateTime badEndDateTime = LocalDateTime.now();
        LocalDateTime badInitDateTime = LocalDateTime.now().plusHours(1);

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseService.totalPurchasesForMostRepeatedAgeByDate(badInitDateTime, badEndDateTime);
        });
    }

    @Test
    void totalPurchasesForMostRepeatedAgeByDate_Ok() throws ServiceException {
        Type listType = new TypeToken<List<PurchasesForMostRepeatedAgeByDateDTO>>() {}.getType();
        String json = getPurchasesForMostRepeatedAgeByDateDTOListJson();
        List<PurchasesForMostRepeatedAgeByDateDTO> mockResult = JsonParserToObject.transformJsonToList(listType, json);
        when(purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime))
                .thenReturn(mockResult);

        List<PurchasesForMostRepeatedAgeByDateDTO> purchasesForMostRepeatedAgeByDateDTOList =
                purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);

        assertEquals(mockResult, purchasesForMostRepeatedAgeByDateDTOList);

    }

    @Test
    void totalPurchasesForMostRepeatedAgeByDate_UnknowException() throws ServiceException {
        // Configuración de datos de prueba

        when(purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime))
                .thenThrow(new RuntimeException(new Exception()));

        assertThrows(ServiceException.class, () -> {
            purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
        });
    }

}
