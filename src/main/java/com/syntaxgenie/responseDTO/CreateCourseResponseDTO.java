package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.enums.CourseMode;
import com.syntaxgenie.enums.CourseType;
import com.syntaxgenie.enums.DifficultyLevel;
import com.syntaxgenie.enums.FieldOfStudy;
import com.syntaxgenie.requestDTO.CollaborationLogo;
import com.syntaxgenie.requestDTO.Expert;
import com.syntaxgenie.requestDTO.Outline;
import com.syntaxgenie.requestDTO.Question;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCourseResponseDTO extends BaseResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private CourseMode mode;
    private CourseType type;
    private DifficultyLevel difficultyLevel;
    private List<Outline> outlines;
    private List<Expert> expertsPanel;
    private List<Question> frequentlyAskedQuestions;
    private List<CollaborationLogo> collaborationLogos;
    private List<ContentSequence> sequence;
    private String registrationStartDate;
    private String registrationEndDate;
    private String startDate;
    private String endDate;
    private String coverImageUrl;
    private String previewVideo;
    private String needToPrepareSection;
    private String bannerVectorUrl;
    private String prerequisites;
    private String classSchedule;
    private FieldOfStudy fieldOfStudy;
    private Float rating;
    private Float price;
    private Boolean draft;
    private String courseType;
    private String courseDifficultyLevel;
    private String courseDuration;
    private String specialization;
    private String instructorName;
    private String instructorProfilePicture;
    private List<String> totalReviews;
    private String totalNumberOfReviews;
    private Integer createdBy;
    private String createdDate;
    private Integer lastModifiedBy;
    private String lastModifiedDate;
    private String formLink;
    private String enrolled;
    private Integer enrollmentId;
    private Boolean paid;
    private Boolean couponAllowed;
}
