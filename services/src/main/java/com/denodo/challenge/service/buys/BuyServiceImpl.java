package com.denodo.challenge.service.buys;

import com.denodo.challenge.dao.buys.BuyDao;
import com.denodo.challenge.entity.buys.Buy;
import com.denodo.challenge.service.buys.interfaces.BuyService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BuyServiceImpl implements BuyService {

    private BuyDao buyDao;

    @Autowired
    public BuyServiceImpl(BuyDao buyDao) {
        this.buyDao = buyDao;
    }

    @Override
    public Integer getFrequentAgeInRangeTime(Date initDate, Date endDate) {

        buyDao.findAll();
        return 3;
    }
}
