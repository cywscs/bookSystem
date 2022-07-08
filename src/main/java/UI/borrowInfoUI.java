package UI;

import Data.Mapper.bookinfoMapper;
import Data.Mapper.borrowinfoMapper;
import Data.Mapper.readerinfoMapper;
import Data.pojo.borrowInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static UI.mainUI.startManager;

public class borrowInfoUI {

    public static void showBorrowInfo() throws Exception {
        System.out.println("                                          借阅信息管理");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("1.图书借阅");
        System.out.println("2.图书归还");
        System.out.println("3.图书借阅查询");
        System.out.println("4.返回主菜单");
        System.out.println("请输入要进行的操作：");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose){
            case 1 -> borrowBook();
            case 2 -> returnBook();
            case 3 -> borrowBookQuery();
            case 4 -> startManager();
        }
    }

    private static void borrowBook() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);
        borrowinfoMapper borrowinfoMapper = sqlSession.getMapper(borrowinfoMapper.class);
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        int num = scanner.nextInt();
        System.out.println("请输入书号：");
        int id = scanner.nextInt();

        if(bookinfoMapper.bookNumberQuery(id) > 0){
            System.out.println("该书当前数量为" + bookinfoMapper.bookNumberQuery(id) + "，可以借阅");
            System.out.println("请输入要借阅的数量：");
            int bookNum = scanner.nextInt(); scanner.nextLine();
            System.out.println("请输入借阅时长（天）：");
            String deadline = scanner.nextLine();
            String sname = readerinfoMapper.getSname(num);
            String bname = bookinfoMapper.getBname(id);
            bookinfoMapper.bookNumberDec(id, bookNum);
            borrowinfoMapper.borrowInfoAdd(num, id, sname, bname, deadline);
            sqlSession.commit();
            System.out.println("借阅成功！");
            showBorrowInfo();
        }else{
            System.out.println("该书当前数量为" + bookinfoMapper.bookNumberQuery(id) + "，无法借阅");
            showBorrowInfo();
        }
    }

    private static void returnBook() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        bookinfoMapper bookinfoMapper = sqlSession.getMapper(bookinfoMapper.class);
        borrowinfoMapper borrowinfoMapper = sqlSession.getMapper(borrowinfoMapper.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        int num = scanner.nextInt();
        System.out.println("请输入书号：");
        int id = scanner.nextInt();
        System.out.println("请输入要归还的数量：");
        int bookNum = scanner.nextInt();
        bookinfoMapper.bookNumberInc(id, bookNum);
        borrowinfoMapper.returnInfoEdit(num, id);
        sqlSession.commit();
        System.out.println("归还成功！");
        showBorrowInfo();
    }

    private static void borrowBookQuery() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        borrowinfoMapper borrowinfoMapper = sqlSession.getMapper(borrowinfoMapper.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入查询方式：");
        System.out.println("1.按学号查询");
        System.out.println("2.按书名查询");
        System.out.println("3.按学院查询");
        int choose = scanner.nextInt(); scanner.nextLine();
        switch(choose){
            case 1 -> {
                System.out.println("请输入学号：");
                int num = scanner.nextInt();
                List<borrowInfo> borrowInfos = borrowinfoMapper.selectByNum(num);
                for(borrowInfo borrowInfo : borrowInfos){
                    System.out.println(borrowInfo);
                }
                sqlSession.close();
                showBorrowInfo();

            }
            case 2 -> {
                System.out.println("请输入书名：");
                String name = scanner.nextLine();
                List<borrowInfo> borrowInfos = borrowinfoMapper.selectByName(name);
                for(borrowInfo borrowInfo : borrowInfos){
                    System.out.println(borrowInfo);
                }
                sqlSession.close();
                showBorrowInfo();
            }
            case 3 -> {
                System.out.println("请输入学院：");
                String college = scanner.nextLine();
                List<borrowInfo> borrowInfos = borrowinfoMapper.selectByCollege(college);
                for(borrowInfo borrowInfo : borrowInfos){
                    System.out.println(borrowInfo);
                }
                sqlSession.close();
                showBorrowInfo();
            }
        }
    }
}
