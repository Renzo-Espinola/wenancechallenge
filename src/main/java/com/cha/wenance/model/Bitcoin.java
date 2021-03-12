package com.cha.wenance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class Bitcoin {
    private Long id;
    private double lprice;
    private String curr1;
    private String curr2;
    private Date dateBitCoin;
    public void prePersist(){this.dateBitCoin=new Date();}
    public Bitcoin(){}
    public Bitcoin(Long id,double lprice,String curr1,String curr2){}
}
