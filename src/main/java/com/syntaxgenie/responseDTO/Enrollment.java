package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enrollment extends BaseResponseDTO {

    private Integer enrollmentId;
    private String email;
    private String name;
    private String index;
}