/**
 * 
 */
package com.excelToBean.excel.core;

/**
 * Determines a true or false value for a given input.
 * 
 * @author PraveenRaj D
 * 
 */
public interface Predicate<T>
{
	/**
	 * Returns the result of applying this predicate to {@code input}.
	 * 
	 * @param input
	 * @return
	 */
	boolean apply(T input);
}
