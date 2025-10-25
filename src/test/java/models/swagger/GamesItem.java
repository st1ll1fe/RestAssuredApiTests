package models.swagger;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class GamesItem {

    @JsonProperty("gameId")
    private int gameId;

    @JsonProperty("requirements")
    private Requirements requirements;

    @JsonProperty("requiredAge")
    private boolean requiredAge;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("isFree")
    private boolean isFree;

    @JsonProperty("price")
    private int price;

    @JsonProperty("dlcs")
    private List<DlcsItem> dlcs;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("company")
    private String company;

    @JsonProperty("publish_date")
    private String publishDate;
}