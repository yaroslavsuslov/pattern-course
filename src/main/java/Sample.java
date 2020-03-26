import lombok.Data;

@Data
public class Sample {

    private final long id;
    private String name;
    private final Sound sound;
    private long portfolioId;
    private int price;


}
