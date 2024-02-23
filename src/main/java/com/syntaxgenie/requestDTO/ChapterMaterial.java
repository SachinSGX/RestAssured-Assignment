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
public class ChapterMaterial {

    private Integer id;
    private Integer chapterId;
    private List<Material> materials;
    private String type;
    private Integer chapterItemSequenceNumber;
    private String contentType;
}