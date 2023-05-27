package com.ssafy.festival;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FestivalMain extends JFrame {
	private JFrame frame;
	
	private DefaultTableModel festivalModel;
	private JTable festivalTable;
	private JScrollPane festivalPan;
	private String[] title = {"연번", "광역단체명", "기초단체명", "축제명", "개최기간", "개최장소", "개최방식", "최초개최년도", "담당자 성명", "담당자 연락처"};
	
	public FestivalMain() {
		createGUI();
	}
	
	public void createGUI() {
		frame = new JFrame("Enjoy! Festival - 즐거운 축제");

		festivalModel = new DefaultTableModel(title, 15);
		festivalTable = new JTable(festivalModel);
		festivalPan = new JScrollPane(festivalTable);
		festivalTable.setColumnSelectionAllowed(true);
		add(new JLabel("축제 정보", JLabel.CENTER), "North");
		add(festivalPan, "Center");
		
		setSize(800, 330);
		setVisible(false);
	}
	
	public void setTable(String s) {
		FestivalParser festivalParser = new FestivalParser();
		List<FestivalDto> fes = festivalParser.getFestInfo();
		int i=0;
		String[][] data = new String[fes.size()][10];
		for(FestivalDto fd : fes) {
			if(fd.getCity().contains(s)) {
				data[i][0] = "" + fd.getNum();
				data[i][1] = fd.getCity();
				data[i][2] = fd.getGroup();
				data[i][3] = fd.getName();
				data[i][4] = fd.getPeriod();
				data[i][5] = fd.getPlace();
				data[i][6] = fd.getOnOff();
				data[i][7] = fd.getStartYear();
				data[i][8] = fd.getManagerName();
				data[i++][9] = fd.getManagerPhoneNumber();
			}
		}
		festivalModel.setDataVector(data, title);
	}

}
