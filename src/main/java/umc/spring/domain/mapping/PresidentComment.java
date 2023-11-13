package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.President;
import umc.spring.domain.Review;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PresidentComment extends BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "presidentId")
    private President president;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId")
    private Review review;
}
