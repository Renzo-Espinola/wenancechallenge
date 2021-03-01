package com.cha.wenance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bitcoin {
    private Long id;
    private double lprice;
    private String curr1;
    private String curr2;
    private Date dateBitCoin;
    public void prePersist(){this.dateBitCoin=new Date();}
}
