package com.cha.wenance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Bitcoin")
@NoArgsConstructor
@AllArgsConstructor
public class BitcoinEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column
    @Id
    private Long id;
    @Column
    private double lprice;
    @Column
    private String curr1;
    @Column
    private String curr2;
    @Column
    @Temporal(TemporalType.TIME)
    private Date dateBitCoin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLprice() {
        return lprice;
    }

    public void setLprice(double lprice) {
        this.lprice = lprice;
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    public Date getDateBitCoin() {
        return dateBitCoin;
    }

    public void setDateBitCoin(Date dateBitCoin) {
        this.dateBitCoin = dateBitCoin;
    }

    @PrePersist
    void prePersist() {
        this.dateBitCoin = new Date();
    }
}
