package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String[] args){
		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader("train.conll"));
			String xx;
			int id = 10;
			while((xx = b.readLine())!=null && id > 0){
				System.out.println(xx+"\tlength"+xx.length());
				id--;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
