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

import interfaces.topluluk.ITopluluk;

public interface ISavas {
	public ITopluluk savas(ITopluluk koloni1,ITopluluk koloni2);
//	public void savasSonuYapilacaklar(int savasSonucu,ITopluluk kazanan,ITopluluk kaybeden); // Bunun private olmasına karar verdim
}
