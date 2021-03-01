package com.cha.wenance.utility;

import com.cha.wenance.entity.BitcoinEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MathCalc {
    Map<Double, Date> bitcoinMap = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(MathCalc.class);

    public double getAverage(List<BitcoinEntity> bitcoinEntityList, Date date1,Date date2) {
        double average = 0;
        int max = 0;
        double sumBitcoins =0;
        for (BitcoinEntity elemento : bitcoinEntityList) {

            if (elemento.getDateBitCoin().equals(date1)||elemento.getDateBitCoin().equals(date2)) {
                average = (elemento.getLprice() + average);
                max++;
            }
        }
        if (average > 0 && max > 0) {
            return (average+sumBitcoins) / max;
        } else {
            logger.info("ZERO DIV");
            return 0;
        }
    }

    public double getVarPorc(List<BitcoinEntity> bitcoinEntityList, Date date1,Date date2) {
        double varPorc = 0;
        double recAverage = 0;
        BitcoinEntity bitcoinEntityMax;
        recAverage = getAverage(bitcoinEntityList, date1, date2);
        if (bitcoinEntityList.stream().max(Comparator.comparing(BitcoinEntity::getLprice)).isPresent()) {
            bitcoinEntityMax = bitcoinEntityList.stream().max(Comparator.comparing(BitcoinEntity::getLprice)).get();
            varPorc = (((bitcoinEntityMax.getLprice() - recAverage) / bitcoinEntityMax.getLprice()) * 100);
            return varPorc;
        }else{
            logger.info("OBJECT NOT FOUND");
            return varPorc;
        }
        }
    }
