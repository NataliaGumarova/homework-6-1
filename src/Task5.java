import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите атаку дракона");
        int dragonAttack = scan.nextInt();
        System.out.println("Введите здоровье дракона");
        int dragonHp = scan.nextInt();
        System.out.println("Введите атаку копейщика");
        int spearAttack = scan.nextInt();
        System.out.println("Введите здоровье копейщика");
        int spearHp = scan.nextInt();
        System.out.println(minQuantitySoldiers(dragonAttack,dragonHp,spearAttack,spearHp));
    }

    static int minQuantitySoldiers(int dragonAttack, int dragonHp, int spearAttack, int spearHp) {
        int quantity = 1;// минимально возможное количество солдат
        //максимально возможное количество копейщиков(жизнь дракона/атака всех копейщиков)
        two: while (quantity <= dragonHp/(spearAttack * quantity)) {
            int quantityNow = quantity;
            int hpSpears = spearHp * quantity;
            int hpDragon = dragonHp;
            while (hpDragon > 0) {
                // атака копейщиков
                int attackSrearForDragon = quantityNow * spearAttack;
                hpDragon = hpDragon - attackSrearForDragon;
                if (hpDragon <= 0) {
                    return quantity;
                }
                // атака дракона
                hpSpears = quantityNow * spearHp - dragonAttack;
                // если дракон победил, добавляем 1 копейщика и начинаем цикл заново
                if (hpSpears <= 0 ) {
                    quantity++;
                    continue two;
                    // количество копейщиков после атаки если остался раненый
                } else if (hpSpears % spearHp != 0) {
                    quantityNow = hpSpears / spearHp;
                    quantityNow++;
                    // количество копейщиков после атаки если раненых нет
                } else if (hpSpears % spearHp == 0) {
                    quantityNow = hpSpears / spearHp;
                }
            }
        }
        return quantity;
    }
}
