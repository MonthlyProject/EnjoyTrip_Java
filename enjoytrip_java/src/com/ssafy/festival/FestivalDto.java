package com.ssafy.festival;

public class FestivalDto {

	/** 연변 */
	private int num;
	/** 광역단체명 */
	private String city;
	/** 기초단체명 */
	private String group;
	/** 축제명*/
	private String name;
	/** 개최기간 */
	private String period;
	/** 개최장소 */
	private String place;
	/** 개최방식 */
	private String onOff;
	/** 최초개최년도 */
	private String startYear;
	/** 담당자 이름 */
	private String managerName;
	/** 담당자 번호 */
	private String managerPhoneNumber;
	
	public FestivalDto() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	@Override
	public String toString() {
		return "FestivalDto [num=" + num + ", city=" + city + ", group=" + group + ", name=" + name + ", period="
				+ period + ", place=" + place + ", onOff=" + onOff + ", startYear=" + startYear + ", managerName="
				+ managerName + ", managerPhoneNumber=" + managerPhoneNumber + "]";
	}
}
