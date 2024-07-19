package port.sport.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Validated
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MemberId")
    Long id;

    @Range(min = 4, max = 16)
    String loginId;

    @Range(min = 4, max = 16)
    String nickName;

    @Range(min = 4, max = 16)
    String password;

    @Range(min = 0, max = 150)
    int age;

    String livingLocation;

    @OneToMany(mappedBy = "member")
    List<Posts> posts= new ArrayList<>();

    public Member(String loginId, String nickName, String password, int age, String livingLocation) {
        this.loginId = loginId;
        this.nickName = nickName;
        this.password = password;
        this.age = age;
        this.livingLocation = livingLocation;
    }
}
