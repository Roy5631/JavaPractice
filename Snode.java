class Snode{
	private String data; // ノードのデータ要素
	private int count; // このデータが入力された回数
	private Snode prev; // 前のノードの参照
	private Snode next; // 次のノードの参照
	//dataとcountを設定
	public Snode(String x) {
		this.data=x;
		this.count=1;
	}
	//prevをget
	Snode getPrev() {
		return this.prev;
	}
	//nextをget
	Snode getNext() {
		return this.next;
	}
	//prevをset
	void setPrev(Snode n) {
		this.prev=n;
	}
	//nextをset
	void setNext(Snode n) {
		this.next=n;
	}
	void setData(String x) {
		this.data=x;
	}
	//countをset
	void setCount(int n) {
		this.count=n;
	}
	//dataをget
	String getData() {
		return this.data;
	}
	//countをget
	int getCount() {
		return this.count;
	}
	//countを1増やす
	void increaseCount() {
		this.count+=1;
	}
	//countを1減らす
	void decreaseCount() {
		this.count-=1;
	}
}