package port.sport.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import port.sport.entitiy.Posts;
import port.sport.entitiy.dto.PostsMemberDto;

public interface PostsRepository extends JpaRepository<Posts, Long>, PostsRepositoryCustom {

}
