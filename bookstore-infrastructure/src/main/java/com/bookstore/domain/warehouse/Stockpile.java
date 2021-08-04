package com.bookstore.domain.warehouse;

import com.bookstore.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

// 库存类
@Entity
@Getter
@Setter
public class Stockpile extends BaseEntity {
    private Integer amount;

    private Integer frozen;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private transient Product product;

    // 锁定
    public void froze(int number){
        this.amount -= number;
        this.frozen += number;
    }

    // 释放
    public void thawed(Integer number) {
        froze(-1 * number);
    }

    public void decrease(Integer number) {
        this.frozen -= number;
    }

    public void increase(Integer number) {
        this.frozen += number;
    }
}
