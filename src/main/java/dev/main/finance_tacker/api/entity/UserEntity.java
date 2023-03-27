package dev.main.finance_tacker.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATED_DATE_TIME")
    @CreatedDate
    private LocalDateTime createdDateTime;
    @Column(name = "LAST_LOGIN_DATE_TIME")
    private LocalDateTime lastLoginDateTime;
    @Column(name = "ENABLED")
    private boolean enabled;
    @ManyToMany(targetEntity = AuthorityEntity.class, mappedBy = "userId", fetch = FetchType.EAGER)
    private List<AuthorityEntity> authorityList;
}
