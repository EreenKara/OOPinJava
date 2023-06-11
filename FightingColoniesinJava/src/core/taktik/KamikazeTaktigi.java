/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* ITaktik arayuzunden implemente edilen Kamikaze taktigi gerceklemesi.
* </p>
*/

package core.taktik;

import interfaces.taktik.ITaktik;
import interfaces.topluluk.ITopluluk;


public class KamikazeTaktigi implements ITaktik{

	/**
	 * Tarihteki kamikaze taktigini dusundum ve nasil bir savas gucu dondurmesi 
	 * uygun olacaksa ona gore bir deger dondurdum.
	 * @return geriye rastgele bir savas gucu donduruyor.
	 */
	@Override
	public int savasGucu(ITopluluk topluluk) {
		int savasGucu;
		if(topluluk.getPopulasyon()>8) 
		{
			savasGucu=(int)((Math.random()*301 )+ 700);  // 700-1000
			topluluk.savasCanKaybet(8);
		}
		else savasGucu=(int)(Math.random()*501); // 0-500
		return savasGucu;
	}

}
