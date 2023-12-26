package com.denodo.challenge.service.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.service.purchases.interfaces.PurchaseService;
import com.denodo.challenge.util.exceptions.ServiceException;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private static final String INVALID_DATE_RANGE_EXCEPTION_MESSAGE = "The date range is not valid. The start date is later than the end date.";

    private static final String BOTH_VALUES_DATE_MUST_HAVE_VALUE_EXCEPTION_MESSAGE = "Both values of the range must be assigned a value.";

    private PurchaseDao purchaseDao;
    private static final Logger log = Logger.getLogger(PurchaseServiceImpl.class);

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime initDateTime,
            LocalDateTime endDateTime) throws ServiceException, IllegalArgumentException {
        if (initDateTime != null && endDateTime != null) {
            if (isDateBefore(initDateTime, endDateTime)) {
                try {
                    return purchaseDao.totalPurchasesForMostRepeatedAgeByDate(initDateTime, endDateTime);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    throw new ServiceException("An error occurred while searching in the database.");
                }
            } else {
                throw new IllegalArgumentException(INVALID_DATE_RANGE_EXCEPTION_MESSAGE);
            }
        } else {
            throw new IllegalArgumentException(BOTH_VALUES_DATE_MUST_HAVE_VALUE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isDateBefore(LocalDateTime initDateTime, LocalDateTime endDateTime) {
        return initDateTime.isBefore(endDateTime);
    }
}
