/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Bunu modüler gelistirmedim cunku stream akislarina hakim degildim ancak
* ilerde duzenlemeye gidilebilcek sekilde bir yapiya musade ettigimi dusunuyorum.
* Istenilen cikti ve girdilerin bulundugu stream'e uygun olarak okuma ve yazma yapilabilir.
* </p>
*/

package core.oyun;

import java.util.Scanner;
import interfaces.oyun.IEkran;

public class Ekran implements IEkran{
	private Scanner in;
	public Ekran()
	{
		in=new Scanner(System.in);
	}
	/**
	 * ekrana parametre olarka veirlen mesaji yazdiriyor.
	 */
	@Override
	public void mesajGoster(String mesaj)
	{
		System.out.println(mesaj);
	}
	/**
	 * kullanicidan bir mesaj aliyor.
	 */
	@Override
	public String mesajAl()
	{
		return in.nextLine();
	}
	@Override
	public void ekraniTemizle()
	{
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			mesajGoster("Ekran temizleme basarisiz.");
		}
	}
	@Override
	public char karakterOku() {
		String yazi;
		do {
			System.out.println("Lutfen bir karakter giriniz:");
			yazi=in.next();
		} while (yazi.length()>1); // eğerki tek bir karakter girilmemişse tekrar kullanicidan bir girdi istiyor.
		return yazi.charAt(0);
	}
}
