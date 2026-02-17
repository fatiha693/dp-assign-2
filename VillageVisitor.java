public interface VillageVisitor {
    void visitShape(ShapeLeaf shape);
    void visitComposite(CompositeComponent composite);

    default void endComposite(CompositeComponent composite) {}
}
