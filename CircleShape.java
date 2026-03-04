import java.util.Map;

public class CircleShape extends SimpleShape {
    public CircleShape(String label, double cost, Map<String, Integer> resources) {
        super(label, cost, resources);
    }

    @Override
    public String shapeType() {
        return "Circle";
    }
}