package Utilities;

import Actions.CommonActions;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import javax.rmi.CORBA.Util;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectRepositoryUtils {

    private static ObjectRepositoryUtils _instance = new ObjectRepositoryUtils();
    private static CommonActions commonActions;


    ObjectRepositoryUtils()
    {
        commonActions = Utils.GetCommonActions();
    }

    public static ObjectRepositoryUtils Instance() {return _instance;}

    Map<String, List<String>> database = Collections.synchronizedMap(new ConcurrentHashMap<String, List<String>>());

    /**
     * Read all data of the csv and store as a database.
     */
    public void TestDataReader(String csvFile)  {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // custom separator
        try(CSVReader reader = new CSVReaderBuilder(
                new FileReader(csvFile))
                .withCSVParser(csvParser)   // custom CSV parser
                .build())
        {
            String[] lineInArray;
            List<String> dataList = new ArrayList<String>();

            //database.put("init", dataList);

            lineInArray = reader.readNext();
            while ((lineInArray = reader.readNext()) != null) {

                if(lineInArray.length==3) {
                    dataList = Arrays.asList(lineInArray);
                    database.put(lineInArray[0], dataList.subList(1, lineInArray.length));
                    }
            }

            commonActions.PrintReportMessage("Se pudieron recuperar los valores del fichero de Objetos: " + csvFile);
            //System.out.println(database);

        }catch (Exception e){
            commonActions.PrintReportMessage("No se pudieron recuperar los valores del fichero de objetos: " + csvFile);
            e.printStackTrace();
        }
    }

    /**
     * Take the data from csv file with objectName and the name of the column data.
     *
     * @param objectName
     *            The objectName of the test case that you need to search.
     * @return The value of the column data in the line of the objectName in the csv.
     */
    public String ObjectID(String objectName)
    {
        try{
            //return database[objectName][1];
            return database.get(objectName).get(1);
        } catch (NullPointerException npe) {
            commonActions.PrintReportMessage("Excepción NULL. Devuelve un NULL del repositorio");
            throw npe;
        }catch (Exception e){
            commonActions.PrintReportMessage("ERROR Repositorio de Objetos. Identificador de objeto: "+objectName+". No se encuentra en el repositorio de Objetos");
            throw e;
        }

    }

    /**
     * Take the data from csv file with objectName and the name of the column data.
     *
     * @param objectName
     *            The objectName of the test case that you need to search.
     * @return The type value of the column data in the line of the objectName in the csv.
     * @throws Exception objectName not found
     */
    public String TypeObjectID(String objectName)
    {
        //return database[objectName][0];
        //System.out.println("1,, "+ database.get(objectName).get(1));
        try {
            return database.get(objectName).get(0);
        } catch (NullPointerException npe) {
            commonActions.PrintReportMessage("Excepción NULL. Devuelve un NULL del repositorio");
            throw npe;
        } catch (Exception e){
            commonActions.PrintReportMessage("ERROR Repositorio de Objetos. Tipo de objeto: "+objectName+". No se encuentra en el repositorio de Objetos");
            throw e;
        }

    }
 }

