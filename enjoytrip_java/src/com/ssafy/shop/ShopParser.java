package com.ssafy.shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopParser {
	private List<ShopDto> shopInfo;
	private ShopDto shopDto;
	private int size;

	public int num;

	public ShopParser(String s) {
		loadData(s);
	}

	private void loadData(String s) {
		File csv = new File("res/소상공인시장진흥공단_상가(상권)정보_" + s + "_202209.csv");
		BufferedReader br = null;
		String line = "";
		shopInfo = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(csv));
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i != 0) {
					shopDto = new ShopDto();
					String[] lineArr = line.split(",");
					shopDto.setNum(lineArr[0]);
					shopDto.setName(lineArr[1]);
					shopDto.setCartegory(lineArr[6]);
					shopDto.setCity(lineArr[12]);
					shopDto.setState(lineArr[14]);
					shopDto.setAddress(lineArr[16]);
					shopDto.setLotAddress(lineArr[24]);
					shopDto.setStreetAddress(lineArr[31]);
					shopInfo.add(shopDto);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ShopDto> getShopInfo() {
		return shopInfo;
	}

	public void addShopInfo(String num, String name, String cartegory, String city, String state, String address,
			String lotAddress, String streetAddress) {
		shopDto = new ShopDto();
		shopDto.setNum(num);
		shopDto.setName(name);
		shopDto.setCartegory(cartegory);
		shopDto.setCity(city);
		shopDto.setState(state);
		shopDto.setAddress(address);
		shopDto.setLotAddress(lotAddress);
		shopDto.setStreetAddress(streetAddress);
		shopInfo.add(shopDto);
	}

	public void deleteShopInfo(String num) {
		for (int i = 0; i < shopInfo.size(); i++) {
			if (shopInfo.get(i).getNum().equals(num)) {
				shopInfo.remove(i);
			}
		}
	}

}
