package com.syntaxgenie.constants;

public interface RelativeURLs {

    String LEARNOVA_LOGIN = "/api/authenticate";
    String CREATE_COURSE = "/api/admin/courses";
    String UPDATE_COURSE = "/api/admin/courses/{id}";
    String GET_COURSE = "/api/public/courses/{id}";
    String DELETE_COURSE = "/api/admin/courses/{id}";
    String CREATE_LESSON = "/api/admin/lessons";
    String CREATE_UNIT = "/api/admin/units";
    String CREATE_CHAPTER = "/api/admin/chapters";
    String ENROLL_STUDENT = "/api/admin/course-enrollments";
}
