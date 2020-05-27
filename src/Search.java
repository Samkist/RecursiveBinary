import java.util.ArrayList;

public class Search<T extends Comparable<T>> {
	private final ArrayList<T> toSearch;
	private final T toFind;
	private boolean contains;

	public Search(ArrayList<T> toSearch, T toFind) {
		this.toSearch = toSearch;
		this.toFind = toFind;
		contains = binarySearch( 0, toSearch.size() - 1) < 0 ? false : true;
	}

	public boolean get() {
		return contains;
	}

	int binarySearch(int l, int r)
	{
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at the middle itself
			if (toSearch.get(mid).equals(toFind))
				return mid;

			// If element is smaller than mid, then it can only
			// be present in left subarray
			if (toSearch.get(mid).compareTo(toFind) > 0)
				return binarySearch(l, mid - 1);

			// Else the element can only be present in right
			// subarray
			return binarySearch(mid + 1, r);
		}

		// We reach here when element is not present in array
		return -1;
	}

}
