package leo.umc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import leo.umc.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
