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

import interfaces.topluluk.ITopluluk;

public interface IOlustur {
	public List<ITopluluk> koloniOlustur(int[] sayilar); // kesinlikle aynı sembollerin gelmemesine dikkat et.
	
}
