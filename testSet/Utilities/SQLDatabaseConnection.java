package Utilities;
import Actions.CommonActions;

import java.net.URL;
import java.sql.*;

public class SQLDatabaseConnection {

    public String codigoConfirmacion;
    public CommonActions commonActions;
    //private static SQLDatabaseConnection _instance = new SQLDatabaseConnection();
    public SQLDatabaseConnection() {
        commonActions = Utils.GetCommonActions();
        codigoConfirmacion = null;
    }

    public String getCodigoConfirmacion (){
        return codigoConfirmacion;
    }

    public void ConexionBD() {

        Connection conn = null;

        try {
            //String conexion
            String dbURL = "jdbc:sqlserver://" +
                            "10.170.5.109;" +
                            //"CPDCASIOBD-PREN.idc.local;" +
                            "databaseName=Casiopea.MS.Security;";

            //Maquina MAC
            //"10.170.5.109;" +
            //Maquina Local
            //"CPDCASIOBD-PREN.idc.local;" +

            String user = "casiopea.HCE";
            String pass = "HCE";

           /*
                    */

            //driver
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //DriverManager.registerDriver(new SQLServerDriver());
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //Class.forName("com.mysql.jdbc.Driver");

            //Conexion
            conn = DriverManager.getConnection(dbURL, user, pass);
            //conn.setAutoCommit(false);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

            //Conexion valida
            System.out.println("Conexion BD correcta: "+conn.isValid(60));

            //Ejecución QUERY
            String selectSql="SELECT top (1) [VerifyCode]\n" +
                    "FROM [Casiopea.MS.Security].[Security].[VerifyCode] v with (nolock)\n" +
                    "inner join [Casiopea.MS.Security].[Security].[User] u with (nolock) on u.Id=v.UserId\n" +
                    "where UserName = 'adalvarez.ext'\n" +
                    "order by v.InsertDate DESC";
            // v with (nolock)
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);


            //Visualizar Resultados
            if (resultSet.next() == false) {
                System.out.println("ResultSet in empty in Java");
            } else {

                do {
                    String data = resultSet.getString(1);
                    commonActions.PrintReportMessage("Código de confirmación recuperado correctamente: "+data);
                    codigoConfirmacion = data; //Exportar
                } while (resultSet.next());
            }

        } catch (SQLException ex) {
            commonActions.CapturadorExcepcion("ConexionBD.png", "No se ha podido realizar correctamente la conexión a la BD");
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                commonActions.CapturadorExcepcion("ConexionBD.png", "No se ha podido realizar correctamente la conexión a la BD");
                ex.printStackTrace();
            }
        }
    }


}
