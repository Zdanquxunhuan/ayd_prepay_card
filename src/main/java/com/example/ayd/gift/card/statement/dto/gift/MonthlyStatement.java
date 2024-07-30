package com.example.ayd.gift.card.statement.dto.gift;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 预付卡月度结算对账单
 */
@Data
@Accessors(chain = true)
public class MonthlyStatement {

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 持卡人
     */
    private String holder;

    /**
     * 交易日期
     */
    private LocalDateTime transactionDate;

    /**
     * 交易类型
     */
    private String transactionType;

    /**
     * 销售小票号
     */
    private String saleReceiptNumber;

    /**
     * 交易流水号
     */
    private String transactionNumber;
}
