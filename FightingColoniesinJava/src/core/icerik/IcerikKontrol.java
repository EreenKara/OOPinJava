/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Okunan icerigin kontrolu icin icerisinde fonksiyonlar barindiriyor.
* </p>
*/

package core.icerik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IcerikKontrol {
	
	public static boolean sayilaraAyrilabilirmi(String icerik)
	{
		Pattern oruntu=Pattern.compile("[^\\d\\s]"); // sayı veya boşluk dışındakileri bulan regex.
		Matcher eslesme=oruntu.matcher(icerik);
		if(eslesme.find()) return false;  // sayi veya bosluk disinda bir sey varsa false donuyor.
		return true;
	}
	public static boolean hepsiBoslukmu(String icerik)
	{
		if(icerik.matches("(\\s||\0)+")) return true;  // tamamı boşluk veya hicbir sey girilmemisse true donuyor..
		return false;
	}
}
