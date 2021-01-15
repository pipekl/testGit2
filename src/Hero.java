import java.util.ArrayList;

abstract class Hero {

    protected String nickName;
    protected int exp, hp, mana;
    protected ArrayList<Item> items = new ArrayList<>();
    protected int damage;

    public Hero(String nickName) {
        this.nickName = nickName;
    }

    public void newExp(Enemy enemy) {
        int lvl = exp/500;
        exp += enemy.exp;
        if (exp/500 > lvl) {
            System.out.printf("\u001B[32mНовый уровень!\u001B[0m Теперь ваш уровень \u001B[32m%d\u001B[0m\n", exp / 500);
            while (exp / 500 != lvl) {
                newLevel();
                lvl++;
            }
        }
    }

    public void battle (Enemy enemy) throws InterruptedException {
        System.out.println("  Герои { hp=" + hp + " mana=" +
                mana + " }");
        System.out.println("  Враг { hp=" + enemy.hp + " }");

        int counter = 1;
        while (hp > 0 & enemy.hp > 0) {
            Thread.sleep(1000);
            System.out.println(counter++ + " раунд:");
            attack(enemy);
            defense(enemy);
            System.out.println("    Герои { hp=" + hp + " mana=" + mana + " }");
            System.out.println("    Враг { hp=" + enemy.hp + " }");
        }
        if (hp > 0)
            newExp(enemy);
        System.out.println(hp > 0 ? "Победа, герой получил опыт " + enemy.exp : "Поражение");
        System.out.printf("Герой { HP=%d, MANNA=%d, damage=%d, exp=%d }\n\n", hp, mana, damage, exp);
        Thread.sleep(2000);
    }

    public int getDamage(){
        return damage;
    }

    public abstract void attack(Enemy enemy);

    public abstract void defense(Enemy enemy);

    public abstract void openItem(Item item);

    public abstract void newLevel();
}