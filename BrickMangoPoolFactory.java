public class BrickMangoPoolFactory implements VillageComboFactory {

    @Override
    public String getComboName() {
        return "Brick House + Mango Tree + Swimming Pool";
    }

    @Override
    public Village createVillage(String villageName) {
        Village village = new Village(villageName);

        House house = new House("Brick House");
        house.add(new RectangleShape("Wall", 30, SimpleShape.map("Bricks", 50, "Cement", 10)));
        house.add(new TriangleShape("Roof", 18, SimpleShape.map("Tiles", 20, "Wood", 5)));
        house.add(new RectangleShape("Door", 6, SimpleShape.map("Wood", 4)));
        village.add(house);

        Tree tree = new Tree("Mango Tree");
        tree.add(new CylinderShape("Trunk", 5, SimpleShape.map("Wood", 6)));
        tree.add(new CircleShape("Canopy", 4, SimpleShape.map("Leaves", 20)));
        tree.add(new CircleShape("Mangoes", 3, SimpleShape.map("Seeds", 3)));
        village.add(tree);

        WaterSource pool = new WaterSource("Swimming Pool");
        pool.add(new RectangleShape("Pool Basin", 40, SimpleShape.map("Cement", 30, "Steel", 10)));
        pool.add(new RectangleShape("Water", 0, SimpleShape.map("WaterLiters", 5000)));
        village.add(pool);

        return village;
    }
}