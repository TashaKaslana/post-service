package org.phong.postservice.infrastructure.mapstruct;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.phong.postservice.dtos.requests.PostCreateRequest;
import org.phong.postservice.dtos.requests.PostMetadataUpdateRequest;
import org.phong.postservice.dtos.requests.PostSurfaceUpdateRequest;
import org.phong.postservice.dtos.requests.PostUpdateRequest;
import org.phong.postservice.dtos.responds.PostEntityRespond;
import org.phong.postservice.infrastructure.persistence.models.PostEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostEntityMapper {
    PostEntity toEntity(PostCreateRequest postCreateRequest);

    PostCreateRequest toDto(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostCreateRequest postCreateRequest, @MappingTarget PostEntity postEntity);

    PostEntity toEntity(PostUpdateRequest postUpdateRequest);

    PostUpdateRequest toDto1(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostUpdateRequest postUpdateRequest, @MappingTarget PostEntity postEntity);

    PostEntity toEntity(PostSurfaceUpdateRequest postSurfaceUpdateRequest);

    PostSurfaceUpdateRequest toDto2(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostSurfaceUpdateRequest postSurfaceUpdateRequest, @MappingTarget PostEntity postEntity);

    PostEntity toEntity(PostMetadataUpdateRequest postMetadataUpdateRequest);

    PostMetadataUpdateRequest toDto3(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostMetadataUpdateRequest postMetadataUpdateRequest, @MappingTarget PostEntity postEntity);

    PostEntity toEntity(PostEntityRespond postEntityRespond);

    PostEntityRespond toDto4(PostEntity postEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostEntity partialUpdate(PostEntityRespond postEntityRespond, @MappingTarget PostEntity postEntity);
}