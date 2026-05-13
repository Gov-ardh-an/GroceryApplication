package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	public static FileInputStream f;// non primitive data type
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static String readStringData(int i, int j, String sheet) throws IOException
	{
		f=new FileInputStream(Constant.TESTDATA);
		w= new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		
		XSSFRow r=s.getRow(i);
		XSSFCell c=r.getCell(j);
		return c.getStringCellValue();
	}
		public static double readIntegerData(int i, int j, String sheet) throws IOException
		{
			f=new FileInputStream(Constant.TESTDATA);
			w= new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			
			XSSFRow r=s.getRow(i);
			XSSFCell c=r.getCell(j);
			return c.getNumericCellValue();
			
		}

}
