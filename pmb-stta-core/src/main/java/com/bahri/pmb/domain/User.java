package com.bahri.pmb.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/15/12
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "admin")
public class User implements UserDetails {

    @Id
    @Column(length = 50, name = "username", nullable = false)
    @Size(max = 50, min = 1)
    @NotNull
    private String username;

    @NotNull
    @Size(min = 1)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone1", length = 20, nullable = true)
    private String phone1;

    @Column(name = "phone2", length = 20, nullable = true)
    private String phone2;

    @NotNull
    @Size(min = 1)
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Size(min = 1)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(min = 1)
    @Column(name = "salt", nullable = false)
    private String salt;

    @NotNull
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    public User() {
        Role role1=new Role();
        role1.setAuthority("ADMIN_IT");
        setRole(role1);
        enabled=true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String alamat) {
        this.address = alamat;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles=new ArrayList<Role>();
        roles.add(role);
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phone1 != null ? !phone1.equals(user.phone1) : user.phone1 != null) return false;
        if (phone2 != null ? !phone2.equals(user.phone2) : user.phone2 != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone1 != null ? phone1.hashCode() : 0);
        result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
