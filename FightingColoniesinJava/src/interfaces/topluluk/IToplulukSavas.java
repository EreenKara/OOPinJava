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

public interface IToplulukSavas {
	public void savasCanKaybet(long canKaybi);
	public long savasYemekKaybi();
	public void yemekKazanci(long yemekKazanci);
	public void kazanmaArttir();
	public void kaybetmeArttir();
	public int savas();

}
