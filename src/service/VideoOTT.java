package service;
import section1.Evaluate;
import section1.VideoEvaluate;

//주석2: 클래스 사용
public class VideoOTT extends OTT {
	//주석5: 인터페이스 다향성 (필드의 다향성)
	Evaluate videoEvaluate = new VideoEvaluate();
	
	public VideoOTT(String name, int price, int people) {
		super(name, price, people);
	}
	
	public void setPeople(int people) {
		//해당 OTT를 구독하려는 사람이 없으므로, 금액을 0원으로 설정
		if(people ==0) {
			this.price = 0;
			this.people = 0;
		}
		else
			this.people=people;
	}
	public int getPeople() {
		return people;
	}
	
	@Override
	//한달 내야할 금액 계산
	//소수 점 이하는 생략한다. (정수 type)
	//주석4 : 예외처리
	public int CalculateMoney() {
		try {
			this.money = price/people;
		}catch(ArithmeticException e) {
			System.out.println("\""+name+"\"을(를) 구독하지 않습니다.");
			this.money =0;
		}
		return money;
	}
	
	
	
	//주석5: 인터페이스 다향성
	@Override
	public void printPrice() {
		this.output = "Video OTT인 \"" +name+ "\" 에게 한 달동안 지불해야 할 금액은 "+money+"원 입니다.";
		this.output += "->"+videoEvaluate.getMoney(money);
		
	}
}
