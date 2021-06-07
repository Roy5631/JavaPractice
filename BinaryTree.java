
public class BinaryTree {
	private Node root; // 最上位の親ノード

	public boolean isEmpty() {
		return root == null;
	}
	

	public Node getMinNode() {
		if(root==null) {
			return null;
		}else {
			return root.getMinNode();
		}
	}
	

	public Node getMaxNode() {
		if (root==null) {
			return null;
		}else {
			return root.getMaxNode();
		}
	}
	

	public Node findNode(double value) {
		
		Node  now=root;
		while (now!=null) {
			if (now.getValue()==value) {
				break;
			}else if (now.getValue()>value) {
				now=now.getLeftNode();
			}else {
				now=now.getRightNode();
			}
		}
		return now;
			
		}
		
	

	public void insertNode(double value) {
		if (findNode(value)!=null) {
			return;
		}else {
			if (root==null) {
				//insertするnode
				Node in=new Node(value);
				root=in;
			}else {
				//みているnode
				Node now=root;
				//uppperのnode
				Node up=null;
				//insertするnode
				Node in=new Node(value);
				int n=-1;
				while (now!=null) {
					if (now.getValue()>value) {
						up=now;
						now=now.getLeftNode();
						n=0;
					}else {
						up=now;
						now=now.getRightNode();
						n=1;
					}
				}
				if (n==0) {
					up.setLeftNode(in);
					in.setUpperNode(up);
				}else {
					up.setRightNode(in);
					in.setUpperNode(up);
				}
			}
		}
	}
	

	public void removeNode(double value) {
		if (findNode(value)==null) {
			return;
		}else {
			//消すnode
			Node rem=findNode(value);
			//なし
			if (rem.getLeftNode()==null && rem.getRightNode()==null) {
				if (rem.getUpperNode()==null) {
					root=null;
				}else {
					if (rem.getValue()>rem.getUpperNode().getValue()) {
						rem.getUpperNode().setRightNode(null);
					}else {
						rem.getUpperNode().setLeftNode(null);
					}
				}
				
			//一つ
			}else if ((rem.getLeftNode()==null && rem.getRightNode()!=null)) {
				if (rem.getUpperNode()==null) {
					rem.getRightNode().setUpperNode(null);
					root=rem.getRightNode();
				}else {
					if (rem.getValue()>rem.getUpperNode().getValue()) {
						rem.getUpperNode().setRightNode(rem.getRightNode());
						rem.getRightNode().setUpperNode(rem.getUpperNode());
					}else {
						rem.getUpperNode().setLeftNode(rem.getRightNode());
						rem.getRightNode().setUpperNode(rem.getUpperNode());
					}
				}
				
			}else if (rem.getLeftNode()!=null && rem.getRightNode()==null){
				if (rem.getUpperNode()==null) {
					rem.getLeftNode().setUpperNode(null);
					root=rem.getLeftNode();
				}else {
					if (rem.getValue()>rem.getUpperNode().getValue()) {
						rem.getUpperNode().setRightNode(rem.getLeftNode());
						rem.getLeftNode().setUpperNode(rem.getUpperNode());
					}else {
						rem.getUpperNode().setLeftNode(rem.getLeftNode());
						rem.getLeftNode().setUpperNode(rem.getUpperNode());
					}
				}
			//二つ
			} else {
				//A
				if (rem.getRightNode().getLeftNode()==null) {
					if (rem.getUpperNode()==null) {
						rem.getRightNode().setUpperNode(null);
						rem.getRightNode().setLeftNode(rem.getLeftNode());
						rem.getLeftNode().setUpperNode(rem.getRightNode());
						root=rem.getRightNode();
					}else {
						if (rem.getValue()>rem.getUpperNode().getValue()) {
							rem.getRightNode().setUpperNode(rem.getUpperNode());
							rem.getRightNode().setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(rem.getRightNode());
							rem.getUpperNode().setRightNode(rem.getRightNode());
						}else {
							rem.getRightNode().setUpperNode(rem.getUpperNode());
							rem.getRightNode().setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(rem.getRightNode());
							rem.getUpperNode().setLeftNode(rem.getRightNode());
						}
					}
					
				//B
				}else {
					//最小
					Node min = rem.getRightNode().getMinNode();
					//i
					if (min.getRightNode()==null) {
						if (rem.getUpperNode()==null) {
							min.getUpperNode().setLeftNode(null);
							min.setUpperNode(null);
							min.setRightNode(rem.getRightNode());
							min.setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(min);
							rem.getRightNode().setUpperNode(min);
							root=min;
						}else {
							min.getUpperNode().setLeftNode(null);
							min.setUpperNode(rem.getUpperNode());
							min.setRightNode(rem.getRightNode());
							min.setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(min);
							rem.getRightNode().setUpperNode(min);
							if (rem.getValue()>rem.getUpperNode().getValue()) {
								rem.getUpperNode().setRightNode(min);
							}else {
								rem.getUpperNode().setLeftNode(min);
							}
						}
						
					//ii
					}else {
						if (rem.getUpperNode()==null) {
							min.getUpperNode().setLeftNode(min.getRightNode());
							min.getRightNode().setUpperNode(min.getUpperNode());
							min.setUpperNode(null);
							min.setRightNode(rem.getRightNode());
							min.setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(min);
							rem.getRightNode().setUpperNode(min);
							root=min;
						}else {
							min.getUpperNode().setLeftNode(min.getRightNode());
							min.getRightNode().setUpperNode(min.getUpperNode());
							min.setUpperNode(rem.getUpperNode());
							min.setRightNode(rem.getRightNode());
							min.setLeftNode(rem.getLeftNode());
							rem.getLeftNode().setUpperNode(min);
							rem.getRightNode().setUpperNode(min);
							if (rem.getValue()>rem.getUpperNode().getValue()) {
								rem.getUpperNode().setRightNode(min);
							}else {
								rem.getUpperNode().setLeftNode(min);
							}
						}
						
					}
				}
					
			}
		}
	}

