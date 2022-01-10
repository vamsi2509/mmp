package library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path=null;

	public XLUtility(String path) {
	this.path=path;
	}

	public int getRowCount(String sheetname) throws IOException
	{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	int rowcount=sheet.getLastRowNum();
	fi.close();
	return rowcount;
	}

	public int getCellCount(String sheetname,int rownum) throws IOException
	{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	fi.close();
	return cellcount;
	}
	public String getCellData(String sheetname,int rownum,int colnum) throws IOException
	{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	DataFormatter formatter=new DataFormatter();
	String data;
	try
	{
	data=formatter.formatCellValue(cell);
	}
	catch(Exception e)
	{
	data="";
	}
	fi.close();
	return data;
	}

	public void setCellData(String sheetname,int rownum,int colnum,String data) throws IOException
	{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetname);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fo=new FileOutputStream(path);
	workbook.write(fo);
	fi.close();
	fo.close();

	}


}
