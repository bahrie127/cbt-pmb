package com.bahri.pmb.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/15/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @Column(length = 50, name = "authority",unique = false)
   // @Size(max = 50, min = 1)
    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (authority != null ? !authority.equals(role.authority) : role.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }
}
