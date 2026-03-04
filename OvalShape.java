import java.util.Map;

public class OvalShape extends SimpleShape {
    public OvalShape(String label, double cost, Map<String, Integer> resources) {
        super(label, cost, resources);
    }

    @Override
    public String shapeType() {
        return "Oval";
    }
}