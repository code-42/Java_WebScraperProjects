public class SearchResult {

    private final String rowNum;
    private final String name;
    private final String symbol;
    private final String marketCap;
    private final String price;
    private final String circSupply;
    private final String vol24h;
    private final String change1h;
    private final String change24h;
    private final String change7d;

    public SearchResult(String rowNum, String name, String symbol, String marketCap, String price, String circSupply, String vol24h, String change1h, String change24h, String change7d) {
        this.rowNum = rowNum;
        this.name = name;
        this.symbol = symbol;
        this.marketCap = marketCap;
        this.price = price;
        this.circSupply = circSupply;
        this.vol24h = vol24h;
        this.change1h = change1h;
        this.change24h = change24h;
        this.change7d = change7d;
    }

    // getters no setters
    public String getRowNum() {
        return rowNum;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public String getPrice() {
        return price;
    }

    public String getCircSupply() {
        return circSupply;
    }

    public String getVol24h() {
        return vol24h;
    }

    public String getChange1h() {
        return change1h;
    }

    public String getChange24h() {
        return change24h;
    }

    public String getChange7d() {
        return change7d;
    }

    // equals() and hashCode() and toString() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchResult that = (SearchResult) o;

        if (rowNum != null ? !rowNum.equals(that.rowNum) : that.rowNum != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (marketCap != null ? !marketCap.equals(that.marketCap) : that.marketCap != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (circSupply != null ? !circSupply.equals(that.circSupply) : that.circSupply != null) return false;
        if (vol24h != null ? !vol24h.equals(that.vol24h) : that.vol24h != null) return false;
        if (change1h != null ? !change1h.equals(that.change1h) : that.change1h != null) return false;
        if (change24h != null ? !change24h.equals(that.change24h) : that.change24h != null) return false;
        return change7d != null ? change7d.equals(that.change7d) : that.change7d == null;
    }

    @Override
    public int hashCode() {
        int result = rowNum != null ? rowNum.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (marketCap != null ? marketCap.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (circSupply != null ? circSupply.hashCode() : 0);
        result = 31 * result + (vol24h != null ? vol24h.hashCode() : 0);
        result = 31 * result + (change1h != null ? change1h.hashCode() : 0);
        result = 31 * result + (change24h != null ? change24h.hashCode() : 0);
        result = 31 * result + (change7d != null ? change7d.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "rowNum='" + rowNum + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", marketCap='" + marketCap + '\'' +
                ", price='" + price + '\'' +
                ", circSupply='" + circSupply + '\'' +
                ", vol24h='" + vol24h + '\'' +
                ", change1h='" + change1h + '\'' +
                ", change24h='" + change24h + '\'' +
                ", change7d='" + change7d + '\'' +
                '}';
    }
}
