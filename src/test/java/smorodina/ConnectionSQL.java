package smorodina;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import smorodina.pages.ОкноАвторизации;

import java.sql.*;

public class ConnectionSQL {
    private Logger log = LogManager.getLogger(ConnectionSQL.class);
    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
        String hostName = "172.16.200.248";
        String sid = "FIRST_ROOM"; //orcl //db11g
        String userName = "lkk_gas_test";
        String password = "lkk_gas_test";

        return getOracleConnection(hostName, sid, userName, password);
    }

    private static Connection getOracleConnection(String hostName, String sid, String userName, String password) throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:oracle:thin:@//" + hostName + ":1521/" + sid;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

    public String getCodeActivation(String nameAcc) throws SQLException, ClassNotFoundException {
        log.trace("\n_______________________________________________\n\nВАЖНО! Проверьте подключены ли Вы к ВПН, доступ до базы данных требует локального подключения с доступами\n\n___________________________________________________________");
        Connection conn = getOracleConnection();
        Statement stmnt = conn.createStatement();
        String SQL = "SELECT NM_CODE_ACTIVATION FROM LKK_CODE_ACTIVATION lca WHERE NM_ABONENT_LOGIN = " + "'" + nameAcc + "'";
        String value = "";
        ResultSet rset = stmnt.executeQuery(SQL);
        while (rset.next()) {
            value = value + rset.getString(1);
        }
        Assert.assertNotNull(value);
        System.out.println(value);
        rset.close();
        stmnt.close();
        return value;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = getOracleConnection();
        Statement stmnt = conn.createStatement();
        ResultSet rset = stmnt.executeQuery("SELECT NM_CODE_ACTIVATION FROM LKK_CODE_ACTIVATION lca WHERE NM_ABONENT_LOGIN = '9028143539'");
        String value = "";
        while (rset.next()) {
            value = value + rset.getString(1);
        }
        Assert.assertNotNull(value);
        System.out.println(value);
        rset.close();
        stmnt.close();

    }
}
