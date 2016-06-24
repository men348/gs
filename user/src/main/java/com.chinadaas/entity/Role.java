package com.chinadaas.entity;

import com.chinadaas.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xie on 16/6/22.
 */

@Entity
@Table(name = "T_ROLE")
public class Role extends BaseEntity{

    private String roleName;
    private String roleId;

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
