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


    @Mapping(target = "commands", expression = "java(deserializeCommands(slide.getCommands()))")
    public abstract SlideDTO map(Slide slide);

    public abstract List<SlideDTO> map(List<Slide> list);

    @Mapping(target = "id", expression = "java(stringToUUID(dto.getId()))")
    @Mapping(target = "commands", expression = "java(serializeCommands(dto.getCommands()))")
    public abstract Slide toEntity(SlideModificationDTO dto);

    UUID stringToUUID(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    String serializeCommands(List<String> commands) {
        if (commands == null || commands.isEmpty()) {
            return null;
        }
        return String.join(",", commands);
    }

    List<String> deserializeCommands(String commands) {
        if (commands == null || commands.isEmpty()) {
            return List.of(); // Возвращаем пустой список
        }
        return List.of(commands.split(","));
    }
}
