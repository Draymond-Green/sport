package port.sport.entitiy.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import port.sport.entitiy.Member;
import port.sport.entitiy.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsMemberDto {
    LocalDateTime created;

    LocalDateTime lastModified;

    String title;

    String content;

    String nickName;

    @QueryProjection
    public PostsMemberDto(LocalDateTime created, LocalDateTime lastModified, String title, String content, String nickName) {
        this.created = created;
        this.lastModified = lastModified;
        this.title = title;
        this.content = content;
        this.nickName = nickName;
    }
}
