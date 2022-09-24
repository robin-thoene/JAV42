package com.robinthoene.jav42.uidesktop.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.robinthoene.jav42.helpers.PasswordHelper;
import com.robinthoene.jav42.models.user.UserCreateModel;
import com.robinthoene.jav42.models.user.UserCreatedModel;
import com.robinthoene.jav42.models.user.UserReadModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robinthoene.jav42.models.user.UserUpdateModel;

/**
 * Helper to access the core api.
 */
public final class CoreApiHelper {
    /**
     * Try to authenticate as admin with username and password.
     *
     * @param userName The username.
     * @param password The password.
     * @return True if the login was successful, false if not.
     */
    public static boolean loginAsAdmin(String userName, String password) {
        try {
            // Hash the password before sending.
            var hashedPassword = PasswordHelper.hashPassword(password);
            // Define the admin authorization request.
            var request = HttpRequest
                    .newBuilder()
                    .uri(new URI(baseUrl + "user/authorize-as-admin"))
                    .header("user-name", userName)
                    .header("password", hashedPassword)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            // Send the request.
            var response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // The authorization request succeeded, store information for further requests.
                requestUserName = userName;
                requestHashedPassword = hashedPassword;
                return true;
            }
            return false;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve the list of all users from the API.
     *
     * @return All available users.
     */
    public static UserReadModel[] getAllUsers() {
        // Define the API request to retrieve all users.
        try {
            var request = HttpRequest
                    .newBuilder()
                    .header("user-name", requestUserName)
                    .header("password", requestHashedPassword)
                    .GET()
                    .uri(new URI(baseUrl + "user"))
                    .build();
            // Send the request.
            var response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the response.
            var body = response.body();
            var mapper = new ObjectMapper();
            var data = mapper.readValue(body, UserReadModel[].class);
            // Return the result.
            return data;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new user in the database.
     *
     * @param model The model of the user to create.
     * @return The created user.
     */
    public static UserCreatedModel createUser(UserCreateModel model) {
        try {
            var mapper = new ObjectMapper();
            var jsonBody = mapper.writeValueAsString(model);
            var request = HttpRequest
                    .newBuilder()
                    .header("Content-type", "application/json")
                    .header("user-name", requestUserName)
                    .header("password", requestHashedPassword)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .uri(new URI(baseUrl + "user"))
                    .build();
            // Send the request.
            var response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the response.
            var body = response.body();
            var data = mapper.readValue(body, UserCreatedModel.class);
            // Return the result.
            return data;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates a user in the database.
     *
     * @param model The model of the user to update.
     * @return The updated user.
     */
    public static UserReadModel updateUser(UserUpdateModel model) {
        try {
            var mapper = new ObjectMapper();
            var jsonBody = mapper.writeValueAsString(model);
            var request = HttpRequest
                    .newBuilder()
                    .header("Content-type", "application/json")
                    .header("user-name", requestUserName)
                    .header("password", requestHashedPassword)
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .uri(new URI(baseUrl + "user"))
                    .build();
            // Send the request.
            var response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the response.
            var body = response.body();
            var data = mapper.readValue(body, UserReadModel.class);
            // Return the result.
            return data;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete a user.
     *
     * @param userId The users unique database identifier.
     * @return True if the deletion was successful, false if not.
     */
    public static boolean deleteUser(long userId) {
        try {
            var request = HttpRequest
                    .newBuilder()
                    .header("user-name", requestUserName)
                    .header("password", requestHashedPassword)
                    .DELETE()
                    .uri(new URI(baseUrl + "user/" + userId))
                    .build();
            // Send the request.
            var response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return true;
            }
            return false;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieve the username of the logged-in user.
     *
     * @return The username of the logged-in user.
     */
    public static String getMe() {
        return requestUserName;
    }

    /**
     * Retrieve a lazy instance of the http client to use in the application.
     *
     * @return The http client.
     */
    private static HttpClient getHttpClient() {
        if (_httpClient != null) {
            return _httpClient;
        }
        _httpClient = HttpClient.newHttpClient();
        return _httpClient;
    }

    /**
     * The username to use for API requests.
     */
    private static String requestUserName;

    /**
     * The hashed password to use for API requests.
     */
    private static String requestHashedPassword;

    /**
     * The lazy loaded http client.
     */
    private static HttpClient _httpClient;

    /**
     * TODO: retrieve this value from staging config.
     */
    private static String baseUrl = "http://localhost:8080/";
}
