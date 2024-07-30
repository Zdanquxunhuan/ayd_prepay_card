package com.example.ayd.gift.card.statement.dto.gift;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 预付卡交易清算汇总报表
 */
@Data
@Accessors(chain = true)
public class TransactionClearingSummary {

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
     * 门店性质
     */
    private String storeType;

    /**
     * 交易类型
     */
    private String transactionType;

    /**
     * 交易笔数
     */
    private Integer transactionCount;

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
}
