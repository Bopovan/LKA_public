package smorodina;

import java.sql.*;

public class ConnectionSQL {
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = getOracleConnection();
        Statement stmnt = conn.createStatement();
        ResultSet rset = stmnt.executeQuery("SELECT NM_CODE_ACTIVATION FROM LKK_CODE_ACTIVATION lca WHERE NM_ABONENT_LOGIN = '9028143539'");
        while(rset.next()) {
            System.out.println(rset.getString(1));
        }
        rset.close();
        stmnt.close();

    }
}
