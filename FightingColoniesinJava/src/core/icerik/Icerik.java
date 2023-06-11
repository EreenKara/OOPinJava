/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Sayi dizisi okuyan bir sınıf.
* </p>
*/


package core.icerik;

import java.io.IOException;
import interfaces.oyun.IEkran;


public class Icerik {
	private String icerik;  // son okunan içeriği içerisinde tutuyor.
	
	public Icerik() {
		icerik=null;
	}
	public String getIcerik() {return icerik;}
	
	private void setIcerik(String icerik)
	{
		this.icerik=icerik;
	}
	
	
	public int[] sayıDizisiOku(IEkran ekran)  
	{
		int [] sayilar=null;
		do {
			try {
				ekran.mesajGoster("Bir sayı dizisi giriniz: ");
				setIcerik(ekran.mesajAl());
				sayilar = IcerikParcala.splitNumbersToIntArray(icerik);
			} catch (IOException e) {
				ekran.mesajGoster(e.getMessage());
			}
		} while (sayilar==null);
		
		return sayilar;
	}
	
}
