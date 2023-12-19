package com.denodo.challenge.dao.buys;

import com.denodo.challenge.entity.buys.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyDao extends JpaRepository<Buy, Long> {
}
