package Utilities;

import Actions.CommonActions;
import Conditions.CommonConditions;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class TestDataUtils {
    private static TestDataUtils _instance = new TestDataUtils();
    public CommonActions commonActions;

    TestDataUtils()
    {
        commonActions = Utils.GetCommonActions();
    }

    public static TestDataUtils Instance()
    {
        return _instance;
    }

    Map<String, List<String>> database = Collections.synchronizedMap(new ConcurrentHashMap<String, List<String>>());
    //Map<String, List<String>> database = new ConcurrentHashMap<String, List<String>>();

    /**
     * Read all data of the csv and store as a database.
     */
    public void TestDataReader(String csvFile)  {
        Path myPath = Paths.get(csvFile);

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        try (CSVReader reader = new CSVReaderBuilder(Files.newBufferedReader(myPath,  StandardCharsets.UTF_8))
                .withCSVParser(csvParser)
                .build()) {
        /*
        try(CSVReader reader = new CSVReaderBuilder(
                new FileReader(csvFile))
                .withCSVParser(csvParser)   // custom CSV parser
                .build())
        {*/
            String[] lineInArray = null;
            List<String> dataList = new ArrayList<String>();

            while ((lineInArray = reader.readNext()) != null) {

                //Filas con con solo 1 columna son para comentarios
                if(lineInArray.length > 1) {
                    dataList = Arrays.asList(lineInArray);
                    database.put(lineInArray[0], dataList.subList(1, lineInArray.length));
                    //System.out.println("indi: "+lineInArray[0]+" lista "+dataList);
                    //System.out.println("lineaa: "+database.get("TESTID"));
                    //System.out.println("lineaa: "+database.get("android_FP_001"));
               }
            }
            commonActions.PrintReportMessage("Se pudieron recuperar los valores del fichero de datos: " + csvFile);
            //System.out.println(database);

        }catch (Exception e){
            commonActions.PrintReportMessage("No se pudieron recuperar los valores del fichero de datos: " + csvFile);
            e.printStackTrace();
        }
    }

    /**
     * Take the data from csv file with testID and the name of the column data.
     * @param testID The testID of the test case that you need to search.
     * @param columnData The name of the column data that you need to take.
     * @return The value of the column data in the line of the testID in the csv.
     */
    public String getDataFromRepository(String testID, String columnData)
    {
        try {
            int indexColumnData = database.get(Utils.GetRowIdentifier()).indexOf(columnData);
            return database.get(testID).get(indexColumnData);
        }catch(Exception e){
            commonActions.PrintReportMessage("ERROR Repositorio de Datos. No se pudo recuperar el valor del elemento " + columnData + " del caso " + testID);
            throw e;
        }

    }

    /***
     * Add a new column into the map and add the value.
     * @param testID
     * @param //newCaseID
     */
    public void addData(String testID, String columnData, String data)
    {
        /*
        int indexColumnData;

        if (database.get(testID).indexOf(columnData)!=-1)
        {
            indexColumnData = database.get(testID).indexOf(columnData);
        }
        else
        {
            database.get(testID).add(columnData);
            indexColumnData = database.get(testID).indexOf(columnData);
        }
        database.get(testID).get(indexColumnData).equals(data);

    //Ultimo paso
        List<String> changedList = database.get(testID);
        changedList.set(indexColumnData, data);
        database.put(testID,changedList);
        //database[testID][indexColumnData] = data; -> Visual Studio line
*/
        int indexColumnData;
    //añade la columna en la primera fila
        if (database.get(Utils.GetRowIdentifier()).indexOf(columnData)!=-1)
        {
            indexColumnData = database.get(Utils.GetRowIdentifier()).indexOf(columnData);
        }
        else
        {
            database.get(Utils.GetRowIdentifier()).add(columnData);
            indexColumnData = database.get(Utils.GetRowIdentifier()).indexOf(columnData);
        }

        database.get(Utils.GetRowIdentifier()).get(indexColumnData).equals(data);

        //Ultimo paso - Añade el nuevo valor a la fila correspondiente
        List<String> changedList = database.get(testID);
        changedList.set(indexColumnData, data);
        database.put(testID,changedList);

    }
}
