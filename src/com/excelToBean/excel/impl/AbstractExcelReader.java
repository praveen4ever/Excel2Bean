/**
 * 
 */
package com.excelToBean.excel.impl;

import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;






/**
 * @author PraveenRaj D
 * 
 */
public abstract class AbstractExcelReader<T, W extends Workbook> implements ExcelReader<T>
{
	private final Class<T> beanClass;
	private final W workbook;

	public AbstractExcelReader(Class<T> beanClass, W workbook)
	{
		this.beanClass = beanClass;
		this.workbook = workbook;
	}

	public final Class<T> getBeanClass()
	{
		return this.beanClass;
	}

	public final W getWorkbook()
	{
		return this.workbook;
	}

	@Override
	public final List<T> read(String sheetName)
	{
		Sheet sheet = getWorkbook().getSheet(sheetName);
		if (sheet != null)
		{
			 List<T> list = Collections.list(new SheetEnumerator<>(sheet, getBeanClass()));
			 return list;
		}
		return null;
	}
}