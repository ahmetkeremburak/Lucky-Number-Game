package project;

/**
 * @author Ahmet Kerem Burak 
 * @since Ocak, 2023
 * <p>
 * House nesnesi üzerinden şans oyununu başlatır. Ekrana yazdırılacak bilgileri alan
 * ve düzenleyen metodları barındırır.
 *</p>
 */
public class Table {
	
//	Tüm oyuncular kaybedene kadar House nesnesi üzerinden oyunu döndürür.
	public void playTillOver() throws InterruptedException {
		House house = new House();
		while(house.getLosers().size() < house.getPlayers().length) {
			game(house);
			Thread.sleep(200);
			Console.clear();
		}
		gameOver(house);
	}
	
//	Konsola oyunun bir turu hakkında yazılacak bilgileri alır ve düzenleyip yazdırır.
	private void game(House house) {
		int luckyNumber = house.playGame();
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("SANSLI SAYI: ");
		System.out.printf("%-15s",luckyNumber);
		System.out.printf("%5s %n","##");
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
		System.out.printf("%20s", " ");
		System.out.printf("%-21s","##");
		System.out.printf("TUR: ");
		System.out.printf("%-15s",house.getRound());
		System.out.printf("%5s %n","##");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("MASA BAKIYE: ");
		System.out.printf("%-15s",house.getBank() + " TL");
		System.out.printf("%5s %n","##");
		System.out.printf("%20s", " ");
		System.out.println("##                                          ##");
		System.out.printf("%20s", " ");
		System.out.println("##------------------------------------------##");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("EN ZENGIN KISI ");
		System.out.printf("%18s %n", "##");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("%-20s",house.getBigShot().getName());
		System.out.printf("%13s%n","##");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("BAKIYESI: ");
		System.out.printf("%-15s",house.getBigShot().getMoney() + " TL");
		System.out.printf("%8s %n","##");
		System.out.printf("%20s", " ");
		System.out.println("##                                          ##");
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
	}
	
//	Oyun sonu ekranını yazdırır
	private void gameOver(House house) {
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
		System.out.printf("%20s", " ");
		System.out.printf("%-21s","##");
		System.out.printf("TUR: ");
		System.out.printf("%-15s",house.getRound());
		System.out.printf("%5s %n","##");
		System.out.printf("%20s", " ");
		System.out.printf("%-13s","##");
		System.out.printf("MASA BAKIYE: ");
		System.out.printf("%-15s",house.getBank() + " TL");
		System.out.printf("%5s %n","##");
		System.out.printf("%20s", " ");
		System.out.println("##                                          ##");
		System.out.printf("%20s", " ");
		System.out.println("##------------------------------------------##");
		System.out.printf("%20s", " ");
		System.out.println("##                OYUN BITTI                ##");
		System.out.printf("%20s", " ");
		System.out.println("##                                          ##");
		System.out.printf("%20s", " ");
		System.out.println("##                                          ##");
		System.out.printf("%20s", " ");
		System.out.println("##############################################");
		
		
	}
}
