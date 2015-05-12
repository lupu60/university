import java.util.List;
import java.util.Arrays;

public class OperationsForDouble {

	private double[] objects;

	public OperationsForDouble(double[] objects) throws Exception {
		if (objects != null) {
			for (int i = 0; i < objects.length - 1; i++) {
				for (int j = i + 1; j < objects.length; j++) {
					if (objects[i] == (objects[j]))
						throw new Exception("The list contains duplicats");
				}
			}
			this.objects = objects;
		} else
			throw new Exception("The list is null");

	}

	public OperationsForDouble(int lenght) {
		objects = new double[lenght];
	}


	public OperationsForDouble() {
	}

	public double find(double object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (object == objects[i])
					return object;
			}
		return 0;
	}


	public void add(double object) throws Exception {
		if (find(object) == 0) {
			int freeIndex = getFistUnusedIndex(objects);
			if (freeIndex != -1)
				objects[freeIndex] = object;
			else
				throw new Exception("Full list!!!");
		} else
			throw new Exception("The element still exist in list");

	}


	public void modify(double oldObject, double newObject) throws Exception {
		int indexOfObj = indexOf(oldObject);
		if (objects != null && indexOfObj != -1)
			objects[indexOfObj] = newObject;
		else
			throw new Exception("The old object dosen't exist");
	}


	public void remove(double object) throws Exception {
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

	public List<Double> findAll() {
		Double[] l = new Double[objects.length];
		for (int i = 0; i < objects.length; i++) {
			l[i] = objects[i];
		}
		return Arrays.asList(l);
	}


	public List<Double> findRange(int[] range) throws Exception {
		Double[] l = new Double[objects.length];
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


	public double[] getObjects() {
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
		OperationsForDouble other = (OperationsForDouble) obj;
		if (!Arrays.equals(objects, other.objects)) {
			return false;
		}
		return true;
	}


	protected int getFistUnusedIndex(double[] list) {
		if (list != null)
			for (int i = 0; i < list.length; i++) {
				if (list[i] == 0)
					return i;
			}
		return -1;
	}


	protected int indexOf(double object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] == object)
					return i;
			}
		return -1;
	}

}
