package port.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import port.sport.entitiy.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByLoginIdAndPassword(String loginId, String password);

}
