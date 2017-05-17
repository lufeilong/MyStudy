package com.hhwy.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDbUpdate {
	
	public static void main(String[] args) {
		String fileName = "D:\\fortest.xlsx";
		List<List<XSSFCell>> dataHolder = read(fileName);
		saveToDatabase(dataHolder);
	}

	public static List<List<XSSFCell>> read(String fileName) {
		
		List<List<XSSFCell>> cellVectorHolder = new ArrayList<List<XSSFCell>>();
		XSSFWorkbook myWorkBook = null;
		
		try {
			FileInputStream myInput = new FileInputStream(fileName);
			myWorkBook = new XSSFWorkbook(myInput);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIter = mySheet.rowIterator();
			
			while (rowIter.hasNext()) {
				
				XSSFRow myRow = (XSSFRow) rowIter.next();
				Iterator<Cell> cellIter = myRow.cellIterator();
				//用于保存每行数据的List，一个元素表示一个cell单元格
				List<XSSFCell> list = new ArrayList<XSSFCell>();
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					list.add(myCell);
				}
				cellVectorHolder.add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(myWorkBook!=null){
				try {
					myWorkBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cellVectorHolder;
	}

	private static void saveToDatabase(List<List<XSSFCell>> dataHolder) {

		for (Iterator<List<XSSFCell>> iterator = dataHolder.iterator(); iterator.hasNext();) {
			
			List<XSSFCell> list = (List<XSSFCell>) iterator.next();
			
			for (XSSFCell xssfCell : list) {
				System.out.println(xssfCell.toString());
			}
		}
	}
}