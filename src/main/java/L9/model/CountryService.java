package L9.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryService {
    private List<L8.model.Country> allCountries = new ArrayList<L8.model.Country>();

    public CountryService() {
        allCountries.add(new L8.model.Country("CHN", "China", "Asia", "Eastern Asia", 9572900.00, 1277558000, "People'sRepublic"));
        allCountries.add(new L8.model.Country("IND", "India", "Asia", "Southern and Central Asia", 3287263.00, 1013662000, "Federal Republic"));
        allCountries.add(new L8.model.Country("USA", "United States", "North America", "North America", 9363520.00, 278357000, "Federal Republic"));
        allCountries.add(new L8.model.Country("IDN", "Indonesia", "Asia", "Southeast Asia", 1904569.00, 212107000, "Republic"));
        allCountries.add(new L8.model.Country("BRA", "Brazil", "South America", "South America", 8547403.00, 170115000, "Federal Republic"));
        allCountries.add(new L8.model.Country("PAK", "Pakistan", "Asia", "Southern and Central Asia", 796095.00, 156483000, "Republic"));
        allCountries.add(new L8.model.Country("RUS", "Russian Federation", "Europe", "Eastern Europe", 17075400.00, 146934000, "Federal Republic"));
        allCountries.add(new L8.model.Country("BGD", "Bangladesh", "Asia", "Southern and Central Asia", 143998.00, 129155000, "Republic"));
        allCountries.add(new L8.model.Country("JPN", "Japan", "Asia", "Eastern Asia", 377829.00, 126714000, "Constitutional Monarchy"));
        allCountries.add(new L8.model.Country("NGA", "Nigeria", "Africa", "Western Africa", 923768.00, 111506000, "Federal Republic"));
        allCountries.add(new L8.model.Country("ATA", "Antarctica", "Antarctica", "Antarctica", 13120000.00, 0, "Co-administrated"));
        allCountries.add(new L8.model.Country("CAN", "Canada", "North America", "North America", 9970610.00, 31147000, "Constitutional Monarchy, Federation"));
        allCountries.add(new L8.model.Country("AUS", "Australia", "Oceania", "Australia and New Zealand", 7741220.00, 18886000, "Constitutional Monarchy, Federation"));
        allCountries.add(new L8.model.Country("ARG", "Argentina", "South America", "South America", 2780400.00, 37032000, "Federal Republic"));
        allCountries.add(new L8.model.Country("KAZ", "Kazakstan", "Asia", "Southern and Central Asia", 2724900.00, 16223000, "Republic"));
    }

    public List<L8.model.Country> getAllCountries() {
        return allCountries;
    }

    public List<L8.model.Country> get10LargestPopulations() {
        Collections.sort(allCountries, new Comparator<L8.model.Country>() {
            public int compare(L8.model.Country c1, L8.model.Country c2) {
                return c2.getPopulation() - c1.getPopulation();
            }

            ;
        });

        return allCountries.subList(0, 10);
    }

    public List<L8.model.Country> get10LargestSurfaces() {
        Collections.sort(allCountries, new Comparator<L8.model.Country>() {
            public int compare(L8.model.Country c1, L8.model.Country c2) {
                return (int) (c2.getSurface() - c1.getSurface());
            }

            ;
        });

        return allCountries.subList(0, 10);
    }

    public L8.model.Country getCountryByCode(String code) {
        L8.model.Country result = null;

        for (L8.model.Country c : allCountries) {
            if (c.getCode().equals(code)) {
                result = c;
                break;
            }
        }

        return result;
    }
}