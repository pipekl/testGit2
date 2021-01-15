import java.util.ArrayList;

public class Archer extends Hero {

    public Archer(String nickName) {
        super(nickName);
        super.exp = 0;
        super.hp = 200;
        super.mana = 50;
        super.damage = 200;
        super.items = new ArrayList<>();

    }

    @Override
    public void attack(Enemy enemy) {
        int num = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        if (enemy.hp > 0)
            if (num <= 50) {
                System.out.println("\u001B[36mДополнительная атака!\u001B[0m Урон + " + (items.size()*10));
                enemy.hp -= getDamage();
                enemy.hp -= items.size()*10;
            }
            else
                enemy.hp -= getDamage();

    }

    @Override
    public void defense(Enemy enemy) {
        int num = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        if (enemy.hp > 0)
            if (num <= 30)
                System.out.println("\u001B[36mГерой уклонился от удара\u001B[0m");
            else
            hp -= enemy.damage;
    }

    @Override
    public void openItem(Item item) {
            items.add(item);
    }

    @Override
    public void newLevel() {
        hp += 150;
        damage += 50;
    }

    @Override
    public String toString() {
        return "Лучник {" +
                "nickName='" + nickName + '\'' +
                ", exp=" + exp +
                ", hp=" + hp +
                ", mana=" + mana +
                ", items=" + items.size() +
                ", damage=" + damage +
                '}';
    }
}