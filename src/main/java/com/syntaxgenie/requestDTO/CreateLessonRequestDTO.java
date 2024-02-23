package com.syntaxgenie.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLessonRequestDTO {

    private Integer courseId;
    private String name;
    private String description;
    private Boolean containsUnits;
}
