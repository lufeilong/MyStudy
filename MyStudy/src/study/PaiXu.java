package study;

public class PaiXu {
	public static void main(String[] args) {
		int[] values = new int[]{12,13,16,79,64,46,1746,1654,4354,3454};
		values = sort(values);
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	
	public static int[] sort(int[] values){
		
		int length = values.length;
		
		for (int i = 0; i < length - 1; i++) {
			
			for (int j = 0; j < length - i - 1; j++) {
				if(values[j] > values[j + 1]){
					int temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
		}
		return values;
	}
	
}
