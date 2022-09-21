package com.robinthoene.jav42.uidesktop.helpers;

import com.robinthoene.jav42.helpers.PasswordHelper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
                    .newBuilder(new URI(baseUrl + "user/authorize-as-admin"))
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
