package com.denodo.challenge.service.mapers.purchases;

import com.denodo.challenge.dto.PurchaseDetailsDTO;
import com.denodo.challenge.entity.purchases.Purchase;

public class PurchaseMapper {

    public static PurchaseDetailsDTO purchaseToPurchaseDetailsDTO(Purchase purchase) {
        PurchaseDetailsDTO purchaseDetailsDTO = new PurchaseDetailsDTO();
        purchaseDetailsDTO.setTotalAmount(purchase.getTotalAmount());
        purchaseDetailsDTO.setUserId(purchase.getUser().getId());

        return purchaseDetailsDTO;
    }
}
