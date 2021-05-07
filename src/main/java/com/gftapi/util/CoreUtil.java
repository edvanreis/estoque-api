package com.gftapi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CoreUtil {
	
	/**
	 *Próposito: valida se a lista esta preenchida
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
	
	/**
	 * Próposito: converter price de string para bigdecimal
	 * 
	 * @param dto
	 * @return
	 */
	public static BigDecimal princeToBigDecimal(String value) {
		if (value != null && !value.isEmpty()) {
			value = value.replace("$", "");
			value = value.toString();
			return new BigDecimal(value);
		}
		return null;
	}

	/**
	 * Próposito: converter price de string para bigdecimal
	 * 
	 * @param dto
	 * @return
	 */
	public static String princeToString(BigDecimal value) {
		String priceStr = null;
		if (value != null) {
			value = value.setScale(2, RoundingMode.HALF_EVEN);
			priceStr = "$" + value.toString();
		}
		return priceStr;
	}

}
