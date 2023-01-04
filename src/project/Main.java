package project;

import java.io.IOException;

/**
 * @author Ahmet Kerem Burak
 * @since Ocak, 2023
 * <p>
 * Uygulamanın main classı. Table nesnesi oluşturur ardından şans oyununu başlatır.
 *</p>
 */
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Table table = new Table();
		table.playTillOver();
	}
}
