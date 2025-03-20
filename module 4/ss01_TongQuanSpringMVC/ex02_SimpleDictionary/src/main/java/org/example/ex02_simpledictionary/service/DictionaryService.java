package org.example.ex02_simpledictionary.service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    private final Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("dog", "chó");
        dictionary.put("cat", "mèo");
        dictionary.put("car", "xe hơi");
        dictionary.put("house", "ngôi nhà");
        dictionary.put("computer", "máy tính");
    }

    public String lookup(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), "Không tìm thấy từ này trong từ điển!");
    }
}
