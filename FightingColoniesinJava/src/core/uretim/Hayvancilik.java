/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* IUretim arayuzunden implemente edilen Hayvancilik uretimi gerceklemesi.
* </p>
*/

package core.uretim;

import interfaces.uretim.IUretim;

public class Hayvancilik implements IUretim {

	/**
	 * @return geriye rastgele bir uretim miktari donduruyor.
	 */
	@Override
	public int uretmeMiktari() {
		return (int)(Math.random()*6+3);  // 3-8
	}

}
