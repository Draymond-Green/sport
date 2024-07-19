package port.sport.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import port.sport.entitiy.dto.PostsMemberDto;

import java.util.List;

public interface PostsRepositoryCustom {

  /*  public List<PostsDto> findAllDto();

    public Page<PostsDto> findAllDto(Pageable pageable);*/

    public Page<PostsMemberDto> findByTitleDto(String title, Pageable pageable);

    public Page<PostsMemberDto> findByContentDto(String content, Pageable pageable);

    public Page<PostsMemberDto> findByTitleOrContent(String title, String content, Pageable pageable);

}
