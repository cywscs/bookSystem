package UI;

import Data.Mapper.bookinfoMapper;
import Data.pojo.bookInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static UI.mainUI.startManager;

public class bookInfoUI {

    public static void showbookInfo() throws Exception {
        System.out.println("                                          图书信息管理");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("1.添加图书信息");
        System.out.println("2.查询图书信息");
        System.out.println("3.进行图书排序");
        System.out.println("4.修改图书信息");
        System.out.println("5.删除图书信息");
        System.out.println("6.返回主菜单");
        System.out.println("请输入要进行的操作：");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose){
            case 1 -> bookInfoAdd();
            case 2 -> bookInfoQuery();
            case 3 -> bookInfoSort();
            case 4 -> bookInfoEdit();
            case 5 -> bookInfoDelete();
            case 6 -> startManager();
        }
    }

    private static void bookInfoAdd() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);

        System.out.println("请输入要添加的图书数量：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        bookInfo bookinfo = new bookInfo();

        for (int i = 0; i < n; i++) {
            System.out.println("请输入书号：");
            bookinfo.setId(scanner.nextInt()); scanner.nextLine();
            System.out.println("请输入书名：");
            bookinfo.setName(scanner.nextLine());
            System.out.println("请输入作者：");
            bookinfo.setAuthor(scanner.nextLine());
            System.out.println("请输入出版社：");
            bookinfo.setPress(scanner.nextLine());
            System.out.println("请输入出版日期：");
            bookinfo.setDate(scanner.nextLine());
            System.out.println("请输入存馆数量：");
            bookinfo.setNumber(scanner.nextInt());
            System.out.println("请输入定价：");
            bookinfo.setPrice(scanner.nextDouble());

            bookinfoMapper.bookInfoAdd(bookinfo);
            sqlSession.commit();
            System.out.println("添加成功！");
        }
        sqlSession.close();
        showbookInfo();
    }

    private static void bookInfoQuery() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);

        System.out.println("请输入查询对象：");
        System.out.println("1.按书名查询");
        System.out.println("2.按作者名");
        System.out.println("3.按出版社");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt(); scanner.nextLine();

        switch (choose){
            case 1 -> {
                System.out.println("请输入书的名称：");
                String name = scanner.nextLine();
                List<bookInfo> bookinfo = bookinfoMapper.selectByName(name);
                for (bookInfo bookInfo : bookinfo) {
                    System.out.println(bookInfo);
                }
                sqlSession.close();
                showbookInfo();
            }
            case 2 -> {
                System.out.println("请输入作者：");
                String author = scanner.nextLine();
                List<bookInfo> bookinfo = bookinfoMapper.selectByAuthor(author);
                for (bookInfo bookInfo : bookinfo) {
                    System.out.println(bookInfo);
                }
                sqlSession.close();
                showbookInfo();
            }
            case 3 -> {
                System.out.println("请输入出版社：");
                String press = scanner.nextLine();
                List<bookInfo> bookinfo = bookinfoMapper.selectByPress(press);
                for (bookInfo bookInfo : bookinfo) {
                    System.out.println(bookInfo);
                }
                sqlSession.close();
                showbookInfo();
            }
        }
    }

    private static void bookInfoSort() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);

        System.out.println("1.按书号进行升序排序");
        System.out.println("2.按书名进行升序排序");
        System.out.println("请输入要执行的操作：");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose){
            case 1 -> {
                List<bookInfo> bookinfo = bookinfoMapper.selectByIdUp();
                for (bookInfo bookInfo : bookinfo) {
                    System.out.println(bookInfo);
                }
                sqlSession.close();
                showbookInfo();
            }
            case 2 ->{
                List<bookInfo> bookinfo = bookinfoMapper.selectByNameUp();
                for (bookInfo bookInfo : bookinfo) {
                    System.out.println(bookInfo);
                }
                sqlSession.close();
                showbookInfo();
            }
        }
    }

    private static void bookInfoEdit() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);
        bookInfo bookinfo = new bookInfo();

        System.out.println("1.按书号进行修改");
        System.out.println("2.按书名进行修改");
        System.out.println("请输入要进行的操作：");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt(); scanner.nextLine();
        switch(choose){
            case 1 -> {
                System.out.println("请输入书号：");
                bookinfo.setId(scanner.nextInt()); scanner.nextLine();
                System.out.println("请输入书名：");
                bookinfo.setName(scanner.nextLine());
                System.out.println("请输入作者：");
                bookinfo.setAuthor(scanner.nextLine());
                System.out.println("请输入出版社：");
                bookinfo.setPress(scanner.nextLine());
                System.out.println("请输入出版日期：");
                bookinfo.setDate(scanner.nextLine());
                System.out.println("请输入存馆数量：");
                bookinfo.setNumber(scanner.nextInt());
                System.out.println("请输入定价：");
                bookinfo.setPrice(scanner.nextDouble());
                bookinfoMapper.EditById(bookinfo);
                sqlSession.commit();
                System.out.println("修改成功！");
                sqlSession.close();
                showbookInfo();
            }
            case 2 -> {
                System.out.println("请输入书名：");
                bookinfo.setName(scanner.nextLine());
                System.out.println("请输入书号：");
                bookinfo.setId(scanner.nextInt()); scanner.nextLine();
                System.out.println("请输入作者：");
                bookinfo.setAuthor(scanner.nextLine());
                System.out.println("请输入出版社：");
                bookinfo.setPress(scanner.nextLine());
                System.out.println("请输入出版日期：");
                bookinfo.setDate(scanner.nextLine());
                System.out.println("请输入存馆数量：");
                bookinfo.setNumber(scanner.nextInt());
                System.out.println("请输入定价：");
                bookinfo.setPrice(scanner.nextDouble());
                bookinfoMapper.EditByName(bookinfo);
                sqlSession.commit();
                System.out.println("修改成功！");
                sqlSession.close();
                showbookInfo();
            }
        }
    }

    private static void bookInfoDelete() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);

        System.out.println("1.按书号删除");
        System.out.println("2.按书名删除");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt(); scanner.nextLine();


        switch (choose){
            case 1 -> {
                System.out.println("请输入书号：");
                int id = scanner.nextInt();
                bookinfoMapper.bookInfoDeleteById(id);
                sqlSession.commit();
                System.out.println("删除成功");
                sqlSession.close();
                showbookInfo();
            }
            case 2 -> {
                System.out.println("请输入书名：");
                String name = scanner.nextLine();
                bookinfoMapper.bookInfoDeleteByName(name);
                sqlSession.commit();
                System.out.println("删除成功");
                sqlSession.close();
                showbookInfo();
            }
        }
    }
}
