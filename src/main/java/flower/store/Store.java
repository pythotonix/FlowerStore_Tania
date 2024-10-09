package flower.store;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Store {
    private List<FlowerBucket> flowerBuckets;

    public Store() {
        this.flowerBuckets = new ArrayList<>();
    }

    public void addFlowerBucket(FlowerBucket bucket) {
        flowerBuckets.add(bucket);
    }

    public List<FlowerBucket> search(FlowerColor color, 
    FlowerType type, double maxPrice) {
        List<FlowerBucket> result = new ArrayList<>();
        
        for (FlowerBucket bucket : flowerBuckets) {
            boolean suitable = false;
            for (FlowerPack pack : bucket.getFlowerPacks()) {
                Flower flower = pack.getFlower();
                if ((color == null 
                || flower.getColor().equals(color.getStringRepresentation())) 
                && (type == null || flower.getType().equals(type)) 
                    && flower.getPrice() <= maxPrice) {
                    suitable = true;
                    break;
                }
            }
            if (suitable) {
                result.add(bucket);
            }
        }
        
        return result;
    }
}
