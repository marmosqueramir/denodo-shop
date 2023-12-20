package com.denodo.challenge.entity.users;

import com.denodo.challenge.entity.util.SchemaVariables;
import com.denodo.challenge.entity.purchases.Purchase;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = SchemaVariables.SCHEMA_APP)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Purchase> purchasesOfPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Purchase> getPurchasesOfPerson() {
        return purchasesOfPerson;
    }

    public void setPurchasesOfPerson(List<Purchase> purchasesOfPerson) {
        this.purchasesOfPerson = purchasesOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(age, user.age)
                && Objects.equals(purchasesOfPerson, user.purchasesOfPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, purchasesOfPerson);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", purchasesOfPerson=" + purchasesOfPerson +
                '}';
    }
}
