package com.kstrinadka.slidesyncbackend.service;

import com.kstrinadka.slidesyncbackend.dao.SlideRepository;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.dto.mapper.UniversalMapper;
import com.kstrinadka.slidesyncbackend.model.Slide;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SlideService {
    private final SlideRepository slideRepository;
    private final UniversalMapper mapper;

    public Slide createSlide(SlideModificationDTO slideDTO) {
        Slide entity = mapper.toEntity(slideDTO);
        return slideRepository.save(entity);
    }

    public Slide getSlide(String id) {
        return slideRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Slide not found"));
    }

    public List<Slide> getSlides() {
        return slideRepository.findAll();
    }

    public Slide updateSlide(String id, SlideModificationDTO slideDTO) {
        Slide slide = slideRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Slide not found"));

        SlideModificationDTO slideModificationDTO = new SlideModificationDTO()
                .setId(id)
                .setType(slideDTO.getType())
                .setCommands(slideDTO.getCommands());

        return slideRepository.save(
                mapper.toEntity(slideModificationDTO)
        );
    }

    public void deleteSlide(String id) {
        slideRepository.deleteById(UUID.fromString(id));
    }

}