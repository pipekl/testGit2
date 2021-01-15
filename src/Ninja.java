public class Ninja extends Enemy{
    public Ninja() {
        super.itemBonus = 3;
        super.hp = 1000;
        super.damage = 150;
        super.exp = 1200;
    }

    public int getItemBonus() {
        return itemBonus;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Нинзя {" +
                "hp=" + hp +
                ", damage=" + damage +
                ", itemBonus=" + itemBonus +
                ", exp=" + exp +
                '}';
    }
}
