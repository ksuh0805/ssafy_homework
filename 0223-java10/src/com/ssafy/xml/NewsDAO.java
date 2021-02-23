package com.ssafy.xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAO {
	List<News> list = new ArrayList<>();

	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectWeather(url);
		return list;
	}

	private void connectWeather(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("item");

			for (int i = 0; i < n.getLength(); i++) {
				News w = new News();
				Node item = n.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("title")) {
						w.setTitle(kid.getTextContent());
					} else if (name.equalsIgnoreCase("author")) {
						w.setAuthor(kid.getTextContent());
					} else if (name.equalsIgnoreCase("pubDate")) {
						w.setDate(kid.getTextContent());
					}
				}
				System.out.println(w);
				list.add(w);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}