/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Low-couplity ilkesine uygun olmasi icin ( yani sonradan gelisime acik olmasi icin ) 
* siniflar arasina koydugum arayuz.
* </p>
*/


package interfaces.oyun;

public interface IEkran {
	void mesajGoster(String mesaj);
	public void ekraniTemizle();
	public char karakterOku();
	String mesajAl();
}
