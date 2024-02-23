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
public class ChapterExternalResource {

    private Integer id;
    private Integer chapterId;
    private List<ResourceLink> resourceLinks;
    private Integer chapterItemSequenceNumber;
    private String contentType;
}