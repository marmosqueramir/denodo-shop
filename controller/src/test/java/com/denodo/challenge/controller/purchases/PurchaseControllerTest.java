package com.denodo.challenge.controller.purchases;

import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import com.denodo.challenge.util.exceptions.ServiceException;
import com.denodo.challenge.util.tests.JsonParserToObject;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

import static com.denodo.challenge.controller.utils.PurchasesMocks.getPurchasesForMostRepeatedAgeByDateDTOListJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PurchaseControllerTest {

    @InjectMocks
    private PurchaseController purchaseController;
    @Mock
    private PurchaseService purchaseService;

    private static LocalDateTime initDateTime;
    private static LocalDateTime endDateTime;

    @BeforeAll
    public static void setUp() {
        // Configuración de datos de prueba
        initDateTime = LocalDateTime.now();
        endDateTime = LocalDateTime.now().plusHours(1);
    }

    @Test
    void testTotalPurchasesForMostRepeatedAgeByDate_Ok() throws ServiceException {
        // Configuración del servicio mock
        Type listType = new TypeToken<List<PurchasesForMostRepeatedAgeByDateDTO>>() {}.getType();
        String json = getPurchasesForMostRepeatedAgeByDateDTOListJson();

        List<PurchasesForMostRepeatedAgeByDateDTO> mockResult = JsonParserToObject.transformJsonToList(listType, json);
        when(purchaseService.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime))
                .thenReturn(mockResult);

        ResponseEntity result = purchaseController
                .totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);

        assertEquals(mockResult, result.getBody());
    }

    @Test
    void testTotalPurchasesForMostRepeatedAgeByDate_NullData() throws ServiceException {
        when(purchaseService
                .totalPurchasesForMostRepeatedAgeByDate(initDateTime, null)).thenThrow(IllegalArgumentException.class);
        when(purchaseService
                .totalPurchasesForMostRepeatedAgeByDate(null, endDateTime)).thenThrow(IllegalArgumentException.class);
        when(purchaseService
                .totalPurchasesForMostRepeatedAgeByDate(null, null)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseController.totalPurchasesForMostRepeatedAgeByDate(initDateTime, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseController.totalPurchasesForMostRepeatedAgeByDate(null, endDateTime);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            purchaseController.totalPurchasesForMostRepeatedAgeByDate(null, null);
        });

    }

    @Test
    void testTotalPurchasesForMostRepeatedAgeByDate_ServiceException() throws ServiceException {
        when(purchaseService
                .totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime)).thenThrow(ServiceException.class);

        assertThrows(ServiceException.class, () -> {
            purchaseController.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
        });

    }
}
