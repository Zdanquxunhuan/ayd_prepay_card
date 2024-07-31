package com.example.ayd.gift.card.statement.exportreport;

import com.example.ayd.gift.card.statement.dto.gift.MonthlyStatement;
import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingDetail;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@Service
public class MonthlyStatementExportReport extends ExportExcelUtil<MonthlyStatement> {

    @Value("${exportFileName.monthlyStatement}")
    private String exportFileName_monthlyStatement;


    @Override
    public void handleDatas() {
        if (Objects.isNull(exportParamsMap)) exportParamsMap = new HashMap<>();

        exportParamsMap.put("fileName", exportFileName_monthlyStatement);
        exportParamsMap.put("owningPeriod", "2024年07月25日");

        exportParamsMap.put("total_transactionAmount", datas.stream().map(MonthlyStatement::getTransactionAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_fee", datas.stream().map(MonthlyStatement::getFee).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_clearAmount", datas.stream().map(MonthlyStatement::getClearAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());

    }
}
