/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Low-couplity ilkesine uygun olmasi icin ( yani sonradan gelisime acik olmasi icin ) 
* siniflar arasina koydugum arayuz.
* </p>
*/

package interfaces.taktik;

import interfaces.topluluk.ITopluluk;

public interface ITaktik {
	// savasGucu olusturma mantigi toplulugu oldurmemeli oldururse
	// savas Sinifi icerisinde guncelleme yapmalisin.
	public 	int savasGucu(ITopluluk topluluk);
	

}
