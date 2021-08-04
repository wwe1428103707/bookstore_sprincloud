package com.bookstore.domain.warehouse;

// 待交付商品的状态
public enum DeliveredStatus {

    // 出库减库存
    DECREASE,

    // 入库增库存
    INCREASE,

    // 待出库冻结库存
    FROZEN,

    // 取消出库解冻库存
    THAWED;
}
