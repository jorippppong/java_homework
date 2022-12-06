package section1;

//Music Service
//한 달에 지불해야 하는 금액을 Expensive, Normal, Cheap으로 구분
public class MusicEvaluate implements Evaluate{
	@Override
	public String getMoney(int money) {
		String level=null;
		
		if(money>=12000)
			level = "Expensive";
		else if(money>=7000)
			level = "Normal";
		else if(money>0)
			level = "Cheap";
		else if(money ==0)
			level="None";
		
		return level;
	}
}
