package com.denodo.challenge.dto;

public class PurchasesForMostRepeatedAgeByDateDTO {

    private Long userId;
    private Long totalAmount;
    private Integer age;
    private Long numberOfAgeRepeats;

    public PurchasesForMostRepeatedAgeByDateDTO(Long userId, Long totalAmount, Integer age, Long numberOfAgeRepeats) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.age = age;
        this.numberOfAgeRepeats = numberOfAgeRepeats;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getNumberOfAgeRepeats() {
        return numberOfAgeRepeats;
    }

    public void setNumberOfAgeRepeats(Long numberOfAgeRepeats) {
        this.numberOfAgeRepeats = numberOfAgeRepeats;
    }
}
