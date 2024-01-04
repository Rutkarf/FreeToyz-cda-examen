package com.api.freetoyz.mapper;


import com.api.freetoyz.controller.dto.toyz.ToyzDTO;
import com.api.freetoyz.repository.toyz.ToyzRepositoryModel;
import com.api.freetoyz.services.model.ToyzServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper( MapStructMapper.class);

    // repository --> service
    @Mapping(source="id", target="id", qualifiedByName = "typeToOptional")
    ToyzServiceModel toyzRepositoryModelToService(ToyzRepositoryModel toyzRepositoryModel);

    // service --> dto
    @Mapping(source="id", target="id", qualifiedByName = "optionalToType")
    ToyzDTO toyzServiceModelToDto(ToyzServiceModel toyzServiceModel);



    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }
    @Named("typeToOptional")
    default <T> Optional<T> typeToOptional(T source) {
        return Optional.ofNullable(source);
    }
}

