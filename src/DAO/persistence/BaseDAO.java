package DAO.persistence;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class BaseDAO {
    protected final Connection getConnection() {
        Connection conn = null;
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDS");
            conn = ds.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return conn;
    }
}