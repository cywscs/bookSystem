package UI;

import java.util.Scanner;

public class mainUI {

    public static void main(String[] args) throws Exception {

        System.out.println("=================欢迎使用图书管理系统====================");
        startManager();
    }

    public static void startManager() throws Exception {
        showMenu();
        menuChoose();
    }

    public static void showMenu() {
        System.out.println("-----------------------主菜单--------------------------");
        System.out.println("1.图书信息管理");
        System.out.println("2.读者信息管理");
        System.out.println("3.图书借阅管理");
        System.out.println("4.退出系统");
        System.out.println("------------------------------------------------------");
    }

    public static void menuChoose() throws Exception {
        System.out.println("请选择你要执行的功能：");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose) {
            case 1 -> bookInfoUI.showbookInfo();
            case 2 -> readerInfoUI.showReaderInfo();
            case 3 -> borrowInfoUI.showBorrowInfo();
            case 4 -> System.out.println("系统已退出");
            default -> menuChoose();
        }
    }
}
