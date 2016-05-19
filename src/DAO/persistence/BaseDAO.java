package DAO.persistence;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    private Connection conn;
    private DataSource ds;

    public BaseDAO() throws Exception {
        try {
            InitialContext ic = new InitialContext();
            this.ds = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDS");
        } catch (Exception e) {
            throw e;
        }
    }

    public void open() throws SQLException {
        try {
            if (this.conn == null || !this.conn.isOpen())
                this.conn = ds.getConnection();
        } catch(SQLException sqle) {
            throw sqle;
        }
    }

    public void close() throws SQLException {
        try {
            if (this.conn != null && this.conn.isOpen())
                this.conn.close();
        } catch(SQLException e) {
            throw e;
        }
    }
}