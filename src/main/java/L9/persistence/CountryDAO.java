package L9.persistence;

import L8.model.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CountryDAO extends BaseDAO {

    private List<Country> selectCountry(String query) {
        List<Country> results = new ArrayList<Country>();
        Connection con = super.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                String code = dbResultSet.getString("code");
                String name = dbResultSet.getString("name");
                String continent = dbResultSet.getString("continent");
                String region = dbResultSet.getString("continent");
                double surface = dbResultSet.getDouble("surface");
                int population = dbResultSet.getInt("surface");
                String government = dbResultSet.getString("goverment");

                Country c = new Country(code, name, continent, region, surface, population, government);

                results.add(c);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return results;
    }

    public List<Country> findAll() {
        return selectCountry("SELECT * FROM countries");
    }

    public Country findByCode(String code) {
        return selectCountry("SELECT * FROM countries WHERE customerid = " + code).get(0);
    }

    public boolean delete(Country c) {
        boolean result = false;
        boolean customerExists = findByCode(c.getCode()) != null;

        if (customerExists) {
            String query = "DELETE FROM countries WHERE code = " + c.getCode();
            Connection con = super.getConnection();
            try {

                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(query) == 1) { // 1 row updated!
                    result = true;
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return result;
    }
}