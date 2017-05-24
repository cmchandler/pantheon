package main.java.src;

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

    private HistoricalFigure ( HistoricalFigureBuilder builder)
    {
          this.article_id = builder._article_id;
          this.full_name = builder._full_name;
          this.sex = builder._sex;
          this.birth_year = builder._birth_year;
          this.city = builder._city;
          this.state = builder._state;
          this.country = builder._country;
          this.continent = builder._continent;
          this.latitude = builder._latitude;
          this.longitude = builder._longitude;
          this.occupation = builder._occupation;
          this.industry = builder._industry;
          this.domain = builder._domain;
          this.article_languages = builder._article_languages;
          this.page_views = builder._page_views;
          this.average_views = builder._average_views;
          this.historical_popularity_index = builder._historical_popularity_index;

}
    public void setPage_views(int p) {
        page_views = p;
    }

    public void setArticle_languages(int l) {
        article_languages = l;
    }

    public void setAverage_views(int a) {
        average_views = a;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getSex() {
        return sex;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getIndustry() {
        return industry;
    }

    public String getDomain() {
        return domain;
    }

    public int getArticle_languages() {
        return article_languages;
    }

    public int getPage_views() {
        return page_views;
    }

    public int getAverage_views() {
        return average_views;
    }

    public double getHistorical_popularity_index() {
        return historical_popularity_index;
    }

    public String getCustomClass(String n){
        if(n == null) n = "";;

        if (n.equals("city")) {
            return this.getCity() ;
        }
        else if(n.equals("country")){
            return this.getCountry() ;
        }
        else if(n.equals("continent")){
            return this.getContinent() ;
        }
        else if(n.equals("page_views")){
            return Integer.toString(this.getPage_views()) ;
        }
        else if(n.equals("avg_views")){
            return Integer.toString(this.getAverage_views()) ;
        }
        else if(n.equals("languages")){
            return Integer.toString(this.getArticle_languages()) ;
        }
        else if(n.equals("domain")){
            return this.getDomain() ;
        }
        else if(n.equals("sex")){
            return this.getSex() ;
        }
        else if(n.equals("occupation")){
            return this.getOccupation() ;
        }
        else if(n.equals("industry")){
            return this.getIndustry() ;
        }
        else{
            return "";
        }
    }

    /**
     * Constructs a HistoricalFigure
     */
    public static class HistoricalFigureBuilder {

        private int _article_id;
        private String _full_name;
        private String _sex;
        private int _birth_year;
        private String _city;
        private String _state;
        private String _country;
        private String _continent;
        private double _latitude;
        private double _longitude;
        private String _occupation;
        private String _industry;
        private String _domain;
        private int _article_languages;
        private int _page_views;
        private int _average_views;
        private double _historical_popularity_index;

        public HistoricalFigureBuilder article_id(int _article_id) {
            this._article_id = _article_id;
            return this;
        }

        public HistoricalFigureBuilder full_name(String _full_name) {
            this._full_name = _full_name;
            return this;
        }

        public HistoricalFigureBuilder sex(String _sex) {
            this._sex = _sex;
            return this;
        }

        public HistoricalFigureBuilder birth_year(int _birth_year) {
            this._birth_year = _birth_year;
            return this;
        }

        public HistoricalFigureBuilder city(String _city) {
            this._city = _city;
            return this;
        }

        public HistoricalFigureBuilder state(String _state) {
            this._state = _state;
            return this;
        }

        public HistoricalFigureBuilder country(String _country) {
            this._country = _country;
            return this;
        }

        public HistoricalFigureBuilder continent(String _continent) {
            this._continent = _continent;
            return this;
        }

        public HistoricalFigureBuilder latitude(double _latitude) {
            this._latitude = _latitude;
            return this;
        }

        public HistoricalFigureBuilder longitude(double _longitude) {
            this._longitude = _longitude;
            return this;
        }

        public HistoricalFigureBuilder occupation(String _occupation) {
            this._occupation = _occupation;
            return this;
        }

        public HistoricalFigureBuilder industry(String _industry) {
            this._industry = _industry;
            return this;
        }

        public HistoricalFigureBuilder domain(String _domain) {
            this._domain = _domain;
            return this;
        }

        public HistoricalFigureBuilder article_languages(int _article_languages) {
            this._article_languages = _article_languages;
            return this;
        }

        public HistoricalFigureBuilder page_views(int _page_views) {
            this._page_views = _page_views;
            return this;
        }

        public HistoricalFigureBuilder average_views(int _average_views) {
            this._average_views = _average_views;
            return this;
        }

        public HistoricalFigureBuilder historical_popularity_index(double _historical_popularity_index) {
            this._historical_popularity_index = _historical_popularity_index;
            return this;
        }

        public HistoricalFigure build() {
            HistoricalFigure figure = new HistoricalFigure(this);
            return figure;
        }
    }

    public Object[] getData() {
        String[] data = {
        Integer.toString(article_id),
        full_name,
        sex,
        Integer.toString(birth_year),
        city,
        state,
        country,
        continent,
        Double.toString(latitude),
        Double.toString(longitude),
        occupation,
        industry,
        domain,
        Integer.toString(article_languages),
        Integer.toString(page_views),
        Integer.toString(average_views),
        Double.toString(historical_popularity_index)
        };

        //clean characters Weka doesn't like
        for(int i = 0; i < data.length; i++) {

            String s = data[i];

           s.replace("\"","");

            data[i].replaceAll("^\"|'\"$`", "");

            if(data[i].contains("\"")) {
                data[i].replace("\"","");
                data[i] = "";
            }

            if(data[i].contains("'")) {
                data[i] = "";
            }

            if(data[i]==null) {
                data[i] = "";
            }
        }



        return data;
    }

    private void clean() {

    }

}
