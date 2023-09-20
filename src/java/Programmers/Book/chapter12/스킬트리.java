package java.Programmers.Book.chapter12;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993
public class 스킬트리 {
	/*
		1) 2023.08.10
	 */

	public static void main(String[] args) {
		스킬트리 con = new 스킬트리();

		System.out.println(con.solution("C", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); // 2
	}

	public int solution(String skill, String[] skill_trees) {

		int answer = 0;

		for (String skillTree : skill_trees) {
			String tempSkill = skillTree;

			for (int i = 0; i < skillTree.length(); i++) {
				String s = skillTree.substring(i, i+1);
				if (!skill.contains(s)) {
					tempSkill = tempSkill.replace(s, ""); // 필수 스킬이 아닐 경우 공백으로 치환
				}
			}

			if (skill.indexOf(tempSkill) == 0)
				answer++;
		}

		return answer;
	}
}
