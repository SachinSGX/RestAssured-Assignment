package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syntaxgenie.requestDTO.*;
import com.syntaxgenie.util.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateChapterResponseDTO extends BaseResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private String mode;
    private String type;
    private String difficultyLevel;
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
    private String fieldOfStudy;
    private Float rating;
    private Float price;
    private Boolean draft;
    private String formLink;
    private String estimatedCourseDuration;
    private Boolean paid;
    private Boolean couponAllowed;
}


//{
//        "id": 48703,
//        "name": "API Testing - test 1",
//        "description": "test",
//        "mode": "LIVE_CLASS",
//        "type": "COURSE",
//        "difficultyLevel": "BEGINNER",
//        "outlines": [
//            {
//            "title": "test",
//            "description": "test"
//            }
//        ],
//        "expertsPanel": [
//            {
//            "name": "test",
//            "imageUrl": "",
//            "designation": "test"
//            }
//        ],
//        "frequentlyAskedQuestions": [],
//        "collaborationLogos": [],
//        "sequence": [
//            {
//            "lessonId": 49701,
//            "units": [
//                {
//                "unitId": 49751,
//                "chapters": [
//                    {
//                    "chapterId": 50804,
//                    "contents": [
//                        {
//                        "contentId": 50854,
//                        "type": "CHAPTER_TEXT_CONTENT"
//                        },
//                        {
//                        "contentId": 51002,
//                        "type": "CHAPTER_VIDEO"
//                        },
//                        {
//                        "contentId": 50953,
//                        "type": "CHAPTER_EXTERNAL_RESOURCE"
//                        },
//                        {
//                        "contentId": 50903,
//                        "type": "CHAPTER_MATERIAL"
//                        },
//                        {
//                        "contentId": 50855,
//                        "type": "CHAPTER_TEXT_CONTENT"
//                        },
//                        {
//                        "contentId": 51003,
//                        "type": "CHAPTER_VIDEO"
//                        }
//                    ]
//                    }
//                ]
//                }
//            ]
//            }
//        ],
//        "registrationStartDate": "2024-01-01T12:30:35Z",
//        "registrationEndDate": "2024-01-10T12:30:35Z",
//        "startDate": "2024-01-15T12:30:35Z",
//        "endDate": "2024-03-30T12:30:35Z",
//        "coverImageUrl": "https://devsalearnovaeastus2.blob.core.windows.net/dev-storage-container-learnova-eastus2/images%2Fbanner.jpg8e05cf08-1b41-4495-85f2-6ec98910538c.jpg",
//        "previewVideo": "",
//        "needToPrepareSection": "",
//        "bannerVectorUrl": null,
//        "prerequisites": "",
//        "classSchedule": "<p>test</p>",
//        "fieldOfStudy": "INTERNET_OF_THINGS",
//        "rating": 0,
//        "price": 25000,
//        "draft": false,
//        "formLink": null,
//        "estimatedCourseDuration": "8 weeks",
//        "couponAllowed": true,
//        "paid": true
//        }