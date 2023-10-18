package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegrationCode {
public  ArrayList<String> GetData(String testCaseName) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:/Users/ajay.mareedu/STORE Regression Report 23.i08.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int NoOfSheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<NoOfSheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("SFLYCAChrome"))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				Iterator<Row> Rows=sheet.iterator();
				Row r=Rows.next();			
				Iterator<Cell> ce =r.cellIterator();
			int coloumn=0;
			int k=0;
				while(ce.hasNext()) {
					
					Cell value = ce.next();
					
					if(value.getStringCellValue().equalsIgnoreCase("Section"))
					{
						
						
						coloumn=k;
						
					}k++;
				
					
					
				}System.out.println(coloumn);
				
				while (Rows.hasNext()) 
				{
					
					Row value= Rows.next();
					
			if(value.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)) 
			{
				Iterator<Cell> cr= value.cellIterator();	
				while(cr.hasNext())
				{
					Cell cv = cr.next();
					if(cv.getCellType()==CellType.STRING) {
						
						  a.add(cr.next().getStringCellValue());
					}else {
						
						a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
						
					}
						
			        
				}
					
				
			}
				
			}
			    
		}
		
	}
		return a;
	}
}
