public class CostVisitor implements VillageVisitor {
    private double totalCost = 0;

    public double getTotalCost() { return totalCost; }

    @Override
    public void visitShape(ShapeLeaf shape) {
        totalCost += shape.getCost();
    }

    @Override
    public void visitComposite(CompositeComponent composite) {
    }
}
