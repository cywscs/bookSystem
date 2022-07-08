package Data.pojo;

public class borrowInfo {

    private int num;
    private String sname;
    private int id;
    private String bname;
    private String borrowDate;
    private String deadline;
    private String returnDate;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return
                "学号：" + num + "\t\t" +
                "姓名：" + sname + "\t\t" +
                "书号：" + id + "\t\t" +
                "书名：" + bname + "\t\t" +
                "借阅日期：" + borrowDate + "\t\t" +
                "应还日期：" + deadline + "\t\t" +
                "归还日期：" + returnDate;
    }
}

