
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

    private String url = "jdbc:mysql://localhost:3306/agenda_telefonica";
    private String user = "root";
    private String password = "";

    private Connection conn;

    public Connection getConexao(){

        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else{
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
