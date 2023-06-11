/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* IUretim arayuzunden implemente edilen Balikcilik uretimi gerceklemesi.
* </p>
*/

package core.uretim;

import interfaces.uretim.IUretim;

public class Balikcilik implements IUretim{

	/**
	 * @return geriye rastgele bir uretim miktari donduruyor.
	 */
	@Override
	public int uretmeMiktari()
	{
		return (int)(Math.random()*5+3); // 3-7   
	}

}
