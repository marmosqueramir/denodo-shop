package com.denodo.challenge.util.tests;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParserToObject {

    public static <T> List<T> transformJsonToList(Type listType, String json) {
        return new Gson().fromJson(json, listType);
    }
}
