package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.ReviewPhoto;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double ratePoint;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reviewText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId")
    private Place place;

    @OneToMany(mappedBy = "review")
    private List<ReviewPhoto> photoList;
}
