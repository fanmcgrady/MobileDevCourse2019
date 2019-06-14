package bean;

import java.util.List;

/**
 * @author fangzhiyang
 */
public class Rank {
    
    private int statusCode;
    private List<RankData> data;

    public List<RankData> getData() {
        return data;
    }

    public void setData(List<RankData> data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
