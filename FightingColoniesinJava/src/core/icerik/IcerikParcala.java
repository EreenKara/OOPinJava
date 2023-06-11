/**
*
* @author Eren Kara errennkaaraa@hotmail.com
* @since 25.05.2023
* <p>
* Parametre olarak verilen icerikleri istenilen sekillerde parcaliyor.
* Egerki icerik istenilen sekillere parcalanamayacak
* yapidaysa exception firlatiyor. 
* </p>
*/

package core.icerik;

import java.util.stream.Collectors;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IcerikParcala {
	
	public static int[] splitNumbersToIntArray(String icerik) throws IOException
	{
		if(!IcerikKontrol.sayilaraAyrilabilirmi(icerik)) throw new IOException("Sayidan ve Boşluktan başka ifade girdiniz");
		if(IcerikKontrol.hepsiBoslukmu(icerik)) throw new IOException("Girilen ifadenin hepsi boşluktu");
		
		String[] bolunmusIcerik=icerik.split("\\s+");  // bosluga gore parcalatiyorum
		int[] sayilar=new int[bolunmusIcerik.length];  // 
		for (int i = 0; i < bolunmusIcerik.length; i++) {
			sayilar[i]=Integer.parseInt(bolunmusIcerik[i]);  // string'i int'e ceviriyorum
		}
		return sayilar;
	}
	public static List<Integer> splitNumbersToList(String icerik) throws IOException
	{
		if(!IcerikKontrol.sayilaraAyrilabilirmi(icerik)) throw new IOException("Sayidan ve Boşluktan başka ifade girdiniz");
		if(IcerikKontrol.hepsiBoslukmu(icerik)) throw new IOException("Girilen ifadenin hepsi boşluktu");
		// icerigi bosluga gore parcalayip onu bir akis icerisinde dolasip istedigim sekle donusturup koleksiyona aktarıyorum.
		return Arrays.stream(icerik.split("\\s+")).map(sayi->Integer.parseInt(sayi)).collect(Collectors.toList());
	}
}
