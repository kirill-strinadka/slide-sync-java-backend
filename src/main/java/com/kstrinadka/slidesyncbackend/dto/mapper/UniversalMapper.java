package com.kstrinadka.slidesyncbackend.dto.mapper;

import com.kstrinadka.slidesyncbackend.dto.SlideDTO;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.model.Slide;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UniversalMapper {

//    @Mapping(target = "comparisons", ignore = true)
    public abstract SlideDTO map(Slide list);

    public abstract Slide toEntity(SlideModificationDTO list);


}
