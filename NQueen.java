import java.util.Arrays;
import java.util.Collections;

public class NQueen {
	
	//クイーンの数
	private final int N;
	//各行の置かれたクイーンの列(position)，サイズは N
	private int[] pos ;
	//クイーンが垂直方向(column)に利いているか（図 4）を示す配列,サイズN
	private Status[] col;
	//クイーンが右斜め下向き(diagonal down)に利いているか（図５）を示す配列，サイズは 2*N-1．
	private Status[] down;
	//クイーンが右斜め上向き(diagonal up)に利いているか（図６）を示す配列，サイズは 2*N-1．
	private Status[] up;
	// 解の個数を数えるための変数
	private int count;
	
	
	//列挙型 Status を定義する
	private enum Status {
		//enum は列挙型で、複数の定数をひとまとめにする。
		FREE, //利き筋になっていない(置ける)
		NOT_FREE //利き筋になっている(置けない)
	}
	
	//コンストラクタ
	public NQueen(int numberOfQueen) {
		N=numberOfQueen;
		pos=new int[N];
		Arrays.fill(pos, -1);
		col=new Status[N];
		Arrays.fill(col, Status.FREE);
		down=new Status[2*N-1];
		Arrays.fill(down, Status.FREE);
		up=new Status[2*N-1];
		Arrays.fill(up, Status.FREE);
		count=0;
		
	}
	
	public boolean tryQueen(int a) {
		//N-1までおければ終わり
		if (a>=N) {
			return true;
		}else {
			for (int i=0;i<N;i++) {
				//i列目における
				if (col[i]==Status.FREE && down[N-1-a+i]==Status.FREE && up[a+i]==Status.FREE) {
					pos[a]=i;
					col[i]=Status.NOT_FREE;
					down[N-1-a+i]=Status.NOT_FREE;
					up[a+i]=Status.NOT_FREE;
					//次おけない
					if (tryQueen(a+1)==false) {
						//リセット
						pos[a]=-1;
						col[i]=Status.FREE;
						down[N-1-a+i]=Status.FREE;
						up[a+i]=Status.FREE;
					}else {
						break;
					}
				}
			}
			//最後までおけなかったかどうかで場合分け
			if (pos[a]!=-1) {
				return tryQueen(a+1);
			}else {
				return false;
			}
		}
	}
	
	public boolean tryQueenAll(int a) {
		if (a>=N) {
			count+=1;
			System.out.println("No : "+count);
			print();
			return true;
		}else {
			for(int i=0;i<N;i++) {
				//i列目における
				if (col[i]==Status.FREE && down[N-1-a+i]==Status.FREE && up[a+i]==Status.FREE) {
					pos[a]=i;
					col[i]=Status.NOT_FREE;
					down[N-1-a+i]=Status.NOT_FREE;
					up[a+i]=Status.NOT_FREE;
					tryQueenAll(a+1);
					//リセット
					pos[a]=-1;
					col[i]=Status.FREE;
					down[N-1-a+i]=Status.FREE;
					up[a+i]=Status.FREE;
				}
			}
			return false;
		}
	}
	
	public void print() {
		for (int i=0;i<N;i++) {
			String m="";
			m+=String.join("", Collections.nCopies(pos[i], "."));
			m+="Q";
			m+=String.join("", Collections.nCopies(N-pos[i]-1, "."));
			System.out.println(m);
		}
	}
}


public class NQueenMain {
	private static void abort(String message) {
		// 起動法と message を表示して，プログラムを終了させる
		System.err.println("Usage: java NQueenMain <queens>");
		System.err.println(message);
		System.exit(1);
		// 1 は以上終了を示す
	}
	
	public static void main(String[] args) {
		
		//パラメータの数は 1,2個でなければならない
		if (args.length > 2){
			abort("Invalid length of args"); 
			return;
		}
		
		// パラメータで指定されたクイーンの数を取得して n にセット
		int n = 0;
		try {
			n = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			abort("Invalid # of queens: " + args[0]);
		}
		if (n<=0) {
			abort("Invalid # of queens: " + args[0]);
		}
		
		
		NQueen nq = new NQueen(n);
		
		if (args.length==2) {
			//allがあれば、すべての解を出す
			String m="";
			try {
				m=args[1];
			}catch(NumberFormatException e){
				abort("Invalid : " + args[1]);
			}
			if ("all".equals(m)) {
				nq.tryQueenAll(0);
			}
		}else {
			// "java NQueenMain クイーンの数" として実行する
			if (nq.tryQueen(0)) {
			// 成功したので解を表示する
				nq.print();
			} else {
			// 失敗したので,その旨のメッセージを表示する.
				System.out.println("No solution.");
			}
		}
	}
}



