package port.sport.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import port.sport.entitiy.Member;
import port.sport.entitiy.Posts;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PostsRepositoryImplTest {
    @Autowired
    EntityManager em;
    @Autowired
    PostsRepositoryImpl repository;

    @BeforeEach
    void beforeEach() {
        Member member = new Member("dmsdn2005", "나감독", "123123", 30, "InCheon");
        Posts posts1 = new Posts(LocalDateTime.now(), LocalDateTime.now(), "a1", "b1", member);
        Posts posts2 = new Posts(LocalDateTime.now(), LocalDateTime.now(), "a2", "b2", member);
        Posts posts3 = new Posts(LocalDateTime.now(), LocalDateTime.now(), "a3", "b3", member);
        Posts posts4 = new Posts(LocalDateTime.now(), LocalDateTime.now(), "a4", "b4", member);

        em.persist(posts1);
        em.persist(posts2);
        em.persist(posts3);
        em.persist(posts4);
    }

    @Test
    void findByTitleDto() {
    }

    @Test
    void findByContentDto() {
    }


}