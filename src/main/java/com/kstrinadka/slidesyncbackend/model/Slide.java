package com.kstrinadka.slidesyncbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Slide {
    @Id
    private UUID id;

    private String type;
    private int order;
    private String commands;

    // todo - картинки лучше в Amazon S3 хранить

}
