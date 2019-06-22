package Model;

public class Category {

    private int id;
    private int departmentId;
    private String name;
    private String description;

    public Category(int id, int departmentId, String name, String description) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
        this.description = description;
    }

    public Category () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
