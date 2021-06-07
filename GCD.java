
import java.util.Scanner;

class GCD {
	public static void main(String[] args) {
		// キーボード入力を使う。
		Scanner scanner = new Scanner(System.in);
		System.out.println("大きい方の整数を入力してください。");
		int a = scanner.nextInt();
		System.out.println("小さい方の整数を入力してください。");
		int b = scanner.nextInt();
		System.out.println("入力された整数は"+a+"と"+b+"ですね。");
		scanner.close(); 
		//最大公約数を計算し、表示する
		int result=getCommonDivisor(a,b);
		System.out.println(a+"と"+b+"の最大公約数は"+result+"です。");

}
private static int getCommonDivisor(int x, int y) {
	 if (x<y) {
		 int tmp=x;
		 x=y;
		 y=tmp;
	 }
	 if (x%y==0) {
		 return y;
	 } else {
		 int tmp=x%y;
		 x=y;
		 y=tmp;
		 return getCommonDivisor(x,y);
	 }
}
}