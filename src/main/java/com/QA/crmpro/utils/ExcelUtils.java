package com.QA.crmpro.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static Workbook book;
	private static Sheet sheet;

	public static String TEST_DATA_FILE_PATH="./src/main/java/com/QA/crmpro/testdata/CrmProTestData.xlsx";

	public static Object[][] getTestData(String sheetname) {

		Object data[][]=null;

		try {
			FileInputStream fi=new FileInputStream(TEST_DATA_FILE_PATH);
			 book=WorkbookFactory.create(fi);
			 sheet=book.getSheet(sheetname);

			data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];


			for(int i=0; i<sheet.getLastRowNum(); i++) {

				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {

					data[i][j]=sheet.getRow(i+1).getCell(j).toString();

				}
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}



}
