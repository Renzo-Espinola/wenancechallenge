package com.cha.wenance.service;

import com.cha.wenance.entity.BitcoinEntity;
import com.cha.wenance.model.Bitcoin;
import com.cha.wenance.model.BitcoinConvert;
import com.cha.wenance.repository.BitcoinRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cha.wenance.gethttprequest.GetHttpDataRequest;
import com.cha.wenance.utility.MathCalc;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BitCoinServiceImpl implements IServiceBitcoin {
    BitcoinEntity bitcoinEntityDb = new BitcoinEntity();
    private MathCalc mathCalc = new MathCalc();
    double sum=0;
    private static final Logger logger = LoggerFactory.getLogger(BitCoinServiceImpl.class);
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private BitcoinRepository bitcoinRepository;
    @Autowired
    private GetHttpDataRequest getHttpDataRequest;
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Iterable<BitcoinEntity> findAll() {
      return bitcoinRepository.findAll();
    }

    @Override
    public Bitcoin save() throws JsonProcessingException {
        Object response= getHttpDataRequest.getResponse();
        BitcoinConvert bitcoinConvert = objectMapper.readValue((String) response,BitcoinConvert.class);
        BitcoinEntity bitcoinEntity = bitcoinRepository.save(modelMapper.map(bitcoinConvert,BitcoinEntity.class));
        logger.info("URL SAVE");
        return modelMapper.map(bitcoinEntity,Bitcoin.class);
    }

    @Override
    public BitcoinEntity showAverage() {
    return null;
    }

    @Override
    public void deleteBy(Long id) {
    //completar delete
    }

    @Override
    public double averageBitcoins(List<BitcoinEntity> bitcoinEntity, Date date1, Date date2) {
        double resultado;
        String tag;
        resultado=mathCalc.getAverage(bitcoinEntity,date1,date2);
        tag= String.valueOf(resultado);
        logger.info(tag);
        return resultado;
    }

    @Override
    public double varPorcBitcoins(List<BitcoinEntity> bitcoinEntity, Date date1, Date date2) {
        double resultado;
        String tag;
        resultado=mathCalc.getVarPorc(bitcoinEntity, date1,date2);
        tag= String.valueOf(resultado);
        logger.info(tag);
        return resultado;
    }

    @Override
    public BitcoinEntity findBy(Long id) throws Exception {
        return bitcoinRepository.findById(id).orElseThrow(() -> new Exception("ERROR CLIENTE"));
    }
}
