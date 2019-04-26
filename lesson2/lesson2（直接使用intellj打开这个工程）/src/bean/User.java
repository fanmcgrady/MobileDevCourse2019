package bean;


/**
 * @author fangzhiyang
 */
public class User {
    private String name;
    private int sex;
    private UserDetail detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public UserDetail getDetail() {
        return detail;
    }

    public void setDetail(UserDetail detail) {
        this.detail = detail;
    }
}
