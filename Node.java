
public class Node {
	private double value;
	private Node upperNode;
	private Node leftNode;
	private Node rightNode;
	
	//コンストラクタ
	public Node(double val) {
		value = val;
	}
	
	//get
	public double getValue() {
		return value;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public Node getUpperNode() {
		return upperNode;
	}
	
	//set
	public void setValue(double val) {
		value = val;
	}
	public void setUpperNode(Node node) {
		upperNode = node;
	}
	public void setLeftNode(Node node) {
		leftNode = node;
	}
	public void setRightNode(Node node) {
		rightNode = node;
	}
	//min
	public Node getMinNode() {
		if (leftNode==null) {
			return null;
		}else {
			Node left=leftNode;
			while (left.getLeftNode()!=null) {
				left=left.getLeftNode();
				}
			return left;
		}
		
	}
	//max
	public Node getMaxNode() {
		if (rightNode==null) {
			return null;
		}else {
			Node right=rightNode;
			while (right.getRightNode()!=null) {
				right=right.getRightNode();
			}
			return right;
		}
	}
}
