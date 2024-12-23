package Controllers;

import Models.Entities.Citizens;
import Services.ICitizenServices;
import Services.impl.CitizenImpl;

import java.util.List;

public class CitizenController {
    private ICitizenServices studentService = new CitizenImpl();
    public List<Citizens> getAll() {
        return studentService.getAll();
    }

    public void save(Citizens citizens) {
        studentService.save(citizens);
    }

    public Citizens findById(String code) {
        return studentService.findById(code);
    }

    public void remove(String code) {
        studentService.remove(code);
    }
}