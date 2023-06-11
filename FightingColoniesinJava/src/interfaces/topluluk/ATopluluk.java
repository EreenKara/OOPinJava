/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Butun topluluklarda olmasini istedigim temel field'lari ve
* temel fonksiyonlari belirledim.
* Belirlemedigim fonksiyonlar o toplulugun ozel olarak yazmasi gereken
* fonksiyonlardır.
* Bu soyut siniftan kalitim alacak olan diğer topluluklar asagidaki
* fonksiyonlari bu sekliyle kullanmali.
* Tanimlamadigim fonksiyonlari ise kendi mantiklarina gore tekrar yazmalilar.
* </p>
*/

package interfaces.topluluk;

import core.topluluk.Koloni;
import interfaces.taktik.ITaktik;
import interfaces.uretim.IUretim;

public abstract class ATopluluk implements ITopluluk {

	protected long populasyon;
	protected long yemekStogu;
	protected ITaktik taktik;
	protected IUretim uretim;
	protected char sembol; 	// sembol unique olmalı 
	protected int kazanma;
	protected int kaybetme;
	
	@Override
	public long getPopulasyon() {
		return this.populasyon;
	}
	@Override
	public long getYemekStogu() {
		return this.yemekStogu;
	}
	@Override
	public char getSembol() {
		return sembol;
	}
	public int getKazanma() {
		return this.kazanma;
	}
	public int getKaybetme() {
		return this.kaybetme;
	}
	@Override
	public void kazanmaArttir() {
		this.kazanma++;
	}
	@Override
	public void kaybetmeArttir() {
		this.kaybetme++;
	}
	
	/**
	 * savas gucu dondurebilmek icin taktik sinifinin savas fonksiyonun cagiriyor.
	 */
	@Override
	public int savas() {
		return taktik.savasGucu(this);
	}
	
	
	@Override
	public boolean yasiyormu() {
		if(populasyon>0 && yemekStogu>0) return true;
		return false;
	}
	
	/**
	 * Her koloninin unique bir sembolu oldugundan dolayi sembole gore bir karsialstirma yapiyorum 
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj==null || !(obj instanceof Koloni)) return false ;
		if(this.sembol==((Koloni)obj).getSembol()) return true;
		return false;
	}

}
