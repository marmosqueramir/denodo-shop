package com.denodo.challenge.util.exceptions;


import org.json.simple.JSONObject;

public class RESTApiResponse {

    public static JSONObject getErrorResponse(int errorCode, String message) {
        var response = new JSONObject();
        response.put("error", errorCode);
        response.put("message", message);
        return response;
    }

    public static JSONObject getErrorResponse(ErrorResponseDTO error) {
        var response = new JSONObject();
        response.put("error", error.getErrorCode());
        response.put("message", error.getMessage());
        return response;
    }
}
