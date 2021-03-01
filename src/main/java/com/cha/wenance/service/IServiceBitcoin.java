package com.cha.wenance.service;

import com.cha.wenance.entity.BitcoinEntity;
import com.cha.wenance.model.Bitcoin;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;
import java.util.List;

public interface IServiceBitcoin {
    Iterable<BitcoinEntity> findAll();
    BitcoinEntity findBy(Long id) throws Exception;
    Bitcoin save () throws JsonProcessingException;
    BitcoinEntity showAverage();
    void deleteBy (Long id);
    double averageBitcoins(List<BitcoinEntity> bitcoinEntity, Date date1, Date date2);
    double varPorcBitcoins(List<BitcoinEntity> bitcoinEntity, Date date1,Date date2);
}
