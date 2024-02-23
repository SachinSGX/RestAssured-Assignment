package com.syntaxgenie.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateChapterRequestDTO {

    private Integer courseId;
    private Integer lessonId;
    private Integer unitId;
    private Integer chapterId;
    private String chapterName;
    private String chapterDescription;
    private List<ChapterText> chapterTextContentDTOList;
    private List<ChapterVideo> chapterVideoDTOList;
    private List<ChapterMaterial> chapterMaterialDTOList;
    private List<ChapterExternalResource> chapterExternalResourceDTOList;
    private List<ChapterSequence> sequenceIdDTOList;

}