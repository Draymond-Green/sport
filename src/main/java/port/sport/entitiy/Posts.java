package port.sport.entitiy;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Posts {
    @Id
    @GeneratedValue
    @Column(name = "PostsId")
    Long id;

    LocalDateTime created;

    LocalDateTime lastModified;

    @Range(min = 1, max = 20)
    String title;

    @Range(min = 10, max = 1000)
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    Member member;

    @Autowired
    @QueryProjection
    public Posts(LocalDateTime created, LocalDateTime lastModified, String title, String content, Member member) {
        this.created = created;
        this.lastModified = lastModified;
        this.title = title;
        this.content = content;

        this.member = member;
        member.posts.add(this);
    }

}
