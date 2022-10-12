package com.feyfree.work.case005;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文案对象
 *
 * @author leilei
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Text implements Serializable {

    private static final long serialVersionUID = -1283590879514408566L;

    /**
     * 文案ID
     */
    String textId;

    /**
     * 商品ID
     */
    String itemId;

    /**
     * 初始化分数
     */
    float score;

    /**
     * 标签 (预留字段) -
     * 20221010  这次可以不用带
     */
    String tag;
}