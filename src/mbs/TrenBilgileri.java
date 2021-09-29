//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public  class TrenBilgileri {
	private static final Charset utf8charset = Charset.forName("UTF-8");
	private static final Charset iso88591charset = Charset.forName("ISO-8859-1");
	private Serial serial;
	
    private String hedefIstasyon;
    private String mevcutIstasyon;
    private String gelecekIstasyon;
    private String sonrakiIstasyon;
    private Boolean takometrePasifEt=false;

    private String baslangicIstasyonu;
    private String oncekiHedefIstasyon;
    private int gidilenMesafe;
    private String rota;
    private int kalanMesafe;
    private int toplamMesafe;
    private int gecilenMesafeSayac;
    private boolean kapiAcikMi;
    private boolean istasyondaMi;
    private boolean yaklasimAnonsuYapildiMi = false;
    private boolean varisAnonsuYapidiMi = false;
    private int takometreSabiti ;
    public int yaklasýmAnonsuMetraj;
    public int varýsAnonsuMetraj;
    public int yaklasýmLediMetraj;
    public int kapýMetrajýTolerans;
    public int yaklasýmLediMetrajTolerans;
    private JSONOku jsonOku;
    public static int count;
    public boolean varýsLed = false;
    public int counter =1;
    private GpioPinDigitalInput kapiButonu;
    private GpioPinDigitalInput takometre;
    public static GpioPinDigitalOutput  role;

    protected EventListenerList listenerList = new EventListenerList();
    private GpioController gpio;
    private static ArrayList<String> MescidiselamTopkapiledMesajYazdýr1 = new ArrayList();
    private static ArrayList<String> TopkapiMescidiselamledMesajYazdýr1 = new ArrayList();

    private static ArrayList<String> MescidiselamTopkapiledMesajYazdýr2_yaklasým = new ArrayList();
    private static ArrayList<String> TopkapiMescidiselamledMesajYazdýr2_yaklasým = new ArrayList();
    private static ArrayList<String> MescidiselamTopkapiledMesajYazdýr2_varýs = new ArrayList();
    private static ArrayList<String> TopkapiMescidiselamledMesajYazdýr2_varýs = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkapý = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_TopkapýMescidiselam = new ArrayList();


    public TrenBilgileri() {
        Init();
        RotaBilgileri.Init();
        jsonOku = new JSONOku();
        jsonOku.main("/param");
        jsonOku.main("/turkishWord");
    	//jsonOku.main("/anonsName");
    	T4_Istasyonlar_MescidiselamTopkapý=jsonOku.T4_Istasyonlar_MescidiselamTopkapý;
    	T4_Istasyonlar_TopkapýMescidiselam=jsonOku.T4_Istasyonlar_TopkapýMescidiselam;

    	MescidiselamTopkapiledMesajYazdýr1=jsonOku.MescidiselamTopkapiledMesajYazdýr1;
    	TopkapiMescidiselamledMesajYazdýr1=jsonOku.TopkapiMescidiselamledMesajYazdýr1;

    	MescidiselamTopkapiledMesajYazdýr2_yaklasým=jsonOku.MescidiselamTopkapiledMesajYazdýr2_yaklasým;
    	
    	TopkapiMescidiselamledMesajYazdýr2_yaklasým=jsonOku.TopkapiMescidiselamledMesajYazdýr2_yaklasým;
        MescidiselamTopkapiledMesajYazdýr2_varýs=jsonOku.MescidiselamTopkapiledMesajYazdýr2_varýs;
    	
    	TopkapiMescidiselamledMesajYazdýr2_varýs=jsonOku.TopkapiMescidiselamledMesajYazdýr2_varýs;
    
        takometreSabiti= jsonOku.takomereSabiti;
        yaklasýmAnonsuMetraj= jsonOku.yaklasýmAnonsuMetraj;
        varýsAnonsuMetraj= jsonOku.varýsAnonsuMetraj;
        yaklasýmLediMetraj= jsonOku.yaklasýmLediMetraj;
        kapýMetrajýTolerans= jsonOku.kapýMetrajýTolerans;
        yaklasýmLediMetrajTolerans=jsonOku.yaklasýmLediMetrajTolerans;
    } 
    private String IstasyonLedAdiGetirBeyazLed_varýs(String istasyonAdi) {
    	
    	if(rotamýz =="TOPKAPI") 
    	{
    		for (int i=0; i< T4_Istasyonlar_MescidiselamTopkapý.size(); i++){
                if (T4_Istasyonlar_MescidiselamTopkapý.get(i).toString().contains(istasyonAdi)==true){
                	
                	String deneme = MescidiselamTopkapiledMesajYazdýr2_varýs.get(i);
                	 return deneme;
                	 
              }
           }	
    	}else {
    		for (int i=0; i< T4_Istasyonlar_TopkapýMescidiselam.size(); i++){

                if (T4_Istasyonlar_TopkapýMescidiselam.get(i).toString().contains(istasyonAdi)==true){
                	String deneme = TopkapiMescidiselamledMesajYazdýr2_varýs.get(i);
                	 return deneme;
              }
           }
    		
    	}
    	
       return "20MY010015 ";
    }
    private String IstasyonLedAdiGetirBeyazLed_yaklasým(String istasyonAdi) {
       
    	//System.out.println("IstasyonLedAdiGetirBeyazLed ----->  "+ istasyonAdi);
    	    	if( this.rota=="MescidiselamTopkapý") 
    	    	{
    	    		for (int i=0; i< T4_Istasyonlar_MescidiselamTopkapý.size(); i++){
    	    	
    	                if (T4_Istasyonlar_MescidiselamTopkapý.get(i).toString().contains(istasyonAdi)==true){
    	                	String deneme = MescidiselamTopkapiledMesajYazdýr2_yaklasým.get(i);
    	                	 return deneme;
    	              }
    	           }	
    	    	}else  if (this.rota=="TopkapýMescidiselam"){
    	    		

    	    		for (int i=0; i< T4_Istasyonlar_TopkapýMescidiselam.size(); i++){


    	                if (T4_Istasyonlar_TopkapýMescidiselam.get(i).toString().contains(istasyonAdi)==true){
    	                	String deneme = TopkapiMescidiselamledMesajYazdýr2_yaklasým.get(i);
    	                	 return deneme;
    	              }
    	           }
    	    		
    	    	}
    	    	
    	       return "20MY010015 ";
    	    }
    private String IstasyonLedAdiGetirSarýLed(String istasyonAdi) {
    	if(istasyonAdi!="") {
    		  if (	T4_Istasyonlar_MescidiselamTopkapý.get(0).toString().contains(istasyonAdi)==true)
    	        {
    	        	String deneme = MescidiselamTopkapiledMesajYazdýr1.get(0);
    	        	 return deneme;

    	    		}
    	    	
    	    	else  {
    	    		String deneme = TopkapiMescidiselamledMesajYazdýr1.get(0);
    	        	 return deneme;

    	    		
    	    	}
    	}
    	else {
    		return "10MY010015 ";
    	}
    	
    }
   /* private String IstasyonLedAdiGetirSarýLed(String istasyonAdi) {
		 Rotalar rota = RotaBilgileri.GetRota(this.mevcutIstasyon, this.gelecekIstasyon, this.hedefIstasyon,this.takometrePasifEt);

   	if(rota == Rotalar.T4MescidiselamTopkapý) 
   	{

   		return TopkapiMescidiselamledMesajYazdýr1.get(0);//MescidiselamTopkapiledMesajYazdýr1

   		}
   	
   	else {

   		return MescidiselamTopkapiledMesajYazdýr1.get(0);//TopkapiMescidiselamledMesajYazdýr1

   		
   	}
   	
   }*/
    public void takometrePasifEt(Boolean takometrePasifEt) {
    	this.takometrePasifEt=takometrePasifEt;
    }
    public String rotamýz;
    public     	int aa =30;

    
    
    public void TakometreVerisiGuncelle() {
    	if(this.takometrePasifEt==false) {
    		//this.kapiAcikMi=false;//*
    		 Rotalar rota = RotaBilgileri.GetRota(this.mevcutIstasyon, this.gelecekIstasyon, this.hedefIstasyon,this.takometrePasifEt);
    		 if(rota == Rotalar.T4MescidiselamTopkapý) {
    			 rotamýz="TOPKAPI";
    		 }else {
    			 rotamýz="MESCIDI SELAM";
    		 }
    	        if ( (!rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERSÝZ))) {
    	        	 this.gidilenMesafe += takometreSabiti;
     	             this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
    	            TrenBilgisiEvent tEvt;

    	            if (this.kalanMesafe < 0) {
    	            	System.out.println(this.kalanMesafe +"this.kalanMesafe ");
    	                this.gecilenMesafeSayac += Math.abs(this.kalanMesafe);
    	                if (takometreSabiti <= this.gecilenMesafeSayac) {

    	                    this.gecilenMesafeSayac = 0;
    	                    this.SonrakiIstasyonaGec();
    	                   // this.kapiAcikMi=true;//*
    	                    tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
    	                    if(this.takometrePasifEt==false) {
    	                    this.guncelle(tEvt);
    	                    }
    	                    return;
    	                }
    	               
        	            this.kalanMesafe = 0;

    	               
    	            }
    	            if(this.kalanMesafe == 0) {
    	            	this.varýsLed=false;
	                    this.gecilenMesafeSayac = 0;

    	            }
    	           if (this.gidilenMesafe >= this.kapýMetrajýTolerans && !this.kapiAcikMi && this.istasyondaMi) {//30 -->kapiMetrajiTolerans
    	                this.istasyondaMi = false;
      	        	  System.out.println("kalan mesafe:" + this.kalanMesafe);

     		       TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_yaklasým(this.gelecekIstasyon));

    	            }
    	            if(this.takometrePasifEt==false) {
    	            this.AnonsKontrol();
    	            tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
    	            this.guncelle(tEvt);
  		          

    	            }
    	        }
    	       // if (this.kalanMesafe ==this.yaklasýmLediMetraj-this.yaklasýmLediMetrajTolerans ||  this.kalanMesafe ==this.yaklasýmLediMetraj) {
    	        if ((this.kalanMesafe>0 &&this.kalanMesafe <=this.yaklasýmLediMetrajTolerans) && this.varýsLed==false  ) {
    	        	this.varýsLed=true;
    	        	System.out.println("this.kalanMesafe"+this.kalanMesafe);
    	        	  System.out.println("kalan mesafe:" + this.kalanMesafe+"this.yaklasýmLediMetraj"+this.yaklasýmLediMetraj+"this.yaklasýmLediMetrajTolerans"+this.yaklasýmLediMetrajTolerans);
    		          TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_varýs(this.gelecekIstasyon));
    		         // TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirSarýLed(this.hedefIstasyon));

    	                }  		
    	}
    	else {
        	System.out.println("takometre bypass edildi...");

    	}
    }
   public int kapidurumuCount=0;
   public boolean kapiControl=false;
    public void KapiDurumuGuncelle(boolean durum) {    	
    	if(this.takometrePasifEt) {
    		//if(durum) {
    		  // TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_varýs(this.gelecekIstasyon));
	           //TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirSarýLed(this.hedefIstasyon));
    		boolean kapiAcKapa = true;
            TrenBilgisiEvent tEvt;
            	this.istasyondaMi = true;
                tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
                if (!this.varisAnonsuYapidiMi) {
                    this.varisAnonsuYap(tEvt);
                    TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_varýs(this.gelecekIstasyon));
         		  // TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirSarýLed(this.hedefIstasyon));	    			
     		
                    this.varisAnonsuYapidiMi = true;
                }   
               
                 TrenBilgileri.this.SonrakiIstasyonaGec();   
            	
          
    		     
            if (this.istasyondaMi && this.kapiAcikMi && !durum) {
                kapiAcKapa = false;
                System.out.println("kapý durumu : " +this.istasyondaMi +this.kapiAcikMi);
                this.kapiControl = true;
            }

            this.kapiAcikMi = durum;
            tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon, this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
            tEvt.isKapiAcKapa = kapiAcKapa;
            this.guncelle(tEvt);
    	}
    //}
    	else 
    	{	   		
        	if( (this.kalanMesafe<=this.kapýMetrajýTolerans || this.kalanMesafe>=this.toplamMesafe-this.kapýMetrajýTolerans  ))
        	{		
            boolean kapiAcKapa = true;
            TrenBilgisiEvent tEvt;
            if (this.kalanMesafe <= this.varýsAnonsuMetraj && durum) { //130 du
                this.istasyondaMi = true;
                tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
                if (!this.varisAnonsuYapidiMi) {
                    this.varisAnonsuYap(tEvt);
                    TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_varýs(this.gelecekIstasyon));

                   // TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_varýs(this.gelecekIstasyon));//eklendi 8/06/2021 ifin dýþýnda olmalý
         		   // TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirSarýLed(this.hedefIstasyon));	    			
     		
                    this.varisAnonsuYapidiMi = true;
                }   
                TrenBilgileri.this.SonrakiIstasyonaGec();        
            }

            if (this.kalanMesafe < this.varýsAnonsuMetraj && this.toplamMesafe > 0 && this.istasyondaMi && this.kapiAcikMi && !durum) {
                kapiAcKapa = false;
            }

            this.kapiAcikMi = durum;
            tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon, this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
            tEvt.isKapiAcKapa = kapiAcKapa;

            this.guncelle(tEvt);
            }	
        	
    		
    	
    	}
		
	}
  
    private void Init() {
        this.hedefIstasyon = "";
        this.oncekiHedefIstasyon = "";
        this.mevcutIstasyon = "";
        this.gelecekIstasyon = "";
        this.sonrakiIstasyon="";
        this.baslangicIstasyonu = "";
        this.gidilenMesafe = 0;
        this.kalanMesafe = 0;
        this.toplamMesafe = 0;
        this.gecilenMesafeSayac = 0;
        this.kapiAcikMi = true;
        this.istasyondaMi = true;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        if(!OSValidator.isWindows()) {
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
   	    this.gpio = GpioFactory.getInstance();
   	  // this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
       // this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
   	   this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_20, PinPullResistance.PULL_UP);
       this.takometre = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_21, PinPullResistance.PULL_UP);

       this.role  = this.gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13);
       this.role.setShutdownOptions(true, PinState.LOW);
       System.out.println(role.isLow()+"role.LOW");
       //this.role.setState(PinState.HIGH);
     //  System.out.println(role.isHigh()+"role.isHig");

       //this.role = this.gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_13, "role",PinState.LOW);
      // role.setShutdownOptions(true, PinState.LOW);
      // role.low();


           this.serial = SerialFactory.createInstance();
           if (this.serial != null) {
               try {
   				this.serial.open("/dev/ttyS0", 4800);
   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
           } else {
               System.out.println("Serial port null");
           }
           
           
           this.kapiButonu.addListener(new GpioPinListener[]{new GpioPinListenerDigital() 
           {
               public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
            		   if (event.getState() == PinState.HIGH) {//buraya bi bakkk
                    	   TrenBilgileri.this.KapiDurumuDegistir(false);
                    	   
                       } else  {

                		  TrenBilgileri.this.KapiDurumuDegistir(true);       		   
            	   }
               }
           }});
   
           this.takometre.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
               public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                   if (event.getState() == PinState.HIGH) {
                      // System.out.println(" --> TAKOMETRE: " + event.getPin() + " = " + event.getState());

                   	TrenBilgileri.this.TakometreArttýr();
                   }

               }
           }});
