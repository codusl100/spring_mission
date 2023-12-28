package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.Role;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.UserFood;
import umc.spring.domain.mapping.UserMission;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 100)
    private String address;

//    @Column(nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private SocialType socialType;

    @Column(length = 20)
    private String phoneNum;

    @Column(length = 1)
    private String phoneYN;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private Role role;

    @Column
    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Alarm> alarmList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFood> userFoodList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList;
}
