package com.cha.wenance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BitcoinConvert {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private double lprice;
    private String curr1;
    private String curr2;
}
