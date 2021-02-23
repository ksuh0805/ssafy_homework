package com.ssafy.xml;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class NewsMain {
	JFrame f = new JFrame("News List");
	JButton b = new JButton("뉴스 불러오기");
	@SuppressWarnings("rawtypes")
	JList li = new JList();
	JScrollPane scroll;
	NewsDAO dao;

	public NewsMain() {
		dao = new NewsDAO(); 
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	protected void showList() {
		List<News> datas = dao
				.getNewsList("http://rss.etnews.com/Section902.xml");
		li.removeAll();
		li.setListData(datas.toArray());
	}
	
	private void createGUI() {
		f.add(b, "South");
		scroll = new JScrollPane();
		scroll.setViewportView(li);
		f.add(scroll);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new NewsMain();
	}
}
