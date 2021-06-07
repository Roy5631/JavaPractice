import java.util.Scanner;

class Stack {
	private int capacity; // スタック用配列のサイズ
	private int size; // 使用した配列の数
	private String [] dataSet; // スタックのデータ項目
	//コンストラクタ作成
	public Stack(int initSize) {
		capacity=initSize;
		dataSet=new String[capacity];
		size=-1;
	}
	public Stack() {
		capacity=16;
		dataSet=new String[capacity];
		size=-1;
	}
	
	//isEmpty
	public boolean isEmpty() {
      return (size == -1);
    }
	//push
	public void push(String s) {
		doubleCapacity();
        dataSet[++size] = s;
    }
	//pop
    public String pop() {
      return dataSet[size--];
    }
    //peek
    public String peek() {
      return dataSet[size];
    }
    //doubleCapacity
    private void doubleCapacity() {
    	//いっぱいになったら実行
    	if (size==capacity-1) {
			capacity*=2;
			String [] tmp=new String[capacity];
			for (int i=0;i<size;i++) {
				tmp[i]=dataSet[i];
			}
			dataSet=tmp;
			System.out.println("Capacity: "+capacity/2+" -> "+capacity);
    	}
	}
	
}

class StackMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    Stack stack = new Stack();
	    //quitするまで実行
	    while (true) {
	    	String str=null;
	    	String string=null;
		    string = scanner.nextLine();
		    str=string.split(" ")[0];
	    	if (str.equals("push")) {
		    	stack.push(string.split(" ")[1]);
	    	}
	    	if (str.equals("pop")) {
		    	stack.pop();
		    }
		    if (str.equals("peek")) {
		    	System.out.println(stack.peek());
		    }
		    if (str.equals("quit")) {
		    	scanner.close();
		    	break;
		    }
	    }

    }
}