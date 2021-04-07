package com.feyfree.basic.sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CentBuyProductsActivity implements Serializable {

    private static final long serialVersionUID = 6332727989433074416L;

    /**
     * 主键自增ID - 作为配置ID使用
     */
    private int id;

    private int time;
}