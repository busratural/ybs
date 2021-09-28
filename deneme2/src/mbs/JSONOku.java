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
	public static ArrayList<String> T4_Istasyonlar_MescidiselamTopkapý = new ArrayList();
	public static ArrayList<String> T4_Istasyonlar_TopkapýMescidiselam = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkapý = new ArrayList();
	public static ArrayList<Integer> T4_Mesafeler_TopkapýMescidiselam = new ArrayList();
	public static ArrayList<String> MescidiselamTopkapiledMesajYazdýr1 = new ArrayList();
	public static ArrayList<String> TopkapiMescidiselamledMesajYazdýr1 = new ArrayList();

	public static ArrayList<String> MescidiselamTopkapiledMesajYazdýr2_yaklasým = new ArrayList();
	
	public static ArrayList<String> TopkapiMescidiselamledMesajYazdýr2_yaklasým = new ArrayList();
public static ArrayList<String> MescidiselamTopkapiledMesajYazdýr2_varýs = new ArrayList();
	
	public static ArrayList<String> TopkapiMescidiselamledMesajYazdýr2_varýs = new ArrayList();
	public static ArrayList<String> LedYazdir_Sarý = new ArrayList();
	public static ArrayList<String> LedYazdir_Beyaz = new ArrayList();


	public int takomereSabiti;
    public int yaklasýmAnonsuMetraj;
    public int varýsAnonsuMetraj;	
    public int yaklasýmLediMetraj;
    public int kapýMetrajýTolerans;
    public int yaklasýmLediMetrajTolerans;
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
	      //   for(int i =0; i<T4_Istasyonlar_MescidiselamTopkapý.size(); i++ ) {
	       // 	 System.out.println(T4_Istasyonlar_MescidiselamTopkapý);
	            //	System.out.println(TopkapiMescidiselamledMesajYazdýr1.get(i)+ "++++"+ i + "sayý kadar");
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
	            	
	            	System.out.println(LedYazdir.get(i)+ "++++"+ i + "sayý kadar");
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

	        String mescidiselamTopkapý =  (String) istasyon.get("MescidiselamTopkapi");   
	        T4_Istasyonlar_MescidiselamTopkapý.add(mescidiselamTopkapý);
	        String mescidiselamTopkapýMesafe = (String) istasyon.get("MescidiselamTopkapiMesafe");    
	        T4_Mesafeler_MescidiselamTopkapý.add(Integer.parseInt(mescidiselamTopkapýMesafe));
	        String topkapýMescidiselam = (String) istasyon.get("TopkapiMescidiselam");    
	        T4_Istasyonlar_TopkapýMescidiselam.add(topkapýMescidiselam);
	        String topkapýMescidiselamMesafe = (String) istasyon.get("TopkapiMescidiselamMesafe");    
	        T4_Mesafeler_TopkapýMescidiselam.add(Integer.parseInt(topkapýMescidiselamMesafe));
	        String cihazID_1= (String) istasyon.get("cihazID_1");
	    	String cihazID_2=(String) istasyon.get("cihazID_2");
	    	String mesajBeklemeSüresidk_1=(String) istasyon.get("mesajBeklemeSuresidk_1");
	    	String mesajBeklemeSüresisn_1=(String) istasyon.get("mesajBeklemeSuresisn_1");
	    	String mesajBeklemeSüresisn_2_yaklasým=(String) istasyon.get("mesajBeklemeSuresisn_2_yaklasým");
	    	String mesajBeklemeSüresidk_2_yaklasým=(String) istasyon.get("mesajBeklemeSuresidk_2_yaklasým");
	    	String mesajBeklemeSüresisn_2_varýs=(String) istasyon.get("mesajBeklemeSuresisn_2_varýs");
	    	String mesajBeklemeSüresidk_2_varýs=(String) istasyon.get("mesajBeklemeSuresidk_2_varýs");
	    	String mesajHýzý_1=(String) istasyon.get("mesajHizi_1");
	    	String mesajHýzý_2=(String) istasyon.get("mesajHizi_2");
	    	String mesajTipi_1=(String) istasyon.get("mesajTipi_1");
	    	String mesajTipi_2=(String) istasyon.get("mesajTipi_2");
	    	String MescidiselamTopkapi_Led=(String) istasyon.get("MescidiselamTopkapi_Led");
	    	String TopkapiMescidiselam_Led=(String) istasyon.get("TopkapiMescidiselam_Led");      
	    	//10
	    	MescidiselamTopkapiledMesajYazdýr1.add(cihazID_1 +"MY"+ mesajBeklemeSüresidk_1 + mesajBeklemeSüresisn_1 + mesajHýzý_1 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazdýr1.add(cihazID_1 +"MY"+ mesajBeklemeSüresidk_1 + mesajBeklemeSüresisn_1 + mesajHýzý_1 + mesajTipi_2 + TopkapiMescidiselam_Led);

	    	//20
	    	MescidiselamTopkapiledMesajYazdýr2_varýs.add(cihazID_2 +"MY"+ mesajBeklemeSüresidk_2_varýs + mesajBeklemeSüresisn_2_varýs + mesajHýzý_2 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazdýr2_varýs.add(cihazID_2 +"MY"+ mesajBeklemeSüresidk_2_varýs + mesajBeklemeSüresisn_2_varýs + mesajHýzý_2 + mesajTipi_2 + TopkapiMescidiselam_Led);
	    	MescidiselamTopkapiledMesajYazdýr2_yaklasým.add(cihazID_2 +"MY"+ mesajBeklemeSüresidk_2_yaklasým + mesajBeklemeSüresisn_2_yaklasým + mesajHýzý_2 + mesajTipi_1 + MescidiselamTopkapi_Led);
	    	TopkapiMescidiselamledMesajYazdýr2_yaklasým.add(cihazID_2 +"MY"+ mesajBeklemeSüresidk_2_yaklasým + mesajBeklemeSüresisn_2_yaklasým + mesajHýzý_2 + mesajTipi_2 + TopkapiMescidiselam_Led);
	    }
	    public void tabelaParam(JSONObject object) 
	    {
	        JSONObject tabela = (JSONObject) object.get("Tabela");
	        String tabelaAdý =  (String) tabela.get("TabelaAdi");  
	    	String Led=(String) tabela.get("Led");
	        String cihazID_1= (String) tabela.get("cihazID_1");
	        String cihazID_2= (String) tabela.get("cihazID_2");

	    	String mesajBeklemeSüresidk_1=(String) tabela.get("mesajBeklemeSuresidk_1");
	    	String mesajBeklemeSüresisn_1=(String) tabela.get("mesajBeklemeSuresisn_1");
	    	String mesajHýzý_1=(String) tabela.get("mesajHizi_1");
	    	String mesajTipi_1=(String) tabela.get("mesajTipi_1");
	    	String mesajBeklemeSüresidk_2=(String) tabela.get("mesajBeklemeSuresidk_2");
	    	String mesajBeklemeSüresisn_2=(String) tabela.get("mesajBeklemeSuresisn_2");
	    	String mesajHýzý_2=(String) tabela.get("mesajHizi_2");
	    	String mesajTipi_2=(String) tabela.get("mesajTipi_2");
	        tabelaList.add(tabelaAdý);	     
	    	LedYazdir_Sarý.add(cihazID_1 +"MY"+ mesajBeklemeSüresidk_1 + mesajBeklemeSüresisn_1 + mesajHýzý_1 + mesajTipi_1 + Led);
	    	LedYazdir_Beyaz.add(cihazID_2 +"MY"+ mesajBeklemeSüresidk_2 + mesajBeklemeSüresisn_2 + mesajHýzý_2 + mesajTipi_2 + Led);

	    }
	    public void parseParam(JSONObject object) 
	    {
	        JSONObject employeeObject = (JSONObject) object.get("takoMetreVerisi");
	        String tako = (String) employeeObject.get("takoMetereSabiti");    
	        takomereSabiti = Integer.parseInt(tako);
	        
	        String yaklasýmMetraj = (String) employeeObject.get("yaklasimAnonsuMetraj");    
	        yaklasýmAnonsuMetraj = Integer.parseInt(yaklasýmMetraj);
	        
	        String varýsMetraj = (String) employeeObject.get("varisAnonsuMetraj");    
	        varýsAnonsuMetraj = Integer.parseInt(varýsMetraj);
	        
	        String ledMetraj = (String) employeeObject.get("yaklasimLediMetraj");    
	        yaklasýmLediMetraj = Integer.parseInt(ledMetraj);
	        
	        String kapýTolerans = (String) employeeObject.get("kapiMetrajiTolerans");    
	        kapýMetrajýTolerans = Integer.parseInt(kapýTolerans);
	        
	        String yaklasýmLediTolerans = (String) employeeObject.get("yaklasimLediMetrajTolerans");    
	        yaklasýmLediMetrajTolerans = Integer.parseInt(yaklasýmLediTolerans);
	        
	        /*JSONObject param = (JSONObject) object.get("param");
	         Zaman = (String) param.get("Zaman");    
	         CalismaZamanBaslangici = (String) param.get("ÇalýþmaZamanBaþlangýcý"); 
	         System.out.println(CalismaZamanBaslangici+"CalismaZamanBaslangici");
	         MetrajBilgisi = (String) param.get("MetrajBilgisi");    
	         IstasyonIsmi = (String) param.get("IstasyonIsmi");    
	         KapiDurumu = (String) param.get("KapýDurumu");    
	         IP = (String) param.get("IP");    

	        JSONObject metro = (JSONObject) object.get("metro");
	         TrenID = (String) metro.get("TrenID");    
	         TrenAdi = (String) metro.get("TrenAdý");    
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