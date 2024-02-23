package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUnitResponseDTO extends BaseResponseDTO {

    private Integer id;
    private Integer courseId;
    private Integer lessonId;
    private String name;
    private String description;
}
