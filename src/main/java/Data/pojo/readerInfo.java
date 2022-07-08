package Data.pojo;

public class readerInfo {

    private int num;
    private String name;
    private String college;
    private String major_class;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor_class() {
        return major_class;
    }

    public void setMajor_class(String major_class) {
        this.major_class = major_class;
    }

    @Override
    public String toString() {
        return
                "学号：" + num + "\t\t" +
                "姓名：" + name + "\t\t" +
                "学院：" + college + "\t\t" +
                "专业班级：" + major_class;

    }
}
