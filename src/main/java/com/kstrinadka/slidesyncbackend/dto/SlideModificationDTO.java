package com.kstrinadka.slidesyncbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SlideModificationDTO {
    private String id;
    private String type;
//    private int order;
    private List<String> commands;
}
