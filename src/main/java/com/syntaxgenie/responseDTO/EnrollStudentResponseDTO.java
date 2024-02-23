package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollStudentResponseDTO extends BaseResponseDTO {

    private List<Enrollment> enrollments;

}
