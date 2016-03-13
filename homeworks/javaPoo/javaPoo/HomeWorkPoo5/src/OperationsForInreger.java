
import java.util.List;
import java.util.Arrays;

public class OperationsForInreger {

	private int[] objects;


	public OperationsForInreger(int[] objects) throws Exception {
		if (objects != null) {
			for (int i = 0; i < objects.length - 1; i++) {
				for (int j = i + 1; j < objects.length; j++) {
					if (objects[i]!=0&&objects[i] == (objects[j]))
						throw new Exception("The list contains duplicats");
				}
			}
			this.objects = objects;
		} else
			throw new Exception("The list is null");

	}


	public OperationsForInreger(int lenght) {
		objects = new int[lenght];
	}

	/** Constructor without parameter */
	public OperationsForInreger() {
	}

	public int find(int object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (object == objects[i])
					return object;
			}
		return 0;
	}


	public void add(int object) throws Exception {
		if (find(object) == 0) {
			int freeIndex = getFistUnusedIndex(objects);
			if (freeIndex != -1)
				objects[freeIndex] = object;
			else
				throw new Exception("Full list!!!");
		} else
			throw new Exception("The element still exist in list");

	}

	public void modify(int oldObject, int newObject) throws Exception {
		int indexOfObj = indexOf(oldObject);
		if (objects != null && indexOfObj != -1)
			objects[indexOfObj] = newObject;
		else
			throw new Exception("The old object dosen't exist");
	}

	public void remove(int object) throws Exception {
		int indexOfObject = indexOf(object);
		if (indexOfObject != -1) {
			if (objects != null) {
				for (int i = indexOfObject; i < objects.length - 1; i++) {
					objects[i] = objects[i + 1];
				}
				objects[objects.length - 1] = 0;
			} else
				throw new Exception("Null list");
		} else
			throw new Exception("The object dosen't exist");
	}


	public List<Integer> findAll() {
		Integer[] l = new Integer[objects.length];
		for (int i = 0; i < objects.length; i++) {
			l[i] = objects[i];
		}
		return Arrays.asList(l);
	}


	public List<Integer> findRange(int[] range) throws Exception {
		Integer[] l = new Integer[objects.length];
		if (objects != null)
			for (int i = 0; i < range.length; i++) {
				if (range[i] < objects.length)
					l[i] = objects[range[i]];
				else
					throw new Exception("The range is out of the list index");
			}
		return Arrays.asList(l);
	}

	public int count() {
		return getFistUnusedIndex(objects);
	}

	public int[] getObjects() {
		return objects;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OperationsForInreger)) {
			return false;
		}
		OperationsForInreger other = (OperationsForInreger) obj;
		if (!Arrays.equals(objects, other.objects)) {
			return false;
		}
		return true;
	}


	protected int getFistUnusedIndex(int[] list) {
		if (list != null)
			for (int i = 0; i < list.length; i++) {
				if (list[i] == 0)
					return i;
			}
		return -1;
	}


	protected int indexOf(int object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] == object)
					return i;
			}
		return -1;
	}

}
