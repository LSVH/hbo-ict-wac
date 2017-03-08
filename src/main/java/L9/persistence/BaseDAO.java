package L9.persistence;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class BaseDAO {
    protected final Connection getConnection() {
        Connection result = null;

        try {
            InitialContext ic = new InitialContext();
            DataSource datasource = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDS");

            result = datasource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }
}
