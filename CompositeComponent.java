
import java.util.*;

public class CompositeComponent implements VillageComponent {
    private final String name;
    private final List<VillageComponent> children = new ArrayList<>();

    public CompositeComponent(String name) {
        this.name = name;
    }

    public void add(VillageComponent c) { children.add(c); }
    public void remove(VillageComponent c) { children.remove(c); }

    public List<VillageComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String getName() { return name; }

    @Override
    public void accept(VillageVisitor visitor) {
        visitor.visitComposite(this);
        for (VillageComponent c : children) {
            c.accept(visitor);
        }
        visitor.endComposite(this);
    }
}
