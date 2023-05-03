
import java.util.Random;

public class Match {

    Fighter f1;
    Fighter f2;

    int minWeight;
    int maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (isCheck()) {

            Random rand = new Random();
            int randomNumber = rand.nextInt(2) + 1; // 0-1 aralığından 1 ekleyerek 1 veya 2 üretir

            if (randomNumber == 1) {
                firstStart();

            } else {

                //2. oyuncunun başladığı durum
                secondStart();
            }

        } else {
            System.out.println("Sikletler Uyumsuz");
        }
    }

    void firstStart() {
        System.out.println("Oyuna " + this.f1.name + " başladı");
        while (this.f1.health > 0 && this.f2.health > 0) {

            System.out.println("****YENİ ROUND*****");
            this.f2.health = f1.hit(this.f2);
            if (isWin()) {
                break;
            }
            this.f1.health = this.f2.hit(this.f1);
            if (isWin()) {
                break;
            }
            System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
            System.out.println(this.f2.name + " Sağlık: " + this.f2.health);

        }
    }

    void secondStart() {
        System.out.println("Oyuna " + this.f2.name + " başladı");
        while (this.f1.health > 0 && this.f2.health > 0) {

            System.out.println("****YENİ ROUND*****");
            this.f1.health = this.f2.hit(this.f1);
            if (isWin()) {
                break;
            }
            this.f2.health = f1.hit(this.f2);
            if (isWin()) {
                break;
            }

            System.out.println(this.f1.name + " Sağlık: " + this.f1.health);
            System.out.println(this.f2.name + " Sağlık: " + this.f2.health);

        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " kazandı");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " kazandı");
            return true;
        }
        return false;
    }
}
