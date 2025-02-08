import java.util.ArrayList;

public class TowerOfHanai {
	
	public static void tower(ArrayList<ArrayList<Integer>> result, int number, int source, int dest, int help) {
		if(number==1) {
			result.add(getTransferDetails(number, source, dest));
		}else {
			tower(result, number-1, source, help, dest);
			result.add(getTransferDetails(number, source, dest));
			tower(result, number-1, help, dest, source);
		}
	}

	private static ArrayList<Integer> getTransferDetails(int number, int source, int dest) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(number);
		list.add(source);
		list.add(dest);
		return list;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		tower(result, 3, 1, 3, 2);
		System.out.println(result);
	}

}
