public class MudBananaPondFactory implements VillageComboFactory {

    @Override
    public String getComboName() {
        return "Mud House + Banana Tree + Pond";
    }

    @Override
    public Village createVillage(String villageName) {
        Village village = new Village(villageName);

        House house = new House("Mud House");
        house.add(new ShapeLeaf("Mud Wall(Rectangle)", 12, ShapeLeaf.map("Mud", 80, "Straw", 15)));
        house.add(new ShapeLeaf("Thatched Roof(Triangle)", 10, ShapeLeaf.map("Straw", 30, "Bamboo", 6)));
        village.add(house);

        Tree tree = new Tree("Banana Tree");
        tree.add(new ShapeLeaf("Trunk(Cylinder)", 4, ShapeLeaf.map("Fiber", 8)));
        tree.add(new ShapeLeaf("Leaves(Ellipses)", 3, ShapeLeaf.map("Leaves", 25)));
        tree.add(new ShapeLeaf("Bananas(Ellipses)", 2, ShapeLeaf.map("Seeds", 2)));
        village.add(tree);

        WaterSource pond = new WaterSource("Pond");
        pond.add(new ShapeLeaf("Pond Basin(Oval)", 10, ShapeLeaf.map("SoilExcavation", 50)));
        pond.add(new ShapeLeaf("Water(Oval)", 0, ShapeLeaf.map("WaterLiters", 3000)));
        pond.add(new ShapeLeaf("Rocks(Border)", 6, ShapeLeaf.map("Rocks", 40)));
        village.add(pond);

        return village;
    }
}
