package com.hhwy.test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiWriteExcelFile {

	public static void main(String[] args) {
		
		List<String> firstRow = new ArrayList<>();
		firstRow.add("rowName01");
		firstRow.add("rowName02");
		firstRow.add("rowName03");
		
		List<List<Object>> rowData = new ArrayList<List<Object>>();
		
		for (int i = 0; i < 10; i++) {
			List<Object> arrayList = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				int number = (int) (Math.random()*23);
				arrayList.add("abcdefghijklmnopqrstuvwxyz".substring(number, number + 3));
			}
			rowData.add(arrayList);
		}
		
		HSSFWorkbook workBook = PoiWriteExcelFile.createWorkBook("sheetName", firstRow, rowData);
		
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("D:\\test01.xls");
			workBook.write(fileOut);
			fileOut.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fileOut!=null){
				try {
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
//		FileOutputStream fileOut = null;
//		
//		HSSFWorkbook workbook = null;
//		
//		try {
//			//创建输出流
//			fileOut = new FileOutputStream("D:\\poi-test.xls");
//			//excel
//			workbook = new HSSFWorkbook();
//			
//			//sheet对象
//			HSSFSheet worksheet = workbook.createSheet("POI Worksheet");
//			
//			//行
//			HSSFRow row1 = worksheet.createRow((short) 0);
//			
//			//第一个单元格
//			HSSFCell cellA1 = row1.createCell(0);
//			
//			cellA1.setCellValue("Hello");
//			
//			//设置单元格样式
//			HSSFCellStyle cellStyle = workbook.createCellStyle();
//			cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
//			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//			cellA1.setCellStyle(cellStyle);
//			
//			//第二个单元格
//			HSSFCell cellB1 = row1.createCell(1);
//			cellB1.setCellValue("Goodbye");
//			
//			//设置单元格样式
//			cellStyle = workbook.createCellStyle();
//			cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
//			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//			cellB1.setCellStyle(cellStyle);
//			
//			//第三个单元格
//			HSSFCell cellC1 = row1.createCell(2);
//			cellC1.setCellValue(true);
//			
//			//第四个单元格
//			HSSFCell cellD1 = row1.createCell(3);
//			cellD1.setCellValue(new Date());
//			cellStyle = workbook.createCellStyle();
//			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
//			cellD1.setCellStyle(cellStyle);
//
//			workbook.write(fileOut);
//			fileOut.flush();
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally{
//			
//			if(fileOut!=null){
//				try {
//					fileOut.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if(workbook!=null){
//				try {
//					workbook.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
	public static HSSFWorkbook createWorkBook(String sheetName,List<String> firstRow,List<List<Object>> rowData) {
		
		HSSFWorkbook wb = null;
		try {
			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName);	//建立新的sheet对象
			
			HSSFRow row = sheet.createRow(0);				//建立第一行，行头
			
			int size = firstRow.size();						
			for (int i = 0; i < size; i++) {
				row.createCell(i).setCellValue(firstRow.get(i));
			}
			for (int i = 0; i < rowData.size(); i++) {
				size = rowData.get(i).size();
				row = sheet.createRow(i + 1);
				for (int j = 0; j < size; j++) {
					row.createCell(j).setCellValue(rowData.get(i).get(j).toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(wb!=null){
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return wb;
	}
}
