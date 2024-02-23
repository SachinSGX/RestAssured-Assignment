package com.syntaxgenie.constants;

public interface Constants {

    String DEFAULT_CONFIG_LOCATION = "src/test/resources/config/config.cfg";
    String CONTENT_TYPE_TEXT = "CHAPTER_TEXT_CONTENT";
    String CONTENT_TYPE_VIDEO = "CHAPTER_VIDEO";
    String CONTENT_TYPE_EXTERNAL_RESOURCE = "CHAPTER_EXTERNAL_RESOURCE";
    String CONTENT_TYPE_MATERIAL = "CHAPTER_MATERIAL";


    // Error messages
    String COURSE_DELETE_FAILED_MESSAGE = "Deletion is not allowed for this course as it has already been purchased by students.";
}
