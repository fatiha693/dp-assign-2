
import java.util.*;

public class ShapeLeaf implements VillageComponent {
    private final String name;
    private final double cost;
    private final Map<String, Integer> resources;

    public ShapeLeaf(String name, double cost, Map<String, Integer> resources) {
        this.name = name;
        this.cost = cost;
        this.resources = new LinkedHashMap<>(resources);
    }

    public double getCost() { return cost; }

    public Map<String, Integer> getResources() {
        return Collections.unmodifiableMap(resources);
    }

    @Override
    public String getName() { return name; }

    @Override
    public void accept(VillageVisitor visitor) {
        visitor.visitShape(this);
    }

    // helper: map("Bricks",50,"Cement",10)
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
