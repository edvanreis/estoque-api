package com.gftapi.util;

import java.util.List;

public class CoreUtil {
	
	/**
	 * valida se a lista esta preenchida
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isListNotEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
