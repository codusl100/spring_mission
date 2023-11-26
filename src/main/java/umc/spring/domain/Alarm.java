package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.AlarmType;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(1)")
    private String isConfirmed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private AlarmType alarmType;

    @Column(nullable = false, length = 45)
    private String alarmTitle;

    @Column(nullable = false, length = 45)
    private String alarmContent;

    @Column(nullable = false, columnDefinition = "VARCHAR(1)")
    private String alarmYN;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
