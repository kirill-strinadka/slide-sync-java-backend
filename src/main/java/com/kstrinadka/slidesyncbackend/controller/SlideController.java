package com.kstrinadka.slidesyncbackend.controller;

import com.kstrinadka.slidesyncbackend.dto.SlideDTO;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.dto.mapper.UniversalMapper;
import com.kstrinadka.slidesyncbackend.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slides")
@RequiredArgsConstructor
public class SlideController {
    private final SlideService slideService;
    private final UniversalMapper mapper;

    @PostMapping
    public SlideDTO createSlide(@RequestBody SlideModificationDTO slideDTO) {
        return mapper.map(slideService.createSlide(slideDTO));
    }

    @GetMapping("/{id}")
    public SlideDTO getSlide(@PathVariable String id) {
        return mapper.map(slideService.getSlide(id));
    }

    @PutMapping("/{id}")
    public SlideDTO updateSlide(@PathVariable String id, @RequestBody SlideModificationDTO slideDTO) {
        return mapper.map(
                slideService.updateSlide(id, slideDTO)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteSlide(@PathVariable String id) {
        slideService.deleteSlide(id);
    }

}
