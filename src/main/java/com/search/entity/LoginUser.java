package com.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

/**
 * UserDetails(位于org.springframework.security.core.userdetails包下)
 * 主要和用户信息有关的接口，该接口是提供用户信息的核心接口。该接口实现仅仅存储用户的信息。
 * 后续会将该接口提供的用户信息封装到认证对象Authentication中去。UserDetails 默认提供了如下方法：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private User user;

    /**
     * 权限
     * 用户的权限集， 默认需要添加ROLE_ 前缀
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 密码
     * 用户的加密后的密码,不加密会使用{noop}前缀
     *
     * @return
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 用户名
     *
     * @return
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 账户未过期
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户为锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 查看凭证是否过期
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 查看用户是否可以用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
