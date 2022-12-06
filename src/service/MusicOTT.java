package service;
import section1.Evaluate;
import section1.MusicEvaluate;

//주석2 : 클래스 상속
public class MusicOTT extends OTT{
	
	//주석5: 인터페이스 다향성 (필드의 다향성)
	Evaluate musicEvaluate = new MusicEvaluate();
	
	public MusicOTT(String name, int price) {
		super(name, price);
	}
	
	//MusicOTT는 아이디 공유 불가라서 한명만 사용가능하다.
	@Override
	public int CalculateMoney() {
		this.money = price;
		return money;
	}
	
	//주석5: 인터페이스 다향성
	@Override
	public void printPrice() {
		this.output = "Music OTT인 \"" +name+ "\" 에게 한 달동안 지불해야 할 금액은 "+money+ "원 입니다.";
		this.output += "->"+musicEvaluate.getMoney(money);
		
	}
	
}
