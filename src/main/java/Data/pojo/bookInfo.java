package Data.pojo;

import java.sql.SQLOutput;

public class bookInfo {

    private Integer id;
    private String name;
    private String author;
    private String press;
    private String date;
    private Integer number;
    private double price;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "书号：" + id + "\t\t" +
                "书名：" + name + "\t\t" +
                "作者：" + author + "\t\t" +
                "出版社：" + press + "\t\t" +
                "出版日期：" + date + "\t\t" +
                "存馆数量：" + number + "\t\t" +
                "价格：" + price;
    }
}
