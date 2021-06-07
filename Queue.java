import java.util.Scanner;

class Queue {
	private int capacity; // 使用可能な配列の大きさ
	private int size; // 使用した配列の個数
	private int front; // 先頭の位置
	private int rear; // 末尾の位置
	private String [] dataSet; // 配列
	public Queue(int initSize) {
		capacity=initSize;
		dataSet=new String[capacity];
		size=-1;
		front=0;
		rear=size;
	}
	public Queue() {
		capacity=16;
		dataSet=new String[capacity];
		size=-1;
		front=0;
		rear=size;
	}
	
	//isEmpty
	public boolean isEmpty() {
      return (size == -1);
    }
	//insert
	public void insert(String s) {
		doubleCapacity();
		size++;
		if (rear<capacity-1) {
			dataSet[++rear] = s;
		}else {
			dataSet[0]=s;
			rear=0;
		}
        
    }
	//remove
    public String remove() {
    	size--;
      return dataSet[front++];
    }
    //peek
    public String peek() {
      return dataSet[rear];
    }
    //doubleCapacity
    private void doubleCapacity() {
    	//いっぱいになったら実行
    	if (size==capacity-1) {
			String [] tmp=new String[capacity*2];
			for (int i=0;i<size;i++) {
				if (front+i>=capacity-1) {
					front=0-i;
				}
				tmp[i]=dataSet[front+i];
			}
			dataSet=tmp;
			front=0;
			rear=size;
			System.out.println("Capacity: "+capacity+" -> "+capacity*2);
    	}
	}
}


class QueueMain{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    Queue queue = new Queue();
	    //quitするまで実行
	    while (true) {
	    	String str=null;
	    	String string=null;
		    string = scanner.nextLine();
		    str=string.split(" ")[0];
	    	if (str.equals("insert")) {
		    	queue.insert(string.split(" ")[1]);
	    	}
	    	if (str.equals("remove")) {
		    	queue.remove();
		    }
		    if (str.equals("peek")) {
		    	System.out.println(queue.peek());
		    }
		    if (str.equals("quit")) {
		    	scanner.close();
		    	break;
		    }
	    }

    }
}