/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Oyunu baslatan sinif bu oluyor.
* Oyunun baslamasi icin gereklilikleri hazirlayip oyunu baslatiyor.
* Oyun bitinceye dek turlamaya devam ettiriyor.
* </p>
*/

package core.oyun;

import java.util.List;
import java.util.stream.Collectors;

import core.icerik.Icerik;
import interfaces.oyun.IEkran;
import interfaces.oyun.IOlustur;
import interfaces.oyun.IOyun;
import interfaces.oyun.IOyunTuru;
import interfaces.topluluk.ITopluluk;

public class Oyun implements IOyun {
	private List<ITopluluk> koloniler;
	private List<ITopluluk> yasayanKoloniler;
	private IOyunTuru oyunTuru; 
	private Icerik icerik;
	private IEkran ekran;
	private IOlustur olustur;
	private int turSayisi; 
	
	public Oyun() {
		icerik=null;
		oyunTuru=new OyunTuru();  // aslında bu low copulity ilkesine aykırı ama NYAT videolarında bu konu daha işlenmedi yapamadım.
		ekran=new Ekran();
		olustur=new Olustur();
		turSayisi=0;
		koloniler=null;
		yasayanKoloniler=null;
	}
	
	/**
	 * Oyunu baslatip bitiren fonksiyon 
	 */
	
	@Override
	public void basla() {
//		char ch='H';
//		do {
//			ch='H';
//			ekran.ekraniTemizle(); // eclips'te hata verdiginden yorum satiri yaptim.
			icerik=new Icerik();
			turSayisi=0;
			
			
			do {
				try {
					koloniler = olustur.koloniOlustur(icerik.sayıDizisiOku(ekran)); // egerki 444'ten fazla bir sayi girilmisse hata firlatiliyor
					
				} catch (Exception e) {
					
					ekran.mesajGoster(e.getMessage());
				}
			} while (koloniler==null);
			
			yasayanKoloniler=koloniler.stream().collect(Collectors.toList());  // burda koloniler'i yasayankolonilere KOPYALIYORUM.
			yasayanKolonileriGuncelle();
			ekran.mesajGoster(kolonileriYazdir());
			
			while(yasayanKoloniler.size()>1) {   // 1 kişide kalmış olabilir 0'da . ikisinde de oyun biter.
				oyunTuru.tur(yasayanKoloniler);
				turSayisi++;
				yasayanKolonileriGuncelle();  // tur sonu yemekTuketimi sonrasi olen kolonileri tespit edip siliyorum.
				ekran.mesajGoster(kolonileriYazdir());
			}
			
			icerik=null;
			koloniler=null;
			yasayanKoloniler=null;
			
//			do {
//				ekran.mesajGoster("Yeni bir oyuna başlamak istermisiniz? (E/H)");
//				ch=ekran.karakterOku();
//				Character.toUpperCase(ch);
//			} while (!(ch=='E'||ch=='H'));
//		} while (ch=='E');
			
		System.out.println("Oyun bitti.");
	}
	private void yasayanKolonileriGuncelle() {  // butun yasayan kolonilerde gezip yasayamayan varsa onu siliyorum
		// asagidaki for dongusundeki hata yasayanlar.size() bir uye silindikten sonra guncelleniyor bu da bana sıkıntı yaratıyor.
//		for (int i = 0; i < yasayanKoloniler.size(); i++) {
//			if((yasayanKoloniler.get(i).yasiyormu())) System.out.println("yasayan koloni: "+yasayanKoloniler.get(i).toString());
//			if(!(yasayanKoloniler.get(i).yasiyormu())) System.out.println("yasamayan koloni: "+yasayanKoloniler.get(i).toString());
//			if(!(yasayanKoloniler.get(i).yasiyormu())) yasayanKoloniler.remove(i);
//			
//		}
		for (ITopluluk topluluk : koloniler) {
			if(!(topluluk.yasiyormu())) yasayanKoloniler.remove(topluluk);
		}
	}

	/**
	 * @return bizden istenilen sekilde bir ciktiyi donduruyor.
	 */
	public String kolonileriYazdir()  // toString yapamk istemedim cunku oyun'u yazdirmiyorum.Kolonileri yazdiriyorum.
	{	
		String yazi="\n------------------------------------------------------------\n";
		yazi+=String.format("Tur sayisi: %d \n",turSayisi );
		yazi+="Koloni\tPopulasyon\tYemekStogu\tKazanma\tKaybetme\n";
		for (ITopluluk topluluk : koloniler) {
			yazi+=topluluk.toString();
		}
		yazi+="\n-----------------------------------------------------------\n";
		return yazi;
	}

//	private boolean oyunBittimi() {  // oyun turu bitince yemek yiyorlar ve yemek stokları bitebilir bu yüzden burda kontrol etireceğim
//	
//	return false;
//}

}
