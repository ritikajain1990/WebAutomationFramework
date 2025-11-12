package com.ui.dataprovider;

import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginProvider {


	@DataProvider(name="LoginTestDataProvider")
	public Iterator<User>  loginTestProvider () throws FileNotFoundException
	{
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"\\testData\\data.json");
		FileReader fileReader = new FileReader(file);

		TestData testdata=gson.fromJson(fileReader,TestData.class);
		List<User> dataToreturn = new ArrayList<User>();

		for(User user : testdata.getData())
		{
			dataToreturn.add(user);
		}

		return dataToreturn.iterator();
	}
	@DataProvider(name="LoginTestDataProviderwithCSV")
	public Iterator<User> loginTestProviderwithCSV () throws CsvValidationException, IOException {
		{
			Gson gson = new Gson();
			File file = new File(System.getProperty("user.dir")+"\\testData\\data.csv");
			FileReader fileReader = new FileReader(file);
			CSVReader csvReader = new CSVReader(fileReader);
			csvReader.readNext();//Skipping the column name 
			User user;
			List<User> line = new ArrayList<User>();
			String[] data;
			while((data=csvReader.readNext())!=null)
			{
				user= new User(data[0],data[1]);
				line.add(user);
			}

			return line.iterator();

		}
	}
	@DataProvider(name="LoginTestDataProviderwithExcel")
	public Iterator<User> loginTestProviderwithExcel () throws InvalidFormatException, IOException  
	{

		File file = new File(System.getProperty("user.dir")+"\\testData\\data.xlsx");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
		XSSFSheet sheet =xssfWorkbook.getSheet("loginSheet");
		Iterator<Row> itr=sheet.rowIterator();
		itr.next();
		User user;
		List<User> line = new ArrayList<User>();
		while(itr.hasNext())
		{  
			Row row =itr.next();
			Cell firstCell =row.getCell(0);
			Cell secondCell =row.getCell(1);
			user = new User(firstCell.toString(),secondCell.toString());
			line.add(user);

		}
return line.iterator();
	}

}
