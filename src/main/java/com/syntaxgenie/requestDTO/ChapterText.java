package com.syntaxgenie.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterText {

    private Integer id;
    private Integer chapterId;
    private String content;
    private Integer chapterItemSequenceNumber;
    private String contentType;
}