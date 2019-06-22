package Controller;

import Model.Department;
import Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Department getDepartment(@PathVariable("id") int id) {
        return departmentService.getDepartment(id);
    }
}
