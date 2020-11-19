package doing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;


public class Control {
	Random r = new Random();
	HashSet<Integer> hs =null;
	LinkedList<Integer> win  =null;
	LinkedList<Integer> ls =null;
	int plusnum = 0;
	int plusnum1 = 0;
	void run(int n) {
		hs = new HashSet<>();
		while(hs.size() != 7) {
			int num = r.nextInt(45)+1;
			hs.add(num);
		}
		win = new LinkedList<>(hs);
		this.plusnum1 = win.get(6);
		win.remove(6);
		Collections.sort(win);
		
		System.out.println("--당첨번호--");
		for(Integer ls : win) {
			System.out.print(ls + " ");
		}
		System.out.println("추가 번호 :" + plusnum1);
		
		System.out.println("=========로또 번호 추첨기========");
		for(int i =0; i<n; i++) {
			System.out.print((i+1) + "번째 로또:");
			hs = new HashSet<Integer>();
			while(hs.size() != 7) {
				int num = r.nextInt(45)+1;
				hs.add(num);
			}

			ls = new LinkedList<Integer>(hs);
			plusnum = ls.get(6);
			ls.remove(6);
			Collections.sort(ls);
			for(Integer is  : ls) {
				System.out.print(is + " ");
			}	
			System.out.println("추가 번호 :" + plusnum);
			correctNumber();
		}
	}
	public Control() {
		
		
	}
	void correctNumber() {
		int count =0;
		
		for(int i =0; i<win.size(); i++) {
			for(int j = 0; j<ls.size(); j++) {
				if(win.get(i) == ls.get(j)) {
					count++;
					break;
				}
			}
		}
		if(count > 6)
		{
			System.out.println("축하드립니다!!! 1등당첨 축하드립니다");
		}
		else if(count == 5 && plusnum1 == plusnum) {
			System.out.println("축하드립니다!! 2등 당첨 되셨습니다");
		}else if(count == 4) {
			System.out.println("축하드립니다!! 3등 당첨 되셨습니다");	
			}
		else if(count == 3) {
			System.out.println("축하드립니다!! 4등 당첨 되셨습니다");
		}
		else if(count == 2) {
			System.out.println("2개");
		}
		else {
			System.out.println("아쉽게도 꽝입니다!!");
		}
	}
}
