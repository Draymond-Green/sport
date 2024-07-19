package port.sport.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import port.sport.entitiy.Posts;
import port.sport.repository.PostsRepository;

import java.util.List;

@Service
public class PostsService {
    PostsRepository postsRepository;
    public Page<Posts> findAll(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public void searchTitle(String title) {

    }
}
