package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import node.Equipment;
import node.Type;

public class TestEquipments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	String fileName = "./data/M1_UE82_Projet_2016_Donnees_Test.xlsm";
	List<Equipment> equipements = new ArrayList<Equipment>();
	Map<String,Equipment> equipments = new HashMap<String, Equipment>();
	try {

		 Workbook workbook;
		 workbook = new XSSFWorkbook(
		     OPCPackage.open(fileName)
		 );

		 //DO STUF WITH WORKBOOK

		 /*FileOutputStream out = new FileOutputStream(new File(fileName));
		 workbook.write(out);
		 out.close();
		 System.out.println("xlsm created successfully..");*/

		 
		 
		 XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Data");
		 Iterator rowIterator = sheet.rowIterator();  
		 //List<XSSFTable> xtables =  sheet.getTables();
		 //int intRowNumber = 0;  
		 
		 int[][] charge = new int[3][];
		 
		 for(int i = 0 ; i < charge.length;i++)
			 charge[i] = new int[18];
		 
		 while(rowIterator.hasNext()){
			 Row row =  (Row) rowIterator.next();  
			
			 if(row.getRowNum() == 2){
				 for( int i = 0; i < charge.length;i++){
					 for(int j = 0 ; j <charge[i].length;j++){
						 charge[i][j] = (int) row.getCell(j+3).getNumericCellValue();
					 }
					 row = (Row) rowIterator.next();
				 }
			 }
			 
			 
			 
			/*if(row.getRowNum() > 7 && row.getCell(2)!= null) { 
				if(row.getCell(2).getNumericCellValue() == 1){
					equipements.add(new Equipment(row.getCell(1).toString(),Type.TYPE1,charge[0]));
				}
				 
				if(row.getCell(2).getNumericCellValue() == 2){
					equipements.add(new Equipment(row.getCell(1).toString(),Type.TYPE2,charge[1]));
				}
					
				if(row.getCell(2).getNumericCellValue() == 3){
					equipements.add(new Equipment(row.getCell(1).toString(),Type.TYPE3,charge[2]));
				}
			 }*/
				
			 
			 if(row.getRowNum() > 7 && row.getCell(2)!= null) { 
					if(row.getCell(2).getNumericCellValue() == 1){
						//equipements.add(new Equipment(row.getCell(1).toString(),Type.TYPE1,charge[0]));
						equipments.put(row.getCell(1).toString()
								, new Equipment(row.getCell(1).toString(),Type.TYPE1,charge[0]));
					}
					 
					if(row.getCell(2).getNumericCellValue() == 2){
						equipments.put(row.getCell(1).toString()
								, new Equipment(row.getCell(1).toString(),Type.TYPE2,charge[1]));
					}
						
					if(row.getCell(2).getNumericCellValue() == 3){
						equipments.put(row.getCell(1).toString()
								, new Equipment(row.getCell(1).toString(),Type.TYPE3,charge[2]));
					}
			 }
			 //System.out.println(row.getRowNum());
		 }
		for(int i : charge[0])
			System.out.print(i);
		System.out.println();
		for(int i : charge[1])
			System.out.print(i);
		System.out.println();
		for(int i : charge[2])
			System.out.print(i);
		System.out.println();
	     System.out.println("got sheet");
	     
	    // for(Equipment e : equipements)
	    //	 System.out.println(e.toString());
	    System.out.println(equipments.size());
	    
	    /**
	     * 
	     * test for hashmap
	     * 
	     * 
	     */
	    Set set = equipments.entrySet();
	    
	    Iterator i = set.iterator();
	    int j = 0;
	    while(i.hasNext()){
	    	Map.Entry x = (Map.Entry)i.next();
	    	System.out.print(x.getKey() + ": ");
	        System.out.println(x.getValue());
	        j++;
	    }
	    System.out.println(j);
		 
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (InvalidFormatException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
