/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* ITaktik arayuzunden implemente edilen Truva taktigi gerceklemesi.
* </p>
*/


package core.taktik;

import interfaces.taktik.ITaktik;
import interfaces.topluluk.ITopluluk;

public class TruvaTaktigi implements ITaktik{

	/**
	 * Tarihteki Truva taktigini dusundum ve nasil bir savas gucu dondurmesi 
	 * uygun olacaksa ona gore bir deger dondurdum.
	 * @return geriye rastgele bir savas gucu donduruyor.
	 */
	@Override
	public int savasGucu(ITopluluk topluluk) {
		int savasGucu;
		
		if(topluluk.getPopulasyon()>3 && topluluk.getPopulasyon()<25)
		{
			savasGucu=(int)((Math.random()*301 )+ 600); // 600-900
			topluluk.savasCanKaybet(3);
			
		}
		else savasGucu=(int)(Math.random()*801 ); // 0-800

		return savasGucu;
	}

}
