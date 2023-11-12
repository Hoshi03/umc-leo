package leo.umc.domain.mapping;

import leo.umc.domain.Member;
import leo.umc.domain.Mission;
import leo.umc.domain.Restaurant;
import leo.umc.domain.common.BaseEntity;
import leo.umc.domain.enums.MissionStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reviewContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
