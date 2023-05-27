package com.ssafy.festival;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FestivalParserHandler extends DefaultHandler{

	
	private int num;
	
	private List<FestivalDto> fests;
	
	private FestivalDto festDto;
	
	private String temp;

	public FestivalParserHandler() {
		fests = new ArrayList<FestivalDto>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = "";
		if(qName.equals("record")) {
			festDto = new FestivalDto();
			fests.add(festDto);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("연번")) {
			festDto.setNum(Integer.parseInt(temp));
		} else if(qName.equals("광역단체명")) {
			festDto.setCity(temp);
		} else if(qName.equals("기초단체명")) {
			festDto.setGroup(temp);
		} else if(qName.equals("축제명")) {
			festDto.setName(temp);
		} else if(qName.equals("개최기간")) {
			festDto.setPeriod(temp);
		} else if(qName.equals("개최장소")) {
			festDto.setPlace(temp);
		} else if(qName.equals("개최방식")) {
			festDto.setOnOff(temp);
		} else if(qName.equals("최초개최년도")) {
			festDto.setStartYear(temp);
		} else if(qName.equals("성명")) {
			festDto.setManagerName(temp);
		} else if(qName.equals("연락처")) {
			festDto.setManagerPhoneNumber(temp);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		temp = new String(ch,start,length);
	}
	
	public List<FestivalDto> getFestivals(){
		return fests;
	}
	
}
