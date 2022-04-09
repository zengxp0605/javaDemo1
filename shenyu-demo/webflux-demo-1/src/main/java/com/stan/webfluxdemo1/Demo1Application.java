package com.stan.webfluxdemo1;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 10:02
 * @Desc:
 */
@SpringBootApplication
public class Demo1Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}


@RestController
@RequestMapping(value = "/posts")
class PostController {

    private final PostRepository posts;

    public PostController(PostRepository posts) {
        this.posts = posts;
    }

    @GetMapping(value = "")
    public Flux<Post> all() {
        return this.posts.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Post> get(@PathVariable(value = "id") UUID id) {
        return this.posts.findById(id);
    }

    @PostMapping(value = "")
    public Mono<ResponseEntity<?>> create(@RequestBody Post post) {
        return this.posts.save(post).map(p -> ResponseEntity.created(URI.create("/posts/" + p.getId())).build());
    }

}

@Component
@Slf4j
class PostRepository {

    private static final List<Post> DATA = new ArrayList<>();

    static {
        DATA.add(Post.builder().id(UUID.randomUUID()).title("post one").content("content of post one").build());
        DATA.add(Post.builder().id(UUID.randomUUID()).title("post two").content("content of post two").build());
    }

    Flux<Post> findAll() {
        return Flux.fromIterable(DATA);
    }


    Mono<Post> findById(UUID id) {
        return findAll().filter(p -> p.getId().equals(id)).last();
    }

    Mono<Post> save(Post post) {
        Post saved = Post.builder().id(UUID.randomUUID()).title(post.getTitle()).content(post.getContent()).build();
        log.info("saved post: {}", saved);
        DATA.add(saved);
        return Mono.just(saved);
    }

}

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Post {
    private UUID id;
    private String title;
    private String content;
}