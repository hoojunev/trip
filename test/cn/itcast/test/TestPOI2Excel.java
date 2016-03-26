package cn.itcast.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestPOI2Excel {

	@Test
	public void write03Excel() {
		try {
			//1、创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//2、创建工作表
			HSSFSheet sheet = workbook.createSheet("Hello World");
			
			//3、创建行，创建第3行
			HSSFRow row = sheet.createRow(2);
			//4、创建单元格，创建第3行第3列
			HSSFCell cell = row.createCell(2);
			
			cell.setCellValue("Helll World!");
			
			FileOutputStream outputStream = new FileOutputStream("D:\\itcast\\测试.xls");
			//将文件写到输出流
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void read03Excel() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\itcast\\测试.xls");
			//1、读取工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			//2、读取工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			//3、读取行,第3行
			HSSFRow row = sheet.getRow(2);
			//4、读取单元格，第3行第3列
			HSSFCell cell = row.getCell(2);
			System.out.println("第3行第3列单元格的内容为：" + cell.getStringCellValue());
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void write07Excel() {
		try {
			//1、创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			//2、创建工作表
			XSSFSheet sheet = workbook.createSheet("Hello World");
			//3、创建行，创建第3行
			XSSFRow row = sheet.createRow(2);
			//4、创建单元格，创建第3行第3列
			XSSFCell cell = row.createCell(2);
			
			cell.setCellValue("Helll World!");
			
			FileOutputStream outputStream = new FileOutputStream("D:\\itcast\\测试.xlsx");
			//将文件写到输出流
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void read07Excel() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\itcast\\测试.xlsx");
			//1、读取工作簿
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			//2、读取工作表
			XSSFSheet sheet = workbook.getSheetAt(0);
			//3、读取行,第3行
			XSSFRow row = sheet.getRow(2);
			//4、读取单元格，第3行第3列
			XSSFCell cell = row.getCell(2);
			System.out.println("第3行第3列单元格的内容为：" + cell.getStringCellValue());
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExcelStyle() {
		try {
			//1、创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1、创建合并单元格对象(起始行号，结束行号，起始列号，结束列号)，合并第3行第3列到第5列
			CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 4);
			//1.2、创建单元格样式
			HSSFCellStyle style = workbook.createCellStyle();
			//水平居中
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//垂直居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			//1.3、创建字体
			HSSFFont font = workbook.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体加粗
			font.setFontHeightInPoints((short)16);//设置字体大小为16号字体
			
			//样式中加载字体
			style.setFont(font);
			
			//设置样式背景
			//设置填充模式
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//以填充的前景色作为单元格的背景色
			style.setFillBackgroundColor(HSSFColor.GREEN.index);
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
			
			//2、创建工作表
			HSSFSheet sheet = workbook.createSheet("Hello World");
			//2.1、加载合并单元格对象
			sheet.addMergedRegion(cellRangeAddress);
			
			//3、创建行，创建第3行
			HSSFRow row = sheet.createRow(2);
			//4、创建单元格，创建第3行第3列
			HSSFCell cell = row.createCell(2);
			//4.1、加载单元格样式
			cell.setCellStyle(style);
			
			cell.setCellValue("Helll World!");
			
			FileOutputStream outputStream = new FileOutputStream("D:\\itcast\\测试.xls");
			//将文件写到输出流
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
