import java.util.*;

public class ResourceVisitor implements VillageVisitor {
    private final Map<String, Integer> totals = new LinkedHashMap<>();

    public Map<String, Integer> getTotals() { return totals; }

    @Override
    public void visitShape(ShapeLeaf shape) {
        for (var e : shape.getResources().entrySet()) {
            totals.put(e.getKey(), totals.getOrDefault(e.getKey(), 0) + e.getValue());
        }
    }

    @Override
    public void visitComposite(CompositeComponent composite) {
    }
}
