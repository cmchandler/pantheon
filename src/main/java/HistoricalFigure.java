package main.java;

/**
 * HistoricalFigure: represents a historical figure data point from the Pantheon data set
 * Expects to use HistoricalFigureBuilder to get around large number of parameters.
 */
public class HistoricalFigure {

    private int article_id;
    private String full_name;
    private String sex;
    private int birth_year;
    private String city;
    private String state;
    private String country;
    private String continent;
    private double latitude;
    private double longitude;
    private String occupation;
    private String industry;
    private String domain;
    private int article_languages;
    private int page_views;
    private int average_views;
    private double historical_popularity_index;

    public HistoricalFigure (
             int article_id,
             String full_name,
             String sex,
             int birth_year,
             String city,
             String state,
             String country,
             String continent,
             double latitude,
             double longitude,
             String occupation,
             String industry,
             String domain,
             int article_languages,
             int page_views,
             int average_views,
             double historical_popularity_index )
    {
          this.article_id = article_id;
          this.full_name = full_name;
          this.sex = sex;
          this.birth_year = birth_year;
          this.city = city;
          this.state = state;
          this.country = country;
          this.continent = continent;
          this.latitude = latitude;
          this.longitude = longitude;
          this.occupation = occupation;
          this.industry = industry;
          this.domain = domain;
          this.article_languages = article_languages;
          this.page_views = page_views;
          this.average_views = average_views;
          this.historical_popularity_index = historical_popularity_index;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getArticle_languages() {
        return article_languages;
    }

    public void setArticle_languages(int article_languages) {
        this.article_languages = article_languages;
    }

    public int getPage_views() {
        return page_views;
    }

    public void setPage_views(int page_views) {
        this.page_views = page_views;
    }

    public int getAverage_views() {
        return average_views;
    }

    public void setAverage_views(int average_views) {
        this.average_views = average_views;
    }

    public double getHistorical_popularity_index() {
        return historical_popularity_index;
    }

    public void setHistorical_popularity_index(double historical_popularity_index) {
        this.historical_popularity_index = historical_popularity_index;
    }
}
