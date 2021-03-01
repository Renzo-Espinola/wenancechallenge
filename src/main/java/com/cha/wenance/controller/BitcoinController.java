package com.cha.wenance.controller;
import com.cha.wenance.entity.BitcoinEntity;
import com.cha.wenance.model.Bitcoin;
import com.cha.wenance.service.IServiceBitcoin;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/v1/bitpost")
@EnableScheduling
public class BitcoinController {
    private static final Logger logger = LoggerFactory.getLogger(BitcoinController.class);
    private static final String FORMAT_DATE = "HH:mm:ss";

    @Autowired
    private IServiceBitcoin iServiceBitcoin;



   @PostMapping
   @Scheduled(fixedRate = 10000)
   public ResponseEntity<Bitcoin> saveBitcoin() throws JsonProcessingException {
                Bitcoin bitcoinDb = null;
                bitcoinDb = iServiceBitcoin.save();
                logger.info("New data obtained from URL");
        return ResponseEntity.status(HttpStatus.CREATED).body(bitcoinDb);
    }

    @GetMapping("/listAll")
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.ok().body(iServiceBitcoin.findAll());}

    @GetMapping("/average")
    public ResponseEntity<Object>getAverageBitcoins(@RequestParam String date, String date2) throws ParseException {
        List<BitcoinEntity>bitcoinEntityList=new ArrayList<>();
        iServiceBitcoin.findAll().forEach(bitcoinEntityList::add);
        Date newDate = new SimpleDateFormat(FORMAT_DATE).parse(date);
        Date newDate2 = new SimpleDateFormat(FORMAT_DATE).parse(date2);
        return ResponseEntity.ok().body(iServiceBitcoin.averageBitcoins(bitcoinEntityList, newDate, newDate2));

    }
    @GetMapping("/varporc")
    public ResponseEntity<Object>getVarPorcBitcoins(@RequestParam String date, String date2) throws ParseException {
       List<BitcoinEntity>bitcoinEntities=new ArrayList<>();
       iServiceBitcoin.findAll().forEach(bitcoinEntities::add);
        Date newDate = new SimpleDateFormat(FORMAT_DATE).parse(date);
        Date newDate2 = new SimpleDateFormat(FORMAT_DATE).parse(date2);
        return ResponseEntity.ok().body(iServiceBitcoin.varPorcBitcoins(bitcoinEntities,newDate, newDate2));

    }
}
