import java.util.Scanner;

public class Enter{

    public String name (Scanner scan) {
        String name = scan.nextLine();
        if (name.length() > 10)
            System.out.println("Короче 10 символов");
        return name;
    }

    public Hero choiceHero (String name) throws InterruptedException {

        System.out.println(" Выберите героя: \n");

        System.out.println("1. Воин: \n здоровье - 500, мана - 10, урон - 150. \n" +
                "Новый уровень дает +200 здоровья и +20 урона.\n" +
                "Если воин имеет предмет 1 типа, к его урону добавляется 100.\n");

        System.out.println("2. Лучник:\n здоровье - 200, мана - 50, урон - 200.\n" +
                "В процессе атаки лучник имеет 30% шанс избежать урон\n" +
                "и 50% шанс нанести дополнительный урон за каждый собранный предмет *10\n" +
                "Новый уровень дает +150 здоровья и +50 урона.\n"  +
                "Лучник всегда находит предмет!\n");

        System.out.println("3. Маг:\n здоровье - 100, мана - 2000, урон - 60.\n" +
                "Новый уровень дает +30 здоровья, 1000 маны и +25 урона.\n" +
                "Маг имеет возможность бить заклинанием в процессе атаки.\n" +
                "Защита мага осуществляется магическим щитом, \n" +
                "который поглащает весь урон, но вместо здоровья тратит ману.\n");
        int num;
        do {
            num = choiceHeroChecking();
        }
        while (num == 0);

        if (num == 1) {
            System.out.println("Вы выбрали Воина!");
            Thread.sleep(1000);
            return new Warrior(name);
        }
        if (num == 2) {
            System.out.println("Вы выбрали Лучника!");
            Thread.sleep(1000);
            return new Archer(name);
        }
        if (num == 3) {
            System.out.println("Вы выбрали Мага!");
            Thread.sleep(1000);
            return new Magician(name);
        }
        return new Warrior(name);
    }

    public int choiceHeroChecking () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 1, 2 или 3:");
        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i >= 1 && i <= 3)
                return i;
            else
                System.out.println("Вы ввели что-то не то...");
        }
        else
            System.out.println("Вы ввели что-то не то...");
        return 0;
    }

    public int moveWhere () {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i >= 1 && i <= 8)
                return i;
            else
                System.out.println("Вы ввели что-то не то...");
        }
        else
            System.out.println("Вы ввели что-то не то...");
        return 0;
    }
}
