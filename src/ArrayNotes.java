import java.util.Scanner;

public class ArrayNotes {

	public static void main(String[] args){
		Scanner in= new Scanner(System.in);
		String[] s= in.nextLine().split(" ");
		for(int i=0; i<s.length ; i++)
			System.out.print(", "+"\""+s[i]+"\"");
	}
}