//           this.role.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
//               public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                   if (event.getState() == PinState.HIGH) {//daha sonra low olarak de dene
//                	   
//                      TrenBilgileri.this.RoleGuncelle();
//                   }
//                  
//
//               }
//           }});
      
           /*this.writeToSP(" ");    */ 
        
        }
    }
    public void Sayac() {
    	Timer myTimer=new Timer();
        TimerTask gorev =new TimerTask() {   
        @Override
        public void run() {     
        	TrenBilgileri.this.kapidurumuCount++; 
        	if(TrenBilgileri.this.kapidurumuCount==3) {
        		TrenBilgileri.this.kapidurumuCount=0;
        		myTimer.cancel();
        	}
        }
    };       
myTimer.schedule(gorev,0,10000);

}
    private void KapiDurumuDegistir(final boolean durum) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { 
        		  TrenBilgileri.this.KapiDurumuGuncelle(durum);        	
            }
        });
    }
  private void TakometreArttýr() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TrenBilgileri.this.TakometreVerisiGuncelle();
            }
        });
    }
  
    private void AnonsKontrol() {
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        if(this.takometrePasifEt==false ) {
        if ((this.kalanMesafe < this.yaklasýmAnonsuMetraj && !this.yaklasimAnonsuYapildiMi)) {
        	//System.out.println(this.gelecekIstasyon +"--------- anonskontrol");
            this.yaklasimAnonsuYap(tEvt);
          
            this.yaklasimAnonsuYapildiMi = true;
        }
    }
    }
   /* private void ByPassAnonsKontrol() {
    	TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi);
        if ((this.kapiAcikMi && this.hedefIstasyon!=null)&& this.takometrePasifEt==true) {
            this.yaklasimAnonsuYap(tEvt);
            this.yaklasimAnonsuYapildiMi = true;
        }
    	
    }*/

    private void SonrakiIstasyonaGec() {
        this.mevcutIstasyon = this.gelecekIstasyon;
        this.gidilenMesafe = 0;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon,this.rota);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
    }

    public String getHedefIstasyon() {
        return this.hedefIstasyon;
    }

    public String getOncekiHedefIstasyon() {
        return this.oncekiHedefIstasyon;
    }

    public String getMevcutIstasyon() {
        return this.mevcutIstasyon;
    }
    public String getSonrakiIstasyon() {
        return this.sonrakiIstasyon;
    }

    public int getKalanMesafe() {
        return this.kalanMesafe;
    }

    public boolean getKapiDurumu() {
        return this.kapiAcikMi;
    }

    public String getBaslangicIstasyonu() {
        return this.baslangicIstasyonu;
    }

    public void setMevcutIstasyon(String istasyon) {
        this.mevcutIstasyon = istasyon;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.gidilenMesafe = 0;
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon,this.rota);
        
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }
    public void setSonrakiIstasyon(String istasyon) {
        this.mevcutIstasyon = istasyon;
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(this.mevcutIstasyon, this.hedefIstasyon);
        this.gidilenMesafe = 0;

        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon,this.rota);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setHedefIstasyon(String istasyon) {
        this.oncekiHedefIstasyon = this.hedefIstasyon;
        this.hedefIstasyon = istasyon;
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(this.mevcutIstasyon, this.hedefIstasyon);

        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(this.mevcutIstasyon, this.hedefIstasyon,this.rota);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setKapiDurumu(boolean durum) {
        this.kapiAcikMi = durum;
        Rotalar rota = RotaBilgileri.GetRota(this.mevcutIstasyon, this.gelecekIstasyon, this.hedefIstasyon,this.takometrePasifEt);
        if (!rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERSÝZ) && durum && this.kalanMesafe < 300) {
            this.setIstasyondaMi(true);
        }
        if(rota == Rotalar.T4MescidiselamTopkapý) {
			 rotamýz="MESCIDI SELAM";
		 }else {
			 rotamýz="TOPKAPI";
		 }

        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setKalanMesafe(int deger) {
        this.kalanMesafe = deger;
    }

    public void setGidilenMesage(int deger) {
        this.gidilenMesafe = deger;
    }

    public void setIstasyondaMi(boolean durum) {
        this.istasyondaMi = durum;
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon, String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,this.takometrePasifEt);
        this.guncelle(tEvt);
    }

    public void setBaslangicIstasyonu(String istasyon) {
        this.baslangicIstasyonu = istasyon;
    }
    JSONYaz jsonYaz ;

    public void setRotaBilgileri(String mevcutIstasyon, String baslangicIstasyonu, String hedefIstasyon, Boolean takometrePasifEt) {
    	/*if(baslangicIstasyonu ==""&& hedefIstasyon=="") {
    		System.out.println(mevcutIstasyon+" buraya neden girdi mevcut istasyon");
    		TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_yaklasým(this.mevcutIstasyon));

    		
    	}*/
        this.baslangicIstasyonu = baslangicIstasyonu;
        this.mevcutIstasyon = mevcutIstasyon;        
        this.hedefIstasyon = hedefIstasyon;
        jsonYaz =new JSONYaz();
        jsonYaz.mevcutRota(mevcutIstasyon,hedefIstasyon);
        this.gelecekIstasyon = RotaBilgileri.getGelecekIstasyon(mevcutIstasyon, hedefIstasyon);
        this.sonrakiIstasyon = RotaBilgileri.getGelecekSonrakiIstasyon(mevcutIstasyon, hedefIstasyon);
        this.takometrePasifEt=takometrePasifEt;
        this.gidilenMesafe = 0;
        this.rota=RotaBilgileri.getHatTipix(mevcutIstasyon, hedefIstasyon);
        this.toplamMesafe = RotaBilgileri.getGelecekIstasyonMesafe(mevcutIstasyon, hedefIstasyon,this.rota);
        this.kalanMesafe = this.toplamMesafe - this.gidilenMesafe;
        this.yaklasimAnonsuYapildiMi = false;
        this.varisAnonsuYapidiMi = false;
        if(baslangicIstasyonu !=""&& hedefIstasyon!="") {
	    TrenBilgileri.this.writeToSP(IstasyonLedAdiGetirBeyazLed_yaklasým(this.mevcutIstasyon));

		
	}
        TrenBilgisiEvent tEvt = new TrenBilgisiEvent(this.hedefIstasyon, this.mevcutIstasyon, this.gelecekIstasyon,this.sonrakiIstasyon,String.valueOf(this.kalanMesafe), String.valueOf(this.toplamMesafe), this.kapiAcikMi, this.istasyondaMi,takometrePasifEt);
	        this.guncelle(tEvt);
    }

    public void addListener(TrenBilgisiListener listener) {
        this.listenerList.add(TrenBilgisiListener.class, listener);
    }

    public void removeListener(TrenBilgisiListener listener) {
        this.listenerList.remove(TrenBilgisiListener.class, listener);
    }

    void guncelle(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).Guncelle(evt);
            }
        }

    }

    void yaklasimAnonsuYap(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).YaklasimAnonsu(evt);
            }
        }

    }

    void varisAnonsuYap(TrenBilgisiEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).VarisAnonsu(evt);
            }
        }

    }

    void mevcutIstasyonDegisti(String mevcutIstasyon) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == TrenBilgisiListener.class) {
                ((TrenBilgisiListener)listeners[i + 1]).MevcutIstasyonDegisti(mevcutIstasyon);
            }
        }

    }
	private static int xorDatas(byte[] data)
    {
        int temp = data[0];
        for (int i = 1; i < data.length; i++)
        {
            temp = temp ^ data[i];
        }
        return temp;
    }
	static byte[] newDatas;
	public static byte[] SendRS232Data(String data)
    {
        try
        {
            //Console.WriteLine("SendRs232(String veri)");
            String str = data;
            //Console.WriteLine("String: " + str);
   			byte[] utf8=data.getBytes("ISO-8859-9");
   			//byte[] utf8 = new String(bytes, "UTF-8").getBytes("ISO-8859-9");

          
            /*if (!serialPort1.IsOpen)
            {
                serialPort1.Open();
                serialPort1.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(serialPort1_DataReceived);
            }*/
            int xorVal = xorDatas(utf8);
            int xorHigh = (((byte)xorVal >> 4) & (byte)0x0F);
            int xorLow = ((byte)xorVal & (byte)0x0F);
            if (xorHigh < 0x0A)
            {
                xorHigh = (byte)((byte)xorHigh + (byte)0x30);
            }
            else
            {
                xorHigh = (byte)((byte)xorHigh + (byte)0x37);
            }
            if (xorLow < 0x0A)
            {
                xorLow = (byte)((byte)xorLow + (byte)0x30);
            }
            else
            {
                xorLow = (byte)((byte)xorLow + (byte)0x37);
            }
            int newDatasLenght = utf8.length + 7;
             newDatas = new byte[newDatasLenght];
            newDatas[0] = 2;
            for (int i = 0; i < utf8.length; i++)
            {
                newDatas[i + 1] = utf8[i];
            }
            newDatas[utf8.length + 1] = 5;
            newDatas[utf8.length + 2] = (byte)xorHigh;
            newDatas[utf8.length + 3] = (byte)xorLow;
            newDatas[utf8.length + 4] = 3;
            newDatas[utf8.length + 5] = 13;
            newDatas[utf8.length + 6] = 10;

return newDatas;
        }
        catch (Exception e)
        {
        }
		return null;
    }
    public void writeToSP(String data) {
    	SendRS232Data(data);
	
	        try {
	            if (this.serial != null && this.serial.isClosed()) {
	                this.serial.open("/dev/ttyS0", 4800);
	            }

	            if (this.serial != null && this.serial.isOpen()) {

	                try {
	                    this.serial.flush();

	        
	                    this.serial.write(newDatas);
	                } catch (UnsupportedEncodingException var5) {
	                    var5.printStackTrace();
	                } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            } else {
	                System.out.println("Seri port kapalý! Data: " + data);
	            }
	        } catch (IllegalStateException var6) {
	            var6.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }	
  

}
