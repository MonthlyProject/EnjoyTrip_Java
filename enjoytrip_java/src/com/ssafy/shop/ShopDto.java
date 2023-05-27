package com.ssafy.shop;

public class ShopDto {
	
	/** 상가업소번호 */
	private String num;
	/** 상호명 */
	private String name;
	/** 상권업종중분류명*/
	private String cartegory;
	/** 시도명 */
	private String city;
	/** 시군구명 */
	private String state;
	/** 행정동명 */
	private String address;
	/** 지번주소 */
	private String lotAddress;
	/** 도로명주소 */
	private String streetAddress;

	public ShopDto() {}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCartegory() {
		return cartegory;
	}

	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLotAddress() {
		return lotAddress;
	}

	public void setLotAddress(String lotAddress) {
		this.lotAddress = lotAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "ShopDto [num=" + num + ", name=" + name + ", cartegory=" + cartegory + ", city=" + city + ", state="
				+ state + ", address=" + address + ", lotAddress=" + lotAddress + ", streetAddress=" + streetAddress
				+ "]";
	}

}
