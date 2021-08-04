package com.bookstore.domain.warehouse;

import com.bookstore.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {
    @NotEmpty(message = "商品名称为空")
    private String title;

    @NotNull(message = "商品价格为空")
    @Min(value = 0, message = "商品价格需高于0")
    // 其实改用BigDecimal
    private Double price;

    @Min(value = 0, message = "评分最低为0")
    @Max(value = 10, message = "评分最高为10")
    private Integer rate;

    private String description;

    private String cover;

    private String detail;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Specification> specifications;
}
