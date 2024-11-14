package com.slippery.wallet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountNumber;
    private String walletType;
    private BigDecimal accountBalance;
    private String currency;
    private int pin;
    private boolean isActivated;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

}
