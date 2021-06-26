package com.saidbouig.serviceuser.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", createdAt=" + createdAt +
            ", createdBy='" + createdBy + '\'' +
            ", updatedAt=" + updatedAt +
            ", updatedby='" + updatedBy + '\'' +
            '}';
    }


}
