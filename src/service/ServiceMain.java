/*
 * 주석1 : 과제 설명
 * 
 * 객체지향 프로그래밍 평가과제
 * 학과: 컴퓨터,전자시스템공학부
 * 학번: 202003343
 * 이름: 조유리
 * 
 * 과제 주제: 한류에 관심이 있지만, 그것을 체험하기 어려운 한국과 먼 거리에 사는 사람들이 가장 쉽게 한류를 즐길 수 있는 방법은 바로 모바일 어플을 활용하는 것이다. 
 * 그 중에서도 OTT 서비스 등을 활용해서 빠르게 한국의 컨텐츠를 즐길 수 있다. 
 * 해당 과제를 통해 사용자가 구독하길 원하는 서비스, 한달 구독료, 그리고 같은 계정을 공유하는 인원 수를 입력하면 
 * 한 달 동안 OTT 서비스에 얼마나 지불하는 지를 알 수 있는 지를 알 수 있도록 만들었다. 
 * */


package service;
import java.util.*;
import java.io.*;

public class ServiceMain {

	public static void main(String[] args) throws IOException{
		//주석8 : 파일 입출력 사용
		BufferedWriter bw = new BufferedWriter(new FileWriter("ottFile.txt", true));
		
		//주석6 : 참조타입(열거타입) 사용
		Week today = null;
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
			case 1:
				today = Week.SUNDAY; break;
			case 2:
				today = Week.MONDAY; break;
			case 3:
				today = Week.TUESDAY; break;
			case 4:
				today = Week.WEDNESDAY; break;
			case 5:
				today = Week.THURSDAY; break;
			case 6:
				today = Week.FRIDAY; break;				
			case 7:
				today = Week.SATURDAY; break;	
		}
		//주석8 : 파일 입출력 사용
		bw.write("오늘의 요일은 "+today+"입니다.");
		bw.newLine();
		
		
		//주석7 : 컬렉션 프레임워크 사용
		List<Integer> list = new ArrayList<Integer>();
		List<MusicOTT> musicList = new ArrayList<>();
		List<VideoOTT> videoList = new ArrayList<>();
		
		PrintPrice printprice = new PrintPrice();
		
		//주석6 : 참조타입(배열 사용)
		String[] musicName= {"멜론", "Flo"};
		int[] musicPrice = {12000, 10900};
		
		String[] videoName = {"넷플릭스", "왓챠", "웨이브"};
		int[] videoPrice = {17000, 12900, 13900};
		int[] videoPeople = {4,0,1};
		
		int sum=0;
	
		
		//주석7 : 컬렉션 프레임워크 사용
		musicList.add(new MusicOTT(musicName[0], musicPrice[0]));
		musicList.add(new MusicOTT(musicName[1], musicPrice[1]));
		
		for(int i =0; i<musicList.size(); i++) {
			MusicOTT mott = musicList.get(i);
			list.add(mott.CalculateMoney());
			printprice.print(mott);
			bw.write(mott.output);
			bw.newLine();
		}
		
		videoList.add(new VideoOTT(videoName[0], videoPrice[0], videoPeople[0]));
		videoList.add(new VideoOTT(videoName[1], videoPrice[1], videoPeople[1]));
		videoList.add(new VideoOTT(videoName[2], videoPrice[2], videoPeople[2]));
		
		for(int i =0; i<videoList.size(); i++) {
			VideoOTT vott = videoList.get(i);
			vott.setPeople(vott.people);
			list.add(vott.CalculateMoney());
			printprice.print(vott);
			bw.write(vott.output);
			bw.newLine();
		}
		
		
		//list에 있는 값을 합쳐서 총합을 계산
		for(int i=0; i<list.size(); i++) {
			sum+=list.get(i);
		}
		//주석8 : 파일 입출력 사용
		bw.write("총 지불 금액은 "+sum+"원 입니다.");
		bw.newLine();
		bw.close();
		
		//주석8 : 파일 입출력 사용
		//주석4 : 예외 처리
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("ottFile.txt"));
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				br.close();
			}
			
		}
		
	}
}
