package com.denodo.challenge.dto;

import java.util.Objects;

public class PurchaseDetailsDTO {

    private Long userId;
    private long totalAmount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseDetailsDTO that = (PurchaseDetailsDTO) o;
        return totalAmount == that.totalAmount && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, totalAmount);
    }

    @Override
    public String toString() {
        return "PurchaseDetailsDTO{" +
                "userId=" + userId +
                ", totalAmount=" + totalAmount +
                '}';
    }

}
