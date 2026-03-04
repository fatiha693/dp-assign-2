public class MudBananaPondFactory implements VillageComboFactory {

    @Override
    public String getComboName() {
        return "Mud House + Banana Tree + Pond";
    }

    @Override
    public Village createVillage(String villageName) {
        Village village = new Village(villageName);

        House house = new House("Mud House");
        house.add(new RectangleShape("Mud Wall", 12, SimpleShape.map("Mud", 80, "Straw", 15)));
        house.add(new TriangleShape("Thatched Roof", 10, SimpleShape.map("Straw", 30, "Bamboo", 6)));
        village.add(house);

        Tree tree = new Tree("Banana Tree");
        tree.add(new CylinderShape("Trunk", 4, SimpleShape.map("Fiber", 8)));
        tree.add(new OvalShape("Leaves", 3, SimpleShape.map("Leaves", 25)));
        tree.add(new OvalShape("Bananas", 2, SimpleShape.map("Seeds", 2)));
        village.add(tree);

        WaterSource pond = new WaterSource("Pond");
        pond.add(new OvalShape("Pond Basin", 10, SimpleShape.map("SoilExcavation", 50)));
        pond.add(new OvalShape("Water", 0, SimpleShape.map("WaterLiters", 3000)));
        pond.add(new RectangleShape("Rocks Border", 6, SimpleShape.map("Rocks", 40)));
        village.add(pond);

        return village;
    }
}