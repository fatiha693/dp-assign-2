public interface VillageVisitor {
    void visitShape(SimpleShape shape);
    void visitComposite(CompositeComponent composite);

    default void endComposite(CompositeComponent composite) {}
}