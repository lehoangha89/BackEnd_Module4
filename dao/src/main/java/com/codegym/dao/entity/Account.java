package com.codegym.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    @NotNull
    @Size(max = 100, min = 1)
    @Pattern(regexp = "^[a-zA-Z0-9\\,\\.\\-\\_\\@]{1,100}$")
    @Column(name = "account_name", nullable = false, unique = true)
    @NotBlank
    private String accountName;
    @NotBlank
    @NotNull
    @Size(max = 100, min = 1)
    @Column(name = "account_password", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9\\,\\.\\-\\_\\@\\$]{1,100}$")
    private String accountPassword;
    @Column(name = "delete_flag")
    boolean deleteFlag;
    @Column(name = "reason")
    String reason;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account() {
    }

    public Account(String accountName, String accountPassword, boolean deleteFlag, String reason,
                   Role role) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.deleteFlag = deleteFlag;
        this.reason = reason;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }


    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