	private void printSubTree(Node node) {
		System.out.print(" ( " + node.getValue());
		
		if (node.getLeftNode() != null || node.getRightNode() != null) {
			if (node.getLeftNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getLeftNode());
			}

			if (node.getRightNode() == null) {
				System.out.print(" ( null ) ");
			} else {
				printSubTree(node.getRightNode());
			}
		}

		System.out.print( " )");
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.print("( null )");
		} else {
			printSubTree(root);
		}
		System.out.println();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryTreeMain {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command, input; // コマンド，入力
		double value = 0; // 数値
		BinaryTree tree = new BinaryTree(); // 二分探索木の作成

		while (true) {
			command = "";
			input = "";

			boolean hasValue = false; // 数値が入力されたときtrueになる

			System.out.print("command > ");
			System.out.flush();

			try {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// 最初のトークンはコマンド
				if (st.hasMoreElements()) {
					command = st.nextToken();
				}
				// 次のトークンがあれば数値
				if (st.hasMoreElements()) {
					input = st.nextToken();
					try {
						value = Double.parseDouble(input);
						hasValue = true;
					} catch (NumberFormatException e) {
						System.out.println("Illegal number was entered: " + input);
						continue;
					}
				}

				System.out.println(command + " " + input);
				System.out.flush();
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}

			if (command.equals("quit")) {
				break;
			} else if (command.equals("min")) {


				System.out.println("Min = " + String.valueOf(tree.getMinNode().getValue()));
				

			} else if (command.equals("max")) {


				System.out.println("Max = " + String.valueOf(tree.getMaxNode().getValue()));
				

			} else if (command.equals("find")) {


				if (tree.findNode(value)==null) {
					System.out.println(input + " was not found");
				}else {
					System.out.println(input + " was found");
				}
				
				

			} else if (command.equals("insert")) {


				if (hasValue) {
					tree.insertNode(value);
				}else {
					System.out.println("No Value");
				}
				

			} else if (command.equals("remove")) {


				if (hasValue) {
					tree.removeNode(value);
				}else {
					System.out.println("No Value");
				}
				

			} else if (command.equals("print")) {
				tree.printTree();
			} else {
				System.out.println("Command is not found: " + command);
			}
		}
	}
}
