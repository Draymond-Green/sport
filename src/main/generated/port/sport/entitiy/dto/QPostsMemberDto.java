package port.sport.entitiy.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * port.sport.entitiy.dto.QPostsMemberDto is a Querydsl Projection type for PostsMemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPostsMemberDto extends ConstructorExpression<PostsMemberDto> {

    private static final long serialVersionUID = -60948272L;

    public QPostsMemberDto(com.querydsl.core.types.Expression<java.time.LocalDateTime> created, com.querydsl.core.types.Expression<java.time.LocalDateTime> lastModified, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<String> nickName) {
        super(PostsMemberDto.class, new Class<?>[]{java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, String.class, String.class}, created, lastModified, title, content, nickName);
    }

}

