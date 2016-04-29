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

import node.Agent;
import node.AgentID;
import node.Equipment;
import node.Type;

public class TestClusters2 {

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
								, new Equipment(row.getCell(1).toString(),Type.TYPE1,charge[1]));
					}
						
					if(row.getCell(2).getNumericCellValue() == 3){
						equipments.put(row.getCell(1).toString()
								, new Equipment(row.getCell(1).toString(),Type.TYPE1,charge[2]));
					}
			 }
			 //System.out.println(row.getRowNum());
		 }
		/*for(int i : charge[0])
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
	    System.out.println(equipments.size());*/
	    
	   /* *//**
	     * 
	     * test for hashmap
	     * 
	     * 
	     *//*
	    Set set = equipments.entrySet();
	    
	    Iterator i = set.iterator();
	    int j = 0;
	    while(i.hasNext()){
	    	Map.Entry x = (Map.Entry)i.next();
	    	System.out.print(x.getKey() + ": ");
	        System.out.println(x.getValue());
	        j++;
	    }
	    System.out.println(j);*/
		 
		 
		 
			Agent agent1 = new Agent(AgentID.AGENT1);
			Agent agent2 = new Agent(AgentID.AGENT2);
			Agent agent3 = new Agent(AgentID.AGENT3);
			Agent agent4 = new Agent(AgentID.AGENT4);
			Agent agent5 = new Agent(AgentID.AGENT5);
			Agent agent6 = new Agent(AgentID.AGENT6);
		 
		 
		 
		 XSSFSheet sheetClusters = (XSSFSheet) workbook.getSheet("Clusters");
		 Iterator rowIteratorClusters = sheetClusters.rowIterator();  

		 
		 while(rowIteratorClusters.hasNext()){
			 Row row =  (Row) rowIteratorClusters.next();  
			
			 /*if(row.getRowNum() >0 && row.getCell(1)!= null){
				 
				 if(row.getCell(1).toString().equals("Agent1")){
					 //System.out.println(row.getCell(1));
					 System.out.println(row.getCell(2));
					 if(row.getCell(2).toString().equals("Jeudi")){
						 agent1.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
					 }else{
						 agent1.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
					 }
				 }
			 }*/
			 if(row.getRowNum() >0 && row.getCell(1)!= null){
				 switch(row.getCell(1).toString()){
				    case "Agent1" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent1.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent1.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				    case "Agent2" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent2.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent2.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				    case "Agent3" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent3.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent3.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				    case "Agent4" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent4.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent4.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				    case "Agent5" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent5.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent5.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				    case "Agent6" :
				    	if(row.getCell(2).toString().equals("Jeudi")){
							 agent6.addEquipmentToThursday(equipments.get(row.getCell(3).toString()));
						 }else{
							 agent6.addEquipmentToWednesday(equipments.get(row.getCell(3).toString()));
						 }
				       break; 
				       
				    default : //Optional
				       //Statements
				 }
			 }
			}
		 
		 
		/* System.out.println("Agent1");
		 System.out.println("Jeudi");
		 for(Equipment e : agent1.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent1.getWednesday())
			 System.out.println(e.toString());
		 
		 System.out.println("Agent2");
		 System.out.println("Jeudi");
		 for(Equipment e : agent2.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent2.getWednesday())
			 System.out.println(e.toString());
		 
		 System.out.println("Agent3");
		 System.out.println("Jeudi");
		 for(Equipment e : agent3.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent3.getWednesday())
			 System.out.println(e.toString());
		 
		 
		 System.out.println("Agent4");
		 System.out.println("Jeudi");
		 for(Equipment e : agent4.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent4.getWednesday())
			 System.out.println(e.toString());
		 
		 
		 System.out.println("Agent5");
		 System.out.println("Jeudi");
		 for(Equipment e : agent5.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent5.getWednesday())
			 System.out.println(e.toString());
		 
		 
		 System.out.println("Agent6");
		 System.out.println("Jeudi");
		 for(Equipment e : agent6.getThursday())
			 System.out.println(e.toString());
		 System.out.println("Mercredi");
		 for(Equipment e : agent6.getWednesday())
			 System.out.println(e.toString());
		 */
		 
		 System.out.println(agent1.toString());
		 System.out.println(agent2.toString());
		 System.out.println(agent3.toString());
		 System.out.println(agent4.toString());
		 System.out.println(agent5.toString());
		 System.out.println(agent6.toString());
		 
		 System.out.println("here");
		 List<Agent> As = new ArrayList<Agent>();
		 As.add(agent1);
		 As.add(agent2);
		 As.add(agent3);
		 As.add(agent4);
		 As.add(agent5);
		 As.add(agent6);
		 
		 for(Agent a : As){
			 System.out.println(a);
		 }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (InvalidFormatException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
