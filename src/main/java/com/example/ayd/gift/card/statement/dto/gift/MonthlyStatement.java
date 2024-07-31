package com.example.ayd.gift.card.statement.dto.gift;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
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

    /**
     * 门店性质
     */
    private String storeType;

    /**
     * 交易方编号
     */
    private String transactionSideNumber;

    /**
     * 交易方名称（一级）
     */
    private String transactionSideName1;

    /**
     * 交易方名称（二级）
     */
    private String transactionSideName2;

    /**
     * 交易金额
     */
    private BigDecimal transactionAmount;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 清算金额
     */
    private BigDecimal clearAmount;

    /**
     * 处理状态
     */
    private String processingStatus;
}
