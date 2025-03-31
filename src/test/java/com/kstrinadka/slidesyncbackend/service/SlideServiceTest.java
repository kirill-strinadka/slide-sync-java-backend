package com.kstrinadka.slidesyncbackend.service;

import com.kstrinadka.slidesyncbackend.config.AbstractTestcontainers;
import com.kstrinadka.slidesyncbackend.dto.SlideModificationDTO;
import com.kstrinadka.slidesyncbackend.model.Slide;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SlideServiceTest extends AbstractTestcontainers {

    @Autowired
    private SlideService slideService;

    @Test
    void testCreateSlide() {
        // Given
        SlideModificationDTO dto = new SlideModificationDTO();
        dto.setId(UUID.randomUUID().toString());
        dto.setType("TEXT");
        dto.setCommands(List.of("command1", "command2").toString());

        // When
        Slide createdSlide = slideService.createSlide(dto);

        // Then
        assertNotNull(createdSlide);
        assertEquals(dto.getType(), createdSlide.getType());
    }

    @Test
    void testGetSlide() {
        // Given
        SlideModificationDTO dto = new SlideModificationDTO();
        dto.setId(UUID.randomUUID().toString());
        dto.setType("TEXT");

        dto.setCommands(List.of("command1", "command2").toString());
        Slide createdSlide = slideService.createSlide(dto);

        // When
        Slide foundSlide = slideService.getSlide(createdSlide.getId().toString());

        // Then
        assertNotNull(foundSlide);
        assertEquals(createdSlide.getId(), foundSlide.getId());
    }
}
