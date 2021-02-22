package com.github.apeforge.ironape.commons.util;

import java.util.Collection;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isEmpty(Collection<?> list) {
		return ((list == null) || (list.isEmpty()));
	}

	public static boolean isNotEmpty(Collection<?> list) {
		return (!(isEmpty(list)));
	}

	public static boolean isIn(Collection<?> list, Object object) {
		if (isNotEmpty(list) && isNotNull(object))
			return list.contains(object);

		return false;
	}

	public static boolean isNotIn(Collection<?> list, Object object) {
		return (!(isIn(list, object)));
	}

	private static boolean isNull(Object object) {
		return (object == null);
	}

	private static boolean isNotNull(Object object) {
		return (!(isNull(object)));
	}
}
