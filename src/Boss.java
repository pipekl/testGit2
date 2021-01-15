public class Boss extends Enemy{
    public Boss() {
        super.itemBonus = 5;
        super.hp = 20000;
        super.damage = 200;
        super.exp = 10000;
    }

    public int getItemBonus() {
        return itemBonus;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "hp=" + hp +
                ", damage=" + damage +
                ", itemBonus=" + itemBonus +
                ", exp=" + exp +
                '}';
    }
}
