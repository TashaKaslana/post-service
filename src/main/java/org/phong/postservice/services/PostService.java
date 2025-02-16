package org.phong.postservice.services;

import org.phong.postservice.dtos.requests.PostCreateRequest;
import org.phong.postservice.dtos.requests.PostMetadataUpdateRequest;
import org.phong.postservice.dtos.requests.PostSurfaceUpdateRequest;
import org.phong.postservice.dtos.requests.PostUpdateRequest;
import org.phong.postservice.dtos.responds.PostEntityRespond;
import org.phong.postservice.enums.BusinessErrorEnum;
import org.phong.postservice.exceptions.PostNotFoundException;
import org.phong.postservice.infrastructure.mapstruct.PostEntityMapper;
import org.phong.postservice.infrastructure.persistence.models.PostEntity;
import org.phong.postservice.infrastructure.persistence.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostEntityMapper postEntityMapper;

    public PostService(PostRepository postRepository,
                       PostEntityMapper postEntityMapper) {
        this.postRepository = postRepository;
        this.postEntityMapper = postEntityMapper;
    }

    public PostEntityRespond getPostById(UUID postId) {
        PostEntity postEntity = findPostById(postId);

        return postEntityMapper.toDto4(postEntity);
    }

    public List<PostEntityRespond> getPostsByAuthorId(UUID authorId) {
        List<PostEntity> postEntities = postRepository.findAllByAuthorId(authorId);

        return postEntities.stream().map(postEntityMapper::toDto4).collect(Collectors.toList());
    }

    public UUID createPost(PostCreateRequest request) {
        PostEntity postEntity = postEntityMapper.toEntity(request);

        PostEntity createdPostEntity = postRepository.save(postEntity);

        return createdPostEntity.getId();
    }

    public PostEntity findPostById(UUID postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException(BusinessErrorEnum.POST_NOT_FOUND.getMessage())
        );
    }

    public void deletePostById(UUID postId) {
        findPostById(postId);

        postRepository.deleteById(postId);
    }

    public void deletePostsByAuthorId(UUID authorId) {
        postRepository.deleteAllByAuthorId(authorId);
    }

    public void updatePost(UUID postId, PostUpdateRequest request) {
        PostEntity postEntity = findPostById(postId);

        PostEntity updatedPost = postEntityMapper.partialUpdate(request, postEntity);

        postRepository.save(updatedPost);
    }

    public void updatePostSurface(UUID postId, PostSurfaceUpdateRequest request) {
        PostEntity postEntity = findPostById(postId);

        PostEntity updatedPost = postEntityMapper.partialUpdate(request, postEntity);

        postRepository.save(updatedPost);
    }

    public void updatePostMetadata(UUID postId, PostMetadataUpdateRequest request) {
        PostEntity postEntity = findPostById(postId);

        PostEntity updatedPost = postEntityMapper.partialUpdate(request, postEntity);

        postRepository.save(updatedPost);
    }
}
