/**
 * 
 */
package com.excelToBean.excel.impl;


import java.util.List;

/**
 * Read an excel file and convert each row into a object {@link T}
 * 
 * @author PraveenRaj D
 * 
 */
public interface ExcelReader<T>
{
	/**
	 * Read sheet with given name of excel file.
	 * 
	 * @param sheetName
	 *            the sheet name
	 * @return the enumerator or NULL if sheet does not exist
	 */
	List<T> read(String sheetName);
}
