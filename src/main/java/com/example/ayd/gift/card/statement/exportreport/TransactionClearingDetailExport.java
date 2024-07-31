package com.example.ayd.gift.card.statement.exportreport;

import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingDetail;
import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingSummary;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@Service
public class TransactionClearingDetailExport extends ExportExcelUtil<TransactionClearingDetail> {

    @Value("${exportFileName.transactionClearingDetail}")
    private String exportFileName_transactionClearingDetail;

    @Override
    public void handleDatas() {
        if (Objects.isNull(exportParamsMap)) exportParamsMap = new HashMap<>();

        exportParamsMap.put("fileName", exportFileName_transactionClearingDetail);
        exportParamsMap.put("startDate", "2024年07月25日");
        exportParamsMap.put("endDate", new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));

        exportParamsMap.put("total_transactionAmount", datas.stream().map(TransactionClearingDetail::getTransactionAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_fee", datas.stream().map(TransactionClearingDetail::getFee).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_clearAmount", datas.stream().map(TransactionClearingDetail::getClearAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_cardAccountBalance", datas.stream().map(TransactionClearingDetail::getCardAccountBalance).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
    }
}
