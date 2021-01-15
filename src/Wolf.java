public class Wolf extends Enemy {
    public Wolf() {
        super.itemBonus = 1;
        super.hp = 500;
        super.damage = 25;
        super.exp = 500;
    }

    public int getItemBonus() {
        return itemBonus;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "hp=" + hp +
                ", damage=" + damage +
                ", itemBonus=" + itemBonus +
                ", exp=" + exp +
                '}';
    }
}

