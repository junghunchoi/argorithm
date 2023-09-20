package java.study;

import java.util.ArrayList;
import java.util.List;

public class leet118 {

	public static void main(String[] args) {
		leet118 con = new leet118();

		con.generate(5);
	}
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0,1);
			for (int j = 1; j < row.size()-1; j++) {

				row.set(j, row.get(j) + row.get(j + 1));
			}
//			System.out.println(row.toString());
			ans.add(new ArrayList<>(row));

		}
		for (List<Integer> l : ans) {
			System.out.println(l.toString());
		}
		return ans;
	}
}
