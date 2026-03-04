import java.util.*;

public abstract class SimpleShape implements VillageComponent {
    private final String label;
    private final double cost;
    private final Map<String, Integer> resources;

    protected SimpleShape(String label, double cost, Map<String, Integer> resources) {
        this.label = label;
        this.cost = cost;
        this.resources = new LinkedHashMap<>(resources);
    }

    public abstract String shapeType();

    public double getCost() { return cost; }

    public Map<String, Integer> getResources() {
        return Collections.unmodifiableMap(resources);
    }

    @Override
    public String getName() {
        return label + " [" + shapeType() + "]";
    }

    @Override
    public void accept(VillageVisitor visitor) {
        visitor.visitShape(this);
    }

    public static Map<String, Integer> map(Object... kv) {
        if (kv.length % 2 != 0) throw new IllegalArgumentException("Need even args");
        Map<String, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < kv.length; i += 2) {
            String k = String.valueOf(kv[i]);
            int v = Integer.parseInt(String.valueOf(kv[i + 1]));
            m.put(k, m.getOrDefault(k, 0) + v);
        }
        return m;
    }
}