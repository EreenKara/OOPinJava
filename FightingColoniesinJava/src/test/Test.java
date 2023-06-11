/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Main blogu uygulamayi calistirabilmek icin.
* </p>
*/

package test;

import core.oyun.Oyun;
import interfaces.oyun.IOyun;

public class Test {

	public static void main(String[] args) {
		
		IOyun oyun=new Oyun();
		oyun.basla();
	}
}
