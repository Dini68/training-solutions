package stringmethods;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    private String setProtocol(String url) {
        return url.substring(0,url.indexOf(":"));
    }
    private String setPath(String url) {

        return url.substring(url.indexOf("/", url.indexOf(":") + 3)+1, url.length());
    }
    private String setHost(String url) {
        if (url.indexOf(":",url.indexOf(":")+3) == -1 ||
                (url.indexOf("/",url.indexOf(":")+3) < url.indexOf(":",url.indexOf(":")+3))) {
            return url.substring(url.indexOf(":") + 3, url.indexOf("/", url.indexOf(":") + 3));
        } else {
            return url.substring(url.indexOf(":") + 3, url.indexOf(":", url.indexOf(":") + 3));
        }
    }
    public UrlManager(String url) {
        this.protocol = setProtocol(url);
        this.host = setHost(url);
        this.path = setPath(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public static void main(String[] args) {
        String url = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);
        System.out.println(urlManager.getProtocol());
        System.out.println(urlManager.getHost());
        System.out.println(urlManager.getPath());
    }
}
