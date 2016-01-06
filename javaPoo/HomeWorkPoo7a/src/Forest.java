import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Forest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Node> tree;

	public Forest(LinkedList<Node> tree) {
		this.tree = tree;
	}

	public Forest() {
		tree= new LinkedList<>();
	}

	public boolean addNode(Node node) {
		node.setRoot(calculateRoot(node));
		return tree.add(node);
	}

	private Node calculateRoot(Node node) {
		if (tree.isEmpty())
			return node;
		return tree.getFirst();

	}
	
	private void setRoots(Forest fr){
		fr.tree.get(0).setRoot(fr.tree.get(0));
		for (int i = 1; i < fr.tree.size(); i++) {
			fr.tree.get(i).setRoot(fr.tree.get(0));
		}
	}
	
	public  Forest readObject(ObjectInputStream ios) throws ClassNotFoundException, IOException{
		Forest fr=(Forest) ios.readObject();
		fr.setRoots(fr);
		return fr;
	}
	
	public void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeObject(this);
	}

	/**
	 * @return the tree
	 */
	public LinkedList<Node> getTree() {
		return tree;
	}

	/**
	 * @param tree
	 *            the tree to set
	 */
	public void setTree(LinkedList<Node> tree) {
		this.tree = tree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Forest [tree=" + tree + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tree == null) ? 0 : tree.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Forest)) {
			return false;
		}
		Forest other = (Forest) obj;
		if (tree == null) {
			if (other.tree != null) {
				return false;
			}
		} else if (!tree.equals(other.tree)) {
			return false;
		}
		return true;
	}

}
