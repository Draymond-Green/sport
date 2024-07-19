package port.sport.entitiy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPosts is a Querydsl query type for Posts
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPosts extends EntityPathBase<Posts> {

    private static final long serialVersionUID = -177124124L;

    public static ConstructorExpression<Posts> create(Expression<java.time.LocalDateTime> created, Expression<java.time.LocalDateTime> lastModified, Expression<String> title, Expression<String> content, Expression<? extends Member> member) {
        return Projections.constructor(Posts.class, new Class<?>[]{java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, String.class, Member.class}, created, lastModified, title, content, member);
    }

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPosts posts = new QPosts("posts");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> created = createDateTime("created", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastModified = createDateTime("lastModified", java.time.LocalDateTime.class);

    public final QMember member;

    public final StringPath title = createString("title");

    public QPosts(String variable) {
        this(Posts.class, forVariable(variable), INITS);
    }

    public QPosts(Path<? extends Posts> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPosts(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPosts(PathMetadata metadata, PathInits inits) {
        this(Posts.class, metadata, inits);
    }

    public QPosts(Class<? extends Posts> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

