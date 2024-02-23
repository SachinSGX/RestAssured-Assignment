package com.syntaxgenie.tests;

import com.syntaxgenie.constants.StaticHeaders;
import com.syntaxgenie.enums.CourseMode;
import com.syntaxgenie.enums.CourseType;
import com.syntaxgenie.enums.DifficultyLevel;
import com.syntaxgenie.enums.FieldOfStudy;
import com.syntaxgenie.reporting.ExtentTestManager;
import com.syntaxgenie.requestDTO.*;
import com.syntaxgenie.responseDTO.*;
import com.syntaxgenie.services.ObjectService;
import com.syntaxgenie.util.TestBase;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestCreateCourseScenarios extends TestBase {

    private ObjectService objectService;
    private LoginRequestDTO loginRequestDTO;
    private CreateCourseRequestDTO createCourseRequestDTO;
    private CreateCourseResponseDTO createCourseResponseDTO;
    private Long allowedDateDiffMilliSec;
    private static String token = null;
    private Integer courseID;


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


    @Test(testName = "testCreateOnDemandCourseWithAllFields")
    public void testCreateOnDemandCourseAllFieldsPaid(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create On Demand Course Scenario With All Fields & Paid");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod001_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod001_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod001_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod001_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod001_courseDescription"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod001_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setEstimatedCourseDuration(testData.get("tcod001_estimatedCourseDuration"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod001_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod001_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod001_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod001_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod001_needToPrepareSection"));

        CollaborationLogo collaborationLogo = new CollaborationLogo();
        collaborationLogo.setName(testData.get("tcod001_logoName"));
        collaborationLogo.setUrl(testData.get("tcod001_logoUrl"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        collaborationLogoList.add(collaborationLogo);
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod001_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod001_outlineTitle"));
        outline.setDescription(testData.get("tcod001_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod001_expertName"));
        expert.setDesignation(testData.get("tcod001_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        Question question = new Question();
        question.setQuestion(testData.get("tcod001_question"));
        question.setAnswer(testData.get("tcod001_answer"));

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod001_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod001_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod001_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNull(createCourseResponseDTO.getEndDate());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateOnDemandCourseWithMandatoryFields")
    public void testCreateOnDemandCourseMandatoryFieldsPaid(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create On Demand Course Scenario With Mandatory Fields & Paid");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod002_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod002_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod002_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod002_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod002_courseDescription"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod002_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setEstimatedCourseDuration(testData.get("tcod002_estimatedCourseDuration"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod002_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod002_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod002_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod002_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod002_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod002_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod002_outlineTitle"));
        outline.setDescription(testData.get("tcod002_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod002_expertName"));
        expert.setDesignation(testData.get("tcod002_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod002_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod002_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod002_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNull(createCourseResponseDTO.getEndDate());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateLiveClassWithAllFields")
    public void testCreateLiveClassAllFieldsPaid(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Live Class Scenario With All Fields & Paid");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod003_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod003_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod003_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod003_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod003_courseDescription"));
        createCourseRequestDTO.setRegistrationStartDate(testData.get("tcod003_registrationStartDate"));
        createCourseRequestDTO.setRegistrationEndDate(testData.get("tcod003_registrationEndDate"));
        createCourseRequestDTO.setStartDate(testData.get("tcod003_startDate"));
        createCourseRequestDTO.setEndDate(testData.get("tcod003_endDate"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod003_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setFormLink(testData.get("tcod003_formLink"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod003_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod003_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod003_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod003_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod003_needToPrepareSection"));

        CollaborationLogo collaborationLogo = new CollaborationLogo();
        collaborationLogo.setName(testData.get("tcod003_logoName"));
        collaborationLogo.setUrl(testData.get("tcod003_logoUrl"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        collaborationLogoList.add(collaborationLogo);
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod003_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod003_outlineTitle"));
        outline.setDescription(testData.get("tcod003_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod003_expertName"));
        expert.setDesignation(testData.get("tcod003_expertDesignation"));
//        expert.setImageUrl(testData.get("tcod003_imageUrl"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        Question question = new Question();
        question.setQuestion(testData.get("tcod003_question"));
        question.setAnswer(testData.get("tcod003_answer"));

        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod003_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod003_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod003_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNotNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getEndDate());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateLiveClassWithMandatoryFields")
    public void testCreateLiveClassMandatoryFieldsPaid(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Live Class Scenario With Mandatory Fields & Paid");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod004_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod004_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod004_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod004_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod004_courseDescription"));
        createCourseRequestDTO.setRegistrationStartDate(testData.get("tcod004_registrationStartDate"));
        createCourseRequestDTO.setRegistrationEndDate(testData.get("tcod004_registrationEndDate"));
        createCourseRequestDTO.setStartDate(testData.get("tcod004_startDate"));
        createCourseRequestDTO.setEndDate(testData.get("tcod004_endDate"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod004_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod004_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod004_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod004_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod004_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod004_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod004_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod004_outlineTitle"));
        outline.setDescription(testData.get("tcod004_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod004_expertName"));
        expert.setDesignation(testData.get("tcod004_expertDesignation"));
//        expert.setImageUrl(testData.get("tcod004_imageUrl"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod004_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod004_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod004_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNotNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getEndDate());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateOnDemandCourseMandatoryFieldsFree")
    public void testCreateOnDemandCourseMandatoryFieldsFree(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create On Demand Course Scenario With Mandatory Fields & Free");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod005_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod005_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod005_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod005_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod005_courseDescription"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod005_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setEstimatedCourseDuration(testData.get("tcod005_estimatedCourseDuration"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod005_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod005_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod005_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod005_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod005_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod005_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod005_outlineTitle"));
        outline.setDescription(testData.get("tcod005_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod005_expertName"));
        expert.setDesignation(testData.get("tcod005_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod005_isPaid")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNull(createCourseResponseDTO.getEndDate());
        softAssert.assertFalse(createCourseResponseDTO.getPaid());
        softAssert.assertFalse(createCourseResponseDTO.getCouponAllowed());
        softAssert.assertNull(createCourseResponseDTO.getPrice());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateOnDemandCourseMandatoryFieldsFree")
    public void testCreateLiveClassMandatoryFieldsFree(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Live Class Scenario With Mandatory Fields & Free");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod006_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod006_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod006_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod006_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod006_courseDescription"));
        createCourseRequestDTO.setRegistrationStartDate(testData.get("tcod006_registrationStartDate"));
        createCourseRequestDTO.setRegistrationEndDate(testData.get("tcod006_registrationEndDate"));
        createCourseRequestDTO.setStartDate(testData.get("tcod006_startDate"));
        createCourseRequestDTO.setEndDate(testData.get("tcod006_endDate"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod006_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod006_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod006_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod006_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod006_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod006_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod006_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod006_outlineTitle"));
        outline.setDescription(testData.get("tcod006_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod006_expertName"));
        expert.setDesignation(testData.get("tcod006_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod006_isPaid")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNotNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getEndDate());
        softAssert.assertFalse(createCourseResponseDTO.getPaid());
        softAssert.assertFalse(createCourseResponseDTO.getCouponAllowed());
        softAssert.assertNull(createCourseResponseDTO.getPrice());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateOnDemandCourseMandatoryFieldsPaidCouponNotAllowed")
    public void testCreateOnDemandCourseMandatoryFieldsPaidCouponNotAllowed(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create On Demand Course Scenario With Mandatory Fields, Paid And No Coupons");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod007_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod007_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod007_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod007_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod007_courseDescription"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod007_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setEstimatedCourseDuration(testData.get("tcod007_estimatedCourseDuration"));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod007_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod007_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod007_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod007_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod007_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod007_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod007_outlineTitle"));
        outline.setDescription(testData.get("tcod007_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod007_expertName"));
        expert.setDesignation(testData.get("tcod007_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod007_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod007_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod007_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNull(createCourseResponseDTO.getEndDate());
        softAssert.assertTrue(createCourseResponseDTO.getPaid());
        softAssert.assertFalse(createCourseResponseDTO.getCouponAllowed());
        softAssert.assertNotNull(createCourseResponseDTO.getPrice());
        softAssert.assertAll();
    }


    @Test(testName = "testCreateLiveClassMandatoryFieldsPaidCouponsNotAllowed")
    public void testCreateLiveClassMandatoryFieldsPaidCouponsNotAllowed(Method method) throws Exception {

        ExtentTestManager.startTest(method.getName(), "Create Live Class Scenario With Mandatory Fields, Paid And No Coupons");

        createCourseRequestDTO = new CreateCourseRequestDTO();
        createCourseRequestDTO.setMode(CourseMode.valueOf(testData.get("tcod008_courseMode").toUpperCase()));
        createCourseRequestDTO.setName(testData.get("tcod008_courseName"));
        createCourseRequestDTO.setType(CourseType.valueOf(testData.get("tcod008_courseType").toUpperCase()));
        createCourseRequestDTO.setDifficultyLevel(DifficultyLevel.valueOf(testData.get("tcod008_difficultyLevel").toUpperCase()));
        createCourseRequestDTO.setDescription(testData.get("tcod008_courseDescription"));
        createCourseRequestDTO.setRegistrationStartDate(testData.get("tcod008_registrationStartDate"));
        createCourseRequestDTO.setRegistrationEndDate(testData.get("tcod008_registrationEndDate"));
        createCourseRequestDTO.setStartDate(testData.get("tcod008_startDate"));
        createCourseRequestDTO.setEndDate(testData.get("tcod008_endDate"));
        createCourseRequestDTO.setFieldOfStudy(FieldOfStudy.valueOf(testData.get("tcod008_fieldOfStudy").toUpperCase()));
        createCourseRequestDTO.setCoverImageUrl(testData.get("tcod008_coverImageUrl"));
        createCourseRequestDTO.setBannerVectorUrl(testData.get("tcod008_bannerVectorUrl"));
        createCourseRequestDTO.setPreviewVideo(testData.get("tcod008_previewVideo"));
        createCourseRequestDTO.setPrerequisites(testData.get("tcod008_prerequisites"));
        createCourseRequestDTO.setNeedToPrepareSection(testData.get("tcod008_needToPrepareSection"));

        List<CollaborationLogo> collaborationLogoList = new ArrayList<>();
        createCourseRequestDTO.setCollaborationLogos(collaborationLogoList);

        createCourseRequestDTO.setClassSchedule(testData.get("tcod008_classSchedule"));

        Outline outline = new Outline();
        outline.setTitle(testData.get("tcod008_outlineTitle"));
        outline.setDescription(testData.get("tcod008_outlineDescription"));

        List<Outline> outlineList = new ArrayList<>();
        outlineList.add(outline);
        createCourseRequestDTO.setOutlines(outlineList);

        Expert expert = new Expert();
        expert.setName(testData.get("tcod008_expertName"));
        expert.setDesignation(testData.get("tcod008_expertDesignation"));

        List<Expert> expertList = new ArrayList<>();
        expertList.add(expert);
        createCourseRequestDTO.setExpertsPanel(expertList);

        List<Question> questionList = new ArrayList<>();
        createCourseRequestDTO.setFrequentlyAskedQuestions(questionList);

        createCourseRequestDTO.setIsPaid(Boolean.parseBoolean(testData.get("tcod008_isPaid")));
        createCourseRequestDTO.setIsCouponAllowed(Boolean.parseBoolean(testData.get("tcod008_isCouponAllowed")));
        createCourseRequestDTO.setPrice(Float.parseFloat(testData.get("tcod008_price")));

        createCourseResponseDTO = (CreateCourseResponseDTO) objectService.createCourse(createCourseRequestDTO, headers, CreateCourseResponseDTO.class);
        courseID = createCourseResponseDTO.getId();

        softAssert.assertEquals(createCourseResponseDTO.getStatusCode(), 201);
        softAssert.assertEquals(createCourseResponseDTO.getName(), createCourseRequestDTO.getName());
        softAssert.assertEquals(createCourseResponseDTO.getDescription(), createCourseRequestDTO.getDescription());
        softAssert.assertEquals(createCourseResponseDTO.getType(), createCourseRequestDTO.getType());
        softAssert.assertEquals(createCourseResponseDTO.getMode(), createCourseRequestDTO.getMode());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getRegistrationEndDate());
        softAssert.assertNotNull(createCourseResponseDTO.getStartDate());
        softAssert.assertNotNull(createCourseResponseDTO.getEndDate());
        softAssert.assertTrue(createCourseResponseDTO.getPaid());
        softAssert.assertFalse(createCourseResponseDTO.getCouponAllowed());
        softAssert.assertNotNull(createCourseResponseDTO.getPrice());
        softAssert.assertAll();
    }

}