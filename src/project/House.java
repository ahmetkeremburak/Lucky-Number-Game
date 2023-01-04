package project;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Ahmet Kerem Burak
 * @since Ocak, 2023
 * <p>
 * Player sınıfından bir ilkleme alır ve ekrana yazdırılacak bilgileri sağlayacak
 * metodları barındırır. Şans oyunu için gerekli olan koşulları kontrol eden ana metodlar
 * bu sınıftadır.
 *</p>
 */
public class House {
	private int bank = 0;
	private int round = 0;
	private Set<Player> losers = new HashSet<Player>();
	private Player bigshot;
	private Player[] players = new Player().playerGenerator();
	
//	Her çağrıldığında rastgele bir numara seçer, oyuncuların numarasıyla karşılaştırır
//	Eğer oyuncu kazanırsa kasadan parayı verir, kaybederse parasını kasaya atar.
	public int playGame() {
		int number = new Random().nextInt(1, 11);
		for (Player player : players) {
			if(player.getMoney() >= 1000 && losers.size() != 10) {
				if(player.getNumber() == number) {
					deductBank(9 * player.getBetMoney());
					player.win();
				}
				else {
					addBank(player.getBetMoney());
					player.lose();
					if(player.getMoney() < 1000) {
						losers.add(player);
					}
				}
			}
		}
		this.round++;
		return number;
	}
	
//	Oyunda en çok paraya sahip kullanıcıyı döndürür
	public Player getBigShot() {
		float temp = players[0].getMoney();
		for (Player player : players) {
			if(player.getMoney() >= 1000 && player.getMoney() >= temp ) {
					this.bigshot = player;
					temp = player.getMoney();
			}
			
		}
		return bigshot;
	}
	
	public int getBank() {
		return this.bank;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Set<Player> getLosers(){
		return losers;
	}
	
//	Bankaya para ekler
	public void addBank(int money) {
		this.bank = getBank() + money;
	}
	
//	Bankadan para eksiltir
	public void deductBank(int money) {
		this.bank = getBank() - money;
	}
}
