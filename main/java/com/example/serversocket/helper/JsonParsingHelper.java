package com.example.serversocket.helper;

import com.example.serversocket.model.ChatModel;
import com.example.serversocket.model.MultipleChoiceModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonParsingHelper {

    public static String ParseToJson(Object obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;

    }

}
