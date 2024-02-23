package com.syntaxgenie.tests;

import com.syntaxgenie.constants.Constants;
import com.syntaxgenie.constants.StaticHeaders;
import com.syntaxgenie.enums.CourseMode;
import com.syntaxgenie.enums.CourseType;
import com.syntaxgenie.enums.DifficultyLevel;
import com.syntaxgenie.enums.FieldOfStudy;
import com.syntaxgenie.reporting.ExtentTestManager;
import com.syntaxgenie.requestDTO.*;
import com.syntaxgenie.responseDTO.*;
import com.syntaxgenie.services.ObjectService;
import com.syntaxgenie.util.BaseResponseDTO;
import com.syntaxgenie.util.TestBase;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestScenarioOne extends TestBase {

    private ObjectService objectService;
    private LoginRequestDTO loginRequestDTO;
    private CreateCourseRequestDTO createCourseRequestDTO;
    private CreateCourseResponseDTO createCourseResponseDTO;
    private CreateLessonRequestDTO createLessonRequestDTO;
    private CreateLessonResponseDTO createLessonResponseDTO;
    private CreateUnitRequestDTO createUnitRequestDTO;
    private CreateUnitResponseDTO createUnitResponseDTO;
    private CreateChapterRequestDTO createChapterRequestDTO;
    private CreateChapterResponseDTO createChapterResponseDTO;
    private EnrollStudentRequestDTO enrollStudentRequestDTO;
    private EnrollStudentResponseDTO enrollStudentResponseDTO;
    private UpdateCourseRequestDTO updateCourseRequestDTO;
    private CreateCourseResponseDTO updateCourseResponseDTO;
    private DeleteCourseResponseDTO deleteCourseResponseDTO;
    private Long allowedDateDiffMilliSec;
    private static String token = null;
    private Integer courseID;
    private Integer lessonID;
    private Integer unitID;
    private Integer chapterID;


    @BeforeClass
    public void serviceSetUp() throws Exception {

        try {
            objectService = new ObjectService(testData.get("url"));

            loginRequestDTO = new LoginRequestDTO();
            loginRequestDTO.setEmail(testData.get("email"));
            loginRequestDTO.setPassword(testData.get("password"));

            token = objectService.generateToken(loginRequestDTO);
            headers = new Headers(StaticHeaders.CONTENT_TYPE_JSON, new Header("Authorization", "Bearer "+token));
            allowedDateDiffMilliSec = 60000L;

        } catch (Exception e) {
            throw e;
        }
    }


    @Test(testName = "testCreateCourse")
    public void testCreateCourse(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create New Course Scenario");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setName(testData.get("courseName"));
        createCourseRequestDTO.setDescription(testData.get("courseDescription"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("difficultyLevel").toUpperCase()));

        Outline outline = new Outline();
        outline.setTitle(testData.get("outlineTitle"));
        outline.setDescription(testData.get("outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("expertName"));
        expert.setDesignation(testData.get("expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        Question question = new Question();
        question.setQuestion(testData.get("question"));
        question.setAnswer(testData.get("answer"));

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        CollaborationLogo collaborationLogo = new CollaborationLogo();
        collaborationLogo.setName(testData.get("logoName"));
        collaborationLogo.setUrl(testData.get("logoUrl"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        collaborationLogoList.add(collaborationLogo);
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setRegistrationStartDate(testData.get("registrationStartDate"));
        createCourseRequestDTO.setRegistrationEndDate(testData.get("registrationEndDate"));
        createCourseRequestDTO.setStartDate(testData.get("startDate"));
        createCourseRequestDTO.setEndDate(testData.get("endDate"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("coverImageUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("previewVideo"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("needToPrepareSection"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("bannerVectorUrl"));
        createCourseRequestDTO.setPrerequisites(testData.get("prerequisites"));
        createCourseRequestDTO.setClassSchedule(testData.get("classSchedule"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("price")));
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("courseMode").toUpperCase()));
        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("isCouponAllowed")));
        createCourseRequestDTO.setEstimatedCourseDuration(testData.get("estimatedCourseDuration"));


        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getExpertsPanel().get(0).getName(), createCourseRequestDTO.getExpertsPanel().get(0).getName());
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testCreateCourse")
    public void testCreateLesson(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Lesson Scenario");

        createLessonRequestDTO = new CreateLessonRequestDTO();
        createLessonRequestDTO.setCourseId(courseID);
        createLessonRequestDTO.setName(testData.get("lessonName"));
        createLessonRequestDTO.setDescription(testData.get("lessonDescription"));
        createLessonRequestDTO.setContainsUnits(true);

        createLessonResponseDTO = (CreateLessonResponseDTO) objectService.createLesson(createLessonRequestDTO, headers, CreateLessonResponseDTO.class);
        lessonID = createLessonResponseDTO.getId();

        softAssert.assertEquals(createLessonResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createLessonResponseDTO.getName(), createLessonRequestDTO.getName());
        softAssert.assertEquals(createLessonResponseDTO.getDescription(), createLessonRequestDTO.getDescription());
        softAssert.assertEquals(createLessonResponseDTO.getContainsUnits(), createLessonRequestDTO.getContainsUnits());
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testCreateLesson")
    public void testCreateUnit(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Unit Scenario");

        createUnitRequestDTO = new CreateUnitRequestDTO();
        createUnitRequestDTO.setCourseId(courseID);
        createUnitRequestDTO.setLessonId(lessonID);
        createUnitRequestDTO.setName(testData.get("unitName"));
        createUnitRequestDTO.setDescription(testData.get("unitDescription"));

        createUnitResponseDTO = (CreateUnitResponseDTO) objectService.createUnit(createUnitRequestDTO, headers, CreateUnitResponseDTO.class);
        unitID = createUnitResponseDTO.getId();

        softAssert.assertEquals(createUnitResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createUnitResponseDTO.getCourseId(), createUnitRequestDTO.getCourseId());
        softAssert.assertEquals(createUnitResponseDTO.getLessonId(), createUnitRequestDTO.getLessonId());
        softAssert.assertEquals(createUnitResponseDTO.getName(), createUnitRequestDTO.getName());
        softAssert.assertEquals(createUnitResponseDTO.getDescription(), createUnitRequestDTO.getDescription());
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testCreateUnit")
    public void testCreateChapter(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Chapter Scenario");

        createChapterRequestDTO = new CreateChapterRequestDTO();
        createChapterRequestDTO.setCourseId(courseID);
        createChapterRequestDTO.setLessonId(lessonID);
        createChapterRequestDTO.setUnitId(unitID);
        createChapterRequestDTO.setChapterName(testData.get("chapterName"));
        createChapterRequestDTO.setChapterDescription(testData.get("chapterDescription"));

        ChapterText chapterText = new ChapterText();
        chapterText.setChapterId(0);
        chapterText.setContent(testData.get("textContent"));
        chapterText.setChapterItemSequenceNumber(0);
        chapterText.setContentType(Constants.CONTENT_TYPE_TEXT);

        List<ChapterText> chapterTextList = new ArrayList<>();
        chapterTextList.add(chapterText);
        createChapterRequestDTO.setChapterTextContentDTOList(chapterTextList);

        ChapterSequence chapterSequence = new ChapterSequence();
        chapterSequence.setType(Constants.CONTENT_TYPE_TEXT);
        chapterSequence.setChapterItemSequenceNumber(0);

        List<ChapterVideo> chapterVideoList = new ArrayList<>();
        createChapterRequestDTO.setChapterVideoDTOList(chapterVideoList);

        List<ChapterMaterial> chapterMaterials = new ArrayList<>();
        createChapterRequestDTO.setChapterMaterialDTOList(chapterMaterials);

        List<ChapterExternalResource> chapterExternalResourceArrayList = new ArrayList<>();
        createChapterRequestDTO.setChapterExternalResourceDTOList(chapterExternalResourceArrayList);

        List<ChapterSequence> chapterSequenceList = new ArrayList<>();
        chapterSequenceList.add(chapterSequence);
        createChapterRequestDTO.setSequenceIdDTOList(chapterSequenceList);

        createChapterResponseDTO = (CreateChapterResponseDTO) objectService.createChapter(createChapterRequestDTO, headers, CreateChapterResponseDTO.class);
        chapterID = createChapterResponseDTO.getSequence().get(0).getUnits().get(0).getChapters().get(0).getChapterId();

        softAssert.assertEquals(createChapterResponseDTO.getStatusCode(), 200);
        softAssert.assertEquals(createChapterResponseDTO.getId(), createChapterRequestDTO.getCourseId());
        softAssert.assertEquals(createChapterResponseDTO.getSequence().get(0).getLessonId(), createChapterRequestDTO.getLessonId());
        softAssert.assertEquals(createChapterResponseDTO.getSequence().get(0).getUnits().get(0).getUnitId(), createChapterRequestDTO.getUnitId());
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testCreateChapter")
    public void testEnrollUsers(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Enroll Users Scenario");

        enrollStudentRequestDTO = new EnrollStudentRequestDTO();

        String[] emails = testData.get("user_emails").split(",");
        List<String> emailList = new ArrayList<>(Arrays.asList(emails));

        enrollStudentRequestDTO.setEmails(emailList);
        enrollStudentRequestDTO.setCourseId(courseID);

        enrollStudentResponseDTO = (EnrollStudentResponseDTO) objectService.enrollStudents(enrollStudentRequestDTO, headers, EnrollStudentResponseDTO.class);

        softAssert.assertEquals(enrollStudentResponseDTO.getStatusCode(), 200);
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testCreateChapter")
    public void testUpdateCourse(Method method) throws Exception{

        ExtentTestManager.startTest(method.getName(), "Update Course Scenario");

        updateCourseRequestDTO = new UpdateCourseRequestDTO();
        updateCourseRequestDTO.setId(courseID);
        updateCourseRequestDTO.setName(testData.get("newCourseName"));
        updateCourseRequestDTO.setDescription(testData.get("newCourseDescription"));
        updateCourseRequestDTO.setType(CourseType.valueOf(testData.get("newCourseType")));
        updateCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("newDifficultyLevel")));
//        Outline outline = new Outline();
//        outline.setTitle("test outline");
//        outline.setDescription("test outline description");
//
//        List<Outline> outlineList = new ArrayList<>();
//        outlineList.add(outline);
        updateCourseRequestDTO.setOutlines(createCourseRequestDTO.getOutlines());
//        Expert expert = new Expert();
//        expert.setName("Dr. Sachin Seram");
//        expert.setDesignation("Lecturer");
//
//        List<Expert> expertList = new ArrayList<>();
//        expertList.add(expert);
        updateCourseRequestDTO.setExpertsPanel(createCourseRequestDTO.getExpertsPanel());
//        Question question = new Question();
//        question.setQuestion("test question?");
//        question.setAnswer("test answer");
//
//        List<Question> questionList = new ArrayList<>();
//        questionList.add(question);
        updateCourseRequestDTO.setFrequentlyAskedQuestions(createCourseRequestDTO.getFrequentlyAskedQuestions());
//        CollaborationLogo collaborationLogo = new CollaborationLogo();
//        collaborationLogo.setName("test name");
//        collaborationLogo.setUrl("test url");
//
//        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
//        collaborationLogoList.add(collaborationLogo);
        updateCourseRequestDTO.setCollaborationLogos(createCourseRequestDTO.getCollaborationLogos());

        updateCourseRequestDTO.setRegistrationStartDate(createCourseRequestDTO.getRegistrationStartDate());
        updateCourseRequestDTO.setRegistrationEndDate(createCourseRequestDTO.getRegistrationEndDate());
        updateCourseRequestDTO.setStartDate(createCourseRequestDTO.getStartDate());
        updateCourseRequestDTO.setEndDate(createCourseRequestDTO.getEndDate());
        updateCourseRequestDTO.setCoverImageUrl(createCourseRequestDTO.getCoverImageUrl());
        updateCourseRequestDTO.setPreviewVideo(createCourseRequestDTO.getPreviewVideo());
        updateCourseRequestDTO.setNeedToPrepareSection(createCourseRequestDTO.getNeedToPrepareSection());
        updateCourseRequestDTO.setBannerVectorUrl(createCourseRequestDTO.getBannerVectorUrl());
        updateCourseRequestDTO.setPrerequisites(createCourseRequestDTO.getPrerequisites());
        updateCourseRequestDTO.setClassSchedule(createCourseRequestDTO.getClassSchedule());
        updateCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("newFieldOfStudy")));
        updateCourseRequestDTO.setPrice(createCourseRequestDTO.getPrice());
        updateCourseRequestDTO.setMode(createCourseRequestDTO.getMode());
        updateCourseRequestDTO.setIsPaid(createCourseRequestDTO.getIsPaid());
        updateCourseRequestDTO.setIsCouponAllowed(createCourseRequestDTO.getIsCouponAllowed());
        updateCourseRequestDTO.setEstimatedCourseDuration(createCourseRequestDTO.getEstimatedCourseDuration());


        updateCourseResponseDTO = (CreateCourseResponseDTO) objectService.updateCourse(courseID.toString() ,updateCourseRequestDTO, headers, CreateCourseResponseDTO.class);

        softAssert.assertEquals(updateCourseResponseDTO.getStatusCode(), 200);
        softAssert.assertEquals(updateCourseResponseDTO.getName(), updateCourseRequestDTO.getName());
        softAssert.assertEquals(updateCourseResponseDTO.getDescription(), updateCourseRequestDTO.getDescription());
        softAssert.assertAll();
    }


    @Test(dependsOnMethods = "testUpdateCourse")
    public void testDeleteCourse(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Delete Course Scenario");

        deleteCourseResponseDTO = (DeleteCourseResponseDTO) objectService.deleteCourse(courseID, headers, DeleteCourseResponseDTO.class);

        softAssert.assertEquals(deleteCourseResponseDTO.getStatusCode(), 400);
        softAssert.assertEquals(deleteCourseResponseDTO.getMessage(), Constants.COURSE_DELETE_FAILED_MESSAGE);
        softAssert.assertAll();
    }

}
