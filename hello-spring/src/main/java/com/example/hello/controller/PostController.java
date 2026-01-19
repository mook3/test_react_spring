package com.example.hello.controller;

import com.example.hello.repository.PostRepository;
import com.example.hello.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PostController(PostRepository postRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.postRepository = postRepository;
      this.kafkaTemplate = kafkaTemplate;
    }

    // CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        kafkaTemplate.send("topic1", "Saving post: " + post.getTitle());
        return postRepository.save(post);
    }

    // READ ALL
    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }
}
