package com.ssafy.festival;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FestivalParser {
	private List<FestivalDto> festInfo;
	private int size;
	
	public int num;

	public FestivalParser() {
		loadData();
	}

	private void loadData() {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		String festInfoFilePath = "res/festival2022.xml";
		
		try {
			SAXParser parser = factory.newSAXParser();
			FestivalParserHandler handler = new FestivalParserHandler();
			parser.parse(festInfoFilePath, handler);
			festInfo = handler.getFestivals();
			
			size = festInfo.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<FestivalDto> getFestInfo() {
		return festInfo;
	}

	public void setFestInfo(List<FestivalDto> festInfo) {
		this.festInfo = festInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public static void main(String[] args) {
		new FestivalParser();
	}
}
