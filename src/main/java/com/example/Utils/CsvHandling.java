package com.example.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.Model.MenuItemModel;
import com.example.Model.MenuModels.GenericMenuModel;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CsvHandling {
    // the delimiter to use for separating entries
    private static final char DEFAULT_SEPARATOR = ',';
     
    // the character to use for quoted elements
    private static final char DEFAULT_QUOTE = '"';
     
    // the line number to skip for start reading 
    private static final int NUM_OF_LINE_SKIP = 1;

    String[] headerRecord = { "id", "name", "description", "price", "image" };

    private static CsvHandling csvHandling;
    public static CsvHandling getInstance(){
        if (csvHandling == null) {
            csvHandling = new CsvHandling();
        }
        return csvHandling;
    }
    
    public void csvWriter(String pathString, GenericMenuModel genericMenuModel) throws IOException{
        try (Writer writer = new FileWriter(pathString);
            CSVWriter csvWriter = new CSVWriter(writer, 
                    CSVWriter.DEFAULT_SEPARATOR, 
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                    CSVWriter.DEFAULT_LINE_END);) {
                        csvWriter.writeNext(headerRecord);
                        ArrayList< MenuItemModel> menuItemModels = genericMenuModel.getMenuItemList();
                        for (MenuItemModel menuItemModel : menuItemModels) {
                            csvWriter.writeNext(new String[] { Integer.toString(menuItemModel.getId()), menuItemModel.getName(), menuItemModel.getDescription(), 
                                Double.toString(menuItemModel.getPrice()), menuItemModel.getImage() });
                        }

                        System.out.println("csvWriter is successfull");
                    }
    }

    public void csvReader(String pathString, GenericMenuModel genericMenuModel) throws IOException {
         try (Reader reader = new FileReader(pathString); 
            CSVReader csvReader = new CSVReader(reader);) {
            // Reading Records One by One in a String array
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                System.out.println("Country [id= " + line[0] 
                        + ", code= " + line[1] 
                        + " , name=" + line[2] + "]");
            }
        }
    }

    public void parseCSVtoBean(GenericMenuModel genericMenuModel) throws FileNotFoundException {
        List<MenuItemModel> beans = new CsvToBeanBuilder<MenuItemModel>(new FileReader(genericMenuModel.getcsvDbPath()))
                .withType(MenuItemModel.class)
                .build()
                .parse();
        
        genericMenuModel.setMenuItemList(new ArrayList<MenuItemModel>(beans));
    }
}
