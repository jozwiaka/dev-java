package mypackage2;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FortuneService_Random implements FortuneService {

	private String[] data = {"data0", "data1", "data2"};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
