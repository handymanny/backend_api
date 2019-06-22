package Dao;

import Model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getAllDepartments();

    Department getDepartment(int id);
}
