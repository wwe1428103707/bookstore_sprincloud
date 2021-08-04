package com.bookstore.domain.security;

import com.bookstore.domain.account.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;


// 认证用户类,Account对象保存了业务属性，如姓名、电话、地址，用于业务发生,AuthenticAccount对象包含其用于认证的属性，譬如密码、角色、是否停用
public class AuthenticAccount extends Account implements UserDetails {

    // 该用户拥有的授权，譬如读取权限、修改权限、增加权限等等

    private Collection<GrantedAuthority> authorities = new HashSet<>();

    public AuthenticAccount(){
        super();
        authorities.add(new SimpleGrantedAuthority(Role.USER));
    }

    public AuthenticAccount(Account account){
        this();
        BeanUtils.copyProperties(account,this);
        if (getId()==1){
            // 系统中第一个用户赋予管理员角色
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN));
        }
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 是否被封
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 是否密码过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
