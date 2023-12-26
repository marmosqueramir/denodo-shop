package com.denodo.challenge.dao.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.jpa.JPADaoImpl;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class PurchaseDaoImpl extends JPADaoImpl<Purchase, Long> implements PurchaseDao {
    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDate initDate,
            LocalDate endDate, LocalTime initHour, LocalTime endHour) {

        return getEntityManager().createNativeQuery("WITH EdadMasRepetida AS (\n" +
                "    SELECT\n" +
                "        u.id,\n" +
                "        u.age,\n" +
                "        DENSE_RANK() OVER (ORDER BY COUNT(*) DESC) AS Ranking,\n" +
                "        COUNT(*) n_edad_repetida\n" +
                "    FROM\n" +
                "        denodo_shop.users u\n" +
                "    JOIN\n" +
                "        denodo_shop.purchases c ON u.id = c.user_id \n" +
                "    WHERE c.date_purchase >= :initDate AND c.date_purchase <= :endDate\n" +
                "      AND c.hour_purchase >= :initHour AND c.hour_purchase <= :endHour\n" +
                "    GROUP BY\n" +
                "        u.id, u.age\n" +
                ")\n" +
                "SELECT\n" +
                "    c.user_id as userId,\n" +
                "    c.total_amount as totalAmount,\n" +
                "    e.age as age,\n" +
                "    e.n_edad_repetida as numberOfAgeRepeats\n" +
                "FROM\n" +
                "    denodo_shop.purchases c\n" +
                "JOIN\n" +
                "    EdadMasRepetida e ON c.user_id = e.id\n" +
                "WHERE\n" +
                "    e.Ranking = 1 AND\n" +
                "    c.date_purchase >= :initDate AND c.date_purchase <= :endDate\n" +
                "      AND c.hour_purchase >= :initHour AND c.hour_purchase <= :endHour",
                        PurchasesForMostRepeatedAgeByDateDTO.class)
                .setParameter("initDate", initDate)
                .setParameter("endDate", endDate)
                .setParameter("initHour", initHour)
                .setParameter("endHour", endHour)
                .getResultList();
    }
}
