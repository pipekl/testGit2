import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Enter enter = new Enter();
        Ninja ninja = new Ninja();
        Boss boss = new Boss();
        Wolf wolf = new Wolf();
        Map map = new Map();
        Item item = new Item(0,0,0);

        System.out.println("\u001B[36mВведите имя персонажа:\u001B[0m");
        String name = enter.name(scan);
        Hero myHero = enter.choiceHero(name);

        map.getMap();
        int mov;
        while (myHero.hp > 0) {
            do {
                System.out.println("Выберите команду: ");
                map.getCommands();
                mov = enter.moveWhere();
            }
            while (mov == 0);
            if (mov == 5)
                System.out.println(wolf);
            if (mov == 6)
                System.out.println(ninja);
            if (mov == 7)
                System.out.println(boss);
            if (mov == 8)
                System.out.println(myHero);

            int enem = map.scanEnemy(mov);

            if (enem == 1) {
                myHero.battle(new Wolf());
                item.items(myHero, wolf);
            }
            if (enem == 2) {
                myHero.battle(new Ninja());
                item.items(myHero, ninja);
            }
            if (enem == 3) {
                myHero.battle(new Boss());
                if (myHero.hp > 0) {
                    item.items(myHero, boss);
                    System.out.println("\u001B[36mВы прошли игру!\u001B[0m");
                    myHero.hp = 0;
                }
            }
            map.moveNumber(mov);
            map.getMap();
        }
    }
}