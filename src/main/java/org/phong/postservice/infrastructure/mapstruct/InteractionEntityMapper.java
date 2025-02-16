package org.phong.postservice.infrastructure.mapstruct;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.phong.postservice.dtos.requests.InteractionCreateRequest;
import org.phong.postservice.dtos.requests.InteractionUpdateRequest;
import org.phong.postservice.dtos.responds.InteractionEntityRespond;
import org.phong.postservice.infrastructure.persistence.models.InteractionEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InteractionEntityMapper {
    InteractionEntity toEntity(InteractionCreateRequest interactionCreateRequest);

    InteractionCreateRequest toDto(InteractionEntity interactionEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InteractionEntity partialUpdate(InteractionCreateRequest interactionCreateRequest, @MappingTarget InteractionEntity interactionEntity);

    InteractionEntity toEntity(InteractionUpdateRequest interactionUpdateRequest);

    InteractionUpdateRequest toDto1(InteractionEntity interactionEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InteractionEntity partialUpdate(InteractionUpdateRequest interactionUpdateRequest, @MappingTarget InteractionEntity interactionEntity);

    InteractionEntity toEntity(InteractionEntityRespond interactionEntityRespond);

    InteractionEntityRespond toDto2(InteractionEntity interactionEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InteractionEntity partialUpdate(InteractionEntityRespond interactionEntityRespond, @MappingTarget InteractionEntity interactionEntity);
}