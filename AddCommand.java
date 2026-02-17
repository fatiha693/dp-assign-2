public class AddCommand implements Command {
    private final CompositeComponent parent;
    private final VillageComponent child;

    public AddCommand(CompositeComponent parent, VillageComponent child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void execute() { parent.add(child); }

    @Override
    public void undo() { parent.remove(child); }

    @Override
    public String name() { return "Add " + child.getName() + " to " + parent.getName(); }
}
