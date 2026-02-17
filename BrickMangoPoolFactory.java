public class BrickMangoPoolFactory implements VillageComboFactory {

    @Override
    public String getComboName() {
        return "Brick House + Mango Tree + Swimming Pool";
    }

    @Override
    public Village createVillage(String villageName) {
        Village village = new Village(villageName);

        House house = new House("Brick House");
        house.add(new ShapeLeaf("Wall(Rectangle)", 30, ShapeLeaf.map("Bricks", 50, "Cement", 10)));
        house.add(new ShapeLeaf("Roof(Triangle)", 18, ShapeLeaf.map("Tiles", 20, "Wood", 5)));
        house.add(new ShapeLeaf("Door(Rectangle)", 6, ShapeLeaf.map("Wood", 4)));
        village.add(house);

        Tree tree = new Tree("Mango Tree");
        tree.add(new ShapeLeaf("Trunk(Cylinder)", 5, ShapeLeaf.map("Wood", 6)));
        tree.add(new ShapeLeaf("Canopy(Circle)", 4, ShapeLeaf.map("Leaves", 20)));
        tree.add(new ShapeLeaf("Mangoes(Small Circles)", 3, ShapeLeaf.map("Seeds", 3)));
        village.add(tree);

        WaterSource pool = new WaterSource("Swimming Pool");
        pool.add(new ShapeLeaf("Pool Basin(Rectangle)", 40, ShapeLeaf.map("Cement", 30, "Steel", 10)));
        pool.add(new ShapeLeaf("Water(Rectangle)", 0, ShapeLeaf.map("WaterLiters", 5000)));
        village.add(pool);

        return village;
    }
}
