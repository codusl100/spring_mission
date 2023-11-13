package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer missionPoint;

    @Column(nullable = false, length = 45)
    private String missionCondition;

    @Column(nullable = false)
    private LocalDate missionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId")
    private Place place;
}
