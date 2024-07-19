package port.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import port.sport.repository.PostsRepository;
import port.sport.repository.PostsRepositoryCustom;
import port.sport.service.PostsService;

@Controller
public class PostsController {

    PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/posts")
    public void boardHome() {
        PostsRepositoryCustom custom;
        PostsRepository repository;

    }
}
