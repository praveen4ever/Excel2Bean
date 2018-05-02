/**
 * 
 */
package com.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.excelToBean.excel.impl.ExcelReader;
import com.excelToBean.excel.impl.XLSReader;




/**
 * @author PraveenRaj
 * 
 */
public class Main {

	public static void main(String[] args) throws Exception {

		FileInputStream in = new FileInputStream("C://Chandra//test.xls");

		ExcelReader<SalComponet> reader = new XLSReader<>(SalComponet.class, in);
		List<SalComponet> result = reader.read("user");
		for (SalComponet salComponet : result) {
			System.out.println("getComponentID "+salComponet.getComponentID() + " getComponentName "
					+ salComponet.getComponentName() + " getComponentAmount "
					+ salComponet.getComponentAmount() + " getComponentMaxAmount "
					+ salComponet.getComponentMaxAmount() + " isEnabled "
					+ salComponet.isEnabled()  + " getExpiryDate "
					+salComponet.getExpiryDate());
			System.out.println();

		}

	}

}
