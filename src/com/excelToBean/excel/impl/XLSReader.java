/**
 * 
 */
package com.excelToBean.excel.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * The implementation of {@link ExcelReader} using Apache POI support reading
 * <strong>xls</strong> file format.
 * format
 * 
 * @author PraveenRaj D
 * 
 */
public class XLSReader<T> extends AbstractExcelReader<T, HSSFWorkbook>
{

	public XLSReader(Class<T> beanClass, InputStream stream) throws IOException
	{
		super(beanClass, new HSSFWorkbook(stream));
	}
}
