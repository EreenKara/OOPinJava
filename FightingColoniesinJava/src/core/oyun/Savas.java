/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Savas mantigini icerisinde barindiran sinif.
* </p>
*/

package core.oyun;

import interfaces.oyun.ISavas;
import interfaces.topluluk.ITopluluk;

public class Savas implements ISavas{

	/**
	 * Kendisine parametre oalrak verilen iki sinifi savastiriyor.
	 * @return geriye kaybeden sinifi donduruyor.
	 */
	@Override
	public ITopluluk savas(ITopluluk koloni1, ITopluluk koloni2) {
		// egerki savas fonksiyonu toplulugu oldurecek sekilde calisirsa
		// uygulama patlar. Taktigin savas() fonksiyonunu populasyonu oldurecek
		// sekilde yapamazsin Ya da yaparsan guncelleme yap oyun mantiginda.
		// cunku kazanan toplulugun veya kaybeden toplulugun yasayip yasamadigina
		// bakilmaksizin savasSonundaYapilacaklar() fonksiyonu cagriliyor.
		// Kazanan toplulukta olebilir cunku savas fonksiyonu cagrilir.
		// savas gucu daha yuksek cikar ve kazanir ancak olmustur.
		int savasSonucu = koloni1.savas()-koloni2.savas();
		ITopluluk kaybeden;
		if(savasSonucu>0) { // koloni1 kazanandı
			savasSonuYapilacaklar(savasSonucu, koloni1, koloni2);
			kaybeden=koloni2;
		}
		else if(savasSonucu<0) {	// koloni2 kazanandı
			savasSonuYapilacaklar(savasSonucu, koloni2, koloni1);
			kaybeden=koloni1;
		}
		else
		{
			savasSonucu=100;
			if(koloni1.getPopulasyon()>koloni2.getPopulasyon())	// koloni1 kazanandı
			{
				savasSonuYapilacaklar(savasSonucu, koloni1, koloni2);
				kaybeden=koloni2;
			}
			else if(koloni2.getPopulasyon()>koloni1.getPopulasyon())	// koloni2 kazanandı
			{
				savasSonuYapilacaklar(savasSonucu, koloni2, koloni1);
				kaybeden=koloni1;
			}
			else
			{
				// burda rastgele birinin kazanamsı gerekiyor
				// Ancak ben koloni1'i kesin olarak kazndırıyorum niye çünkü kolnoi1 buraya zaten rastgele geldi.
				// koloni1 rastgele bir koloni. O yüzden zaten koloni1 veya koloni2'nin kazanaması rastgelelik açısından aynı anlama geliyor.
				// tekrar bir random ile eşleştirmeye gerek yok diye düşünüyorum.
				savasSonuYapilacaklar(savasSonucu, koloni1, koloni2); 
				kaybeden=koloni2;
			}
		}
		
		return kaybeden;
	}

	/**
	 * 
	 * @param savasSonucu parametresi sayesinde can kaybini hesapliyorum
	 * @param kazanan  parametresi ile kazanan koloni'nin savas sonu olmasi gerekenleri ayarliyorum.
	 * @param kaybeden parametresi ile kaybeden koloni'nin savas sonu olmasi gerekenleri ayarliyorum.
	 */
	private void savasSonuYapilacaklar(int savasSonucu, ITopluluk kazanan, ITopluluk kaybeden) {
		long yemekKaybi=kaybeden.savasYemekKaybi();
		kazanan.yemekKazanci(yemekKaybi);
		
		// ustteki yemek kaybi koloniyi oldururse diye boyle bir kontrol yapmak zorunda kaldim
		// bu topluluk gerceklemesi (koloni) 'nin yemekKaybi() fonksiyonu toplulugu oldurmuyor
		// ancak baska bir gercekleme'ninki oldurebilir.
		if(kaybeden.yasiyormu())  
		{
			savasSonucu=Math.abs(savasSonucu);
			double canKaybetmeOrani=(double)savasSonucu/1000;
			int canKaybi=(int)(kaybeden.getPopulasyon()*canKaybetmeOrani);
			kaybeden.savasCanKaybet(canKaybi);
		}
		
		kazanan.kazanmaArttir();
		kaybeden.kaybetmeArttir();
	}
	
	
	
	
	
	
	
}
