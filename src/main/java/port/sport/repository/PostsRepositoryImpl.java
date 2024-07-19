package port.sport.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.micrometer.observation.Observation;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import port.sport.entitiy.dto.PostsMemberDto;
import port.sport.entitiy.dto.QPostsMemberDto;

import java.util.List;
import java.util.function.LongSupplier;

import static port.sport.entitiy.QMember.*;
import static port.sport.entitiy.QPosts.*;


@Repository
public class PostsRepositoryImpl implements PostsRepositoryCustom{
    JPAQueryFactory queryFactory;

    public PostsRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<PostsMemberDto> findByTitleDto(String title, Pageable pageable) {
        List<PostsMemberDto> content = queryFactory.select(new QPostsMemberDto(posts.created, posts.lastModified, posts.title, posts.content, member.nickName))
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsTitle(title))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(posts.count())
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsTitle(title));

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);

    }

    @Override
    public Page<PostsMemberDto> findByContentDto(String content, Pageable pageable) {
        List<PostsMemberDto> fetch = queryFactory.select(new QPostsMemberDto(posts.created, posts.lastModified, posts.title, posts.content, member.nickName))
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsContent(content))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(posts.count())
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsContent(content));

        return PageableExecutionUtils.getPage(fetch, pageable, countQuery::fetchOne);
    }

    @Override
    public Page<PostsMemberDto> findByTitleOrContent(String title, String content, Pageable pageable) {
        List<PostsMemberDto> fetch = queryFactory.select(new QPostsMemberDto(posts.created, posts.lastModified, posts.title, posts.content, member.nickName))
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsTitleOrContent(title, content))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = queryFactory.select(posts.count())
                .from(posts)
                .leftJoin(posts.member, member)
                .where(containsTitleOrContent(title, content));

        return PageableExecutionUtils.getPage(fetch, pageable, count::fetchOne);
    }

    public BooleanExpression containsTitle(String title) {
        return title == null ? null : posts.title.contains(title);
    }

    public BooleanExpression containsContent(String content) {
        return content == null ? null : posts.content.contains(content);
    }

    public BooleanExpression containsTitleOrContent(String title, String content) {
        return posts.title.contains(title).or(posts.content.contains(content));
    }
}
