public class Demo {

    public static void main(String[] args) {

        // 1. Choose village combination using Factory
        VillageComboFactory factory = new BrickMangoPoolFactory();
        Village village = factory.createVillage("AoV Village");

        System.out.println("Selected Village Configuration:");
        System.out.println(factory.getComboName());
        System.out.println();

        // 2. Generate report using Visitor
        ReportVisitor reportVisitor = new ReportVisitor();
        village.accept(reportVisitor);

        System.out.println("Village Structure:");
        System.out.println(reportVisitor.getReport());

        // 3. Calculate total cost using Visitor
        CostVisitor costVisitor = new CostVisitor();
        village.accept(costVisitor);

        System.out.println("Total Construction Cost: " + costVisitor.getTotalCost());
        System.out.println();

        // 4. Estimate resources using Visitor
        ResourceVisitor resourceVisitor = new ResourceVisitor();
        village.accept(resourceVisitor);

        System.out.println("Total Resources Required:");
        System.out.println(resourceVisitor.getTotals());
        System.out.println();

        // 5. Demonstrate Command Pattern (Add a new window to house)
        House house = (House) village.getChildren().get(0);

        ShapeLeaf window = new ShapeLeaf(
                "Window (Square)",
                4,
                ShapeLeaf.map("Glass", 2, "Aluminum", 1)
        );

        Command addWindow = new AddCommand(house, window);
        addWindow.execute();

        System.out.println("Added a window to the house.");
        System.out.println();

        // Recalculate cost
        CostVisitor newCostVisitor = new CostVisitor();
        village.accept(newCostVisitor);

        System.out.println("New Total Cost After Modification: " + newCostVisitor.getTotalCost());
        System.out.println();

        // Undo the change
        addWindow.undo();

        System.out.println("Undo operation performed.");

        CostVisitor finalCostVisitor = new CostVisitor();
        village.accept(finalCostVisitor);

        System.out.println("Final Cost After Undo: " + finalCostVisitor.getTotalCost());
    }
}