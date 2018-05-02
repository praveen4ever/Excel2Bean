/**
 * 
 */
package com.excelToBean.excel.impl;

import com.excelToBean.excel.core.CellMapping;



/**
 * Default implementation of {@link CellMapping}
 * 
 * @author PraveenRaj D
 * 
 */
public class CellMappingLocal implements CellMapping
{

	private int pos;
	private String prop;
	private Class<?> type;

	private CellMappingLocal(int pos, String prop, Class<?> type)
	{
		this.pos = pos;
		this.prop = prop;
		this.type = type;
	}

	@Override
	public int getCellPosition()
	{
		return this.pos;
	}

	@Override
	public String getPropertyName()
	{
		return this.prop;
	}

	@Override
	public Class<?> getCellType()
	{
		return this.type;
	}

	public static CellMapping newCellMapping(int pos, String prop, Class<?> type)
	{
		return new CellMappingLocal(pos, prop, type);
	}
}
