package cz;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MovieDTO {
    private Integer id;
    private String image;
    @NotNull
    private String title;
    @Size(min = 3)
    private String age;
    @NotNull
    private String tags;
    private String description;
    @Min(1)
    private Number price;
}
