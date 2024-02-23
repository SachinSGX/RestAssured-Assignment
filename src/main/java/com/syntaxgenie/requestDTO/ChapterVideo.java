package com.syntaxgenie.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterVideo {

    private Integer id;
    private Integer chapterId;
    private String fileName;
    private String url;
    private String type;
    private Integer chapterItemSequenceNumber;
    private String contentType;
}
