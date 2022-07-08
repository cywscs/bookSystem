package UI;

import Data.Mapper.readerinfoMapper;
import Data.pojo.readerInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static UI.mainUI.startManager;

public class readerInfoUI {

    public static void showReaderInfo() throws Exception {
        System.out.println("                                          读者信息管理");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("1.添加读者信息");
        System.out.println("2.查询读者信息");
        System.out.println("3.读者信息排序");
        System.out.println("4.修改读者信息");
        System.out.println("5.删除读者信息");
        System.out.println("6.返回主菜单");
        System.out.println("请输入要进行的操作：");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose){
            case 1 -> readerInfoAdd();
            case 2 -> readerInfoQuery();
            case 3 -> readerInfoSort();
            case 4 -> readerInfoEdit();
            case 5 -> readerInfoDelete();
            case 6 -> startManager();
        }
    }

    private static void readerInfoAdd() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);

        readerInfo readerinfo = new readerInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        readerinfo.setNum(scanner.nextInt()); scanner.nextLine();
        System.out.println("请输入姓名：");
        readerinfo.setName(scanner.nextLine());
        System.out.println("请输入学院：");
        readerinfo.setCollege(scanner.nextLine());
        System.out.println("请输入专业班级：");
        readerinfo.setMajor_class(scanner.nextLine());

        readerinfoMapper.readerInfoAdd(readerinfo);
        sqlSession.commit();
        System.out.println("添加成功！");
        sqlSession.close();
        showReaderInfo();
    }

    private static void readerInfoQuery() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);

        System.out.println("请输入查询对象：");
        System.out.println("1.按学号查询");
        System.out.println("2.按姓名查询");
        System.out.println("3.按专业班级查询");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt(); scanner.nextLine();

        switch (choose){
            case 1 -> {
                System.out.println("请输入学号：");
                int num = scanner.nextInt();
                List<readerInfo> readerInfos = readerinfoMapper.selectByNum(num);
                for(readerInfo readerInfo : readerInfos){
                    System.out.println(readerInfo);
                }
                sqlSession.close();
                showReaderInfo();
            }
            case 2 -> {
                System.out.println("请输入姓名：");
                String name = scanner.nextLine();
                List<readerInfo> readerInfos = readerinfoMapper.selectByName(name);
                for(readerInfo readerInfo : readerInfos){
                    System.out.println(readerInfo);
                }
                sqlSession.close();
                showReaderInfo();
            }
            case 3 -> {
                System.out.println("请输入专业班级");
                String major_class = scanner.nextLine();
                List<readerInfo> readerInfos = readerinfoMapper.selectByMajor_class(major_class);
                for(readerInfo readerInfo : readerInfos){
                    System.out.println(readerInfo);
                }
                sqlSession.close();
                showReaderInfo();
            }
        }
    }

    private static void readerInfoSort() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);

        System.out.println("1.按学号进行升序排序");
        System.out.println("2.按学院进行升序排序");
        System.out.println("请输入要执行的操作：");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose){
            case 1 ->{
                List<readerInfo> readerInfos = readerinfoMapper.selectByNumUp();
                for(readerInfo readerInfo : readerInfos){
                    System.out.println(readerInfo);
                }
                sqlSession.close();
                showReaderInfo();
            }
            case 2 ->{
                List<readerInfo> readerInfos = readerinfoMapper.selectByCollegeUp();
                for(readerInfo readerInfo : readerInfos){
                    System.out.println(readerInfo);
                }
                sqlSession.close();
                showReaderInfo();
            }
        }
    }

    private static void readerInfoEdit() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);
        readerInfo readerinfo = new readerInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        readerinfo.setNum(scanner.nextInt()); scanner.nextLine();
        System.out.println("请输入姓名：");
        readerinfo.setName(scanner.nextLine());
        System.out.println("请输入学院：");
        readerinfo.setCollege(scanner.nextLine());
        System.out.println("请输入专业班级：");
        readerinfo.setMajor_class(scanner.nextLine());
        readerinfoMapper.readerInfoEdit(readerinfo);
        sqlSession.commit();
        System.out.println("修改成功！");
        sqlSession.close();
        showReaderInfo();
    }

    private static void readerInfoDelete() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        readerinfoMapper readerinfoMapper = sqlSession.getMapper(readerinfoMapper.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        int num = scanner.nextInt(); scanner.nextLine();
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        readerinfoMapper.readerInfoDelete(num,name);
        sqlSession.commit();
        System.out.println("删除成功");
        sqlSession.close();
        showReaderInfo();
    }

}
