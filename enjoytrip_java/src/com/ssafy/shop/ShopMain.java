package com.ssafy.shop;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShopMain extends JFrame {
	private JFrame frame;

	private DefaultTableModel shopModel;
	private JTable shopTable;
	private JScrollPane shopPan;

	private JButton modifyBt;
	private JButton deleteBt;
	
	private String[] title = { "상가업소번호", "상호명", "상권업종중분류명", "시도명", "시군구명", "행정동명", "지번주소", "도로명주소" };

	private String curNum;
	
	private ShopParser parser;
	
	public ShopMain() {
		createGUI();
	}

	private void createGUI() {

		frame = new JFrame("Enjoy! Shop - 즐거운 상점");

		shopModel = new DefaultTableModel(title, 8);
		shopTable = new JTable(shopModel);
		shopPan = new JScrollPane(shopTable);
		shopTable.setColumnSelectionAllowed(true);
		add(new JLabel("상권 정보", JLabel.CENTER), "North");
		add(shopPan, "Center");
		
		modifyBt = new JButton("추가");
		deleteBt = new JButton("삭제");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel(new GridLayout(2, 1));
		top.add(modifyBt);
		top.add(deleteBt);
		panel.add(top);
		add(panel,"West");
		
		shopTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = shopTable.getSelectedRow();
				String num = ((String) shopTable.getValueAt(row, 0)).trim();
				showTripInfo(num);
			}
		});
		
		deleteBt.addActionListener( e -> delete(curNum) );
		modifyBt.addActionListener( e -> add() );
		 
		//showTrips();
		setSize(800, 400);
		setVisible(false);
	}

	protected void showTripInfo(String num) {
		curNum = num;
	}

	public void setTable(String s) {
		parser = new ShopParser(s);
		List<ShopDto> shops = parser.getShopInfo();
		int i = 0;
		String[][] data = new String[shops.size()][8];
		for (ShopDto sd : shops) {
			data[i][0] = sd.getNum();
			data[i][1] = sd.getName();
			data[i][2] = sd.getCartegory();
			data[i][3] = sd.getCity();
			data[i][4] = sd.getState();
			data[i][5] = sd.getAddress();
			data[i][6] = sd.getLotAddress();
			data[i++][7] = sd.getStreetAddress();
		}
		shopModel.setDataVector(data, title);
	}
	
	public void delete(String num) {
		parser.deleteShopInfo(num);
		showTrips();
	}
	
	public void add() {
		System.out.println("추가할 상권 정보를 순서대로 입력하세요. \n->  \"상가업소번호\" \"상호명\" \"상권업종중분류명\" \"시도명\" \"시군구명\" \"행정동명\" \"지번주소\" \"도로명주소\"");
		Scanner sc = new Scanner(System.in);
		parser.addShopInfo(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
		showTrips();
	}
	
	public void showTrips() {
		List<ShopDto> shops = parser.getShopInfo();
		int i = 0;
		String[][] data = new String[shops.size()][8];
		for (ShopDto sd : shops) {
			data[i][0] = sd.getNum();
			data[i][1] = sd.getName();
			data[i][2] = sd.getCartegory();
			data[i][3] = sd.getCity();
			data[i][4] = sd.getState();
			data[i][5] = sd.getAddress();
			data[i][6] = sd.getLotAddress();
			data[i++][7] = sd.getStreetAddress();
		}
		shopModel.setDataVector(data, title);
	}
}
