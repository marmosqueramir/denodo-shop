package com.denodo.challenge.entity.buys;

import com.denodo.challenge.entity.users.User;
import com.denodo.challenge.entity.util.SchemaVariables;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "buys", schema = SchemaVariables.SCHEMA_APP)
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Mirar si lo ponemos a NO LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_purchase")
    private Date dateOfPurchase;

    @Temporal(TemporalType.TIME)
    @Column(name = "hour_purchase")
    private Date hourOfPurchase;

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

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getHourOfPurchase() {
        return hourOfPurchase;
    }

    public void setHourOfPurchase(Date hourOfPurchase) {
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
        Buy buy = (Buy) o;
        return totalAmount == buy.totalAmount && Objects.equals(id, buy.id) && Objects.equals(user, buy.user) && Objects.equals(dateOfPurchase, buy.dateOfPurchase) && Objects.equals(hourOfPurchase, buy.hourOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, dateOfPurchase, hourOfPurchase, totalAmount);
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", user=" + user +
                ", dateOfPurchase=" + dateOfPurchase +
                ", hourOfPurchase=" + hourOfPurchase +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
