/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Oyunu baslatabilmek olusturma mantigini icinde barindiran sinif.
* İcerisinde kolonileri olusturabiliyor. 
* Rastgele bir taktik ve uretim donduren fonksiyonlar barindiriyor.
* </p>
*/

package core.oyun;

import java.util.ArrayList;
import java.util.List;

import core.taktik.HilalTaktigi;
import core.taktik.KamikazeTaktigi;
import core.taktik.PartVurusuTaktigi;
import core.taktik.TruvaTaktigi;
import core.topluluk.Koloni;
import core.uretim.Avcilik;
import core.uretim.Balikcilik;
import core.uretim.Hayvancilik;
import core.uretim.Tarim;
import interfaces.oyun.IOlustur;
import interfaces.taktik.ITaktik;
import interfaces.topluluk.ITopluluk;
import interfaces.uretim.IUretim;

public class Olustur implements IOlustur{

	@Override
	public List<ITopluluk> koloniOlustur(int[] sayilar){
		if(sayilar.length>444) throw new IllegalArgumentException("444'den fazla sayi giremezsiniz"); // cunku 444 tane farkli sembol atıyorum.
		List<ITopluluk> koloniler=new ArrayList<ITopluluk>();
		for (int i = 0; i < sayilar.length; i++) {  // girilen sayı adedince koloni olusturuyorum;
			ITaktik taktik = rastgeleTaktik();
			IUretim uretim = rastgeleUretim();
			char sembol=(char)((int)((Math.random()*444)+200)); // 444 tane sembol arasinda dolasiyorum.
			boolean devammi;
			do {
				devammi=false;
				for (ITopluluk topluluk : koloniler) { // sembol burda ayırt edici özellik olmalı bu yüzden diğer kolonileri tarıyorum ve eşsiz bir tane bulmaya çalışıyorum
					if(topluluk.getSembol()==sembol) 
					{
						sembol=(char)((int)(Math.random()*444)+200);
						devammi=true;
						break;
					}
				}
			}while (devammi);
			koloniler.add(new Koloni(sayilar[i], sembol, taktik, uretim));
		}
		return koloniler;
	}
	/**
	 * 
	 * @return rastgele bir taktik donduruyor.
	 */
	private ITaktik rastgeleTaktik() {
		int secim=(int)(Math.random()*4);  // rastgele 4'unden birini secmek icin 0-3
		ITaktik taktik=null;
		switch (secim) {
		case 0:
			taktik=new HilalTaktigi();
			break;
		case 1:
			taktik=new KamikazeTaktigi();
			break;
		case 2:
			taktik=new PartVurusuTaktigi();
			break;
		case 3:
			taktik=new TruvaTaktigi();
			break;
		default:
			break;
		}
		return taktik;
	}
	/**
	 * 
	 * @return rastgele bir uretim donduruyor.
	 */
	private IUretim rastgeleUretim() {
		int secim=(int)(Math.random()*4); // rastgele 4'unden birini secmek icin 0-3
		IUretim uretim=null;
		switch (secim) {
		case 0:
			uretim=new Avcilik();
			break;
		case 1:
			uretim=new Balikcilik();
			break;
		case 2:
			uretim=new Hayvancilik();
			break;
		case 3:
			uretim=new Tarim();
			break;
		default:
			break;
		}
		return uretim;
	}

}
