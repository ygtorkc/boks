import java.util.Random;

class Boxer {
    private String name;
    private int energy;
    private int attackPower;
    private int defensePower;

    public Boxer(String name, int energy, int attackPower, int defensePower) {
        this.name = name;
        this.energy = energy;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void attack(Boxer opponent) {
        int damage = this.attackPower - opponent.getDefensePower();
        if (damage > 0) {
            opponent.setEnergy(opponent.getEnergy() - damage);
        }
    }
}

class Fight {
    private Boxer boxer1;
    private Boxer boxer2;

    public Fight(Boxer boxer1, Boxer boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }

    public void startFight() {
        Random random = new Random();
        while (boxer1.getEnergy() > 0 && boxer2.getEnergy() > 0) {
            if (random.nextBoolean()) {
                boxer1.attack(boxer2);
            } else {
                boxer2.attack(boxer1);
            }
        }

        if (boxer1.getEnergy() <= 0 && boxer2.getEnergy() <= 0) {
            System.out.println("The fight was a draw!");
        } else if (boxer1.getEnergy() <= 0) {
            System.out.println(boxer2.getName() + " won the fight!");
        } else {
            System.out.println(boxer1.getName() + " won the fight!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("Boxer 1", 100, 10, 5);
        Boxer boxer2 = new Boxer("Boxer 2", 100, 10, 5);

        Random random = new Random();
        int firstFighter = random.nextInt(2);

        Fight fight;
        if (firstFighter == 0) {
            fight = new Fight(boxer1, boxer2);
        } else {
            fight = new Fight(boxer2, boxer1);
        }

        fight.startFight();
    }
}
