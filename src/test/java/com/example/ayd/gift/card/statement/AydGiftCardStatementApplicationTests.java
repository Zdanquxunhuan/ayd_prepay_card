package com.example.ayd.gift.card.statement;

import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingSummary;
import com.example.ayd.gift.card.statement.exportreport.TransactionClearingSummaryExport;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import com.example.ayd.gift.card.statement.util.TestFileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
@SpringBootTest
class AydGiftCardStatementApplicationTests {

    @Value("${exportFileName.transactionClearingSummary}")
    private String exportFileName_transactionClearingSummary;

    @Autowired
    private TransactionClearingSummaryExport transactionClearingSummaryExport;


    @Test
    public void testPath(){
    }

    @Test
    void testExport(){

        List<TransactionClearingSummary> datas = new ArrayList<>();
        TransactionClearingSummary summary1 = new TransactionClearingSummary()
                .setTransactionSideNumber("AX")
                .setTransactionSideName1("AX")
                .setTransactionSideName2("AX")
                .setStoreType("AX")
                .setTransactionType("门店交易卡")
                .setTransactionCount(5)
                .setTransactionAmount(new BigDecimal("100.00"))
                .setFee(new BigDecimal("5.00"))
                .setClearAmount(new BigDecimal("95.00"));

        TransactionClearingSummary summary2 = new TransactionClearingSummary()
                .setTransactionSideNumber("AX")
                .setTransactionSideName1("AX")
                .setTransactionSideName2("AX")
                .setStoreType("门店类型")
                .setTransactionType("门店交易卡")
                .setTransactionCount(10)
                .setTransactionAmount(new BigDecimal("200.00"))
                .setFee(new BigDecimal("10.00"))
                .setClearAmount(new BigDecimal("190.00"));

        datas.add(summary1);
        datas.add(summary2);



        Map<String,String> map = new HashMap<>();

        transactionClearingSummaryExport.doExport(TransactionClearingSummary.class,datas,map);


    }

}
