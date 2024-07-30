package com.example.ayd.gift.card.statement.dto.gift;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 预付卡余额汇总表
 */
@Data
@Accessors(chain = true)
public class BalanceSummary {

    /**
     * 卡状态
     */
    private String cardStatus;

    /**
     * 卡面值
     */
    private BigDecimal cardValue;

    /**
     * 已用金额
     */
    private BigDecimal usedAmount;

    /**
     * 可用金额
     */
    private BigDecimal availableAmount;

    /**
     * 卡号
     */
    private String cardNo;
}
