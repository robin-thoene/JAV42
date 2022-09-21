package com.robinthoene.jav42.uidesktop.helpers;

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
     */
    public static void loginAsAdmin(String userName, String password) {
        try {
            // Hash the password before sending.
            var hashedPassword = "";
            // Define the admin authorization request.
            var request = HttpRequest
                    .newBuilder(new URI(baseUrl + "user/authorize-as-admin"))
                    .header("user-name", userName)
                    .header("password", hashedPassword)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            // Create http client to send the request.
            var httpClient = HttpClient.newHttpClient();
            // Send the request.
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // TODO: Handle the response.
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO: retrieve this value from staging config.
     */
    private static String baseUrl = "http://localhost:8080/";
}
