/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* ITaktik arayuzunden implemente edilen Hilal taktigi gerceklemesi.
* </p>
*/

package core.taktik;

import interfaces.taktik.ITaktik;
import interfaces.topluluk.ITopluluk;
public class HilalTaktigi implements ITaktik{

	/**
	 * Tarihteki hilal taktigini dusundum ve nasil bir savas gucu dondurmesi 
	 * uygun olacaksa ona gore bir deger dondurdum.
	 * @return geriye rastgele bir savas gucu donduruyor.
	 */
	@Override
	public int savasGucu(ITopluluk topluluk) {
		int savasGucu;
		if(topluluk.getPopulasyon()>200) 
		{
			savasGucu=(int)((Math.random()*301 )+ 600); // 600-900
		}
		else
		{
			savasGucu=(int)((Math.random()*701 )+ 200); // 200-900
		}
		
		
		return savasGucu;
	}

}
