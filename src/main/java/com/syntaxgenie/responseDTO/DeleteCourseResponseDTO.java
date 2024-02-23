package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteCourseResponseDTO extends BaseResponseDTO {

    private String timeStamp;
    private String title;
    private Integer status;
    private String detail;
    private String message;
    private String data;
}
