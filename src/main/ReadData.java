package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import node.Agent;
import node.AgentID;
import node.Equipment;
import node.Type;

public class ReadData {

	
	private static Map<String, Equipment> equipments = new HashMap<String, Equipment>();
	private static List<Agent> agents = new LinkedList<Agent>();
	private static int[][] charge = new int[3][];
	
	static String fileName = "./data/M1_UE82_Projet_2016_Donnees_Test.xlsm";

	public static void readEquipments() {
		try {

			Workbook workbook;
			workbook = new XSSFWorkbook(OPCPackage.open(fileName));
			// read from Data sheet
			XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Data");
			Iterator rowIterator = sheet.rowIterator();

			// 3 charges lines
			
			for (int i = 0; i < charge.length; i++)
				charge[i] = new int[18];

			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();

				// Read charges
				if (row.getRowNum() == 2) {
					for (int i = 0; i < charge.length; i++) {
						for (int j = 0; j < charge[i].length; j++) {
							charge[i][j] = (int) row.getCell(j + 3).getNumericCellValue();
						}
						row = (Row) rowIterator.next();
					}
				}

				// Read equipments
				if (row.getRowNum() > 7 && row.getCell(2) != null) {
					if (row.getCell(2).getNumericCellValue() == 1) {
						equipments.put(row.getCell(1).toString(),
								new Equipment(row.getCell(1).toString(), Type.TYPE1, charge[0]));
					}

					if (row.getCell(2).getNumericCellValue() == 2) {
						equipments.put(row.getCell(1).toString(),
								new Equipment(row.getCell(1).toString(), Type.TYPE2, charge[1]));
					}

					if (row.getCell(2).getNumericCellValue() == 3) {
						equipments.put(row.getCell(1).toString(),
								new Equipment(row.getCell(1).toString(), Type.TYPE3, charge[2]));
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	public static void readClusters(){
		try {

			 Workbook workbook;
			 workbook = new XSSFWorkbook(
			     OPCPackage.open(fileName)
			 );
			
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
			 
			 
			 agents.add(agent1);
			 agents.add(agent2);
			 agents.add(agent3);
			 agents.add(agent4);
			 agents.add(agent5);
			 agents.add(agent6);
			 
			
			 
			 
			 
			 
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (InvalidFormatException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			}
	}
	
	
	
	public static void main(String[] args) {
		/**
	     * 
	     * test for hashmap
	     * 
	     * 
	     */
		readEquipments();
	   /* Set set = equipments.entrySet();
	    
	    Iterator i = set.iterator();
	    int j = 0;
	    while(i.hasNext()){
	    	Map.Entry x = (Map.Entry)i.next();
	    	System.out.print(x.getKey() + ": ");
	        System.out.println(x.getValue());
	        j++;
	    }
	    System.out.println(j);*/
	    
	    readClusters();
	    
	    //for(Agent a : agents)
	    //	System.out.println(a.toString());
	    
	    System.out.println(agents.toString());
	}




	public static Map<String, Equipment> getEquipments() {
		return equipments;
	}




	public static List<Agent> getAgents() {
		return agents;
	}




	public static int[][] getCharge() {
		return charge;
	}

}
