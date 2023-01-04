package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 * @author Ahmet Kerem Burak 
 * @since Ocak, 2023
 * <p>
 * names.txt dosyasında istenen formatta bulunan verileri alır, içerisinden bilgileri alır,
 * birer Player nesnesi içine yerleştirir. Tüm playerların bilgilerini içeren bir dizi üretir. 
 *</p>
 */
public class Player {
	
	String name;
	float money;
	float bet;
	int number;

//	text dosyasından oyuncuların bilgilerini okur ve irdeler.
//	Bilgileri bir oyuncu nesnesinin içine yerleştirir
//	Oyuncuları bir diziye koyarak diziyi döndürür
	public Player[] playerGenerator(){
		LinkedList<String[]> info = null;
		try {
			info = splitter(reader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player[] players = new Player[10];
		int i = 0;
		
		for (String[] person : info) {
			Player ply = new Player();
			ply.setName(person[0]);
			ply.setMoney(Float.parseFloat(person[1]));
			ply.setBet(Float.parseFloat(person[2]));
			ply.setNumber(Integer.parseInt(person[3]));
			players[i] = ply;
			i++;
		}
		
		return players;
	}
	
//	Text dosyasını okur ve her satırı string olarak bir bağlı listeye ekler
	private LinkedList<String> reader() throws IOException {
		InputStreamReader ifr = new InputStreamReader(getClass().getResourceAsStream("/project/names.txt"));
		BufferedReader br = new BufferedReader(ifr);
		
		LinkedList<String> list = new LinkedList<String>();
		while(br.ready()) {
			list.add(br.readLine());
		}
		br.close();
		return list;
	}
	
//	String tutan bir bağlı listenin elemanlarını regex ile böler ve bir diziye koyar
//	Oluşan dizileri bir bağlı listeye doldurur ve listeyi döndürür
	private LinkedList<String[]> splitter(LinkedList<String> list) {
		LinkedList<String[]> people = new LinkedList<String[]>();
		for (String line : list) {
			people.add(line.split("#"));
		}
		return people;
	}
	
	public void win() {
		setMoney(getMoney() + (9*getBetMoney()));
	}
	
	public void lose() {
		setMoney(getMoney() - getBetMoney());
	}
	
	public int getBetMoney(){
		int betMoney = (int) (getMoney()*bet);
		return betMoney;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return (int) money;
	}


	public void setMoney(float money) {
		this.money =(int) money;
	}


	public float getBet() {
		return bet;
	}


	public void setBet(float bet) {
		this.bet = bet;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
