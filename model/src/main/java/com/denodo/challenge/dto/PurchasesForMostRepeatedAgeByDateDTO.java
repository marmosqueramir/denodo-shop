package com.denodo.challenge.dto;

public class PurchasesForMostRepeatedAgeByDateDTO {

    private Long userId;

    private Long total_amount;

    private Integer age;
    private Long numberOfAgeRepeats;

    public PurchasesForMostRepeatedAgeByDateDTO(Long userId, Long total_amount, Integer age, Long numberOfAgeRepeats) {
        this.userId = userId;
        this.total_amount = total_amount;
        this.age = age;
        this.numberOfAgeRepeats = numberOfAgeRepeats;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Long total_amount) {
        this.total_amount = total_amount;
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
