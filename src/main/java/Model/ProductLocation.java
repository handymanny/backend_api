package Model;

public class ProductLocation {

    private int categoryId;
    private int departmentId;
    private String categoryName;
    private String departmentName;

    public ProductLocation(int categoryId, int departmentId, String categoryName, String departmentName) {
        this.categoryId = categoryId;
        this.departmentId = departmentId;
        this.categoryName = categoryName;
        this.departmentName = departmentName;
    }

    public ProductLocation() {}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
