package com.kstrinadka.slidesyncbackend.service;

import com.kstrinadka.slidesyncbackend.dao.SlideRepository;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.dto.mapper.UniversalMapper;
import com.kstrinadka.slidesyncbackend.model.Slide;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SlideService {
    private final SlideRepository slideRepository;
    private final UniversalMapper universalMapper;

    public Slide createSlide(SlideModificationDTO slideDTO) {
        Slide entity = universalMapper.toEntity(slideDTO);

        return slideRepository.save(entity);
    }

    public Slide getSlide(String id) {
        return slideRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Slide not found"));
    }

    public Slide updateSlide(String id, SlideModificationDTO slideDTO) {
        Slide slide = slideRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Slide not found"));

        slide.setType(slideDTO.getType());
        slide.setOrder(slideDTO.getOrder());

        return slideRepository.save(slide);
    }

    public void deleteSlide(String id) {
        slideRepository.deleteById(UUID.fromString(id));
    }

}