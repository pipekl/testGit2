
public class Map {
    String [][] map = {{"I___I","WOLF_","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},
            {"I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},
            {"I___I","I___I","I___I","NINJA","I___I","I___I","I___I","I___I","NINJA","I___I"},
            {"I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},
            {"I___I","I___I","I___I","I___I","I___I","I___I","WOLF_","I___I","I___I","I___I"},
            {"I___I","BOSS_","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},
            {"I___I","I___I","I___I","WOLF_","I___I","I___I","I___I","I___I","WOLF_","I___I"},
            {"I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},
            {"NINJA","I___I","I___I","I___I","I___I","\u001B[34m_YOU_\u001B[0m","I___I","I___I","I___I","NINJA"},
            {"I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I","I___I"},};

    public void getMap () {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public int scanEnemy (int num) {
        if (num == 1)
            return scanUp();
        if (num == 2)
            return scanDown();
        if (num == 3)
            return scanLeft();
        if (num == 4)
            return scanRight();
        return 0;
    }

    public int scanUp() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i - 1 >= 0 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i-1][j].equals("WOLF_")) {
                        System.out.println("Впереди Волк!");
                        return 1;
                    }
                    if (map[i-1][j].equals("NINJA")) {
                        System.out.println("Впереди Нинзя!");
                        return 2;
                    }
                    if (map[i-1][j].equals("BOSS_")) {
                        System.out.println("Впереди Босс!");
                        return 3;
                    }
                }
            }
        }
        return 0;
    }

    public int scanDown() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i+1 <= map.length-1 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i+1][j].equals("WOLF_")) {
                        System.out.println("Впереди Волк!");
                        return 1;
                    }
                    if (map[i+1][j].equals("NINJA")) {
                        System.out.println("Впереди Нинзя!");
                        return 2;
                    }
                    if (map[i+1][j].equals("BOSS_")) {
                        System.out.println("Впереди Босс!");
                        return 3;
                    }
                }
            }
        }
        return 0;
    }

    public int scanLeft() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j-1 >= 0 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i][j-1].equals("WOLF_")) {
                        System.out.println("Впереди Волк!");
                        return 1;
                    }
                    if (map[i][j-1].equals("NINJA")) {
                        System.out.println("Впереди Нинзя!");
                        return 2;
                    }
                    if (map[i][j-1].equals("BOSS_")) {
                        System.out.println("Впереди Босс!");
                        return 3;
                    }
                }
            }
        }
        return 0;
    }

    public int scanRight() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j+1 <= map.length-1 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i][j+1].equals("WOLF_")) {
                        System.out.println("Впереди Волк!");
                        return 1;
                    }
                    if (map[i][j+1].equals("NINJA")) {
                        System.out.println("Впереди Нинзя!");
                        return 2;
                    }
                    if (map[i][j+1].equals("BOSS_")) {
                        System.out.println("Впереди Босс!");
                        return 3;
                    }
                }
            }
        }
        return 0;
    }

    public void moveNumber (int num) {
        if (num == 1)
            moveUp();
        if (num == 2)
            moveDown();
        if (num == 3)
            moveLeft();
        if (num == 4)
            moveRight();
    }

    public void moveUp() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i - 1 >= 0 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i-1][j].equals("WOLF_") || map[i-1][j].equals("NINJA") || map[i-1][j].equals("BOSS_")) {
                        map[i-1][j] = "\u001B[34m_YOU_\u001B[0m";
                        map[i][j] = "I___I";
                        i = map.length;
                        break;
                    }
                    String temp = map[i][j];
                    map[i][j] = map[i-1][j];
                    map[i-1][j] = temp;
                    i = map.length;
                    break;
                }
            }
        }
    }

    public void moveDown() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i+1 <= map.length-1 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i+1][j].equals("WOLF_") || map[i+1][j].equals("NINJA") || map[i+1][j].equals("BOSS_")) {
                        map[i+1][j] = "\u001B[34m_YOU_\u001B[0m";
                        map[i][j] = "I___I";
                        i = map.length;
                        break;
                    }
                    String temp = map[i][j];
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = temp;
                    i = map.length;
                    break;
                }
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j-1 >= 0 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i][j-1].equals("WOLF_") || map[i][j-1].equals("NINJA") || map[i][j-1].equals("BOSS_")) {
                        map[i][j-1] = "\u001B[34m_YOU_\u001B[0m";
                        map[i][j] = "I___I";
                        i = map.length;
                        break;
                    }
                    String temp = map[i][j];
                    map[i][j] = map[i][j-1];
                    map[i][j-1] = temp;
                    i = map.length;
                    break;
                }
            }
        }
    }

    public void moveRight() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j+1 <= map.length-1 && map[i][j].equals("\u001B[34m_YOU_\u001B[0m")) {
                    if (map[i][j+1].equals("WOLF_") || map[i][j+1].equals("NINJA") || map[i][j+1].equals("BOSS_")) {
                        map[i][j+1] = "\u001B[34m_YOU_\u001B[0m";
                        map[i][j] = "I___I";
                        i = map.length;
                        break;
                    }
                    String temp = map[i][j];
                    map[i][j] = map[i][j+1];
                    map[i][j+1] = temp;
                    i = map.length;
                    break;
                }
            }
        }
    }


    public void getCommands() {
        System.out.println("1 - Вверх");
        System.out.println("2 - Вниз");
        System.out.println("3 - Влево");
        System.out.println("4 - Вправо");
        System.out.println();
        System.out.println("5 - Волк");
        System.out.println("6 - Нинзя");
        System.out.println("7 - Босс");
        System.out.println("8 - Персонаж");
    }
}
