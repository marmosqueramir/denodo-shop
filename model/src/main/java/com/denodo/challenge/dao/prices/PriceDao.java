package com.denodo.challenge.dao.prices;

import com.denodo.challenge.entity.prices.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceDao extends JpaRepository<Price, Long> {
}
