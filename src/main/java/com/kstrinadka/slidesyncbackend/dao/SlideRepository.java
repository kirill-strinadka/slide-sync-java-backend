package com.kstrinadka.slidesyncbackend.dao;

import com.kstrinadka.slidesyncbackend.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SlideRepository extends JpaRepository<Slide, UUID> {

}
