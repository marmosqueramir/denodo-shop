package com.denodo.challenge.dao.purchases;

import com.denodo.challenge.entity.purchases.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase, Long> {
}
