package com.brex.virtual_onsite;


import com.brex.virtual_onsite.model.Company;
import com.brex.virtual_onsite.rest.Client;
import com.brex.virtual_onsite.service.CompanyService;
import com.brex.virtual_onsite.service.impl.CompanyServiceFactory;

import java.util.List;

/**
 * Preparation material:
 *
 * Coding Interview (60 min):
 *
 * In preparation for this interview we recommend preparing and understanding how to do the following in your
 * programming language of choice
 * 1. Making HTTP Requests to a RESTful JSON API
 * 2. Parsing and handling JSON responses
 * 3. Parsing ISO8601 datetime strings
 * You can do this part of the interview in your own IDE/text editor if you like and come with some prepared code
 * around the above processes.
 * You can prepare small code snippets and libraries, but you should not use complete frameworks (e.g., Spring Boot).
 * Review how to model data structures.
 * Practice explaining your thought process before starting a coding question.
 * THINK OUT LOUD, it is crucial to maintain active communication throughout the entire interview.
 * We have the following test endpoint you can use to test you are able to successfully make requests to our API and
 * practice parsing JSON responses with ISO8601 datetime strings
 * https://platform.brexapis.com/interview/test curl --request GET \
 *   --url https://platform.brexapis.com/interview/test \
 *   --header ‘Accept: application/json’
 *
 *
 * We strongly recommend using a dynamically-typed language as it’s easier to make HTTP requests and to parse JSON
 *
 *
 *
 * For Java candidates, the following libraries are available in codesignal. However you can setup your own project
 * locally with additional libraries if you prefer
 *
 * 1  import java.io.*;
 * 2  import java.math.*;
 * 3  import java.net.*;
 * 4  import java.net.http.*;
 * 5  import java.util.*;
 * 6  import java.util.concurrent.*;
 * 7  import java.util.function.*;
 * 8  import java.util.regex.*;
 * 9  import java.util.stream.*;
 * 10 import java.text.*;
 * 11 import java.security.SecureRandom;
 * 12 import com.fasterxml.jackson.core.*;
 * 13 import com.fasterxml.jackson.core.type.*;
 * 14 import com.fasterxml.jackson.databind.*;
 *
 *
 * Java Libraries:
 *
 * Gson for JSON parsing // I went with Jackson
 * OkHttp for requests // LXF: I went with native Java 11 HttpClientApi
 * DateTimeFormatter for date parsing
 */
public class Main {

    public static void main(String[] args) {
        CompanyService service = CompanyServiceFactory.build();
        List<Company> companies = service.getCompanies();
    }

}
