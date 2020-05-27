import java.util.ArrayList;

public class Sort<T extends Comparable<T>> {

	private final ArrayList<T> toSort;

	public Sort(ArrayList<T> toSort) {
		this.toSort = toSort;
		mergeSort(toSort);
	}

	public ArrayList<T> get() {
		return toSort;
	}


	private void mergeSort(ArrayList<T> a) {
		int mid = a.size() / 2;
		ArrayList<T> l = new ArrayList<>(mid);
		ArrayList<T> r = new ArrayList<>(a.size() - mid);

		for (int i = 0; i < mid; i++) {
			l.set(i, a.get(i));
		}
		for (int i = mid; i < a.size(); i++) {
			r.set(i - mid, a.get(i));
		}
		mergeSort(l);
		mergeSort(r);

		merge(a, l, r);
	}

	private void merge(
			ArrayList<T> a, ArrayList<T> l, ArrayList<T> r) {

		int i = 0, j = 0, k = 0;
		while (i < l.size() && j < r.size()) {
			if (l.get(i).compareTo(r.get(j)) <= 0) {
				//a[k++] = l[i++];
				a.set(k++, l.get(i++));
			}
			else {
				a.set(k++, r.get(j++));
			}
		}
		while (i < l.size()) {
			a.set(k++, l.get(i++));
		}
		while (j < r.size()) {
			a.set(k++, r.get(j++));
		}
	}
}
