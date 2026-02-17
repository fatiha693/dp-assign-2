public class ReportVisitor implements VillageVisitor {
    private final StringBuilder sb = new StringBuilder();
    private int indent = 0;

    public String getReport() { return sb.toString(); }

    private void line(String s) {
        sb.append("  ".repeat(Math.max(0, indent))).append(s).append("\n");
    }

    @Override
    public void visitComposite(CompositeComponent composite) {
        line("+ " + composite.getName());
        indent++;
    }

    @Override
    public void visitShape(ShapeLeaf shape) {
        line("- " + shape.getName() + " | cost=" + shape.getCost() + " | res=" + shape.getResources());
    }

    @Override
    public void endComposite(CompositeComponent composite) {
        indent--;
    }
}
