package com.denodo.challenge.service.mapers.buy;

import com.denodo.challenge.dto.BuyDetailsDTO;
import com.denodo.challenge.entity.buys.Buy;

public class BuyMapper {

    public static BuyDetailsDTO buyToBuyDetailsDTO(Buy buy) {
        BuyDetailsDTO buyDetailsDTO = new BuyDetailsDTO();
        buyDetailsDTO.setTotalAmount(buy.getTotalAmount());
        buyDetailsDTO.setUserId(buy.getUser().getId());

        return buyDetailsDTO;
    }
}
