package com.fag.domain.dto;

import java.time.LocalDateTime;

public class UserAccountDTO {
    
    private String id;
    private String document;
    private String name;
    private String email;
    private String password;
    private String accountNumber;
    private LocalDateTime createdAt;
    private LocalDateTime disabledAt;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }
    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserAccountDTO [id=" + id + ", document=" + document + ", name=" + name + ", email=" + email
                + ", password=" + password + ", accountNumber=" + accountNumber + ", createdAt=" + createdAt
                + ", disabledAt=" + disabledAt + "]";
    }
    
}
