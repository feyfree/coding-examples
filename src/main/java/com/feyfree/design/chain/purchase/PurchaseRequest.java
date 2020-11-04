package com.feyfree.design.chain.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 采购单
 *
 * @author leilei
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PurchaseRequest {
    private double amount;

    private String number;


    private String purpose;
}
