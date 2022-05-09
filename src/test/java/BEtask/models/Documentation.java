package BEtask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.openqa.selenium.net.Urls;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Documentation {
    public int id;
    public String name;
    public String symbol;
    public String category;
    public String description;
    public String slug;
    public String logo;
    public String subreddit;
    public String notice;
    public ArrayList<String> tags;
    @JsonProperty("tag-names")
    public ArrayList<String> tagNames;
    @JsonProperty("tag-groups") 
    public ArrayList<String> tagGroups;
    public Urls urls;
    public Object platform;
    public Date date_added;
    public String twitter_username;
    public int is_hidden;
    public Object date_launched;
    public ArrayList<Object> contract_address;
    public Object self_reported_circulating_supply;
    public Object self_reported_tags;
    public Object self_reported_market_cap;
}