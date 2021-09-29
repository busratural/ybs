package mbs;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JSONOku {

	public int istasyonSayisi;
	public int tabelaSayisi;
    public static ArrayList<String> tabelaList = new ArrayList<String>();
	public static ArrayList<String> T4_Istasyonlar_MescidiselamTopkap� = new ArrayList();
	public static ArrayList<String> T4_Istasyonlar_Topkap�Mescidiselam = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkap� = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_Topkap�Mescidiselam = new ArrayList();
	public static ArrayList<String> MescidiselamTopkapiledMesajYazd�r1 = new ArrayList();
	public static ArrayList<String> TopkapiMescidiselamledMesajYazd�r1 = new ArrayList();

	public static ArrayList<String> MescidiselamTopkapiledMesajYazd�r2_yaklas�m = new ArrayList();
	
	public static ArrayList<String> TopkapiMescidiselamledMesajYazd�r2_yaklas�m = new ArrayList();
public static ArrayList<String> MescidiselamTopkapiledMesajYazd�r2_var�s = new ArrayList();
	
	public static ArrayList<String> TopkapiMescidiselamledMesajYazd�r2_var�s = new ArrayList();
	public static ArrayList<String> LedYazdir_Sar� = new ArrayList();
	public static ArrayList<String> LedYazdir_Beyaz = new ArrayList();


	public int takomereSabiti;
    public int yaklas�mAnonsuMetraj;
    public int var�sAnonsuMetraj;	
    public int yaklas�mLediMetraj;
    public int kap�Metraj�Tolerans;
    public int yaklas�mLediMetrajTolerans;
    public String Zaman;
    public String CalismaZamanBaslangici;
    public String MetrajBilgisi;
    public String IstasyonIsmi;
    public String KapiDurumu;
    public String IP;
    public String TrenID;
    public String TrenAdi;
    public String MAC;

    public int fontSize;    
    public int fontSizeLabel;

    public int fontStyle;
    public String fontName;
    public Color textcolor;
    public Color labelcolor;
    public Color tabcolor;
    public Color tema;
    



	  public void main(String filepath)   {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	        String startDir = System.getProperty("user.dir");

	        String path = startDir + filepath;
	        try (FileReader reader = new FileReader(path))
	        {
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	             
	            if(filepath.contains("station")) {
		            istasyonSayisi=employeeList.size();
		           

	            employeeList.forEach( emp -> parseIstasyon( (JSONObject) emp ) );
	      //   for(int i =0; i<T4_Istasyonlar_MescidiselamTopkap�.size(); i++ ) {
	       // 	 System.out.println(T4_Istasyonlar_MescidiselamTopkap�);
	            //	System.out.println(TopkapiMescidiselamledMesajYazd�r1.get(i)+ "++++"+ i + "say� kadar");
	       //     }

	            }
	            
	            else if(filepath.contains("param")) {
		            employeeList.forEach( emp -> parseParam( (JSONObject) emp ) );
	            }
	            else if(filepath.contains("turkishWord")) {
		            employeeList.forEach( emp -> turkishWordParam( (JSONObject) emp ) );

	            }
	            else if(filepath.contains("tabela")) {
		            tabelaSayisi=employeeList.size();

		            employeeList.forEach( emp -> tabelaParam( (JSONObject) emp ) );
                    /* for(int i =0; i<LedYazdir.size(); i++ ) {
	            	
	            	System.out.println(LedYazdir.get(i)+ "++++"+ i + "say� kadar");
	            }*/
	            }
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void parseIstasyon(JSONObject object) 
	    {
	        JSONObject istasyon = (JSONObject) object.get("istasyon");

	        String mescidiselamTopkap� =  (String) istasyon.get("MescidiselamTopkapi");   
	        T4_Istasyonlar_MescidiselamTopkap�.add(mescidiselamTopkap�);
	        String mescidiselamTopkap�Mesafe = (String) istasyon.get("MescidiselamTopkapiMesafe");    
	        T4_Mesafeler_MescidiselamTopkap�.add(Integer.parseInt(mescidiselamTopkap�Mesafe));
	        String topkap�Mescidiselam = (String) istasyon.get("TopkapiMescidiselam");    
	        T4_Istasyonlar_Topkap�Mescidiselam.add(topkap�Mescidiselam);
	        String topkap�MescidiselamMesafe = (String) istasyon.get("TopkapiMescidiselamMesafe");    
	        T4_Mesafeler_Topkap�Mescidiselam.add(Integer.parseInt(topkap�MescidiselamMesafe));
	        String cihazID_1= (String) istasyon.get("cihazID_1");
	    	String cihazID_2=(String) istasyon.get("cihazID_2");
	    	String mesajBeklemeS�residk_1=(String) istasyon.get("mesajBeklemeSuresidk_1");
	    	String mesajBeklemeS�resisn_1=(String) istasyon.get("mesajBeklemeSuresisn_1");
	    	String mesajBeklemeS�resisn_2_yaklas�m=(String) istasyon.get("mesajBeklemeSuresisn_2_yaklas�m");
	    	String mesajBeklemeS�residk_2_yaklas�m=(String) istasyon.get("mesajBeklemeSuresidk_2_yaklas�m");
	    	String mesajBeklemeS�resisn_2_var�s=(String) istasyon.get("mesajBeklemeSuresisn_2_var�s");
	    	String mesajBeklemeS�residk_2_var�s=(String) istasyon.get("mesajBeklemeSuresidk_2_var�s");
	    	String mesajH�z�_1=(String) istasyon.get("mesajHizi_1");
	    	String mesajH�z�_2=(String) istasyon.get("mesajHizi_2");
	    	String mesajTipi_1=(String) istasyon.get("mesajTipi_1");
	    	String mesajTipi_2=(String) istasyon.get("mesajTipi_2");
	    	String MescidiselamTopkapi_Led=(String) istasyon.get("MescidiselamTopkapi_Led");
	    	String TopkapiMescidiselam_Led=(String) istasyon.get("TopkapiMescidiselam_Led");      
	    	//10
	    	MescidiselamTopkapiledMesajYazd�r1.add(cihazID_1 +"MY"+ mesajBeklemeS�residk_1 + mesajBeklemeS�resisn_1 + mesajH�z�_1 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazd�r1.add(cihazID_1 +"MY"+ mesajBeklemeS�residk_1 + mesajBeklemeS�resisn_1 + mesajH�z�_1 + mesajTipi_2 + TopkapiMescidiselam_Led);

	    	//20
	    	MescidiselamTopkapiledMesajYazd�r2_var�s.add(cihazID_2 +"MY"+ mesajBeklemeS�residk_2_var�s + mesajBeklemeS�resisn_2_var�s + mesajH�z�_2 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazd�r2_var�s.add(cihazID_2 +"MY"+ mesajBeklemeS�residk_2_var�s + mesajBeklemeS�resisn_2_var�s + mesajH�z�_2 + mesajTipi_2 + TopkapiMescidiselam_Led);
	    	MescidiselamTopkapiledMesajYazd�r2_yaklas�m.add(cihazID_2 +"MY"+ mesajBeklemeS�residk_2_yaklas�m + mesajBeklemeS�resisn_2_yaklas�m + mesajH�z�_2 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazd�r2_yaklas�m.add(cihazID_2 +"MY"+ mesajBeklemeS�residk_2_yaklas�m + mesajBeklemeS�resisn_2_yaklas�m + mesajH�z�_2 + mesajTipi_2 + TopkapiMescidiselam_Led);
	    }
	    public void tabelaParam(JSONObject object) 
	    {
	        JSONObject tabela = (JSONObject) object.get("Tabela");
	        String tabelaAd� =  (String) tabela.get("TabelaAdi");  
	    	String Led=(String) tabela.get("Led");
	        String cihazID_1= (String) tabela.get("cihazID_1");
	        String cihazID_2= (String) tabela.get("cihazID_2");

	    	String mesajBeklemeS�residk_1=(String) tabela.get("mesajBeklemeSuresidk_1");
	    	String mesajBeklemeS�resisn_1=(String) tabela.get("mesajBeklemeSuresisn_1");
	    	String mesajH�z�_1=(String) tabela.get("mesajHizi_1");
	    	String mesajTipi_1=(String) tabela.get("mesajTipi_1");
	    	String mesajBeklemeS�residk_2=(String) tabela.get("mesajBeklemeSuresidk_2");
	    	String mesajBeklemeS�resisn_2=(String) tabela.get("mesajBeklemeSuresisn_2");
	    	String mesajH�z�_2=(String) tabela.get("mesajHizi_2");
	    	String mesajTipi_2=(String) tabela.get("mesajTipi_2");
	        tabelaList.add(tabelaAd�);	     
	    	LedYazdir_Sar�.add(cihazID_1 +"MY"+ mesajBeklemeS�residk_1 + mesajBeklemeS�resisn_1 + mesajH�z�_1 + mesajTipi_1 + Led);
	    	LedYazdir_Beyaz.add(cihazID_2 +"MY"+ mesajBeklemeS�residk_2 + mesajBeklemeS�resisn_2 + mesajH�z�_2 + mesajTipi_2 + Led);

	    }
	    public void parseParam(JSONObject object) 
	    {
	        JSONObject employeeObject = (JSONObject) object.get("takoMetreVerisi");
	        String tako = (String) employeeObject.get("takoMetereSabiti");    
	        takomereSabiti = Integer.parseInt(tako);
	        
	        String yaklas�mMetraj = (String) employeeObject.get("yaklasimAnonsuMetraj");    
	        yaklas�mAnonsuMetraj = Integer.parseInt(yaklas�mMetraj);
	        
	        String var�sMetraj = (String) employeeObject.get("varisAnonsuMetraj");    
	        var�sAnonsuMetraj = Integer.parseInt(var�sMetraj);
	        
	        String ledMetraj = (String) employeeObject.get("yaklasimLediMetraj");    
	        yaklas�mLediMetraj = Integer.parseInt(ledMetraj);
	        
	        String kap�Tolerans = (String) employeeObject.get("kapiMetrajiTolerans");    
	        kap�Metraj�Tolerans = Integer.parseInt(kap�Tolerans);
	        
	        String yaklas�mLediTolerans = (String) employeeObject.get("yaklasimLediMetrajTolerans");    
	        yaklas�mLediMetrajTolerans = Integer.parseInt(yaklas�mLediTolerans);
	        
	        /*JSONObject param = (JSONObject) object.get("param");
	         Zaman = (String) param.get("Zaman");    
	         CalismaZamanBaslangici = (String) param.get("�al��maZamanBa�lang�c�"); 
	         System.out.println(CalismaZamanBaslangici+"CalismaZamanBaslangici");
	         MetrajBilgisi = (String) param.get("MetrajBilgisi");    
	         IstasyonIsmi = (String) param.get("IstasyonIsmi");    
	         KapiDurumu = (String) param.get("Kap�Durumu");    
	         IP = (String) param.get("IP");    

	        JSONObject metro = (JSONObject) object.get("metro");
	         TrenID = (String) metro.get("TrenID");    
	         TrenAdi = (String) metro.get("TrenAd�");    
	         MAC = (String) metro.get("MAC");    */
 

	    }
	    public void turkishWordParam(JSONObject object) 
	    {
	    	   JSONObject obj = (JSONObject) object.get("Style");	    	   
	    	   String textrgb= (String) obj.get("rgbText");
		       String[] color1 = textrgb.split(", ", 3);
               int r1=  Integer.parseInt(color1[0]);
               int g1=  Integer.parseInt(color1[1]);           
               int b1=  Integer.parseInt(color1[2]);
		       Color colors1 = new Color(r1,g1,b1);  
		       textcolor = colors1;
		       
	    	   String labelrgb= (String) obj.get("rgbLabel");
		       String[] color2 = labelrgb.split(", ", 3);
               int r2=  Integer.parseInt(color2[0]);
               int g2=  Integer.parseInt(color2[1]);           
               int b2=  Integer.parseInt(color2[2]);
		       Color colors2 = new Color(r2,g2,b2);  
		       labelcolor = colors2;
		       
	    	   String tabrgb= (String) obj.get("rgbTabText");
		       String[] color3 = tabrgb.split(", ", 3);
               int r3=  Integer.parseInt(color3[0]);
               int g3=  Integer.parseInt(color3[1]);           
               int b3=  Integer.parseInt(color3[2]);
		       Color colors3 = new Color(r3,g3,b3);  
		       tabcolor = colors3;
		       
		       String rgbTheme= (String) obj.get("rgbTheme");
		       String[] color4= rgbTheme.split(", ", 3);
               int r4=  Integer.parseInt(color4[0]);
               int g4=  Integer.parseInt(color4[1]);           
               int b4=  Integer.parseInt(color4[2]);
		       Color colors4 = new Color(r4,g4,b4);  
		       tema = colors4;
		       
	    	   String Name= (String) obj.get("fontName");
		        fontName =Name;
	    	   String Size= (String) obj.get("fontSize");
	    	   fontSize= Integer.parseInt(Size);
	    	   String SizeLabel= (String) obj.get("fontSizeLabel");
	    	   fontSizeLabel= Integer.parseInt(SizeLabel);
	    	   String Style= (String) obj.get("fontStyle");
	    	   fontStyle=Integer.parseInt(Style);
    }
	    
		private char split(String a, char c) {
			// TODO Auto-generated method stub
			return 0;
		}
}