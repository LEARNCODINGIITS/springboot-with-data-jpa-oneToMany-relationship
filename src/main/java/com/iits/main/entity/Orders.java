package com.iits.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
public class Orders {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="ord_id")
 private Long id;
 private String orderDate;
 private double amount;
 
 @ToString.Exclude
 @ManyToOne(fetch = FetchType.EAGER) // Fetch associated customer eagerly
 @JoinColumn(name = "fk_cus_id", referencedColumnName = "cus_id")
 private Customer customer;
}
