/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* ATopluluk soyut sinifindan kalitim almis koloni gerceklemesi.
* Icerisinde bir toplulugun yapmasi gereken fonksiyonlari barindiryor.
* Yemek yiyebiliyor, savas sonunda populasyon kaybedebiliyor vs.
* ATopluluk icerisinde tanimlamadigim kendi mantigini barindiran fonksiyonlar
* burada yer almakta. Ornegin savas sonucu kaybedilen yemek miktari %10
* olmak zorunda degil. Ama bu toplulukta %10 miktarinda yemek kaybi var.
* </p>
*/


package core.topluluk;

import interfaces.taktik.ITaktik;
import interfaces.topluluk.ATopluluk;
import interfaces.uretim.IUretim;

public class Koloni extends ATopluluk{

//	private long populasyon;
//	private long yemekStogu;
//	private ITaktik taktik;
//	private IUretim uretim;
//	private char sembol; // sembol unique olmalı 
//	private int kazanma;
//	private int kaybetme;
	
	
	public Koloni(long populasyon,char sembol,ITaktik taktik,IUretim uretim)
	{
		setPopulasyon(populasyon);
		if(populasyon>0)setYemekStogu((long)Math.pow(populasyon, 2));
		else setYemekStogu(0);
		this.taktik=taktik;
		this.uretim=uretim;
		this.kazanma=0;
		this.kaybetme=0;
		this.sembol=sembol;
	}
	
	private void setPopulasyon(long populasyon) {  // - bir değer girilebilir. 
		this.populasyon=populasyon;
	}
	private void setYemekStogu(long yemekStogu) {
		this.yemekStogu=yemekStogu;
		
	}
	
	/**
	 * savas sonucunda savas sonucuna gore kaybedecegi can'i kaybediyor.
	 * Egerki girilen acn kaybi 0'dan kucukse veya koloni yasamiyorsa
	 * hata firlatiliyor.
	 */
	@Override
	public void savasCanKaybet(long canKaybi) {
		if(canKaybi<0) throw new IllegalArgumentException("Can kaybi sifirdan kucuk olamaz");
		if(!yasiyormu()) throw new IllegalCallerException("Koloni yasamadigindan can kaybedemez"); 
		if(canKaybi<2) canKaybi=2;
		setPopulasyon(this.populasyon-canKaybi);
	}
	/**
	 * savas sonucunda koloni kaybettiyse yemek kaybediyor.
	 * @return kaybettigi yemek miktarini geriye donduruyorki kazanan sinif bu miktarda yemek kazansin.
	 */
	@Override
	public long savasYemekKaybi() {
		if(yemekStogu<=0) throw new IllegalCallerException("Koloninin yemegi olmadigindan yemek kaybedemez");
		long yemekKaybi=this.yemekStogu/10;
		setYemekStogu(yemekStogu-yemekKaybi); 
											  
		return yemekKaybi;
	}
	/**
	 * savas sonucunda koloni kazandiysa kaybeden koloninin kaybettigi kadar yemek kazaniyor.
	 */
	@Override
	public void yemekKazanci(long yemekKazanci) {
		if(yemekKazanci<0) throw new IllegalArgumentException("Yemek kazanci sifirdan kucuk olamaz.");
		setYemekStogu(yemekStogu+yemekKazanci);
	}
	
	/**
	 * tur sonunda yemek uretebilmek icin uretim sinifinin uretim fonksiyonunu
	 * cagirip kendi yemek stogunun ustune ekliyor.
	 * Koloni yasamiyorsa exception firlatiyor.
	 */
	@Override
	public void yemekUret() {
		if(!this.yasiyormu()) throw new IllegalCallerException("Koloni yasamadigi icin yemek stogu artamaz");
		setYemekStogu(yemekStogu+uretim.uretmeMiktari());
	}

	/**
	 * tur sonu koloni populasyon sayisini arttiriyor.
	 * Egerki koloni yasarmiyorsa exception filatiyor.
	 */
	@Override
	public void populasyonArttir() {  // aslında aşağıdaki konrtole gerek yok. Eğerki popülasyon 0'dan küçükse zaten bu fonksiyon çağrılmaz
		if(!this.yasiyormu()) throw new IllegalCallerException("Koloni yasamadigi icin populasyonu artamaz");
		setPopulasyon(populasyon+populasyon/5);
	}
	/**
	 * @param yemekTuketimi parametresi kadar yemek stogundan yemek azaltiyor.
	 * Egerki verilen parametre 0'dan kucukse exception firlatiliyor.
	 * Egerki koloni yasamiyorsa exception firlatiliyor.
	 */
	public void yemekTuket(long yemekTuketimi)
	{
		if(yemekTuketimi<0) throw new IllegalArgumentException("Yemek tuketimi sifirdan kucuk olamaz");
		if(!yasiyormu()) throw new IllegalCallerException("Koloni yasamadigi icin yemek tuketemez");
		setYemekStogu(yemekStogu-yemekTuketimi);
	}
	/**
	 * 
	 * Egerki koloni yasamiyorsa exception firlatiliyor.
	 */
	@Override
	public void turSonuYemekTuket() {
		if(!yasiyormu()) throw new IllegalCallerException("Koloni yasamadigi icin yemek tuketemez");
		long yemekTuketimi = populasyon*2;
		setYemekStogu(yemekStogu - yemekTuketimi);
	}
	 
	/**
	 * Bizden odevde istenilen sekilde bir yazdırma yapiyorum.
	 */
	@Override
	public String toString() {
		if(yasiyormu()) return String.format(" %3c %9d %17d %13d %6d\n",sembol,populasyon,yemekStogu,kazanma,kaybetme );
		return String.format(" %3c %9s %17s %13s %6s\n",sembol,"--","--","--","--" );
	}
	



	
}
