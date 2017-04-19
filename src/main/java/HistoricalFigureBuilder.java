package main.java;

/**
 * Constructs a HistoricalFigure
 */
public class HistoricalFigureBuilder {

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

    public HistoricalFigureBuilder article_id(int _article_id ) {
        this._article_id = _article_id;
        return this;
    }

    public HistoricalFigureBuilder full_name(String _full_name) {
        this._full_name = _full_name;
        return this;
    }

    public HistoricalFigureBuilder sex(String _sex) {
        this._sex= _sex;
        return this;
    }

    public HistoricalFigureBuilder birth_year(int _birth_year) {
        this._birth_year = _birth_year;
        return this;
    }

    public HistoricalFigureBuilder _city(String _city) {
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
        return new HistoricalFigure(
                _article_id,
                _full_name,
                _sex,
                _birth_year,
                _city,
                _state,
                _country,
                _continent,
                _latitude,
                _longitude,
                _occupation,
                _industry,
                _domain,
                _article_languages,
                _page_views,
                _average_views,
                _historical_popularity_index
        );
    }
}
