package com.bookstore.domain.account;

import com.bookstore.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Account extends BaseEntity {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    private String password;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    private String avatar;

    @Pattern(regexp = "1\\d{10}", message = "手机号格式不正确")
    private String telephone;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String location;
}
