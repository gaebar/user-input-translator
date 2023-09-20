package com.userinputtranslator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Step 1: Introduction
        // Comments describing the program

        // Step 2: Import Necessary Libraries
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        // Step 3: Collect user input
        // Prompting the user to input a phrase to translate and the language code to
        // translate to
        System.out.print("Enter the phrase to translate: ");
        String phrase = scanner.nextLine();
        System.out.print(
                "Enter the language code to translate to (e.g., 'it' for Italian, 'es' for Spanish, 'fr' for French, 'zh' for Chinese): ");
        String languageCode = scanner.nextLine();

        // Step 4: Data Manipulation (forming the API request URL)
        String apiUrl = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + languageCode;
        String body = "[{'Text':'" + phrase + "'}]";

        // Step 5: API Interaction
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", "949ecacfda8e4acc8bff7fddd082ddab")
                .header("Ocp-Apim-Subscription-Region", "westus2")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Step 6: Display Results
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

            System.out.println(
                    "Azure AI detected your entry text as: " + language);
            System.out.println("Translated Text: " + translatedText);
        } catch (Exception e) {
            System.err.println("Error during API request: " + e.getMessage());
        }

        scanner.close();
    }
}
