package com.syntaxgenie.services;

import com.syntaxgenie.constants.RelativeURLs;
import com.syntaxgenie.requestDTO.*;
import com.syntaxgenie.util.APIServicesBase;
import com.syntaxgenie.util.BaseResponseDTO;
import com.syntaxgenie.util.RestUtil;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class ObjectService extends APIServicesBase {

	private String baseURI;

	public ObjectService(String baseURI) {
		this.baseURI = baseURI;
	}

	public String generateToken(LoginRequestDTO body) throws Exception {
		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return generateToken(requestBody, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public String generateToken(String body, Method method) throws Exception {
		try {
			setRequest(baseURI, RelativeURLs.LEARNOVA_LOGIN, body);
			Response response = makeRequest(body, method);
			return response.jsonPath().getString("id_token");

		} catch (Exception e){
			throw e;
		}

	}



	public BaseResponseDTO createCourse(CreateCourseRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return createCourse(requestBody, headers, classType, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO createCourse(String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.CREATE_COURSE, body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}



	public BaseResponseDTO createLesson(CreateLessonRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return createLesson(requestBody, headers, classType, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO createLesson(String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.CREATE_LESSON, body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}



	public BaseResponseDTO createUnit(CreateUnitRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return createUnit(requestBody, headers, classType, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO createUnit(String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.CREATE_UNIT, body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}



	public BaseResponseDTO createChapter(CreateChapterRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return createChapter(requestBody, headers, classType, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO createChapter(String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.CREATE_CHAPTER, body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}


	public BaseResponseDTO enrollStudents(EnrollStudentRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return enrollStudents(requestBody, headers, classType, Method.POST);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO enrollStudents(String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.ENROLL_STUDENT, body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}


	public BaseResponseDTO updateCourse(String id, UpdateCourseRequestDTO body, Headers headers, Class<?> classType) throws Exception {

		try {
			String requestBody = objectMapper.writeValueAsString(body);
			return updateCourse(id, requestBody, headers, classType, Method.PUT);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO updateCourse(String id, String body, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support parallel execution if needed
			setRequest(baseURI, RelativeURLs.UPDATE_COURSE.replace("{id}", id), body, headers);

			// Make Request
			Response response = makeRequest(body, headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}


	public BaseResponseDTO deleteCourse(Integer id, Headers headers, Class<?> classType) throws Exception {

		try {
			return deleteCourse(id, headers, classType, Method.DELETE);

		} catch (Exception e) {
			throw e;
		}
	}

	public BaseResponseDTO deleteCourse(Integer id, Headers headers, Class<?> classType, Method method) throws Exception {

		try {
			// baseURI set here to support dynamic execution if needed
			setRequest(baseURI, RelativeURLs.DELETE_COURSE.replace("{id}", id.toString()));

			// Make Request
			Response response = makeRequest(headers, method);

			// Clear Base Path & URI
			RestUtil.resetBasePath();
			RestUtil.resetBaseURI();

			return convertResponseToType(response, classType);

		} catch (Exception e) {
			throw e;
		}
	}

}