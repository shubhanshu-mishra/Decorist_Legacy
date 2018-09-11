package utilities;

public class RandomNumberGeneration {

	public static int generateRandomNum(int maxLimit) {
		int number=(int) (Math.random()*maxLimit);
		return number;
	}
}
