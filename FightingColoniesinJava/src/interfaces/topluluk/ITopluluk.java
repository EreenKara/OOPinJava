/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Low-couplity ilkesine uygun olmasi icin ( yani sonradan gelisime acik olmasi icin ) 
* siniflar arasina koydugum arayuz.
* </p>
*/

package interfaces.topluluk;

public interface ITopluluk extends IToplulukSavas,IToplulukTurSonu{
	public long getPopulasyon();
	public long getYemekStogu();
	public char getSembol();
	public void yemekTuket(long yemekTuketimi);
	public boolean yasiyormu();
	public boolean equals(Object obj);
	// equals methodu override edilmeli
}
