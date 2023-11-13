package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.enums.SuccessFail;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private MissionStatus missionStatus;

    @Column
    private Integer classificationNum;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SuccessFail successStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "missionId")
    private Mission mission;
}
