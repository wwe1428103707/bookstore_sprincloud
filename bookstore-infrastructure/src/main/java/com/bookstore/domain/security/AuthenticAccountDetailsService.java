package com.bookstore.domain.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;


// 认证用户信息查询服务
@Named
public class AuthenticAccountDetailsService implements UserDetailsService {

    @Inject
    private AuthenticAccountRepository accountRepository;

    /**
     * 根据用户名查询用户角色、权限等信息
     * 如果用户名无法查询到对应的用户，或者权限不满足，直接抛出{@link UsernameNotFoundException}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(accountRepository.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("未找到该用户:" + username));
    }

}
