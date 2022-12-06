package service;

public class OTT {
	public String name;
	public int price;
	public int people;
	public int money;
	public String output;
	
	public OTT(String name, int price, int people) {
		this.name = name;
		this.price = price;
		this.people = people;
	}
	public OTT(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	//한달 내야할 금액 계산
	//소수 점 이하는 생략한다. (정수 type)
	public int CalculateMoney() {
		return money;
	}
	
	//가격 계산
	public void printPrice() {
		
	}
}
