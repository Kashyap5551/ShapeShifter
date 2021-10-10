package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTechnique {

	public static List<Shape> sortShapes(List<Shape> list) {

		for (int j = 1; j < list.size(); j++) {
			Shape current = list.get(j);
			int i = j - 1;
			while ((i > -1) && ((list.get(i).compareTo(current)) == 1)) {
				list.set(i + 1, list.get(i));
				i--;
			}
			list.set(i + 1, current);

		}
		return list;

	}
}
