package flower.store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FlowerPack {
    private Flower flower;
    private int count;

    public double getPrice() {
        return flower.getPrice()*count;
    }
}

