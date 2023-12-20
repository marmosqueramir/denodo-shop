package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.PurchaseDao;
import com.denodo.challenge.dto.PurchaseDetailsDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import com.denodo.challenge.service.mapers.purchases.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseDao purchaseDao;

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public Integer getFrequentAgeInRangeTime(Date initDate, Date endDate) {

        purchaseDao.findAll();
        return 3;
    }

    @Override
    public PurchaseDetailsDTO getPurchaseDetails(Long purchaseId) {
        Purchase purchase = purchaseDao.getById(purchaseId);
        return PurchaseMapper.purchaseToPurchaseDetailsDTO(purchase);
    }
}
