package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.PlaceStatus;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String placeName;

    @Column(nullable = false, length = 200)
    private String placeAddress;

    @Column(nullable = false)
    private Time openTime;

    @Column(nullable = false)
    private Time closeTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private PlaceStatus placeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodTypeId")
    private FoodType foodType;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Mission> missionList;
}
