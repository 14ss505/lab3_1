package MVC;

import MVC.view.View;

import java.util.Scanner;

public class MenuView implements View{
    Scanner sc = new Scanner(System.in);
    private String menu;
    private int next;

    @Override
    public void display() {
        System.out.println(menu);
        setNext(sc.nextInt());
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
