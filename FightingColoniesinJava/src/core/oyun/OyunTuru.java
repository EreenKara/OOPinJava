/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Oyunda tur ici gerceklesecek seylerin mantigini iceren sinif.
* </p>
*/

package core.oyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import interfaces.oyun.IOyunTuru;
import interfaces.topluluk.ITopluluk;


// istersen oyun boyunca oyun turlarında ne olduğunu görebilmek için oyunturunun içerisinde
// yasayan kolonilieri felan tut ayrı olarak başlangıçta yani log kayıtları gibi kalsın
// ve eslesmeleride tutabilirsin. Ama bence gerek yok.
public class OyunTuru implements IOyunTuru{
	private Savas savas;
	private List<Entry<ITopluluk,ITopluluk>> eslesmeler;
//	private List<Koloni> yasayanKoloniler; // Bence alan olarak durmamalı. Yasayan koloniler oyun turuna ait değil oyuna ait
	public OyunTuru()
	{
		this.savas=new Savas(); 
		eslesmeler=null;
	}
	
	/**
	 * Yasayan kolonileri parametre olarak aliyorum. Parametre oalrka almamin sebebi
	 * her tur sonunda tur sonu yemek tuketimi esnasinda olen kolonileri oyun sinifi
	 * icerisinde tespit ediyor olmam.
	 * Yasayan koloniler'e gore savasSayisi'nii hesapliyorum yani yasayan koloni sayisinin
	 * 2 ile kombinasyonunu hesaplamis oluyorum.
	 * Sonra yasayan koloniler arasinda tur icinde eslesmemis olan siniflari eslestirip 
	 * savastiriyorum. Savas sonunda kayebden sinifin olup olmedigini kontrol edip
	 * olduyse yasayan koloniler'i guncelleyip yeni savas sayisini buluyorum.
	 * Cunku bir koloni olurse olasiklar guncellenmeli. Ancak olen koloni ile savasmis
	 * olduklari icin bu olasiligi dahil etmem gerekiyor ve toplamda
	 * yeni kombinasyon + olen sinifin savas sayisi kadar toplam savas olmali.
	 * for dongusunun kosulu her bir olen koloni oldugunda guncelleniyor.
	 * En son ise tur sonu yapilacak aktviteleri yaptirip fonksiyonu bitiryorum.
	 */
	@Override
	public void tur(List<ITopluluk> yasayanKoloniler) {
		eslesmeler =new ArrayList<Entry<ITopluluk,ITopluluk>>();
		int savasSayisi=(yasayanKoloniler.size()*(yasayanKoloniler.size()-1))/2;
		for (int i = 0; i < savasSayisi ; i++) {
			Entry<ITopluluk,ITopluluk> eslesme=eslesme(yasayanKoloniler);
			ITopluluk kaybeden = savas.savas(eslesme.getKey(), eslesme.getValue());
			
			//savasSayisini yasayan koloni sayısına göre güncelliyorum
			if(!(kaybeden.yasiyormu())) {
				yasayanKoloniler.remove(kaybeden);
				savasSayisi=(yasayanKoloniler.size()*(yasayanKoloniler.size()-1))/2;
				for (int j = 0; j < eslesmeler.size(); j++) {
					if(eslesmeler.get(j).getKey().equals(kaybeden) || eslesmeler.get(j).getValue().equals(kaybeden)) savasSayisi++;
				}
			}
		}
		turSonuYapilacaklar(yasayanKoloniler);
		eslesmeler=null;
	}
	/**
	 * Tur icinde daha onceden eslesmis olan kolonileri tekrar eslestirmiyorum.
	 * @param yasayanKoloniler --> disardan eslesme yapacagim topluluk koleksiyonunu aliyorum.
	 * @return eslesen iki toplulugu donduruyorum.
	 */
	private Entry<ITopluluk, ITopluluk> eslesme(List<ITopluluk> yasayanKoloniler) {
		boolean devammi;
		ITopluluk rasgeleTopluluk1;
		ITopluluk rasgeleTopluluk2;
		do {
			devammi=false;
			rasgeleTopluluk1=yasayanKoloniler.get((int)(Math.random()*yasayanKoloniler.size()));
			do {
				rasgeleTopluluk2=yasayanKoloniler.get((int)(Math.random()*yasayanKoloniler.size()));  // koloni'nin kendisi ile savasmasinin onune geciyorum.
			} while (rasgeleTopluluk1==rasgeleTopluluk2);
			
			for (int i = 0; i < eslesmeler.size(); i++) {
				if( (eslesmeler.get(i).getKey()==rasgeleTopluluk1 && eslesmeler.get(i).getValue()==rasgeleTopluluk2)  ||  
					(eslesmeler.get(i).getValue()==rasgeleTopluluk1 && eslesmeler.get(i).getKey()==rasgeleTopluluk2)  ) { // daha onceden bir eslesmislerse baska bir eslesme olmasi icin bunu gecersiz kiliyorum.
					devammi=true;
					break;
				}
			}
		} while (devammi); 
		Entry<ITopluluk,ITopluluk> eslesme=Map.entry(rasgeleTopluluk1, rasgeleTopluluk2); 
		eslesmeler.add(eslesme); // bir daha bu eslesmenin donmemesi icin kaydini aliyorum.
		return eslesme;
	}
	
	private void turSonuYapilacaklar(List<ITopluluk> yasayanKoloniler) {
		for (ITopluluk topluluk : yasayanKoloniler) {
			topluluk.populasyonArttir();
			topluluk.turSonuYemekTuket();
		}
	}
	
	
	
}
