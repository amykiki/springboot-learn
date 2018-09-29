package demo.modal;

/**
 * @author :  ZouShumin
 * @Project Name :  springboot-learn
 * @Package Name :  demo.modal
 * @Description :
 * @Creation Date:  2018-09-29 11:46
 * --------  ---------  --------------------------
 */
public class User {
    private Integer id;
    private String name;
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
