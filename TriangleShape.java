import java.util.Map;

public class TriangleShape extends SimpleShape {
    public TriangleShape(String label, double cost, Map<String, Integer> resources) {
        super(label, cost, resources);
    }

    @Override
    public String shapeType() {
        return "Triangle";
    }
}