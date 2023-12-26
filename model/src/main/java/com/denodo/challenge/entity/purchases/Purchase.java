package com.denodo.challenge.entity.purchases;

import com.denodo.challenge.entity.users.User;
import com.denodo.challenge.entity.util.SchemaVariables;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "purchases", schema = SchemaVariables.SCHEMA_APP)
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Mirar si lo ponemos a NO LAZY
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_purchase")
    private LocalDate dateOfPurchase;

    @Temporal(TemporalType.TIME)
    @Column(name = "hour_purchase")
    private LocalTime hourOfPurchase;

    @Column(name = "total_amount")
    private long totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public LocalTime getHourOfPurchase() {
        return hourOfPurchase;
    }

    public void setHourOfPurchase(LocalTime hourOfPurchase) {
        this.hourOfPurchase = hourOfPurchase;
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
        Purchase purchase = (Purchase) o;
        return totalAmount == purchase.totalAmount && Objects.equals(id, purchase.id)
                && Objects.equals(user, purchase.user) && Objects.equals(dateOfPurchase, purchase.dateOfPurchase)
                && Objects.equals(hourOfPurchase, purchase.hourOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, dateOfPurchase, hourOfPurchase, totalAmount);
    }

}
