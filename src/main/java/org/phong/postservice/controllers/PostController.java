package org.phong.postservice.controllers;

import jakarta.validation.Valid;
import org.phong.postservice.dtos.requests.PostCreateRequest;
import org.phong.postservice.dtos.requests.PostMetadataUpdateRequest;
import org.phong.postservice.dtos.requests.PostSurfaceUpdateRequest;
import org.phong.postservice.dtos.requests.PostUpdateRequest;
import org.phong.postservice.dtos.responds.PostEntityRespond;
import org.phong.postservice.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostEntityRespond> getPostById(@PathVariable UUID postId) {
        PostEntityRespond post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<PostEntityRespond>> getPostsByAuthorId(@PathVariable UUID authorId) {
        List<PostEntityRespond> posts = postService.getPostsByAuthorId(authorId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<UUID> createPost(@RequestBody PostCreateRequest request) {
        UUID postId = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable UUID postId) {
        postService.deletePostById(postId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deletePostsByAuthorId(@PathVariable UUID authorId) {
        postService.deletePostsByAuthorId(authorId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable UUID postId,
                                           @Valid @RequestBody PostUpdateRequest request) {
        postService.updatePost(postId, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{postId}/surface")
    public ResponseEntity<Void> updatePostSurface(@PathVariable UUID postId,
                                                  @Valid @RequestBody PostSurfaceUpdateRequest request) {
        postService.updatePostSurface(postId, request);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{postId}/metadata")
    public ResponseEntity<Void> updatePostMetadata(@PathVariable UUID postId,
                                                   @Valid @RequestBody PostMetadataUpdateRequest request) {
        postService.updatePostMetadata(postId, request);
        return ResponseEntity.noContent().build();
    }
}