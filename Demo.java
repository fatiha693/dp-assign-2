public class Demo {

    public static void main(String[] args) {
        VillageComboFactory factory = new BrickMangoPoolFactory();
        Village village = factory.createVillage("AoV Village");

        System.out.println("Selected Village Configuration:");
        System.out.println(factory.getComboName());
        System.out.println();
        ReportVisitor reportVisitor = new ReportVisitor();
        village.accept(reportVisitor);
        System.out.println("Village Structure:");
        System.out.println(reportVisitor.getReport());
        CostVisitor costVisitor = new CostVisitor();
        village.accept(costVisitor);
        System.out.println("Total Construction Cost: " + costVisitor.getTotalCost());
        System.out.println();
        ResourceVisitor resourceVisitor = new ResourceVisitor();
        village.accept(resourceVisitor);
        System.out.println("Total Resources Required:");
        System.out.println(resourceVisitor.getTotals());
        System.out.println();
        House house = (House) village.getChildren().get(0);

        SimpleShape window = new RectangleShape(
                "Window",
                4,
                SimpleShape.map("Glass", 2, "Aluminum", 1)
        );

        Command addWindow = new AddCommand(house, window);
        addWindow.execute();

        CostVisitor newCost = new CostVisitor();
        village.accept(newCost);
        System.out.println("After adding window, cost: " + newCost.getTotalCost());
        addWindow.undo();

        CostVisitor undoCost = new CostVisitor();
        village.accept(undoCost);
        System.out.println("After undo, cost: " + undoCost.getTotalCost());
    }
}