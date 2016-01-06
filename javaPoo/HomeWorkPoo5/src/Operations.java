import java.util.List;
import java.util.Arrays;

public class Operations<T> {
	private T[] objects;

	public Operations(T[] objects) throws Exception { 
		if (objects != null) {
			for (int i = 0; i < objects.length - 1; i++) {
				for (int j = i + 1; j < objects.length; j++) {
					if (objects[i] != null && objects[i].equals(objects[j]))
						throw new Exception("The list contains duplicats");
				}
			}
			this.objects = objects;
		} else
			throw new Exception("The list is null");

	}


	@SuppressWarnings("unchecked")
	public Operations(int lenght) {
		objects = (T[]) new Object[lenght];
	}

	public Operations() {
	}

	public T find(T object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (object.equals(objects[i]))
					return object;
			}
		return null;
	}


	public void add(T object) throws Exception {
		if (find(object) == null) {
			int freeIndex = getFistUnusedIndex(objects);
			if (freeIndex != -1)
				objects[freeIndex] = object;
			else
				throw new Exception("Full list!!!");
		} else
			throw new Exception("The element still exist in list");

	}


	public void modify(T oldObject, T newObject) throws Exception {
		int indexOfObj = indexOf(oldObject);
		if (objects != null && indexOfObj != -1)
			objects[indexOfObj] = newObject;
		else
			throw new Exception("The old object dosen't exist");
	}

	public void remove(T object) throws Exception {
		int indexOfObject = indexOf(object);
		if (indexOfObject != -1) {
			if (objects != null) {
				for (int i = indexOfObject; i < objects.length - 1; i++) {
					objects[i] = objects[i + 1];
				}
				objects[objects.length - 1] = null;
			} else
				throw new Exception("Null list");
		} else
			throw new Exception("The object dosen't exist");
	}


	public List<T> findAll() {
		return Arrays.asList(objects);
	}


	public List<T> findRange(int[] range) throws Exception {
		@SuppressWarnings("unchecked")
		T[] list = (T[]) new Object[range.length];
		if (objects != null)
			for (int i = 0; i < range.length; i++) {
				if (range[i] < objects.length)
					list[i] = objects[range[i]];
				else
					throw new Exception("The range is out of the list index");
			}
		return Arrays.asList(list);
	}

	public int count() {
		return getFistUnusedIndex(objects);
	}

	public T[] getObjects() {
		return objects;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Operations)) {
			return false;
		}
		Operations<?> other = (Operations<?>) obj;
		if (!Arrays.equals(objects, other.objects)) {
			return false;
		}
		return true;
	}

	protected int getFistUnusedIndex(T[] list) {
		if (list != null)
			for (int i = 0; i < list.length; i++) {
				if (list[i] == null)
					return i;
			}
		return -1;
	}

	protected int indexOf(T object) {
		if (objects != null)
			for (int i = 0; i < objects.length; i++) {
				if (objects[i].equals(object))
					return i;
			}
		return -1;
	}

}
