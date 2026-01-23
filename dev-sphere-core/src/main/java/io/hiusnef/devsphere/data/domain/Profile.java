package io.hiusnef.devsphere.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "profiles")
@EqualsAndHashCode(callSuper = true)
public class Profile extends AbstractAuditableEntity<String> {
    
    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 2000, columnDefinition = "TEXT")
    private String bio;

    @Column(length = 500)
    private String avatarUrl;
}
