package com.example.ayd.gift.card.statement.exportreport;

import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingSummary;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TransactionClearingSummaryExport extends ExportExcelUtil<TransactionClearingSummary> {

    @Value("${exportFileName.transactionClearingSummary}")
    private String exportFileName_transactionClearingSummary;

    public void init(List<TransactionClearingSummary> datas, Map<String, String> exportParamsMap) {
        this.datas = datas;
        this.exportParamsMap = exportParamsMap;
    }

    public void handleDatas() {
        this.exportParamsMap.put("fileName", exportFileName_transactionClearingSummary);
        this.exportParamsMap.put("startDate","2024年07月25日");
        this.exportParamsMap.put("endDate",new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));

        this.exportParamsMap.put("total_transactionCount", datas.stream().mapToInt(TransactionClearingSummary::getTransactionCount).sum() + "");
        this.exportParamsMap.put("total_transactionAmount", datas.stream().map(TransactionClearingSummary::getTransactionAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        this.exportParamsMap.put("total_fee", datas.stream().map(TransactionClearingSummary::getFee).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        this.exportParamsMap.put("total_clearAmount", datas.stream().map(TransactionClearingSummary::getClearAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
    }

}
