package com.syntaxgenie.requestDTO;

import com.syntaxgenie.enums.CourseMode;
import com.syntaxgenie.enums.CourseType;
import com.syntaxgenie.enums.DifficultyLevel;
import com.syntaxgenie.enums.FieldOfStudy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequestDTO {

    private String name;
    private String description;
    private CourseType type;
    private DifficultyLevel difficultyLevel;
    private List<Outline> outlines;
    private List<Expert> expertsPanel;
    private List<Question> frequentlyAskedQuestions;
    private List<CollaborationLogo> collaborationLogos;
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
    private Float price;
    private CourseMode mode;
    private Boolean isPaid;
    private Boolean isCouponAllowed;
    private String estimatedCourseDuration;
    private String formLink;
}
