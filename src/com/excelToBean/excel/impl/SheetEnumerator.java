/**
 * 
 */
package com.excelToBean.excel.impl;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.excelToBean.excel.core.CellMapping;


/**
 * @author PraveenRaj D
 */
public class SheetEnumerator<T> implements Enumeration<T>
{
	private final Iterator<Row> iRows;
	private final Class<T> beanClass;

	private List<CellMapping> cellMappings;
	private BeanWriter<T> beanWriter;

	public SheetEnumerator(final Sheet sheet, Class<T> clazz)
	{
		this.iRows = sheet.iterator();
		this.beanClass = clazz;
		this.beanWriter = new BeanWriter<>(this.beanClass);
		this.cellMappings = new CellMappingBuilderLocal(this.beanClass, sheet).buildCellMappings();

		ignoreFirstRow();
	}

	/**
	 * Always ignore the first row. The first row is header row.
	 */
	private void ignoreFirstRow()
	{
		if (this.iRows.hasNext())
		{
			this.iRows.next();
		}
	}

	@Override
	public boolean hasMoreElements()
	{
		return this.iRows.hasNext();
	}

	@Override
	public T nextElement()
	{
		try
		{
			Row row = this.iRows.next();

			T bean = this.beanClass.newInstance();

			populate(bean, row);

			return bean;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			return null;
		}
	}

	/**
	 * Populate a bean with data from {@link Row}.
	 * 
	 * @param bean
	 *            the bean
	 * @param row
	 *            the row in sheet.
	 */
	private void populate(final T bean, Row row)
	{
		Iterator<Cell> i = row.cellIterator();
		while (i.hasNext())
		{
			Cell cell = i.next();

			CellMapping mapping = cellMapping(cell);

			if (mapping != null)
			{
				this.beanWriter.writeTo(bean, cell, mapping);
			}
		}
	}

	private CellMapping cellMapping(Cell cell)
	{
		int index = cell.getColumnIndex();
		for (CellMapping mapping : this.cellMappings)
		{
			if (mapping.getCellPosition() == index)
			{
				return mapping;
			}
		}
		return null;
	}
}
