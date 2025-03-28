package com.kstrinadka.slidesyncbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SlideModificationDTO {
    private String id;
    private String type;
    private int order;
    private String commands;
}
