package com.repository;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    private final static Map<String, String> map = new HashMap<>();
    static {
        map.put("rectangle", "hình chữ nhật");
        map.put("circle", "hình tròn");
        map.put("triangle", "hình tam giác");
    }
    public String translate(String word){

        String result = map.get(word);
        if (result == null){
            return word + " chưa cập nhật trong từ điển";
        } else {
            return result;
        }
    }
}
