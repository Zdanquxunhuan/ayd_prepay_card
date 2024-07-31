package com.example.ayd.gift.card.statement.exportreport;

import com.example.ayd.gift.card.statement.dto.gift.BalanceSummary;
import com.example.ayd.gift.card.statement.util.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceSummaryExport extends ExportExcelUtil<BalanceSummary> {

    @Value("${exportFileName.balanceSummary}")
    private String exportFileName_balanceSummary;

    @Override
    public void handleDatas() {
        this.exportParamsMap.put("fileName", exportFileName_balanceSummary);

        this.exportParamsMap.put("total_usedAmount",datas.stream().map(BalanceSummary::getUsedAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
        this.exportParamsMap.put("total_availableAmount",datas.stream().map(BalanceSummary::getAvailableAmount).reduce(BigDecimal.ZERO, BigDecimal::add).toString());
    }
}
