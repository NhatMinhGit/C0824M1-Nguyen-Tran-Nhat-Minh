package org.example.ex04_sandwichcondiments.service.impl;

import org.example.ex04_sandwichcondiments.service.SandwichCondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichCondimentsServiceImpl implements SandwichCondimentsService {
    @Override
    public String save(String[] condiments) {
        if (condiments == null || condiments.length == 0) {
            return "Bạn chưa chọn loại gia vị nào!";
        }
        return "Bạn đã chọn: " + String.join(", ", condiments);
    }
}
