package com.competella.qaframework.parsers;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelParser {

	private static final Logger LOGGER = Logger.getLogger(ExcelParser.class);
	private static final String FILE_PATH = "C:\\Users\\talhas\\Desktop\\Data\\Office\\Automations\\Eclipes\\qaframework\\src\\utl\\CompetellaRLog2.xlsx";
    private Multimap<String, String> values = HashMultimap.create();

    private XSSFWorkbook myExcelBook;
    private List<String> headList = new ArrayList();

	public Multimap getStatisticDataMap() {
		getHeader();
		addHeaderAndDataToMap();
		LOGGER.debug("Total values in statistics sheet : " + values.size());
		return values;
	}

    private void getHeader()  {
    	try {
			myExcelBook = new XSSFWorkbook(new FileInputStream(FILE_PATH));
			XSSFSheet myExcelSheet = myExcelBook.getSheet("CompetellaResult");

			Row headRow = myExcelSheet.getRow(0);

			for (Cell item : headRow) {
				String cellValue = item.toString();
				headList.add(cellValue);
			}
		} catch(IOException ex) {
			String errorMessage = "Failed to read header of excel file. ";
    		LOGGER.error(errorMessage, ex);
    		throw new IllegalStateException(errorMessage);
		}
    }

    private void addHeaderAndDataToMap() {
		try {
			myExcelBook = new XSSFWorkbook(new FileInputStream(FILE_PATH));
		} catch (IOException ex) {
			String errorMessage = "Failed to read the excel file. ";
			LOGGER.error(errorMessage, ex);
			throw new IllegalStateException(errorMessage);
		}

        XSSFSheet myExcelSheet = myExcelBook.getSheet("CompetellaResult");

        int index = myExcelSheet.getPhysicalNumberOfRows();
        for (int i = 1; i <= index; i++) {
            Row myRow1 = myExcelSheet.getRow(i);
            for (String item : headList) {
                Cell cell = myRow1.getCell(headList.indexOf(item));

                String newItem = item + index;

                if (cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
					values.put(newItem, "");
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    Date cellValueDate = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat();
                    String newDateFormat = "yyyy-MM-dd HH:mm:ss";
                    sdf.applyPattern(newDateFormat);
                    String newDateString = sdf.format(cellValueDate);
					values.put(newItem, newDateString);
                } else {
					values.put(newItem, cell.toString());
                }
            }
            index--;
        }
    }
}

