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

import java.util.List;
//import java.util.Map;

import interfaces.topluluk.ITopluluk;

public interface IOyunTuru {
	public void tur(List<ITopluluk> yasayanKoloniler); //içerisinde bir hashmap barındırsın 
//	public Map.Entry<String, String> eslesme();  // bunun private olmasına karar verdim
//	public void turSonuYapilacaklar(); // Bunun private olmasına karar veidm
	// oyun turu içerisinde savas fonksiyonun geri döndürüdüğü değerin ölüp ölmediğni kontrol etmek olacak
}
