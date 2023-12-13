// ToyzDTOMapper.java

//package com.api.freetoyz.controller.dto.toyz;
//
//import com.api.freetoyz.services.model.ToyzServiceModel;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//import java.util.Optional;
//
//@Mapper
//public interface ToyzDTOMapper {
//
//    ToyzDTOMapper INSTANCE = Mappers.getMapper(ToyzDTOMapper.class);
//
//    // POST ET PUT
//    @Mapping(source = "filename", target = "filename", qualifiedByName = "typeToOptional")
//    ToyzServiceModel ToyzGetDTOToToyzServiceModel(ToyzDTO toyzDTO);
//
//    // GET ALL et GET ONE
//    @Mappings({
//            @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType"),
//            @Mapping(source = "filename", target = "filename", qualifiedByName = "optionalToType")
//    })
//    ToyzGetDTO ToyzServiceModelToToyzGetDTO(ToyzServiceModel toyzStoreServiceModel);
//
//    @Named("optionalToType")
//    default <T> T optionalToType(Optional<T> source) throws Exception {
//        return source.orElse(null);
//    }
//
//    @Named("typeToOptional")
//    default <T> Optional<T> typeToOptional(T source) throws Exception {
//        return Optional.ofNullable(source);
//    }
//}

