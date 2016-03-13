
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IdArray extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	public class IteratorThree implements Iterator<String> {
		private int elemNumber, contor = -1;

		public IteratorThree() {
			elemNumber = IdArray.this.size();
		}

		@Override
		public boolean hasNext() {
			if ((contor + 1) * 3 >= elemNumber)
				return false;
			return true;

		}

		@Override
		public String next() {
			if (hasNext())
				return IdArray.this.get(++contor * 3);
			else
				throw new NoSuchElementException("No more elements");

		}

		@Override
		public void remove() {
			if ((contor - 1) * 3 < elemNumber) {
				IdArray.this.remove((contor - 1) * 3);
				elemNumber--;
			}

		}

	}

	public class IteratorFirstLast implements Iterator<String> {
		private int elemNumber, contor = 0, first, last;

		public IteratorFirstLast() {
			elemNumber = IdArray.this.size();
			last = elemNumber - 1;
		}

		@Override
		public boolean hasNext() {
			if (contor < elemNumber)
				return true;
			return false;
		}

		@Override
		public String next() {
			if (hasNext())
				if (contor++ % 2 == 0)
					return IdArray.this.get(first++);
				else
					return IdArray.this.get(last--);
			else
				throw new NoSuchElementException("No more elements");
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}
