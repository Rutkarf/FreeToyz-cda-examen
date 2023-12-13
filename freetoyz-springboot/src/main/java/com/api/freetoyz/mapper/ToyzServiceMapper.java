//package com.api.freetoyz.mapper;
//
//import com.api.freetoyz.repository.toyz.ToyzRepositoryModel;
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
//public interface ToyzServiceMapper {
//    ToyzServiceMapper INSTANCE = Mappers.getMapper(ToyzServiceMapper.class);
//
//    // POST ET PUT
//    @Mappings({
//            @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType"),
//            @Mapping(source = "filename", target = "filename", qualifiedByName = "optionalToType")
//    })
//    ToyzRepositoryModel ToyzServiceModelToToyzRepositoryModel (ToyzServiceModel toyzServiceModel);
//
//    // GET ALL et GET ONE
//    @Mappings({
//            @Mapping(source = "id", target = "id", qualifiedByName = "typeToOptional"),
//            @Mapping(source = "filename", target = "filename", qualifiedByName = "typeToOptional")
//    })
//    ToyzServiceModel ToyzRepositoryModelToToyzServiceModel(ToyzRepositoryModel toyzRepositoryModel);
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
//
//}
//
