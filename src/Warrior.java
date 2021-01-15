import java.util.ArrayList;

public class Warrior extends Hero {

    public Warrior(String nickName) {
        super(nickName);
        super.exp = 0;
        super.hp = 500;
        super.mana = 10;
        super.damage = 150;
        super.items = new ArrayList<>();
    }

    @Override
    public void attack(Enemy enemy) {
        enemy.hp -= getDamage();
    }

    @Override
    public void defense(Enemy enemy) {
        if (enemy.hp > 0)
        hp -= enemy.damage;
    }

    @Override
    public void openItem(Item item) {
        int num = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        if (num > 50) {
            items.add(item);
            if (item.type == 1) {
                System.out.println("\u001B[34mГерой улучшил свое оружие! Урон +100\u001B[0m");
                damageUp();
            }
        }
    }

    public void damageUp() {
        damage += 100;
    }
    @Override
    public void newLevel () {
        hp += 200;
        damage += 20;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "nickName='" + nickName + '\'' +
                ", exp=" + exp +
                ", hp=" + hp +
                ", mana=" + mana +
                ", items=" + items.size() +
                ", damage=" + damage +
                '}';
    }
}