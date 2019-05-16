package javaHomeWork;
import javax.swing.*;
import java.awt.*;
public class HomeWork_1 extends JFrame {
	
	void myInfo() {
	setLayout(new GridLayout(8, 2));
    Container con = getContentPane();
    con.add(new JButton("이름"));
    con.add(new JTextField("서민기"));
    con.add(new JButton("학번"));
    con.add(new JTextField("16112239"));
    con.add(new JButton("학과"));
    con.add(new JTextField("정보통신공학과"));
    con.add(new JButton("장래희망"));
    con.add(new JTextField("SI개발자"));
    con.add(new JButton("여름방학 계획"));
    con.add(new JTextField("고등학교 동창들과 Java와 Github를 활용해서 프로젝트 진행(방학 기간동안 결과내기가 목표)"));
    con.add(new JButton("다음학기 계획"));
    con.add(new JTextField("1학년때 성적 낮은과목들 재수강하기"));
    con.add(new JButton("좌우명"));
    con.add(new JTextField("즐길수 없다면 즐거운 척이라도 해라"));
    con.add(new JButton("내 인생의 맨토"));
    con.add(new JTextField("아직 없음"));
    setSize(1200, 400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	public static void main(String[] args) {
		HomeWork_1 h = new HomeWork_1();
		h.myInfo();
	}
}
