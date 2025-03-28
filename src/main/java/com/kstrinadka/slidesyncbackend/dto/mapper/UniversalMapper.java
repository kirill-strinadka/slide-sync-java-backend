package com.kstrinadka.slidesyncbackend.dto.mapper;

import com.kstrinadka.slidesyncbackend.dto.SlideDTO;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.model.Slide;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UniversalMapper {


    public abstract SlideDTO map(Slide list);

    public abstract List<SlideDTO> map(List<Slide> list);

    @Mapping(target = "id", expression = "java(stringToUUID(dto.getId()))")
    public abstract Slide toEntity(SlideModificationDTO dto);

    UUID stringToUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

}
