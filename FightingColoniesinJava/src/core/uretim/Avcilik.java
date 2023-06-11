/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* IUretim arayuzunden implemente edilen Avcilik uretimi gerceklemesi.
* </p>
*/

package core.uretim;

import interfaces.uretim.IUretim;

public class Avcilik implements IUretim{

	/**
	 * @return geriye rastgele bir uretim miktari donduruyor.
	 */
	@Override
	public int uretmeMiktari() {	
		return (int)(Math.random()*11); //0-10  aslında 10.9999 bile dönebilir ama int'e çeviriyorum o yüzden 0-10 arası değerler gelecek
	}

	

}
