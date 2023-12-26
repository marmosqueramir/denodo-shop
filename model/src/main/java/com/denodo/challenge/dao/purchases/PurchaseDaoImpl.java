package com.denodo.challenge.dao.purchases;

import com.denodo.challenge.dao.purchases.interfaces.PurchaseDao;
import com.denodo.challenge.dto.PurchasesForMostRepeatedAgeByDateDTO;
import com.denodo.challenge.entity.purchases.Purchase;
import com.denodo.challenge.util.database.JPADaoImpl;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PurchaseDaoImpl extends JPADaoImpl<Purchase, Long> implements PurchaseDao {
    @Override
    public List<PurchasesForMostRepeatedAgeByDateDTO> totalPurchasesForMostRepeatedAgeByDate(LocalDateTime initDate,
        LocalDateTime endDate) {

        String sqlQuery = """
            WITH EdadMasRepetida AS (
                    SELECT
                        u.id,
                        u.age,
                        DENSE_RANK() OVER (ORDER BY COUNT(*) DESC) AS Ranking,
                        COUNT(*) n_edad_repetida
                    FROM
                        denodo_shop.users u
                    JOIN
                        denodo_shop.purchases c ON u.id = c.user_id 
                    WHERE c.date_purchase BETWEEN :initDate AND :endDate
                    GROUP BY
                        u.id, u.age
                )
            SELECT
                c.user_id as userId,
                c.total_amount as totalAmount,
                e.age as age,
                e.n_edad_repetida as numberOfAgeRepeats
            FROM
                denodo_shop.purchases c
            JOIN
                EdadMasRepetida e ON c.user_id = e.id
            WHERE
                e.Ranking = 1 AND
                c.date_purchase BETWEEN :initDate AND :endDate""";

        return getEntityManager().createNativeQuery(sqlQuery,
                        PurchasesForMostRepeatedAgeByDateDTO.class)
                .setParameter("initDate", initDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
