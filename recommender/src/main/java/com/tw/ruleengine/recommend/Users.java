package com.tw.ruleengine.recommend;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {

    private String name;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    private String userId;

    private String password;
    private String emailId;

    public Users(String name, String emailId, String userId, String password) {
        this.name = name;
        this.emailId = emailId;
        this.userId = userId;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        return new EqualsBuilder()
                .append(name, users.name)
                .append(userId, users.userId)
                .append(password, users.password)
                .append(emailId, users.emailId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(userId)
                .append(password)
                .append(emailId)
                .toHashCode();
    }
}
