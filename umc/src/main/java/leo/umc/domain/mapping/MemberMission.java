package leo.umc.domain.mapping;

import leo.umc.domain.Member;
import leo.umc.domain.Mission;
import leo.umc.domain.common.BaseEntity;
import leo.umc.domain.enums.MissionStatus;
import leo.umc.domain.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
