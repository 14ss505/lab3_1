package MVC.view;

import java.util.List;
import java.util.Scanner;

public class DisplayView implements View{
	private int num;
	Scanner sc = new Scanner(System.in);
	private List<String> pageNameList;

	@Override
	public void display() {
		for (int i = 0; i < pageNameList.size(); i++) {
            System.out.println(i + ": " + pageNameList.get(i));
        }
		System.out.println("choose the page:");
		setNum(sc.nextInt());
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<String> getPageNameList() {
		return pageNameList;
	}

	public void setPageNameList(List<String> pageNameList) {
		this.pageNameList = pageNameList;
	}

}
