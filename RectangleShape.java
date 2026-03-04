import java.util.Map;

public class RectangleShape extends SimpleShape {
    public RectangleShape(String label, double cost, Map<String, Integer> resources) {
        super(label, cost, resources);
    }

    @Override
    public String shapeType() {
        return "Rectangle";
    }
}
