package com.userinputtranslator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Introduction: This program translates a user-inputted phrase to a selected
        // language using Azure API

        // Import necessary libraries
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        Dotenv dotenv = Dotenv.load();

        // Collect user input
        System.out.print("Enter the phrase to translate: ");
        String phrase = scanner.nextLine();
        System.out.print(
                "Enter the language code to translate to (e.g., 'it' for Italian, 'es' for Spanish, 'fr' for French, 'zh' for Chinese): ");
        String languageCode = scanner.nextLine();

        // Data Manipulation: forming the API request URL
        String apiUrl = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + languageCode;
        String body = "[{\"Text\":\"" + phrase + "\"}]";

        String azureApiKey = dotenv.get("AZURE_API_KEY");
        String apiRegion = dotenv.get("API_REGION");

        // API Interaction
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", azureApiKey)
                .header("Ocp-Apim-Subscription-Region", apiRegion)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Display Results
            String responseBody = response.body();

            System.out.println("Response from server: " + responseBody); // Print the raw response to understand its
                                                                         // structure

            JSONArray jsonResponse = new JSONArray(responseBody);
            JSONObject firstResponseObject = jsonResponse.getJSONObject(0);

            // Get detected language information
            JSONObject detectedLanguage = firstResponseObject.getJSONObject("detectedLanguage");
            String language = detectedLanguage.getString("language");

            // Get translation information
            JSONArray translations = firstResponseObject.getJSONArray("translations");
            JSONObject firstTranslation = translations.getJSONObject(0);
            String translatedText = firstTranslation.getString("text");

            System.out.println("Azure AI detected your entry text as: " + language);
            System.out.println("Translated Text: " + translatedText);
        } catch (IOException e) {
            System.err.println("I/O Error during API request: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Request was interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during API request: " + e.getMessage());
        }

        scanner.close();
    }
}
