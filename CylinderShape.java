import java.util.Map;

public class CylinderShape extends SimpleShape {
    public CylinderShape(String label, double cost, Map<String, Integer> resources) {
        super(label, cost, resources);
    }

    @Override
    public String shapeType() {
        return "Cylinder";
    }
}