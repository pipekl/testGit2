import java.util.ArrayList;

public class Magician extends Hero {
    private ArrayList<Item> casts = new ArrayList<>();

    public Magician (String nickName) {
        super(nickName);
        super.exp = 0;
        super.hp = 100;
        super.mana = 2000;
        super.damage = 60;
        super.items = new ArrayList<>();

    }

    @Override
    public void attack(Enemy enemy) {
        if (casts.size() != 0 && mana >= 100) {
            enemy.hp -= 200 + damage;
            mana -= 100;
            casts.remove(0);
            System.out.println("\u001B[36mГерой расходует заклинание.\u001B[0m\n " +
                    "Осталось заклинаний: \u001B[36m" + casts.size() + "\u001B[0m");
        }
        else
            enemy.hp -= getDamage();
    }

    @Override
    public void defense(Enemy enemy) {
        if (enemy.hp > 0) {
            if (mana >= enemy.damage) {
                mana -= enemy.damage;
            }
            else
                hp -= enemy.damage;
        }
    }

    @Override
    public void openItem(Item item) {
        int num = (int) (Math.random() * ((100 - 1) + 1)) + 1;
        if (num > 50) {
            items.add(item);
            if (item.type == 2) {
                System.out.println("\u001B[34mГерой получил заклинание!\u001B[0m");
                casts.add(item);
                System.out.println("Всего заклинаний \u001B[34m" + casts.size() + "\u001B[0m");
            }
        }
    }

    @Override
    public void newLevel () {
        hp += 30;
        damage += 25;
        mana += 1000;
    }

    @Override
    public String toString() {
        return "Маг {" +
                "nickName='" + nickName + '\'' +
                ", exp=" + exp +
                ", hp=" + hp +
                ", mana=" + mana +
                ", items=" + items.size() +
                ", damage=" + damage +
                ", casts=" + casts.size() +
                '}';
    }
}
