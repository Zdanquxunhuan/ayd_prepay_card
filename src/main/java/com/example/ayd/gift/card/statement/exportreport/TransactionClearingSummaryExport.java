package com.example.ayd.gift.card.statement.exportreport;

import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingSummary;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TransactionClearingSummaryExport extends ExportExcelUtil<TransactionClearingSummary> {

    @Value("${exportFileName.transactionClearingSummary}")
    private String exportFileName_transactionClearingSummary;

    @Override
    public void handleDatas() {
        if (Objects.isNull(exportParamsMap)) exportParamsMap = new HashMap<>();

        exportParamsMap.put("fileName", exportFileName_transactionClearingSummary);
        exportParamsMap.put("startDate", "2024年07月25日");
        exportParamsMap.put("endDate", new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));

        exportParamsMap.put("total_transactionCount", datas.stream().mapToInt(TransactionClearingSummary::getTransactionCount).sum() + "");
        exportParamsMap.put("total_transactionAmount", datas.stream().map(TransactionClearingSummary::getTransactionAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_fee", datas.stream().map(TransactionClearingSummary::getFee).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        exportParamsMap.put("total_clearAmount", datas.stream().map(TransactionClearingSummary::getClearAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
    }

}
