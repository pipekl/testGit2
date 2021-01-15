public class Item {
    int price, weight, type;
    public Item(int price, int weight, int type){
        this.price = price;
        this.weight = weight;
        this.type = type;
    }

    public void items (Hero hero, Enemy enemy) throws InterruptedException {
        for (int i = 0; i < enemy.itemBonus*10; i++) {
            Item item = new Item(0, 0, i % 3);
            hero.openItem(item);
        }
        System.out.println("Всего собрано предметов: " + hero.items.size());
        Thread.sleep(2000);
    }
}