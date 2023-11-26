package leo.umc.domain;

import leo.umc.domain.common.BaseEntity;
import leo.umc.domain.enums.Gender;
import leo.umc.domain.enums.Status;
import leo.umc.domain.mapping.MemberMission;
import leo.umc.domain.mapping.MemberPrefer;
import leo.umc.domain.mapping.Review;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DynamicUpdate
@DynamicInsert
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String detailAddress;

    @Column(length = 13)
    private String phoneNum;

    @Column(length = 20)
    private String loginId;

    @Column(length = 20)
    private String password;

    @Column(length = 40)
    private LocalDate birthday;

    //멤버 비활성화 기간 체크용?
    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 40)
    private String email;

    @ColumnDefault("0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private Status status;


    //양방향 매핑은 1:N에서 1에 해당하는 엔티티에 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MyPage> MyPageList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ReviewRequestAlarm> ReviewReQuestAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MissionAlarm> MissionAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PointHistory> PointHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();



}