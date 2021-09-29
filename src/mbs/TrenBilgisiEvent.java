//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

class TrenBilgisiEvent {
    String hedefIstasyon;
    String mevcutIstasyon;
    String gelecekIstasyon;
    String sonrakiIstasyon;
    String gelecekKonumGosterge;
    String mevcutKonumGosterge;

    String kalanMesafe;
    String toplamMesafe;
    String kapiDurumu;
    String istasyonDurumu;
    public HatTipi hatTipi;
    public Yonler yon;
    public Rotalar rota;
    boolean ledEkranSil = false;
    boolean isKapiAcKapa = false;

    public TrenBilgisiEvent(String hedefIstasyon, String mevcutIstasyon, String gelecekIstasyon,String s, String kalanMesafe, String toplamMesafe, boolean kapiDurumu, boolean istasyonDurumu,boolean takometrePasifEt) {
    	this.mevcutKonumGosterge=gelecekIstasyon;
        this.hedefIstasyon = hedefIstasyon;
        this.mevcutIstasyon = mevcutIstasyon;
        this.gelecekIstasyon = gelecekIstasyon;
        this.sonrakiIstasyon = s;
        this.kalanMesafe = kalanMesafe;
        this.toplamMesafe = toplamMesafe;
    	this.gelecekKonumGosterge=s;

    	if(this.gelecekKonumGosterge.contains(hedefIstasyon)) 
    	{ 

    		this.gelecekKonumGosterge="";
    	}
    	if(this.mevcutKonumGosterge.contains(hedefIstasyon)) 
    	{ 

    		this.mevcutKonumGosterge="";
    	}

        if (kapiDurumu) {
            this.kapiDurumu = "A�IK";
        } else  {
            this.kapiDurumu = "KAPALI";
        }

        if (istasyonDurumu) {
            this.istasyonDurumu = "�STASYONDA";
        } else {
            this.istasyonDurumu = "�STASYONDA DE��L";
        }

        this.hatTipi = RotaBilgileri.getHatTipi(mevcutIstasyon, hedefIstasyon);
        this.yon = RotaBilgileri.getYon(mevcutIstasyon, hedefIstasyon);
        this.rota = RotaBilgileri.GetRota(mevcutIstasyon, gelecekIstasyon, hedefIstasyon,takometrePasifEt);
        

       

        if (!this.rota.equals(Rotalar.SECILMEDI) && !this.rota.equals(Rotalar.GECERS�Z)) {
            this.ledEkranSil = false;
        } else {
            this.ledEkranSil = true;
        }

    }
}
