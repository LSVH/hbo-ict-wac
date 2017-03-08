package L8.services;


import L8.model.Country;
import L8.model.CountryService;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/countries")
public class CountryResource {
    @GET
    @Produces("application/json")
    public String getAllCountries() {
        CountryService cs = new CountryService();
        return getJsonArray(cs.getAllCountries());
    }

    @GET
    @Path("largestsurfaces")
    @Produces("application/json")
    public String get10LargestSurfaces() {
        CountryService cs = new CountryService();
        return getJsonArray(cs.get10LargestSurfaces());
    }

    @GET
    @Path("largestpopulations")
    @Produces("application/json")
    public String get10LargestPopulations() {
        CountryService cs = new CountryService();
        return getJsonArray(cs.get10LargestPopulations());
    }

    @GET
    @Path("{code}")
    @Produces("application/json")
    public String getCountry(@PathParam("code") String code) {
        CountryService cs = new CountryService();

        JsonArrayBuilder jab = Json.createArrayBuilder();

        Country c = cs.getCountryByCode(code.toUpperCase());

        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("code", c.getCode());
        job.add("name", c.getName());
        job.add("continent", c.getContinent());
        job.add("region", c.getRegion());
        job.add("surface", c.getSurface());
        job.add("population", c.getPopulation());
        job.add("goverment", c.getGovernment());

        jab.add(job);

        JsonArray ja = jab.build();

        return ja.toString();
    }

    private String getJsonArray(List<Country> countries) {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Country c : countries) {
            JsonObjectBuilder job = Json.createObjectBuilder();

            job.add("code", c.getCode());
            job.add("name", c.getName());
            job.add("continent", c.getContinent());
            job.add("region", c.getRegion());
            job.add("surface", c.getSurface());
            job.add("population", c.getPopulation());
            job.add("goverment", c.getGovernment());

            jab.add(job);
        }

        JsonArray ja = jab.build();

        return ja.toString();
    }
}
