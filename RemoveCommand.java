public class RemoveCommand implements Command {
    private final CompositeComponent parent;
    private final VillageComponent child;

    public RemoveCommand(CompositeComponent parent, VillageComponent child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void execute() { parent.remove(child); }

    @Override
    public void undo() { parent.add(child); }

    @Override
    public String name() { return "Remove " + child.getName() + " from " + parent.getName(); }
}
