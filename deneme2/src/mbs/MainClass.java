// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javafx.scene.media.MediaPlayer;

public class MainClass extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private MBSPlayer player;
    private TrenBilgileri trenBilgileri;
     private GpioController gpio;
    private Serial serial;
   // private GpioPinDigitalInput kapiButonu;
   // private GpioPinDigitalInput takometre;
    private GpioPinDigitalOutput amplifikator;
    private GpioPinDigitalInput anonsBaslatma;
    private GpioPinDigitalInput �nput3;
    private GpioPinDigitalInput �nput4;
    private GpioPinDigitalInput �nput5;
    private GpioPinDigitalInput �nput6;
    private GpioPinDigitalInput �nput7;
    private GpioPinDigitalInput �nput8;
    private GpioPinDigitalInput �nput1;

    private String versiyon = "v2.0.0";
    private static JLabel lblToplamMesafe;
    private JLabel lblHedefIstasyon;
    private JLabel lblGelecekIstasyon;
    private static JLabel lblKapiDurumu;
    private JLabel lblKalanMesafe;
    private JLabel lblAracDurumu;
    private JLabel lblVersion;
    private JLabel lblMevcutKonum;
    private JLabel lblGelecekKonum;
    private JLabel lblHedefKonum;
    private JLabel lblRotaHedef;
    private JLabel lblRotaBaslangic;
    private JLabel lblDetayliRotaMevcutIstasyon;
    private JLabel lblDetayliRotaHedef;
    private static JLabel lblBaslangicKonum;
    private JLabel lblTrenNoInfoLabel;
    private JLabel lblParolaBilgi;
    private JLabel trenNumarasiVal;
    private JButton btnAnonsKapat;
    private JButton btnTakometreByPass;

    private JButton btnTakometre;
    private JButton btnRole;

    private JPanel mainIstasyonPanel;
    private JPanel gelecekIstasyonPanel;
    private JPanel ayarlarPanel;
    private JPanel uyariPanel;
    private JPanel baslangicIstasyonuPanel;
    private JPanel konumPanel;
    private JPanel istasyonAnonslariPanel;
    private JPanel anaRotaKurPanel;
    private JPanel donusYonuSecPanel;
    private JTabbedPane tTabbedPane;
    private JTabbedPane tRotaKurPanel;
    private BlinkLabel lblRotaSecimUyari;
    private BlinkLabel lblRotaUyari;
    private int rotaSecilenIstasyon = 0;
    private int detayliRotaSecilenIstasyon = 0;
    private JGradientButton btnMescid;
    private JGradientButton btnTopkap�;
    private  JLabel lblMevcut ;
    private JLabel lblGelecek;
    
    private JGradientButton btnTopkap�1;

    private JGradientButton btnOnay;
    private JGradientButton btnIptal;
    private JGradientButton btnDetayliRotaOnay;
    private JGradientButton btnDetayliRotaIptal;
    private JTextField trenNoField;
    private JPasswordField passField;
    private JButton[] mevcutIstasyonButonlari;
    static Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");
    static TrayIcon trayIcon;
    private Rotalar mevcutRota;
    private String mevcutHedefIstasyon;
    private String startDir;
    private String imageDir;
    private ImageIcon iconOnay;
    private ImageIcon iconIptal;
    private Font fontDefault;
    private Font fontLabel;

    
   // private Font fontDetayliRota;
    //private Font fontAnaDetayliRota;

    //private Font fontOzelAnonslar;
    //private Font fontKonumLabel;
    private JLabel lblMevcutSesSeviyesi;
    private boolean isCursorVisible;
    String sesSeviyesi;
    private JTabbedPane tRotaPane;
    private Tema seciliTema;
    private EPostaYolla ePostaYolla;
    private JSONOku jsonOku;
    private static JSONYaz jsonYaz;
    SimpleDateFormat sekil = new SimpleDateFormat();
    static Date �al��t�rmaTarihi = new Date();	
    public static Boolean takometrePasifEt =false;
    public Boolean anonsYapma=false;

 //   private static BrightnessManager brightnessmanager;
    ActionListener listenerTabelaKur;
    ActionListener listenerAnaRotaKur;

    ActionListener listenerDetayliRota;
    ActionListener listenerDetayliAnaRota;
    ActionListener listenerDetayliRotaOnay;
    ActionListener listenerDetayliAnaRotaOnay;

    ActionListener listenerDetayliRotaIptal;
    ActionListener listenerDetayliAnaRotaIptal;
    ActionListener listenerDonusYonu;
    ActionListener listenerOzelAnonslar;
    ActionListener sesAzalt;
    ActionListener sesArttir;
    private static ArrayList<String> MescidiselamTopkapiledMesajYazd�r1 = new ArrayList();
    private static ArrayList<String> MescidiselamTopkapiledMesajYazd�r2 = new ArrayList();
    private static ArrayList<String> TopkapiMescidiselamledMesajYazd�r1 = new ArrayList();
    private static ArrayList<String> TopkapiMescidiselamledMesajYazd�r2 = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkap� = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_Topkap�Mescidiselam = new ArrayList();
    private static ArrayList<String> TabelaLed = new ArrayList();
    private static ArrayList<String> TabelaLedYazd�r_Sar� = new ArrayList();
    private static ArrayList<String> TabelaLedYazd�r_Beyaz = new ArrayList();


    static {
        trayIcon = new TrayIcon(image, "Tester2");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

               
                try {
                //brightnessmanager=new BrightnessManager();
                
                	//brightnessmanager.setBrightness(100);
                    JFrame testFrame = new JFrame();
                    testFrame.setBounds(0, 0, 800, 600);
                    testFrame.setUndecorated(true);
                    testFrame.setBackground(new Color(255, 255, 255));
                    testFrame.setVisible(true);
                    JLabel label = new JLabel();
                    String startDir = System.getProperty("user.dir");
                    String imageDir = "/img";
                    ImageIcon iconUlasim = new ImageIcon(startDir + imageDir + "/istanbul_ulasism.png");
                    label.setIcon(iconUlasim);
                    label.setBounds(0, 0, 800, 600);
                    label.setHorizontalAlignment(0);
                    label.setVerticalAlignment(0);
                    JPanel testContentPane = new JPanel();
                    testContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
                    testFrame.setContentPane(testContentPane);
                    testContentPane.setLayout((LayoutManager)null);
                    testContentPane.setBackground(Color.DARK_GRAY.brighter().brighter());
                    testContentPane.setBounds(0, 0, 800, 600);
                    testContentPane.add(label);
                    MainClass frame = new MainClass();
                    frame.setUndecorated(true);
                    frame.setExtendedState(6);
                    BufferedImage cursorImg = new BufferedImage(16, 16, 2);
                    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                    if (!OSValidator.isWindows()) {
                        frame.getContentPane().setCursor(blankCursor);
                    }

                    frame.getContentPane().setCursor(blankCursor);
                    testFrame.setVisible(false);
                    frame.setVisible(true);
                    jsonYaz =new JSONYaz();

               	  /* Timer myTimer=new Timer();
                    TimerTask gorev =new TimerTask() {   
                           @Override
                           public void run() {
                                  System.out.println(�al��t�rmaTarihi+lblKapiDurumu.getText()+lblToplamMesafe.getText()+ lblBaslangicKonum.getText());      

                                  jsonYaz.parametrik(�al��t�rmaTarihi,lblKapiDurumu.getText(),lblToplamMesafe.getText(), lblBaslangicKonum.getText());
                           }
                    };
        
                    myTimer.schedule(gorev,0,3000);
               	*/
                    jsonYaz.sabit();
                } catch (Exception var10) {
                    var10.printStackTrace();
                }

            }
        });
    }

    public MainClass() {
    	jsonOku = new JSONOku();
        jsonOku.main("/station");
    	T4_Istasyonlar_MescidiselamTopkap�=jsonOku.T4_Istasyonlar_MescidiselamTopkap�;
    	T4_Istasyonlar_Topkap�Mescidiselam=jsonOku.T4_Istasyonlar_Topkap�Mescidiselam;

    	MescidiselamTopkapiledMesajYazd�r1=jsonOku.MescidiselamTopkapiledMesajYazd�r1;
    	//MescidiselamTopkapiledMesajYazd�r2=jsonOku.MescidiselamTopkapiledMesajYazd�r2;
    	
    	TopkapiMescidiselamledMesajYazd�r1=jsonOku.TopkapiMescidiselamledMesajYazd�r1;
    	//TopkapiMescidiselamledMesajYazd�r2=jsonOku.TopkapiMescidiselamledMesajYazd�r2;
     
        this.mevcutRota = Rotalar.SECILMEDI;
        this.mevcutHedefIstasyon = "";
        this.isCursorVisible = false;
        this.sesSeviyesi = "??";
        this.listenerTabelaKur = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("LED:" + e.getActionCommand());
                if (!OSValidator.isWindows()) {
    	        	
    	                      // MainClass.this.writeToSP(TabelaIstasyoAdiGetir_Sar�(e.getActionCommand()));
    	                       MainClass.this.SendRS232Data(TabelaIstasyoAdiGetir_Sar�(e.getActionCommand()));
    	                     //  MainClass.this.writeToSP(TabelaIstasyoAdiGetir_Beyaz(e.getActionCommand()));    	                	   
    	                       MainClass.this.SendRS232Data(TabelaIstasyoAdiGetir_Beyaz(e.getActionCommand()));

    	    }else {
    	    	//	//data= data.replace("�", "-").replace("�", "_").replace("�", ",").replace("�", "*").replace("�", "\\").replace("�", "/");
                //MainClass.this.writeToSP(TabelaIstasyoAdiGetir_Sar�(e.getActionCommand()));    	                	   
               // MainClass.this.writeToSP(TabelaIstasyoAdiGetir_Beyaz(e.getActionCommand()));
                MainClass.this.SendRS232Data(TabelaIstasyoAdiGetir_Sar�(e.getActionCommand()));
                MainClass.this.SendRS232Data(TabelaIstasyoAdiGetir_Beyaz(e.getActionCommand()));


    	    }                MainClass.this.tTabbedPane.setSelectedIndex(0);
                
            }
        };
        this.listenerAnaRotaKur = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("LED:" + e.getActionCommand());
                btnMescid.setActionCommand(e.getActionCommand());
                if (!OSValidator.isWindows()) {
    	         //  MainClass.this.writeToSP(IstasyonLedAdiGetir(e.getActionCommand()));
    	           MainClass.this.SendRS232Data(IstasyonLedAdiGetir(e.getActionCommand()));    	                	                 	   
    
    	    }else {
                //MainClass.this.writeToSP(IstasyonLedAdiGetir(e.getActionCommand()));    	                	    	                	   

                MainClass.this.SendRS232Data(IstasyonLedAdiGetir(e.getActionCommand()));    	                	    	                	   
    	    }
                MainClass.this.tTabbedPane.setSelectedIndex(0);

            }                                              	
        };
        this.listenerDetayliRota = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.detayliRotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblDetayliRotaMevcutIstasyon.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                } else if (MainClass.this.detayliRotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblDetayliRotaHedef.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                    MainClass.this.btnDetayliRotaOnay.setEnabled(true);
                }

            }
        };
        this.listenerDetayliAnaRota = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.detayliRotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.btnMescid.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                }
               
                else if (MainClass.this.detayliRotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.btnTopkap�.setText(e.getActionCommand());
                    var10000 = MainClass.this;
                    var10000.detayliRotaSecilenIstasyon = var10000.detayliRotaSecilenIstasyon + 1;
                    MainClass.this.btnDetayliRotaOnay.setEnabled(true);

                }
               

            }
        };
        this.listenerDetayliRotaOnay = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String baslangicIstasyonu = RotaBilgileri.BaslangicIstasyonuBul(MainClass.this.lblDetayliRotaMevcutIstasyon.getText(), MainClass.this.lblDetayliRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.trenBilgileri.setRotaBilgileri(MainClass.this.lblDetayliRotaMevcutIstasyon.getText(), baslangicIstasyonu, MainClass.this.lblDetayliRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.lblDetayliRotaMevcutIstasyon.setText("-");
                MainClass.this.lblDetayliRotaMevcutIstasyon.setFont(fontLabel);

                MainClass.this.lblDetayliRotaHedef.setText("-");
                MainClass.this.lblDetayliRotaHedef.setFont(fontLabel);

                MainClass.this.detayliRotaSecilenIstasyon = 0;
              

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                        JButton btn = (JButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setFont(fontDefault);
                        btn.setEnabled(true);
                    } catch (Exception var5) {
                    }
                }

                MainClass.this.btnDetayliRotaOnay.setEnabled(false);
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                if (!MainClass.this.mevcutRota.equals(Rotalar.GECERS�Z)) {
                    MainClass.this.mevcutRota.equals(Rotalar.SECILMEDI);
                }

              //  MainClass.this.MevcutIstasyonButonKontrol();
            }
        };
        this.listenerDetayliAnaRotaOnay = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	   
                 MainClass.this.btnTopkap�.setActionCommand("sdsdsdsdsdsda");
                 MainClass.this.btnTopkap�.setText("sdsdsdsdsdsda");

            }
        };
        this.listenerDetayliRotaIptal = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.lblDetayliRotaMevcutIstasyon.setText("-");
                MainClass.this.lblDetayliRotaHedef.setText("-");
                MainClass.this.detayliRotaSecilenIstasyon = 0;
                MainClass.this.btnDetayliRotaOnay.setEnabled(false);

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                        JButton btn = (JButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setEnabled(true);
                    } catch (Exception var4) {
                    }
                }

            }
        };
        
        this.listenerDetayliAnaRotaIptal = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.btnMescid.setText(" ");
               MainClass.this.btnTopkap�.setText(" ");

                MainClass.this.detayliRotaSecilenIstasyon = 0;
                MainClass.this.btnDetayliRotaOnay.setEnabled(false);

                for(int i = 0; i < MainClass.this.istasyonAnonslariPanel.getComponentCount(); ++i) {
                    try {
                    	JGradientButton btn = (JGradientButton)MainClass.this.istasyonAnonslariPanel.getComponent(i);
                        btn.setEnabled(true);
                    } catch (Exception var4) {
                    }
                }

            }
        };
        this.listenerDonusYonu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String istasyon = e.getActionCommand();
                if (!OSValidator.isWindows()) {
                	 // MainClass.this.writeToSP(IstasyonLedAdiGetir(istasyon));
    	                       MainClass.this.SendRS232Data(IstasyonLedAdiGetir(istasyon));


    	    }else {
    	    	//  MainClass.this.writeToSP(IstasyonLedAdiGetir(istasyon));
                MainClass.this.SendRS232Data(IstasyonLedAdiGetir(istasyon));

    	    }
                MainClass.this.lblKalanMesafe.setText(String.valueOf(MainClass.this.trenBilgileri.getKalanMesafe()));
                MainClass.this.donusYonuSecPanel.setVisible(false);
            }
        };
        this.listenerOzelAnonslar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                String path = e.getActionCommand();
            //    System.out.println(path);
				//String path =this.startDirx +"/Anons/OZEL/ANONS1"+"/ARAC_DEPOYA_G�DER.mp3";
		       
               // this.iconOnay = new ImageIcon(this.startDir + this.imageDir + "/onay.png");
               // System.out.println("Path:" + path);
                MainClass.this.tTabbedPane.requestFocus();
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                	//MainClass.this.anonsYapma=true;
                	 if(!MainClass.this.player.state){
                         MainClass.this.player.Play(path);//sil
                         if(!OSValidator.isWindows()) {
                             MainClass.this.trenBilgileri.role.isHigh();

                         }
                     }
                	 else {
                     	System.out.println("�st �ste anons yap�lamaz");
                     }

            
                MainClass.this.contentPane.requestFocus();
                if (path.contains("ARAC_DEPOYA_GIDER")) {
                    MainClass.this.SendRS232Data("10MY400015   DEPO");
                    MainClass.this.SendRS232Data("20MY400015   DEPO");
                    
                } else if (path.contains("ARAC_SERVIS_DISI")) {
                	MainClass.this.SendRS232Data("10MY400015SERV�S DI�I");
                    MainClass.this.SendRS232Data("20MY400015SERV�S DI�I");
                } else if (path.contains("ARA� ATAT�RK")) {
                    MainClass.this.SendRS232Data("ATAK�Y - ��R�NEVLER");
                } else if (path.contains("ARA� K�RAZLI")) {
                    MainClass.this.SendRS232Data("K�RAZLI");
                } else if (path.contains("ARA� OTOGAR")) {
                    MainClass.this.SendRS232Data("OTOGAR");
                } else if (path.contains("ARA� YEN�KAPI")) {
                    MainClass.this.SendRS232Data("YEN�KAPI");
                }

            }
        };
        this.sesAzalt = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!OSValidator.isWindows()) {
                    try {
                     //   String[] co = new String[]{"/bin/sh", "-c", "sudo amixer set PCM 1060-"};
                        String[] co = new String[]{"/bin/sh", "-c", "sudo amixer set 'Master' 10%-"};

                        Runtime.getRuntime().exec(co);
                        MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }
                    } catch (IOException var3) {
                        var3.printStackTrace();
                    }

                }
                else {                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                System.out.println(MainClass.this.lblMevcutSesSeviyesi);
                if (MainClass.this.lblMevcutSesSeviyesi != null) {
                    MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                }
}
                
            }
        };
        this.sesArttir = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!OSValidator.isWindows()) {
                    try {
                        String[] co = new String[]{"/bin/sh", "-c", "sudo amixer set 'Master' 10%+"};
                        Runtime.getRuntime().exec(co);
                        MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }
                    } catch (IOException var3) {
                        var3.printStackTrace();
                    }

                }
                else {                        System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                if (MainClass.this.lblMevcutSesSeviyesi != null) {
                    MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                }
}
            }
        };
        this.seciliTema = new Tema(this.getBackground());
        this.startDir = System.getProperty("user.dir");
        this.imageDir = "/img";
        this.iconOnay = new ImageIcon(this.startDir + this.imageDir + "/onay.png");
        this.iconIptal = new ImageIcon(this.startDir + this.imageDir + "/iptal.png");
        
        this.fontDefault = new Font(this.seciliTema.fontName, this.seciliTema.fontStyle, this.seciliTema.fontSize);
        this.fontLabel = new Font(this.seciliTema.fontName, this.seciliTema.fontStyle, this.seciliTema.fontSizeLabel);


      //  this.fontOzelAnonslar = this.fontDefault;//.deriveFont(13.0F);
        //this.fontKonumLabel = this.fontDefault;//.deriveFont(14.0F);
        UIManager.put("TabbedPane.selected", this.seciliTema.selectedTabBackground);
        UIManager.put("TabbedPane.selectedForeground", this.seciliTema.selectedTabForeground);
        UIManager.put("TabbedPane.foreground", this.seciliTema.selectedTabForeground);
        this.setDefaultCloseOperation(3);
        this.setBounds(0, 0, 800, 600);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        this.contentPane.setBackground(this.seciliTema.contentPaneBackground);
        this.contentPane.setFont(fontLabel);
        this.tTabbedPane = new JTabbedPane();
        this.tTabbedPane.setBackground(this.seciliTema.tabbedPaneBackground);
        
        this.tTabbedPane.setTabLayoutPolicy(1);
        this.tTabbedPane.setForeground(this.seciliTema.tabcolor);
        this.tTabbedPane.setFont(this.fontLabel);

        JPanel trenBilgileriPanel = this.TrenBilgileriPaneliGetir();

        this.tTabbedPane.addTab("<html><center>&nbsp;TREN<br/>B�LG�LER�<br></center></html>", (Icon)null, trenBilgileriPanel);
        this.tTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                MainClass.this.tRotaKurPanel.setSelectedIndex(0);
            }
        });
    
        JPanel rotaKurPanel = new JPanel();
        rotaKurPanel.setLayout((LayoutManager)null);
        rotaKurPanel.setBounds(0, 0, 800, 600);
        rotaKurPanel.setBackground(this.seciliTema.rotaKurPanelBackground);
        this.tRotaKurPanel = this.RotaPaneliGetir();
        this.tRotaKurPanel.setBounds(5, 5, 775, 490);
        rotaKurPanel.add(this.tRotaKurPanel);
        this.tTabbedPane.addTab("<html><center>&nbsp;&nbsp;ROTA<br/>&nbsp;&nbsp;KUR&nbsp;&nbsp;<br></center></html>", (Icon)null, rotaKurPanel);
        this.baslangicIstasyonuPanel = this.BaslangicAnonlariPaneliniGetir();
        this.tTabbedPane.addTab("<html><center>&nbsp;BA�LANGI�&nbsp;<br>ANONSLARI<br></center></html>", (Icon)null, this.baslangicIstasyonuPanel);
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout((LayoutManager)null);
        ozelAnonsPanel.setBounds(0, 0, 800, 600);
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanelBackground);
        JTabbedPane ozelAnonsTabPanel = this.OzelAnonlarPaneliniGetir();
        ozelAnonsPanel.add(ozelAnonsTabPanel);
        this.tTabbedPane.addTab("<html><center><br><br>�ZEL<br/>ANONSLAR<br><br><br></center></html>", (Icon)null, ozelAnonsPanel);
        this.mainIstasyonPanel = new JPanel();
        this.mainIstasyonPanel.setLayout((LayoutManager)null);
        this.mainIstasyonPanel.setBounds(0, 0, 800, 500);
        JPanel istasyonlarPanel = this.IstasyonlarPaneliniGetir();
        this.mainIstasyonPanel.add(istasyonlarPanel);
        this.tTabbedPane.addTab("<html><center>&nbsp;&nbsp;�STASYON&nbsp;&nbsp;<br>ANONSLARI<br></center></html>", (Icon)null, this.mainIstasyonPanel);
        this.ayarlarPanel = this.ParolaPanel();
        ozelAnonsPanel.setBackground(this.seciliTema.ayarlarPanelBackground);
        this.tTabbedPane.addTab("<html><center>&nbsp;AYARLAR&nbsp;<br></center></html>", (Icon)null, this.ayarlarPanel);
        
        this.contentPane.add(this.tTabbedPane);
        this.player = new MBSPlayer();

    
        this.trenBilgileri = new TrenBilgileri();
        this.trenBilgileri.addListener(new TrenBilgisiListener() {
            public void Guncelle(TrenBilgisiEvent evt) {
                MainClass.this.TrenBilgileriArayuzunuGuncelle(evt);
                MainClass.this.RotaKontrol(evt.rota);
            }

            public void YaklasimAnonsu(TrenBilgisiEvent evt) {
                MainClass.this.YaklasimAnonsuYap(MainClass.this.trenBilgileri.getBaslangicIstasyonu(), IstasyondanDosyaOkuma(evt.gelecekIstasyon), evt.hedefIstasyon);
                if (evt.gelecekIstasyon.equals(evt.hedefIstasyon)) {
                  //  if (!evt.gelecekIstasyon.equals("TOPKAPI")) {
                       // MainClass.this.donusYonuSecPanel.setVisible(true);
                       // MainClass.this.writeToSP(IstasyonLedAdiGetir(MainClass.this.trenBilgileri.getBaslangicIstasyonu()));    	
                //} else {
                    	
	                   //    MainClass.this.writeToSP(IstasyonLedAdiGetir("MESCID-� SELAM"));    	                	   

                        //MainClass.this.writeToSP("10MY010015MESCIDISELAM");
                    	
                    }
              //  }

                MainClass.this.contentPane.requestFocus();
            }

            public void VarisAnonsu(TrenBilgisiEvent evt) {
                if (MainClass.this.mevcutRota != Rotalar.GECERS�Z && MainClass.this.mevcutRota != Rotalar.SECILMEDI) {
                   // Rotalar var10000 = Rotalar.DEPO;
                }

                MainClass.this.VarisAnonsuYap(MainClass.this.trenBilgileri.getBaslangicIstasyonu(), IstasyondanDosyaOkuma(evt.gelecekIstasyon), evt.hedefIstasyon);
                String hedef=evt.hedefIstasyon;
                
               	MainClass.this.SendRS232Data(IstasyonLedAdiGetir(hedef));  
                MainClass.this.donusYonuSecPanel.setVisible(false);
                MainClass.this.contentPane.requestFocus();
            }

            public void MevcutIstasyonDegisti(String mevcutIstasyon) {
                for(int i = 0; i < MainClass.this.mevcutIstasyonButonlari.length; ++i) {
                    MainClass.this.mevcutIstasyonButonlari[i].setEnabled(false);
                }

            }
        
        });
        if (!OSValidator.isWindows()) {
            this.InitializeIO();
        }

        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('x'), "forward");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('X'), "forward");
        this.contentPane.getActionMap().put("forward", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (!MainClass.this.isCursorVisible) {
                    MainClass.this.getContentPane().setCursor(Cursor.getDefaultCursor());
                    MainClass.this.isCursorVisible = true;
                } else {
                    BufferedImage cursorImg = new BufferedImage(16, 16, 2);
                    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
                    MainClass.this.getContentPane().setCursor(blankCursor);
                    MainClass.this.isCursorVisible = false;
                }

            }
        });
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('t'), "takometre");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('T'), "takometre");
        this.contentPane.getActionMap().put("takometre", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (OSValidator.isWindows()) {
                    MainClass.this.trenBilgileri.TakometreVerisiGuncelle();
                }

            }
        });
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('k'), "kapi");
        this.contentPane.getInputMap().put(KeyStroke.getKeyStroke('K'), "kapi");
        this.contentPane.getActionMap().put("kapi", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                if (OSValidator.isWindows()) {
                    if (MainClass.this.trenBilgileri.getKapiDurumu()) {
                        MainClass.this.KapiDurumuDegistir(false);
                    } else {
                        MainClass.this.KapiDurumuDegistir(true);
                    }
                }

            }
        });
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger("global");
        globalLogger.setLevel(Level.OFF);
        TimerTask task = new MainClass.EkranKoruyucuEngelleTask();
        Timer timer = new Timer();
        timer.schedule(task, 8000L, 50000L);
        this.fontLabel = new Font(this.seciliTema.fontName, this.seciliTema.fontStyle, this.seciliTema.fontSizeLabel);

       if (MainClass.this.trenBilgileri.getKapiDurumu()) {
           this.lblKapiDurumu.setText(this.TextCenter("A�IK"));
           this.lblKapiDurumu.setFont(fontLabel);
       this.lblKapiDurumu.setForeground(Color.red);

         //   this.lblKapiDurumu.setFont(this.fontLabel);
        }
        else {
            this.lblKapiDurumu.setText(this.TextCenter("KAPALI"));
           this.lblKapiDurumu.setForeground(Color.green);

        }
    }

    public void TrenBilgileriArayuzunuGuncelle(TrenBilgisiEvent evt) {
       // this.fontLabel = new Font(this.seciliTema.fontName, this.seciliTema.fontStyle, 20);

        this.lblAracDurumu.setText(this.TextCenter(evt.istasyonDurumu));
        if (!this.donusYonuSecPanel.isVisible()) {
            this.lblKalanMesafe.setText(this.TextCenter(evt.kalanMesafe));
            this.lblKalanMesafe.setFont(fontLabel);

        }

        this.lblKapiDurumu.setText(this.TextCenter(evt.kapiDurumu));
        if(this.lblKapiDurumu.toString().contains("A�IK")==true) {
        	this.lblKapiDurumu.setForeground(Color.red);
            this.lblAracDurumu.setFont(fontLabel);

        }else {
        	 this.lblKapiDurumu.setForeground(Color.green);
        }
        this.lblToplamMesafe.setText(this.TextCenter(evt.toplamMesafe));
        this.lblToplamMesafe.setFont(fontLabel);
        
        this.lblBaslangicKonum.setText(this.TextCenter(this.trenBilgileri.getBaslangicIstasyonu()));

        
        
        if(evt.mevcutKonumGosterge!="") 
        {
        	this.lblMevcutKonum.setText(this.TextCenter(evt.gelecekIstasyon));
        	this.lblMevcutKonum.setVisible(true);
        	this.lblMevcut.setVisible(true);
        	this.lblMevcutKonum.setBounds(195, 95, 130, 100);
         	this.lblMevcut.setBounds(220, 20, 50, 100);
         	//this.lblMevcutKonum.setBounds(195, 95, 100, 100);
         	//this.lblMevcut.setBounds(220, 20, 50, 100);

        }else 
        {
        	this.lblMevcutKonum.setVisible(false);
        	this.lblMevcut.setVisible(false);

        }if(evt.gelecekKonumGosterge!="") 
        {
            this.lblGelecekKonum.setText(this.TextCenter(evt.sonrakiIstasyon));
        	this.lblGelecekKonum.setVisible(true);
        	this.lblGelecek.setVisible(true);

        	this.lblGelecek.setBounds(430, 20, 50, 100);
             this.lblGelecekKonum.setBounds(410, 95, 130, 100);


        }
        else 
        {
        	this.lblGelecekKonum.setVisible(false);
        	this.lblGelecek.setVisible(false);
        	this.lblGelecek.setBounds(430, 20, 50, 100);
            this.lblGelecekKonum.setBounds(410, 95, 130, 100);
        }

        //mevcut konumu de�i�tirdim
        this.lblHedefKonum.setText(this.TextCenter(evt.hedefIstasyon));
        this.lblHedefIstasyon.setText(this.TextCenter(evt.hedefIstasyon));
        this.lblHedefIstasyon.setFont(fontLabel);
        this.lblGelecekIstasyon.setText(this.TextCenter(evt.gelecekIstasyon));
        this.lblGelecekIstasyon.setFont(fontLabel);  
        }
    private String IstasyonLedAdiGetir(String istasyonAdi) {
    	System.out.println(istasyonAdi+"istasyon ad� getir");

    	if(T4_Istasyonlar_MescidiselamTopkap�.get(0).toString().contains(istasyonAdi)==true) 
    	{

    		for (int i=0; i< T4_Istasyonlar_MescidiselamTopkap�.size(); i++){
                if (T4_Istasyonlar_MescidiselamTopkap�.get(i).toString().contains(istasyonAdi)==true){
                	System.out.println(MescidiselamTopkapiledMesajYazd�r1.get(i));
               	 return MescidiselamTopkapiledMesajYazd�r1.get(i);
              }
           }	
    	}else if(T4_Istasyonlar_Topkap�Mescidiselam.get(0).toString().contains(istasyonAdi)==true){

    		for (int i=0; i< T4_Istasyonlar_Topkap�Mescidiselam.size(); i++){
                if (T4_Istasyonlar_Topkap�Mescidiselam.get(i).toString().contains(istasyonAdi)==true){
                	System.out.println(TopkapiMescidiselamledMesajYazd�r1.get(i));

                	 return TopkapiMescidiselamledMesajYazd�r1.get(i);

              }
           }
    		
    	}
    	
       return "10MY010015 ";
    }
    private String TabelaIstasyoAdiGetir_Sar�(String istasyonAdi) {
    	//System.out.println(istasyonAdi+  "----->istasyonad�");

    
    		for (int i=0; i< TabelaLed.size(); i++){
    			
                if (TabelaLed.get(i).toString().contains(istasyonAdi)==true){
        	System.out.println(TabelaLedYazd�r_Sar�.get(i)+"1");
                	
               	 return TabelaLedYazd�r_Sar�.get(i);
              }
               
           
    	}
    		
    	
    	
       return "10MY010015 ";
    }
    private String TabelaIstasyoAdiGetir_Beyaz(String istasyonAdi) {    
    	for (int i=0; i< TabelaLed.size(); i++){  			
                if (TabelaLed.get(i).toString().contains(istasyonAdi)==true){
               	System.out.println("beyaz ledlerde : "+ TabelaLedYazd�r_Beyaz.get(i));
               	 return TabelaLedYazd�r_Beyaz.get(i);
              }
    	}
	
       return "20MY010015 ";
    }
  

    private File[] Sirala(File[] dosyalar) {
        for(int i = 0; i < dosyalar.length - 1; ++i) {
            int index = this.getIstasyonIndex(dosyalar[i].getName());
            if (index >= 0 && index < dosyalar.length && index != i) {
                File temp = new File(dosyalar[i].getAbsolutePath());
                dosyalar[i] = new File(dosyalar[index].getAbsolutePath());
                dosyalar[index] = new File(temp.getAbsolutePath());
                i = 0;
            }
        }

        return dosyalar;
    }

    private int getIstasyonIndex(String istasyon) {
        if (istasyon.toUpperCase().equals("TOPKAPI")) {
            return 0;
        } else if (istasyon.toUpperCase().equals("FETIHKAPI")) {
            return 1;
        } else if (istasyon.toUpperCase().equals("VATAN")) {
            return 2;
        } else if (istasyon.toUpperCase().equals("EDIRNEKAPI")) {
            return 3;
        } else if (istasyon.toUpperCase().equals("SEHITLIK")) {
            return 4;
        } else if (istasyon.toUpperCase().equals("DEMIRKAPI")) {
            return 5;
        } else if (istasyon.toUpperCase().equals("TOPCULAR")) {
            return 6;
        } else if (istasyon.toUpperCase().equals("RAMI")) {
            return 7;
        } else if (istasyon.toUpperCase().equals("ULUYOL")) {
            return 8;
        } else if (istasyon.toUpperCase().equals("SAGMALCILAR")) {
            return 9;
        } else if (istasyon.toUpperCase().equals("CUKURCESME")) {
            return 10;
        } else if (istasyon.toUpperCase().equals("A. FUAT BA�.")) {
            return 11;
        } else if (istasyon.toUpperCase().equals("TASKOPRU")) {
            return 12;
        } else if (istasyon.toUpperCase().equals("KARADENIZ")) {
            return 13;
        } else if (istasyon.toUpperCase().equals("KIPTAS-VEN.")) {
            return 14;
        } else if (istasyon.toUpperCase().equals("CUMHURIYET")) {
            return 15;
        } else if (istasyon.toUpperCase().equals("50.YIL")) {
            return 16;
        } else if (istasyon.toUpperCase().equals("HACI SUKRU")) {
            return 17;
        } else if (istasyon.toUpperCase().equals("YENIMAHALLE")) {
            return 18;
        } else if (istasyon.toUpperCase().equals("SULTANCIFTLIGI")) {
            return 19;
        } else if (istasyon.toUpperCase().equals("CEBECI")) {
            return 20;
        } else if (istasyon.toUpperCase().equals("MESCID-� SELAM")) {
            return 21;
        }  else {
            return -1;
        }
    }

    private void PowerManagerKapat() {
        if (!OSValidator.isWindows()) {
            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo pkill -f mate-power"};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var3) {
                System.out.println(var3.toString());
            }

        }
    }

    private void ScreenSaverKapat() {
        if (!OSValidator.isWindows()) {
            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo pkill -f mate-screens"};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var3) {
                System.out.println(var3.toString());
            }

        }
    }

    private void EkranKoruyucuyuIptalEt() {
        this.PowerManagerKapat();
        this.ScreenSaverKapat();
    }

    private void KalibrasyonuAyarla(String min_x, String max_x, String min_y, String max_y) {
        try {
            boolean isOptionEnable = false;
            String input = "";
            String newLine = "\t\tOption \"Calibration\" \"" + min_x + " " + max_x + " " + min_y + " " + max_y + "\"";
            String path = "/usr/share/X11/xorg.conf.d/10-evdev.conf";
            BufferedReader file = new BufferedReader(new FileReader(path));

            while(true) {
                String line;
                while((line = file.readLine()) != null) {
                    if (line.contains("Option") && line.contains("Calibration")) {
                        input = input + newLine + '\n';
                        isOptionEnable = true;
                    } else {
                        input = input + line + '\n';
                    }
                }

                file.close();
                if (!isOptionEnable) {
                    file = new BufferedReader(new FileReader(path));

                    while((line = file.readLine()) != null) {
                        input = input + line + '\n';
                        if (line.contains("Identifier") && line.contains("evdev touchscreen catchall")) {
                            input = input + newLine + '\n';
                        }
                    }

                    file.close();
                }

                FileOutputStream fileOut = new FileOutputStream(path);
                fileOut.write(input.getBytes());
                fileOut.close();
                break;
            }
        } catch (Exception var12) {
            System.out.println("Problem reading file.\n" + var12.toString());
        }

    }

    private void KalibrasyonuSifirla() {
        try {
            String input = "";
            String path = "/usr/share/X11/xorg.conf.d/10-evdev.conf";
            BufferedReader file = new BufferedReader(new FileReader(path));

            while(true) {
                String line;
                do {
                    if ((line = file.readLine()) == null) {
                        file.close();
                        FileOutputStream fileOut = new FileOutputStream(path);
                        fileOut.write(input.getBytes());
                        fileOut.close();
                        return;
                    }
                } while(line.contains("Option") && line.contains("Calibration"));

                input = input + line + '\n';
            }
        } catch (Exception var6) {
            System.out.println("Problem reading file.\n" + var6.toString());
        }
    }

    private String[] EthernetAyarMetniOlustur(int trenNo) {
        int num = trenNo - 400;
        String[] texts = new String[]{"#interfaces(5) file used by ifup(8) and ifdown(8)", "#Include files from /etc/network/interfaces.d:", "source-directory /etc/network/interfaces.d", "", "auto eth2", "iface eth2 inet loopback", "iface eth2 inet static", null, null};
        if (trenNo == 571) {
            texts[7] = "        address 10.2.149.24";
            texts[8] = "        netmask 255.255.255.0";
        } else {
            texts[7] = "        address 172.22.110." + num;
            texts[8] = "        netmask 255.255.255.0";
        }

        return texts;
    }

    private void EthernetAyariYap(String[] text) {
        if (!OSValidator.isWindows()) {
            String[] co;
            try {
                Throwable var2 = null;
                co = null;

                try {
                    PrintStream out = new PrintStream(new FileOutputStream("/etc/network/interfaces"));

                    try {
                        for(int i = 0; i < text.length; ++i) {
                            out.println(text[i]);
                        }
                    } finally {
                        if (out != null) {
                            out.close();
                        }

                    }
                } catch (Throwable var16) {
                    if (var2 == null) {
                        var2 = var16;
                    } else if (var2 != var16) {
                        var2.addSuppressed(var16);
                    }

                    throw var2;
                }
            } catch (FileNotFoundException var17) {
                var17.printStackTrace();
            }

            try {
                co = new String[]{"/bin/sh", "-c", "sudo ifdown eth2; sudo ifup eth2 "};
                Process p = Runtime.getRuntime().exec(co);
                p.waitFor();
                p.destroy();
            } catch (Exception var14) {
            }

        }
    }

    private void TrenNoKaydet(String trenNo) {
        if (!OSValidator.isWindows()) {
            String[] co = new String[]{"/bin/sh", "-c", "echo " + trenNo + " > '/home/ybspi/trenno.txt' "};

            try {
                Runtime.getRuntime().exec(co);
            } catch (IOException var4) {
                var4.printStackTrace();
            }

        }
    }

    private String TrenNoGetir() {
        if (OSValidator.isWindows()) {
            return "000";
        } else {
            String tNo = "";

            try {
                String[] co = new String[]{"/bin/sh", "-c", "sudo cat '/home/ybspi/trenno.txt' "};
                Process p = Runtime.getRuntime().exec(co);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while((tNo = br.readLine()) != null) {
                    if (tNo != "") {
                        System.out.println("TrenNo: " + tNo);
                        break;
                    }
                }

                p.waitFor();
                System.out.println("exit: " + p.exitValue());
                p.destroy();
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return tNo;
        }
    }

   /* private void MevcutIstasyonButonKontrol() {
        for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
            boolean isEnable = RotaBilgileri.IstasyonRotadaMi(this.mevcutRota, this.mevcutIstasyonButonlari[i].getActionCommand(), this.trenBilgileri.getBaslangicIstasyonu(), this.trenBilgileri.getHedefIstasyon());
            if (!isEnable) {
                this.mevcutIstasyonButonlari[i].setEnabled(false);
            } else {
                this.mevcutIstasyonButonlari[i].setEnabled(true);
            }
        }

    }*/

    public void RotaKontrol(Rotalar rota) {
         if (rota.equals(Rotalar.GECERS�Z)) {
            System.out.println("Rota GECERS�Z");
            this.lblRotaSecimUyari.setText(this.TextCenter("SE��LEN ROTA GE�ERL� DE��L"));
            this.lblRotaSecimUyari.setFont(fontLabel);

            this.uyariPanel.setVisible(true);
        } else if (rota.equals(Rotalar.SECILMEDI)) {
            this.lblRotaSecimUyari.setText(this.TextCenter("L�TFEN ROTA SE��N�Z"));
            this.lblRotaSecimUyari.setFont(fontLabel);

            this.uyariPanel.setVisible(true);
        }else if(rota.equals(Rotalar.Kur)) {
            this.lblRotaSecimUyari.setText(this.TextCenter("ROTA TAMAMLANDI. YEN� ROTA SE��N�Z"));
            this.lblRotaSecimUyari.setFont(fontLabel);

            this.uyariPanel.setVisible(true);
        	this.lblMevcutKonum.setVisible(true);
        	this.lblMevcut.setVisible(true);
        	 this.lblGelecekKonum.setVisible(true);
         	this.lblGelecek.setVisible(true);
         	this.lblMevcutKonum.setBounds(195, 95, 100, 100);
         	this.lblMevcut.setBounds(220, 20, 50, 100);
        }     
        else if (rota.equals(Rotalar.T4Topkap�Mescidiselam)) {
            this.uyariPanel.setVisible(false);
        } else if (rota.equals(Rotalar.T4MescidiselamTopkap�)) {
            this.uyariPanel.setVisible(false);
        } 
      /*   if ((!rota.equals(this.mevcutRota) || !this.trenBilgileri.getHedefIstasyon().equals(this.mevcutHedefIstasyon)) && !rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERS�Z)) {
        	 String hedef=this.trenBilgileri.getHedefIstasyon();
   	       //MainClass.this.writeToSP(IstasyonLedAdiGetir(hedef)); 
   	      //  System.out.println("hedef istasyon bilgisi : " +hedef);
   	       MainClass.this.SendRS232Data(IstasyonLedAdiGetir(hedef));         
   	       } else if (rota.equals(Rotalar.SECILMEDI) || rota.equals(Rotalar.GECERS�Z)) {
             for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
                 this.mevcutIstasyonButonlari[i].setEnabled(false);
             }
         }*/
        if ((!rota.equals(this.mevcutRota) || !this.trenBilgileri.getHedefIstasyon().equals(this.mevcutHedefIstasyon)) && !rota.equals(Rotalar.SECILMEDI) && !rota.equals(Rotalar.GECERS�Z)) {       	
 	        String hedef=this.trenBilgileri.getHedefIstasyon();
 	       //MainClass.this.writeToSP(IstasyonLedAdiGetir(hedef)); 
 	       
 	       MainClass.this.SendRS232Data(IstasyonLedAdiGetir(hedef));    	                	   

 	                     // writeToSP("10MY010015"+hedef);
 	           
 	    
           // this.writeToSP("10MY010015"+this.trenBilgileri.getHedefIstasyon());
        } else if (!rota.equals(Rotalar.Kur)&&(rota.equals(Rotalar.SECILMEDI) || rota.equals(Rotalar.GECERS�Z))) {
        	/*System.out.println(this.mevcutIstasyonButonlari.length+" this.mevcutIstasyonButonlari.length");
	            for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
                this.mevcutIstasyonButonlari[i].setEnabled(false);
      	       System.out.println("sa�ma: ");  }*/
       	 MainClass.this.SendRS232Data("10MY010015 ");
         MainClass.this.SendRS232Data("20MY010015 "); 	                	   


          
	          
        }
        else{
 	        String hedef=this.trenBilgileri.getHedefIstasyon();

  	       MainClass.this.SendRS232Data(IstasyonLedAdiGetir(hedef));    	                	   

        }

        this.mevcutHedefIstasyon = this.trenBilgileri.getHedefIstasyon();
        this.mevcutRota = rota;
    }

    public void SetTrenBilgileriStyle(JLabel label, String text, int x, int y, int w, int h) {
        Color color = this.seciliTema.trenBilgileriForeground;
        //Font font = new Font(label.getFont().getFamily(), 1, 15);
        label.setFont(this.fontDefault);

        int horizontalAlignment = 0;
        int verticalAlignment = 0;
        label.setForeground(color);
        label.setHorizontalAlignment(horizontalAlignment);
        label.setVerticalAlignment(verticalAlignment);
        label.setText("<html><center>" + text + "</center></html>");
        label.setBounds(x, y, w, h);
    }

    public void SetTrenBilgileriStyle(JPanel panel, String text, int x, int y, int w, int h) {
        Color color = this.seciliTema.trenBilgileriBackground;
        panel.setLayout((LayoutManager)null);
        panel.setFont(this.fontLabel);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(text);
        titledBorder.setTitleFont(fontLabel);
        panel.setBorder(titledBorder);
        titledBorder.setTitleColor(this.seciliTema.titledBorderTextColor);
        panel.setBounds(x, y, w, h);
        panel.setBackground(color);

    }

    public String TextCenter(String text) {
        return "<html><center>" + text + "</center></html>";
    }

    public String SesSeviyesiGetir() {
        if (OSValidator.isWindows()) {
            return "???%";
        } else {
            String s = "";

            try {
               // String[] co = new String[]{"/bin/sh", "-c", "sudo amixer get PCM | egrep -o '[0-9]+%' "};
                String[] co = new String[]{"/bin/sh", "-c", "sudo amixer get 'Master' | egrep -o '[0-9]+%' "};

                Process p = Runtime.getRuntime().exec(co);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while((s = br.readLine()) != null) {
                    if (s != "") {
                        System.out.println("line:: " + s);
                        break;
                    }
                }

                p.waitFor();
                System.out.println("exit: " + p.exitValue());
                p.destroy();
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            return s;
        }
    }

    public JPanel DonusSeferiUyariPaneliGetir() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBackground(this.seciliTema.donusSeferiPanelBackground);
        BlinkLabel lblMesaj = new BlinkLabel("<html><center>D�N�� Y�N� ���N TABELA KUR</center></html>");
        lblMesaj.setBounds(50, 50, 600, 60);
        lblMesaj.setHorizontalAlignment(0);
        lblMesaj.setVerticalAlignment(0);
        lblMesaj.setForeground(this.seciliTema.donusSeferiUyariForeground);
        lblMesaj.setBackground(this.seciliTema.donusSeferiUyariBackground);
        //Font fontMevcut = lblMesaj.getFont().deriveFont(30.0F);
        lblMesaj.setFont(this.fontDefault);   
        JGradientButton btnTopkap� = new JGradientButton("MESCID-� SELAM", true, "MESCID-� SELAM", false, this.fontDefault, this.listenerDonusYonu);
        btnTopkap�.setPreferredSize(new Dimension(120, 100));
        btnTopkap�.setBounds(198, 150, 150, 100);
        JGradientButton btnMescid = new JGradientButton("TOPKAPI", true, "TOPKAPI", false, this.fontDefault, this.listenerDonusYonu);
        btnMescid.setPreferredSize(new Dimension(120, 100));
        btnMescid.setBounds(372, 150, 150, 100);
        btnMescid.setVisible(false);
      /*  btnDepo.setPreferredSize(new Dimension(120, 100));
        btnDepo.setBounds(372, 150, 150, 100);*/
        JGradientButton btnBos = new JGradientButton("BO�", true, " ", false, this.fontDefault, this.listenerDonusYonu);
        btnBos.setPreferredSize(new Dimension(120, 100));
        btnBos.setBounds(546, 150, 150, 100);
        JLabel lblNot = new JLabel();
        lblNot.setText("NOT: Sadece trenin bu ba�taki tabelas�n� ayarlar.");
        lblNot.setFont(this.fontDefault);
        lblNot.setBounds(100, 270, 500, 50);
        lblNot.setForeground(this.seciliTema.donusSeferiUyariAciklamaForeground);
        lblNot.setHorizontalAlignment(0);
        lblNot.setVerticalAlignment(1);
        panel.add(lblNot);
        panel.add(lblMesaj);

        panel.add(btnTopkap�);
        panel.add(btnMescid);
       // panel.add(btnDepo);
        panel.add(btnBos);
        return panel;
    }

    public JPanel TabelaPaneliniGetir() {
    	jsonOku = new JSONOku();
        jsonOku.main("/tabela");
    	TabelaLed=jsonOku.tabelaList;  
    	TabelaLedYazd�r_Sar�=jsonOku.LedYazdir_Sar�;  
    	TabelaLedYazd�r_Beyaz=jsonOku.LedYazdir_Beyaz; 
        JPanel tabelaKurPanel = new JPanel();
        tabelaKurPanel.setLayout(new FlowLayout(0, 5, 5));
        tabelaKurPanel.setBackground(this.seciliTema.tabelaPaneliBackground);
        tabelaKurPanel.setBounds(0, 0, 500, 500);
        //String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        //File istasyonlarFolder = new File(istasyonlarPath);
        //File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        //istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.tabelaSayisi != 0) {
            JButton[] jButtonsOzel = new JButton[jsonOku.LedYazdir_Sar�.size()];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
            	
            	try {
					String tabale=new String (jsonOku.tabelaList.get(i).getBytes("ISO-8859-1"), "UTF-8");
					 JGradientButton btnNewButton = new JGradientButton(jsonOku.tabelaList.get(i), true, jsonOku.tabelaList.get(i), false, this.fontDefault, this.listenerTabelaKur);
		                btnNewButton.setPreferredSize(new Dimension(122, 73));
		                tabelaKurPanel.add(btnNewButton);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
            }
        } else {
            System.out.println("Tabela bulunamad�" );
        }

        return tabelaKurPanel;
    }

    public JPanel OzelAnonlarPaneli1() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel1Background);
        String path = this.startDir + "/Anons/OZEL/ANONS1/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];
            for(int i = 0; i < jButtonsOzel.length; ++i) {

                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "").replace("_", " ");
//					name = new String((ozelAnonsDosyalari[i].getName().replace(".mp3", "").replace("_", " ")).getBytes("UTF-8"), "ISO-8859-1");
                
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JPanel OzelAnonlarPaneli2() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel2Background);
        String path = this.startDir + "/Anons/OZEL/ANONS2/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "").replace("_", " ");
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JPanel OzelAnonlarPaneli3() {
        JPanel ozelAnonsPanel = new JPanel();
        ozelAnonsPanel.setLayout(new FlowLayout(0, 5, 5));
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonsPanel3Background);
        String path = this.startDir + "/Anons/OZEL/ANONS3/";
        File folder = new File(path);
        File[] ozelAnonsDosyalari = folder.listFiles();
        Arrays.sort(ozelAnonsDosyalari, new Comparator<File>() {
            public int compare(File f1, File f2) {
                String aName = f1.getName();
                String bName = f2.getName();
                return aName.compareTo(bName);
            }
        });
        if (ozelAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[ozelAnonsDosyalari.length];

            for(int i = 0; i < jButtonsOzel.length; ++i) {
                String name = ozelAnonsDosyalari[i].getName().replace(".mp3", "").replace("_", " ");
                String anonsPath = ozelAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(175, 100));
                Font font = this.fontDefault;
                btnNewButton.setFont(font);
                ozelAnonsPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return ozelAnonsPanel;
    }

    public JTabbedPane OzelAnonlarPaneliniGetir() {
        JTabbedPane ozelAnonsPanel = new JTabbedPane();
        ozelAnonsPanel.setForeground(this.seciliTema.tabcolor);
        ozelAnonsPanel.setBackground(this.seciliTema.ozelAnonslarPanelBackground);
        ozelAnonsPanel.setFont(this.fontLabel);
        ozelAnonsPanel.setBounds(5, 5, 790, 590);
        JPanel ozelAnons1 = this.OzelAnonlarPaneli1();			
        JPanel ozelAnons2 = this.OzelAnonlarPaneli2();
        JPanel ozelAnons3 = this.OzelAnonlarPaneli3();
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 1<br><br></center></html>", (Icon)null, ozelAnons1, "Sayfa1");
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 2<br><br></center></html>", (Icon)null, ozelAnons2, "Sayfa2");
        ozelAnonsPanel.addTab("<html><center><br>SAYFA 3<br><br></center></html>", (Icon)null, ozelAnons3, "Sayfa3");
        return ozelAnonsPanel;	
    }

    public JPanel BaslangicAnonlariPaneliniGetir() {
        JPanel baslangicAnonslariPanel = new JPanel();
        baslangicAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        baslangicAnonslariPanel.setBackground(this.seciliTema.baslangicAnonslariPanelBackground);
        String path = this.startDir + "/Anons/BASLANGIC/";
        baslangicAnonslariPanel.setBounds(20, 20, 700, 500);
        File folder = new File(path);
        File[] baslangicAnonsDosyalari = folder.listFiles();
        if (baslangicAnonsDosyalari != null) {
            for(int i = 0; i < baslangicAnonsDosyalari.length; ++i) {
                String name = baslangicAnonsDosyalari[i].getName().replace(".mp3", "").replace("_", " ");;
                String anonsPath = baslangicAnonsDosyalari[i].getPath();
                JGradientButton btnNewButton = new JGradientButton(name, true, anonsPath, false, this.fontDefault, this.listenerOzelAnonslar);
                btnNewButton.setPreferredSize(new Dimension(150, 80));
                baslangicAnonslariPanel.add(btnNewButton);
            }
        } else {
            System.out.println(path + " not found!");
        }

        return baslangicAnonslariPanel;
    }
    public void restartApplication() throws URISyntaxException, IOException
    {
      final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
      //final String dd = MainClass.class.getProtectionDomain().getCodeSource().getLocation().toURI());
     // String current = new java.io.File( "." ).getCanonicalPath();
      final String currentJar =new java.io.File( "." ).getCanonicalPath()+"/MBS1.jar";


      /* is it a jar file? */
    /*  if(!currentJar.getName().endsWith(".jar")) {
          System.out.println("1"+currentJar);

          return;

      }*/

      /* Build command: java -jar application.jar */
      final ArrayList<String> command = new ArrayList<String>();
      command.add(javaBin);
      command.add("-jar");
      command.add(currentJar);
      System.out.println(command);
      final ProcessBuilder builder = new ProcessBuilder(command);
      builder.start();
      System.exit(0);
    }
   
   
    public JPanel TrenBilgileriPaneliGetir() {
        int line1Y = 20;
        int line2Y = 350;
        JPanel trenBilgileriPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)trenBilgileriPanel, "", 25, 5, 500, 500);
        JLabel label = new JLabel();
        ImageIcon iconUlasim = new ImageIcon(this.startDir + this.imageDir + "/istanbul_ulasim_mini.png");
        label.setIcon(iconUlasim);
        label.setBounds(330, 397, 180, 60);
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        trenBilgileriPanel.add(label);
        JPanel gelecekIstasyonPanel = new JPanel();
        
        this.SetTrenBilgileriStyle((JPanel)gelecekIstasyonPanel, "Gelecek �stasyon", 40, line2Y-48, 175, 100);
        this.lblGelecekIstasyon = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblGelecekIstasyon, "", 0, 0, 175, 100);
       this.lblGelecekIstasyon.setFont(fontLabel);

        gelecekIstasyonPanel.add(this.lblGelecekIstasyon);
        
        JPanel hedefIstasyonPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)hedefIstasyonPanel, "Hedef �stasyon", 220, line2Y-48, 175, 100);
        this.lblHedefIstasyon = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblHedefIstasyon, "", 0, 0, 175, 100);
       // this.lblHedefIstasyon.setFont(fontLabel);
        hedefIstasyonPanel.add(this.lblHedefIstasyon);
        
        JPanel kalanMesafePanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)kalanMesafePanel, "Kalan Mesafe (m)", 400, line2Y-48, 175, 100);
        this.lblKalanMesafe = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblKalanMesafe, "", 0, 0, 175, 100);
       // this.lblKalanMesafe.setFont(fontLabel);
        kalanMesafePanel.add(this.lblKalanMesafe);
        
        JPanel toplamMesafePanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)toplamMesafePanel, "Toplam Mesafe (m)", 580, line2Y-48, 175, 100);
        this.lblToplamMesafe = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblToplamMesafe, "", 0, 0, 175, 100);
      //  this.lblToplamMesafe.setFont(fontLabel);
        toplamMesafePanel.add(this.lblToplamMesafe);
        
        JPanel kapiPanel = new JPanel();

        this.SetTrenBilgileriStyle((JPanel)kapiPanel, "Kap� Durumu", 40, line1Y, 175, 100);
        this.lblKapiDurumu = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblKapiDurumu, "", 0, 0, 175, 100);
     //  this.lblKapiDurumu.setFont(fontLabel);
        kapiPanel.add(this.lblKapiDurumu);    
        
        JPanel aracDurumuPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)aracDurumuPanel, "Ara� Durumu", 220, line1Y, 175, 100);
        this.lblAracDurumu = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblAracDurumu, "", 0, 0, 175, 100);
       // this.lblAracDurumu.setFont(fontLabel);
        aracDurumuPanel.add(this.lblAracDurumu);
        
        JPanel sesSeviyesiPanel = new JPanel();
        MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();

        this.SetTrenBilgileriStyle((JPanel)sesSeviyesiPanel, "Ses Seviyesi Ayar�", 400, line1Y, 175, 100);
        this.lblVersion = new JLabel();
       // this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
        //sesSeviyesiPanel.add(this.lblVersion);

        JGradientButton sesAzaltButonu = new JGradientButton("<html><center> - </center></html>");
        sesAzaltButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesAzaltButonu.setBounds(10, 25, 55, 60);
        sesAzaltButonu.setActionCommand("-");
        sesAzaltButonu.setFocusable(false);
        sesAzaltButonu.addActionListener(this.sesAzalt);
        sesSeviyesiPanel.setFont(this.fontDefault);

        sesSeviyesiPanel.add(sesAzaltButonu);
        this.lblMevcutSesSeviyesi = new JLabel("", 0);
        this.lblMevcutSesSeviyesi.setHorizontalTextPosition(0);
        this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
        //Font f = new Font("ARIAL", 1, 14);
        this.lblMevcutSesSeviyesi.setFont(this.fontDefault);
        this.lblMevcutSesSeviyesi.setBounds(60, 25, 55, 60);
        this.lblMevcutSesSeviyesi.setForeground(this.seciliTema.sesSeviyesiForeground);
        lblMevcutSesSeviyesi.setFont(this.fontDefault);

        sesSeviyesiPanel.add(this.lblMevcutSesSeviyesi);
        JGradientButton sesArttirButonu = new JGradientButton("<html><center> + </center></html>");
        sesArttirButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesArttirButonu.setBounds(110, 25, 55, 60);
        sesArttirButonu.setActionCommand("+");
        sesArttirButonu.setFocusable(false);
        sesArttirButonu.addActionListener(this.sesArttir);
        sesArttirButonu.setFont(this.fontDefault);

        sesSeviyesiPanel.add(sesArttirButonu);
       /* JPanel versiyonPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)versiyonPanel, "Versiyon", 400, line1Y, 175, 100);
        this.lblVersion = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
        versiyonPanel.add(this.lblVersion);*/
        this.konumPanel = this.KonumPaneliGetir(40, line2Y - (line1Y + 195) - 5, 720, 160);
        this.konumPanel.setFont(fontLabel);
        this.uyariPanel = new JPanel();
        this.uyariPanel.setFont(fontLabel);

        this.SetTrenBilgileriStyle((JPanel)this.uyariPanel, "B�LG�LEND�RME PANOSU", 40, line2Y - (line1Y + 195) - 5, 720, 160);
        
        this.donusYonuSecPanel = this.DonusSeferiUyariPaneliGetir();
        this.SetTrenBilgileriStyle((JPanel)this.donusYonuSecPanel, "", 40, 150, 720, 310);
        this.donusYonuSecPanel.setVisible(false);
        this.btnAnonsKapat = new JButton("<html><center> ANONSU KAPAT </center></html>");
        this.btnAnonsKapat.setActionCommand("ANONSU KAPAT");
        this.btnAnonsKapat.setBounds(580, line1Y + 6, 175, 46);
        this.btnAnonsKapat.setBackground(this.seciliTema.anonsuKapatButonBackground);
        this.btnAnonsKapat.setForeground(this.seciliTema.anonsuKapatButonForeground);
        this.btnAnonsKapat.setFocusable(false);
        this.btnAnonsKapat.setEnabled(true);
        this.btnAnonsKapat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	System.out.println("Butona t�kland�.");
					MainClass.this.player.Stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
      
        this.btnTakometreByPass = new JButton("<html><center> Takometre ByPass  </center></html>");
        this.btnTakometreByPass.setActionCommand("Takometre ByPass");
        this.btnTakometreByPass.setBounds(580, line1Y + 52, 175, 46);
        this.btnTakometreByPass.setBackground(Color.red);
        this.btnTakometreByPass.setForeground(this.seciliTema.anonsuKapatButonForeground);
        this.btnTakometreByPass.setFocusable(false);

        this.btnTakometreByPass.addActionListener(new ActionListener() {
            private Object seciliTema;

			public void actionPerformed(ActionEvent e) {
            	if(MainClass.this.takometrePasifEt==false) {
            		 MainClass.this.btnTakometreByPass.setBackground(new Color(70, 0, 0));
                     MainClass.this.btnTakometreByPass.setForeground(new Color(255, 255, 255));
                    // MainClass.this.btnTakometreByPass.setEnabled(false);
                     MainClass.this.btnTakometreByPass.setText("Takometre ByPass Edildi");
                     MainClass.this.takometrePasifEt =true;
                     MainClass.this.trenBilgileri.takometrePasifEt(MainClass.this.takometrePasifEt);
                     System.out.println(MainClass.this.takometrePasifEt);
            		
            	}else {
            		
            		 MainClass.this.btnTakometreByPass.setBackground(Color.red);
                     MainClass.this.btnTakometreByPass.setForeground(jsonOku.textcolor);
                    // MainClass.this.btnTakometreByPass.setEnabled(false);
                     MainClass.this.btnTakometreByPass.setText("Takometre ByPass");
                     MainClass.this.takometrePasifEt =false;
                     MainClass.this.trenBilgileri.takometrePasifEt(MainClass.this.takometrePasifEt);
                     System.out.println(MainClass.this.takometrePasifEt);

            	}
            	
            	

            }
        });
        this.btnTakometre = new JButton("<html><center>T</center></html>");
        this.btnTakometre.setBounds(330, 300, 40, 22);
        this.btnTakometre.setFocusable(false);
        this.btnTakometre.setBackground(Color.gray);
        this.btnTakometre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.trenBilgileri.TakometreVerisiGuncelle();
            }
        });
        if (!OSValidator.isWindows()) {
            this.btnTakometre.setVisible(false);
        }
        else {
            this.btnTakometre.setVisible(true);

        }
        this.btnRole = new JButton("<html><center>R</center></html>");
        this.btnRole.setBounds(400, 400, 40, 22);
        this.btnRole.setFocusable(false);
        this.btnRole.setBackground(Color.gray);
        this.btnRole.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println(	"role butonu");
              //  MainClass.this.trenBilgileri.RoleGuncelle();
            }
        });
        if (!OSValidator.isWindows()) {
            this.btnRole.setVisible(false);
        }
        else {
            this.btnRole.setVisible(true);

        }

        JButton btnKapiAcKapa = new JButton("<html><center>K</center></html>");
        btnKapiAcKapa.setBounds(370, 370, 40, 22);
        btnKapiAcKapa.setBackground(Color.gray);
        btnKapiAcKapa.setFocusable(false);
        btnKapiAcKapa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainClass.this.trenBilgileri.getKapiDurumu()) {
                    MainClass.this.KapiDurumuDegistir(false);
                } else {
                    MainClass.this.KapiDurumuDegistir(true);
                }

            }
        });
        if (!OSValidator.isWindows()) {
            btnKapiAcKapa.setVisible(false);
        }else {
            btnKapiAcKapa.setVisible(true);

        }

        JButton btnCikis = new JButton("<html><center>�</center></html>");
        btnCikis.setBounds(410, 470, 40, 22);
        btnCikis.setBackground(Color.gray);
        btnCikis.setFocusable(false);
        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        if (!OSValidator.isWindows()) {
            btnCikis.setVisible(false);
        }

        btnCikis.setVisible(false);
        this.lblRotaSecimUyari = new BlinkLabel("<html><center>L�TFEN ROTA SE��N�Z</center></html>");
        this.lblRotaSecimUyari.setBounds(0, 0, 700, 160);
        this.lblRotaSecimUyari.setHorizontalAlignment(0);
        this.lblRotaSecimUyari.setVerticalAlignment(0);
        this.lblRotaSecimUyari.setForeground(this.seciliTema.rotaSecimiUyariForeground);
        this.lblRotaSecimUyari.setBackground(this.seciliTema.rotaKurulumuPanelBackground);
        //Font fontMevcut = this.lblRotaSecimUyari.getFont().deriveFont(25.0F);
        this.lblRotaSecimUyari.setFont(this.fontLabel);
        this.lblRotaSecimUyari.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainClass.this.tTabbedPane.setSelectedIndex(1);
            }
        });
        this.uyariPanel.add(this.lblRotaSecimUyari);
        if (OSValidator.isWindows()) {
            this.uyariPanel.setVisible(false);
        }

        trenBilgileriPanel.add(this.donusYonuSecPanel);
        trenBilgileriPanel.add(btnCikis);
        trenBilgileriPanel.add(this.btnTakometre);
        trenBilgileriPanel.add(this.btnRole);

        trenBilgileriPanel.add(btnKapiAcKapa);
        trenBilgileriPanel.add(this.uyariPanel);
        trenBilgileriPanel.add(this.uyariPanel);
        trenBilgileriPanel.add(this.konumPanel);
        trenBilgileriPanel.add(this.btnAnonsKapat);
        trenBilgileriPanel.add(this.btnTakometreByPass);

        trenBilgileriPanel.add(sesSeviyesiPanel);
        trenBilgileriPanel.add(aracDurumuPanel);
        trenBilgileriPanel.add(kapiPanel);
        trenBilgileriPanel.add(toplamMesafePanel);
        trenBilgileriPanel.add(kalanMesafePanel);
        trenBilgileriPanel.add(hedefIstasyonPanel);
        trenBilgileriPanel.add(gelecekIstasyonPanel);
        return trenBilgileriPanel;
    }

    public JTabbedPane RotaPaneliGetir() {
        this.tRotaPane = new JTabbedPane();

        this.tRotaPane.setBackground(this.seciliTema.rotaPaneliBackground);
        this.tTabbedPane.setBounds(5, 5, 790, 590);
        this.tRotaPane.setFont(this.fontLabel);
        JPanel rotaKurPanel = this.RotaKurulumuPaneliniGetir();
        this.tRotaPane.setForeground(this.seciliTema.tabcolor);

        this.tRotaPane.addTab("<html><center><br>ROTA KURULUMU<br><br></center></html>", (Icon)null, rotaKurPanel, "Rota Kurulumu");
        
        this.gelecekIstasyonPanel = this.DetayliRotaPaneliniGetir();
        this.tRotaPane.addTab("<html><center><br>ARA �STASYON ROTA KURULUMU<br><br></center></html>", (Icon)null, this.gelecekIstasyonPanel, "Detayli Rota");
        
       // JPanel mevcutIstasyonPanel = this.MevcutIstasyonPaneliGetir();
        //this.tRotaPane.addTab("<html><center><br>MEVCUT �STASYON SE�<br><br></center></html>", (Icon)null, mevcutIstasyonPanel, "Mevcut �stasyonu");
        JPanel tabelaPanel = this.TabelaPaneliniGetir();
        this.tRotaPane.addTab("<html><center><br>TABELA KUR<br><br></center></html>", (Icon)null, tabelaPanel, "Tabela Kur");
       return this.tRotaPane;

    }

    public JPanel IstasyonlarPaneliniGetir() {
        JPanel istasyonAnonslariPanel = new JPanel();
        istasyonAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        istasyonAnonslariPanel.setBackground(this.seciliTema.istasyonlarPanelBackground);
        String startDir = System.getProperty("user.dir");
        String istasyonlarPath = startDir + "/Anons/ISTASYON/";
        istasyonAnonslariPanel.setBounds(0, 0, 800, 500);
        File istasyonlarFolder = new File(istasyonlarPath);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        

        istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.T4_Istasyonlar_MescidiselamTopkap�.size() != 0) {
            JButton[] jButtonsOzel = new JButton[jsonOku.T4_Istasyonlar_MescidiselamTopkap�.size()];

            for(int i = 0; i < jButtonsOzel.length; ++i) {

                JGradientButton btnNewButton = new JGradientButton( jsonOku.T4_Istasyonlar_MescidiselamTopkap�.get(i));
             
               // if(istasyonlarFolder.exists()) {                	
               // }else {
                for(int j=0; j < istasyonAnonsDosyalari.length; ++j) {
                	
                	if(DosyadanIstasyonOkuma(istasyonAnonsDosyalari[j].getName()).contains(jsonOku.T4_Istasyonlar_MescidiselamTopkap�.get(i))==true)
                	{
                	//	btnNewButton.setName(istasyonAnonsDosyalari[j].toString());
                		//System.out.println(btnNewButton.getName());
                        btnNewButton.setActionCommand(istasyonAnonsDosyalari[j].getPath());
                	}
                	

                }

              //  }
                btnNewButton.setFocusable(false);
                btnNewButton.setPreferredSize(new Dimension(150, 80));
              //  Font font = btnNewButton.getFont().deriveFont(13.0F);
                btnNewButton.setFont(this.fontDefault);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       System.out.println("Path:" + e.getActionCommand());
                        MainClass.this.mainIstasyonPanel.remove(0);
                        MainClass.this.mainIstasyonPanel.repaint();
                        JPanel panel = MainClass.this.IstasyonAnonslariPaneliniGetir(e.getActionCommand() + "/", ((JGradientButton)e.getSource()).getText());
                        MainClass.this.mainIstasyonPanel.add(panel);
                        MainClass.this.mainIstasyonPanel.repaint();
                    }
                });
                istasyonAnonslariPanel.add(btnNewButton);

            }
        } else {
            System.out.println(istasyonlarPath + " not found!");
        }

        return istasyonAnonslariPanel;
    }
    private String DosyadanIstasyonOkuma(String istasyon) {
        if (istasyon.toUpperCase().equals("TOPKAPI")) {
            return istasyon;
        } else if (istasyon.toUpperCase().equals("FETIHKAPI")) {
            return "FET�HKAPI";
        } else if (istasyon.toUpperCase().equals("VATAN")) {
            return istasyon;
        } else if (istasyon.toUpperCase().equals("EDIRNEKAPI")) {
            return "ED�RNEKAPI";
        } else if (istasyon.toUpperCase().equals("SEHITLIK")) {
            return "�EH�TL�K";
        } else if (istasyon.toUpperCase().equals("DEMIRKAPI")) {
            return "DEM�RKAPI";
        } else if (istasyon.toUpperCase().equals("TOPCULAR")) {
            return istasyon;
        } else if (istasyon.toUpperCase().equals("RAMI")) {
            return "RAM�";
        } else if (istasyon.toUpperCase().equals("ULUYOL_BEREC")) {
            return "ULUYOL BEREC";
        } else if (istasyon.toUpperCase().equals("SAGMALCILAR")) {
            return "SA�MALCILAR";
        } else if (istasyon.toUpperCase().equals("BOSNA_CUKURCESME")) {
            return "BOSNA �UKUR�E�ME";
        } else if (istasyon.toUpperCase().equals("A.FUAT_BASGIL")) {
            return "A. FUAT BA�G�L";
        } else if (istasyon.toUpperCase().equals("TASKOPRU")) {
            return "TA�K�PR�";
        } else if (istasyon.toUpperCase().equals("KARADENIZ")) {
            return "KARADEN�Z";
        } else if (istasyon.toUpperCase().equals("KIPTAS_VENEZIA")) {
            return "K�PTA�-VENEZIA";
        } else if (istasyon.toUpperCase().equals("CUMHURIYET_MAHALLESI")) {
            return "CUMHUR�YET MAHALLES�";
        } else if (istasyon.toUpperCase().equals("50YIL_BASTABYA")) {
            return "50.YIL BA�TABYA";
        } else if (istasyon.toUpperCase().equals("HACISUKRU")) {
            return "HACI ��KR�";
        } else if (istasyon.toUpperCase().equals("YENIMAHALLE")) {
            return "YEN�MAHALLE";
        } else if (istasyon.toUpperCase().equals("SULTANCIFTLIGI")) {
            return "SULTAN C�FTL���";
        } else if (istasyon.toUpperCase().equals("CEBECI")) {
            return "CEBEC�";
        } else if (istasyon.toUpperCase().equals("MESCIDI_SELAM")) {
            return "MESCID-� SELAM";
        }  else {
            return "";
        }
    }
    private String IstasyondanDosyaOkuma(String istasyon) {
        if (istasyon.toUpperCase().equals("TOPKAPI")) {
            return istasyon;
        } else if (istasyon.toUpperCase().equals("FET�HKAPI")) {
            return"FETIHKAPI";
        } else if (istasyon.toUpperCase().equals("VATAN")) {
            return"VATAN";
        } else if (istasyon.toUpperCase().equals("ED�RNEKAPI")) {
            return"EDIRNEKAPI";
        } else if (istasyon.toUpperCase().equals("�EH�TL�K")) {
            return"SEHITLIK";
        } else if (istasyon.toUpperCase().equals("DEM�RKAPI")) {
            return"DEMIRKAPI";
        } else if (istasyon.toUpperCase().equals("TOPCULAR")) {
            return"TOPCULAR";
        } else if (istasyon.toUpperCase().equals("RAM�")) {
            return"RAMI";
        } else if (istasyon.toUpperCase().equals("ULUYOL BEREC")) {
            return "ULUYOL_BEREC";
        } else if (istasyon.toUpperCase().equals("SA�MALCILAR")) {
            return"SAGMALCILAR";
        } else if (istasyon.toUpperCase().equals("BOSNA �UKUR�E�ME")) {
            return "BOSNA_CUKURCESME";
        } else if (istasyon.toUpperCase().equals("A. FUAT BA�G�L")) {
            return "A.FUAT_BASGIL";
        } else if (istasyon.toUpperCase().equals("TA�K�PR�")) {
            return "TASKOPRU";
        } else if (istasyon.toUpperCase().equals("KARADEN�Z")) {
            return "KARADENIZ";
        } else if (istasyon.toUpperCase().equals("K�PTA�-VENEZIA")) {
            return "KIPTAS_VENEZIA";
        } else if (istasyon.toUpperCase().equals("CUMHUR�YET MAHALLES�")) {
            return "CUMHURIYET_MAHALLESI";
        } else if (istasyon.toUpperCase().equals("50.YIL BA�TABYA")) {
            return "50YIL_BASTABYA";
        } else if (istasyon.toUpperCase().equals("HACI ��KR�")) {
            return"HACISUKRU";
        } else if (istasyon.toUpperCase().equals("YEN�MAHALLE")) {
            return"YENIMAHALLE";
        } else if (istasyon.toUpperCase().equals("SULTAN C�FTL���")) {
            return"SULTANCIFTLIGI";
        } else if (istasyon.toUpperCase().equals("CEBEC�")) {
            return "CEBECI";
        } else if (istasyon.toUpperCase().equals("MESCID-� SELAM")) {
            return "MESCIDI_SELAM";
        }  else {
            return "";
        }
    }
    public JPanel IstasyonAnonslariPaneliniGetir(String path, String name) {
        JPanel anaPanel = new JPanel();
        anaPanel.setLayout((LayoutManager)null);
        anaPanel.setBackground(this.seciliTema.istasyonAnonslariPanelBackground);
        anaPanel.setBounds(0, 0, 800, 500);
        JLabel lblIstasyonAdi = new JLabel();
        lblIstasyonAdi.setText(name);
        //Font fontIsim = new Font("ARIAL", 1, 25);
        lblIstasyonAdi.setFont(this.fontDefault);
        lblIstasyonAdi.setBounds(0, 0, 800, 50);
        lblIstasyonAdi.setForeground(this.seciliTema.istasyonAnonslariIstasyonAdiForeground);
        lblIstasyonAdi.setHorizontalAlignment(0);
        lblIstasyonAdi.setVerticalAlignment(0);
        anaPanel.add(lblIstasyonAdi);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(0, 5, 5));
        panel.setBackground(this.seciliTema.istasyonAnonslariPanelBackground);
        panel.setBounds(0, 50, 800, 400);
        File istasyonlarFolder = new File(path);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        JGradientButton geriButonu = new JGradientButton("<html><center>GER�</center></html>");
        geriButonu.setFocusable(false);
        geriButonu.setActionCommand("GER�");
        geriButonu.setPreferredSize(new Dimension(140, 80));
        geriButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.mainIstasyonPanel.remove(0);
                MainClass.this.mainIstasyonPanel.repaint();
                JPanel panel = MainClass.this.IstasyonlarPaneliniGetir();
                MainClass.this.mainIstasyonPanel.add(panel);
                MainClass.this.mainIstasyonPanel.repaint();
            }
        });
        ImageIcon icon = new ImageIcon(this.startDir + this.imageDir + "/backward.png");
        geriButonu.setIcon(icon);
        panel.add(geriButonu);
        if (istasyonAnonsDosyalari != null) {
            JButton[] jButtonsOzel = new JButton[istasyonAnonsDosyalari.length];
            
            for(int i = 0; i < jButtonsOzel.length; ++i) {
                JGradientButton btnNewButton = new JGradientButton("<html><center>" + istasyonAnonsDosyalari[i].getName() + "</center></html>");
                btnNewButton.setActionCommand(istasyonAnonsDosyalari[i].getPath());
                String deneme =istasyonAnonsDosyalari[i].getName();
                btnNewButton.setPreferredSize(new Dimension(140, 80));
                btnNewButton.setFocusable(false);
                //Font font = btnNewButton.getFont().deriveFont(13.0F);
                btnNewButton.setFont(this.fontDefault);
                btnNewButton.addActionListener(new ActionListener() {
                	
                    public void actionPerformed(ActionEvent e) {

                        String path = e.getActionCommand();
                        MainClass.this.tTabbedPane.requestFocus();
                        MainClass.this.player.state=false;
                        //MainClass.this.writeToSP(TabelaIstasyoAdiGetir_Beyaz(name));
                            
                            	//MainClass.this.anonsYapma=true;
                       if(!MainClass.this.player.state){
                           MainClass.this.player.Play(path);  

                       }
                        MainClass.this.contentPane.requestFocus();
                        MainClass.this.tTabbedPane.setSelectedIndex(0);
                        MainClass.this.mainIstasyonPanel.remove(0);
                        MainClass.this.mainIstasyonPanel.repaint();
                        JPanel panel = MainClass.this.IstasyonlarPaneliniGetir();
                        MainClass.this.mainIstasyonPanel.add(panel);
                        MainClass.this.mainIstasyonPanel.repaint();
                    }
                });
                panel.add(btnNewButton);

            }
        } else {
            System.out.println("Path not found:" + path);
        }

        anaPanel.add(panel);
        return anaPanel;
    }

   
    
//BU KISIMDA OLACAK
   /* private JPanel MevcutIstasyonPaneliGetir() {
        JPanel mevcutIstasyonPanel = new JPanel();
        mevcutIstasyonPanel.setLayout(new FlowLayout(0, 5, 5));
        mevcutIstasyonPanel.setBackground(this.seciliTema.mevcutIstasyonPanelBackground);
        String startDir = System.getProperty("user.dir");
        String istasyonlarPath = startDir + "/Anons/ISTASYON/";
        mevcutIstasyonPanel.setBounds(0, 100, 800, 400);
        
        jsonOku = new JSONOku();
        jsonOku.main("/anonsName");
    	T4_Istasyonlar_MescidiselamTopkap�=jsonOku.T4_Istasyonlar_MescidiselamTopkap�;
    	T4_Istasyonlar_Topkap�Mescidiselam=jsonOku.T4_Istasyonlar_Topkap�Mescidiselam;

    	MescidiselamTopkapiledMesajYazd�r1=jsonOku.MescidiselamTopkapiledMesajYazd�r1;
    	MescidiselamTopkapiledMesajYazd�r2=jsonOku.MescidiselamTopkapiledMesajYazd�r2;
    	
    	TopkapiMescidiselamledMesajYazd�r1=jsonOku.TopkapiMescidiselamledMesajYazd�r1;
    	TopkapiMescidiselamledMesajYazd�r2=jsonOku.TopkapiMescidiselamledMesajYazd�r2;
       // jsonYaz=new JSONYaz();
       // jsonYaz.main("/param");

       //File istasyonlarFolder = new File(istasyonlarPath);
        //File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
       // istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        if (jsonOku.istasyonSayisi != 0) {
            this.mevcutIstasyonButonlari = new JButton[jsonOku.T4_Istasyonlar_MescidiselamTopkap�.size()];
            for(int i = 0; i < this.mevcutIstasyonButonlari.length; ++i) {
                this.mevcutIstasyonButonlari[i] = new JGradientButton("<html><center>" + jsonOku.T4_Istasyonlar_MescidiselamTopkap�.get(i) + "</center></html>");
                this.mevcutIstasyonButonlari[i].setEnabled(false);
                this.mevcutIstasyonButonlari[i].setActionCommand(jsonOku.T4_Istasyonlar_MescidiselamTopkap�.get(i));
                this.mevcutIstasyonButonlari[i].setFocusable(false);
                this.mevcutIstasyonButonlari[i].setPreferredSize(new Dimension(122, 73));
                //Font font = new Font("ARIAL", 1, 12);
                this.mevcutIstasyonButonlari[i].setFont(this.fontDefault);
                this.mevcutIstasyonButonlari[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        MainClass.this.trenBilgileri.setMevcutIstasyon(e.getActionCommand());
                        //MainClass.this.trenBilgileri.setSonrakiIstasyon(e.getActionCommand());

                        MainClass.this.tTabbedPane.setSelectedIndex(0);
                    }
                });
                mevcutIstasyonPanel.add(this.mevcutIstasyonButonlari[i]);
            }
        } else {
            System.out.println(istasyonlarPath + " not found!");
        }

        return mevcutIstasyonPanel;
    }    */
    
    private JPanel AyarlarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.ayarlarPaneliBackground);
        JGradientButton cikisButonu = new JGradientButton("<html><center> AYARLAR �IKI� </center></html>");
        cikisButonu.setBounds(390, 10, 180, 110);
        cikisButonu.setActionCommand("�IKI�");
        cikisButonu.setFocusable(false);
        cikisButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.passField.setText("");
                MainClass.this.ayarlarPanel.removeAll();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel = MainClass.this.ParolaPanel();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
            }
        });
        
        panel.add(cikisButonu);
     
        JLabel lblParlaklik = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)lblParlaklik, "Ekran Parlakl��� Ayarla", 600, 0, 180, 50);
        panel.add(lblParlaklik);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JSlider setting examples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = (int) rect.getMaxY() - frame.getHeight();;
        JPanel panelx = new JPanel();   
         JSlider slider = new JSlider(JSlider.VERTICAL,0,100,100);

         slider.setPreferredSize(new Dimension(50,340));
  
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
         
        slider.setPaintLabels(true);
        Hashtable position = new Hashtable<Integer, JLabel>();
        position.put(0, new JLabel("0"));
        position.put(10, new JLabel("10"));
        position.put(20, new JLabel("20"));
        position.put(30, new JLabel("30"));
        position.put(40, new JLabel("40"));
        position.put(50, new JLabel("50"));
        position.put(60, new JLabel("60"));
        position.put(70, new JLabel("70"));
        position.put(80, new JLabel("80"));
        position.put(90, new JLabel("90"));
        position.put(100, new JLabel("100"));
         
        slider.setLabelTable(position);

        slider.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int level = ((JSlider)e.getSource()).getValue();
                               
                /*try {
                	
                //	brightnessmanager.setBrightness(level);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
                
            }
        });
         
        panelx.add(slider);     
        
        // Set the window to be visible as the default to be false
        frame.add(panelx);
        frame.pack();
        
        Dimension d = panelx.getSize();
        slider.setLocation(670,50);
        frame.setVisible(false);
        panel.add(slider);
     
        JGradientButton programiKapatButonu = new JGradientButton("<html><center> PROGRAMI YEN�DEN BA�LAT </center></html>");
        programiKapatButonu.setColors(this.seciliTema.programiKapatButonColor1, this.seciliTema.programiKapatButonColor2);
        programiKapatButonu.setBounds(390, 150, 180, 110);


        programiKapatButonu.setActionCommand("Programi Yeniden Ba�lat");
        programiKapatButonu.setFocusable(false);
        programiKapatButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           	try {                 
				restartApplication();
				} catch (URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
                    System.out.println("catch");
					e1.printStackTrace();
				}      	
            }
        });
        panel.add(programiKapatButonu);
        
        JGradientButton kalibrasyonButonu = new JGradientButton("<html><center> EKRAN KAL�BRASYONU </center></html>");
        kalibrasyonButonu.setBounds(10, 10, 180, 110);
        kalibrasyonButonu.setActionCommand("KAL�BRASYON");
        kalibrasyonButonu.setFocusable(false);
        kalibrasyonButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder builder = new ProcessBuilder(new String[]{"xinput_calibrator"});
                    builder.redirectErrorStream(true);
                    Process process = builder.start();
                    InputStream is = process.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = null;
                    System.out.println("MBS Calibration Output:");

                    while((line = reader.readLine()) != null) {
                        if (line.contains("Option") && line.contains("Calibration")) {
                            String newStr = line.replace("Option", "");
                            newStr = newStr.replace("Calibration", "");
                            newStr = newStr.replace("\"", "");
                            newStr = newStr.trim();
                            System.out.println("New String: " + newStr);
                            String[] splitted = newStr.split(" ");
                            System.out.println("Length: " + splitted.length);
                            if (splitted.length == 4) {
                                System.out.println("min_x: " + splitted[0]);
                                System.out.println("max_x: " + splitted[1]);
                                System.out.println("min_y: " + splitted[2]);
                                System.out.println("max_y: " + splitted[3]);
                                MainClass.this.KalibrasyonuAyarla(splitted[0], splitted[1], splitted[2], splitted[3]);
                            }
                        }
                    }
                } catch (Exception var9) {
                    var9.printStackTrace();
                }

            }
        });
        panel.add(kalibrasyonButonu);
        JGradientButton kalibrasyonSifirlaButonu = new JGradientButton("<html><center> KAL�BRASYON RESET </center></html>");
        kalibrasyonSifirlaButonu.setBounds(200, 10, 180, 110);
        kalibrasyonSifirlaButonu.setActionCommand("KAL�BRASYON");
        kalibrasyonSifirlaButonu.setFocusable(false);
        kalibrasyonSifirlaButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!OSValidator.isWindows()) {
                        MainClass.this.KalibrasyonuSifirla();
                        String[] co = new String[]{"/bin/sh", "-c", "sudo reboot"};
                        Runtime.getRuntime().exec(co);
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
        panel.add(kalibrasyonSifirlaButonu);
        JGradientButton trenNumaraAyarButonu = new JGradientButton("<html><center> TREN NUMARASI AYARI </center></html>");
        trenNumaraAyarButonu.setBounds(10, 150, 180, 110);
        trenNumaraAyarButonu.setActionCommand("TREN NO AYAR");
        trenNumaraAyarButonu.setFocusable(false);
        trenNumaraAyarButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel = MainClass.this.TrenNoAyarPaneli();
                MainClass.this.ayarlarPanel.repaint();
                MainClass.this.ayarlarPanel.setBackground(MainClass.this.seciliTema.ayarlarPaneliBackground);
                MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
            }
        });
        panel.add(trenNumaraAyarButonu);
        JLabel lblTrenNumarasi = new JLabel();
        this.SetTrenBilgileriStyle((JLabel)lblTrenNumarasi, "Tren No:", 640, 440, 100, 50);
        panel.add(lblTrenNumarasi);
        this.trenNumarasiVal = new JLabel();
        String trenNo = this.TrenNoGetir();
        this.SetTrenBilgileriStyle((JLabel)this.trenNumarasiVal, trenNo, 710, 440, 60, 50);
        panel.add(this.trenNumarasiVal);
        //JPanel sesPanel = this.SesSeviyesiPaneli();
        //panel.add(sesPanel);
        JPanel versiyonPanel = this.VersiyonPanelPaneli();
        panel.add(versiyonPanel);
        
        JGradientButton anonsAr�zaButonu = new JGradientButton("<html><center> Ar�za Bildir  </center></html>");
        anonsAr�zaButonu.setColors(this.seciliTema.programiKapatButonColor1, this.seciliTema.arizaAnonsButonColor1);

        anonsAr�zaButonu.setBounds(200, 150, 180, 110);
        anonsAr�zaButonu.setActionCommand("Ar�za Anons");
        anonsAr�zaButonu.setFocusable(false);
        anonsAr�zaButonu.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {  
        	        ePostaYolla = new EPostaYolla();
        	        ePostaYolla.EPostaYolla();
      				
                  }
        });
        panel.add(anonsAr�zaButonu);
        return panel;
    }
    
    private JPanel VersiyonPanelPaneli() {
    	 JPanel versiyonPanel = new JPanel();
         this.SetTrenBilgileriStyle((JPanel)versiyonPanel, "Versiyon", 10, 340, 175, 100);
         this.lblVersion = new JLabel();
         this.SetTrenBilgileriStyle((JLabel)this.lblVersion, this.versiyon, 0, 0, 175, 100);
         versiyonPanel.add(this.lblVersion);
         return versiyonPanel;

    }

    private JPanel SesSeviyesiPaneli() {
        JPanel sesSeviyesiPanel = new JPanel();
        this.SetTrenBilgileriStyle((JPanel)sesSeviyesiPanel, "SES SEV�YES� AYARI", 280, 380, 220, 100);
        JGradientButton sesAzaltButonu = new JGradientButton("<html><center> - </center></html>");
        sesAzaltButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesAzaltButonu.setBounds(20, 30, 60, 60);
        sesAzaltButonu.setActionCommand("-");
        sesAzaltButonu.setFocusable(false);
        sesAzaltButonu.addActionListener(this.sesAzalt);
        sesAzaltButonu.setFont(fontDefault);
        sesSeviyesiPanel.add(sesAzaltButonu);
        
        this.lblMevcutSesSeviyesi = new JLabel("", 0);
        this.lblMevcutSesSeviyesi.setHorizontalTextPosition(0);
        this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
        Font f = new Font("ARIAL", 1, 14);
        this.lblMevcutSesSeviyesi.setFont(f);
        this.lblMevcutSesSeviyesi.setBounds(80, 30, 60, 60);
        this.lblMevcutSesSeviyesi.setForeground(this.seciliTema.sesSeviyesiForeground);
        sesSeviyesiPanel.add(this.lblMevcutSesSeviyesi);
        JGradientButton sesArttirButonu = new JGradientButton("<html><center> + </center></html>");
        sesArttirButonu.setColors(this.seciliTema.sesAyarButonColor1, this.seciliTema.sesAyarButonColor2);
        sesArttirButonu.setBounds(140, 30, 60, 60);
        sesArttirButonu.setActionCommand("+");
        sesArttirButonu.setFocusable(false);
        sesArttirButonu.addActionListener(this.sesArttir);
        sesSeviyesiPanel.add(sesArttirButonu);
        return sesSeviyesiPanel;
    }

    private JPanel ParolaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.ayarlarPaneliBackground);
        //Font font = new Font("ARIAL", 1, 16);
        //Font fontHata = new Font("ARIAL", 1, 25);
        this.lblParolaBilgi = new JLabel();
        this.lblParolaBilgi.setBounds(550, 180, 250, 50);
        this.lblParolaBilgi.setText("Parola Yanl��!");
        this.lblParolaBilgi.setVisible(false);
        this.lblParolaBilgi.setFont(this.fontDefault);
        panel.add(this.lblParolaBilgi);
        this.passField = new JPasswordField();
        this.passField.setBounds(250, 10, 240, 50);
        this.passField.setFont(this.fontDefault);
        panel.add(this.passField);
        JGradientButton[] btnNumpad = new JGradientButton[13];

        for(int i = 0; i < btnNumpad.length; ++i) {
            String text = "";
            if (i < 9) {
                text = String.valueOf(i + 1);
            } else if (i == 9) {
                text = "Sil";
            } else if (i == 10) {
                text = "0";
            } else if (i == 11) {
                text = "�ptal";
            } else if (i == 12) {
                text = "ONAY";
            }

            btnNumpad[i] = new JGradientButton("<html><center>" + text + "</center></html>");
            if (i == 12) {
                btnNumpad[i].setBounds(250, 395, 240, 80);
            } else {
                btnNumpad[i].setBounds(250 + i % 3 * 80, 70 + i / 3 * 80, 80, 80);
            }

            btnNumpad[i].setFocusable(false);
            btnNumpad[i].setFont(this.fontDefault);
            btnNumpad[i].setActionCommand(text);
            btnNumpad[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String passText = MainClass.this.passField.getText();
                    if (e.getActionCommand().equals("�ptal")) {
                        MainClass.this.passField.setText("");
                    } else if (e.getActionCommand().equals("Sil")) {
                        if (passText.length() > 0) {
                            MainClass.this.passField.setText(passText.substring(0, passText.length() - 1));
                        }
                    } else if (e.getActionCommand().equals("ONAY")) {
                        if (MainClass.this.passField.getText().equals("5357")) {
                            MainClass.this.sesSeviyesi = MainClass.this.SesSeviyesiGetir();
                            System.out.println("G�R�� ONAYLANDI");
                            MainClass.this.lblParolaBilgi.setVisible(false);
                            MainClass.this.ayarlarPanel.removeAll();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                            if (MainClass.this.lblMevcutSesSeviyesi != null) {
                                System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                                MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                            }
                        } else {
                            MainClass.this.lblParolaBilgi.setVisible(true);
                        }
                    } else {
                        MainClass.this.passField.setText(MainClass.this.passField.getText() + e.getActionCommand());
                    }

                }
            });
            panel.add(btnNumpad[i]);
        }

        return panel;
    }

    private JPanel TrenNoAyarPaneli() {
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        //Font font = new Font("ARIAL", 1, 16);
        JLabel lblTrenNoLabel = new JLabel();
        lblTrenNoLabel.setBounds(140, 10, 120, 50);
        lblTrenNoLabel.setText("TREN NUMARASI:");
        lblTrenNoLabel.setForeground(this.seciliTema.sesSeviyesiForeground);
        panel.add(lblTrenNoLabel);
        this.lblTrenNoInfoLabel = new JLabel();
        this.lblTrenNoInfoLabel.setBounds(500, 10, 250, 50);
        this.lblTrenNoInfoLabel.setText("Tren numaras� ge�ersiz!");
        this.lblTrenNoInfoLabel.setVisible(false);
        panel.add(this.lblTrenNoInfoLabel);
        this.trenNoField = new JTextField();
        this.trenNoField.setBounds(250, 10, 240, 50);
        this.trenNoField.setFont(this.fontDefault);
        panel.add(this.trenNoField);
        JGradientButton[] btnNumpad = new JGradientButton[14];

        for(int i = 0; i < btnNumpad.length; ++i) {
            String text = "";
            if (i < 9) {
                text = String.valueOf(i + 1);
            } else if (i == 9) {
                text = "Sil";
            } else if (i == 10) {
                text = "0";
            } else if (i == 11) {
                text = "�ptal";
            } else if (i == 12) {
                text = "ONAY";
            } else if (i == 13) {
                text = "�IKI�";
            }

            btnNumpad[i] = new JGradientButton("<html><center>" + text + "</center></html>");
            if (i == 12) {
                btnNumpad[i].setBounds(250, 395, 118, 80);
            } else if (i == 13) {
                btnNumpad[i].setBounds(372, 395, 118, 80);
            } else {
                btnNumpad[i].setBounds(250 + i % 3 * 80, 70 + i / 3 * 80, 80, 80);
            }

            btnNumpad[i].setFocusable(false);
            btnNumpad[i].setFont(this.fontDefault);
            btnNumpad[i].setActionCommand(text);
            btnNumpad[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String trenNoText = MainClass.this.trenNoField.getText();
                    if (e.getActionCommand().equals("�ptal")) {
                        MainClass.this.trenNoField.setText("");
                    } else if (e.getActionCommand().equals("Sil")) {
                        if (trenNoText.length() > 0) {
                            MainClass.this.trenNoField.setText(trenNoText.substring(0, trenNoText.length() - 1));
                        }
                    } else if (e.getActionCommand().equals("ONAY")) {
                        String strTrenNo = MainClass.this.trenNoField.getText();
                        int trenNo = -1;
                        if (strTrenNo != "") {
                            trenNo = Integer.parseInt(strTrenNo);
                        }

                        if (trenNo >= 499 && trenNo <= 575) {
                            String[] texts = MainClass.this.EthernetAyarMetniOlustur(trenNo);
                            MainClass.this.EthernetAyariYap(texts);
                            MainClass.this.TrenNoKaydet(String.valueOf(trenNo));
                            MainClass.this.lblTrenNoInfoLabel.setVisible(false);
                            MainClass.this.ayarlarPanel.removeAll();
                            MainClass.this.ayarlarPanel.repaint();
                            MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                            MainClass.this.ayarlarPanel.repaint();
                            if (MainClass.this.lblMevcutSesSeviyesi != null) {
                                System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                                MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                            }

                            MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                        } else {
                            MainClass.this.lblTrenNoInfoLabel.setVisible(true);
                        }
                    } else if (e.getActionCommand().equals("�IKI�")) {
                        MainClass.this.trenNoField.setText("");
                        MainClass.this.ayarlarPanel.removeAll();
                        MainClass.this.ayarlarPanel.repaint();
                        MainClass.this.ayarlarPanel = MainClass.this.AyarlarPanel();
                        MainClass.this.ayarlarPanel.repaint();
                        if (MainClass.this.lblMevcutSesSeviyesi != null) {
                            System.out.println("Ses seviyesi: " + MainClass.this.sesSeviyesi);
                            MainClass.this.lblMevcutSesSeviyesi.setText(MainClass.this.sesSeviyesi);
                        }

                        MainClass.this.tTabbedPane.setComponentAt(5, MainClass.this.ayarlarPanel);
                    } else if (trenNoText.length() < 3) {
                        MainClass.this.trenNoField.setText(MainClass.this.trenNoField.getText() + e.getActionCommand());
                    }

                }
            });
            panel.add(btnNumpad[i]);
        }

        return panel;
    }

    public JPanel KonumPaneliGetir(int x, int y, int w, int h) {
        JPanel kPanel = new JPanel();
        kPanel.setLayout((LayoutManager)null);
        kPanel.setBounds(x, y, w, h);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("KONUM");

        kPanel.setBorder(titledBorder);
        titledBorder.setTitleColor(this.seciliTema.titledBorderTextColor);
        titledBorder.setTitleFont(fontLabel);

        kPanel.setBackground(this.seciliTema.konumPanelBackground);
        String startDir = System.getProperty("user.dir");
        JLabel lblBaslangic = new JLabel();
        String picPath = startDir + this.imageDir + "/gpoint.png";
        lblBaslangic.setIcon(new ImageIcon(picPath));
        lblBaslangic.setBounds(25, 20, 50, 100);
        lblBaslangic.setHorizontalAlignment(4);
        lblBaslangic.setVerticalAlignment(1);
        this.lblBaslangicKonum = new JLabel();
        this.lblBaslangicKonum.setText("BASLANGIC");
        this.lblBaslangicKonum.setFont(this.fontLabel);
        this.lblBaslangicKonum.setBounds(5, 95, 100, 100);
        this.lblBaslangicKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblBaslangicKonum.setHorizontalAlignment(0);
        this.lblBaslangicKonum.setVerticalAlignment(1);
         lblMevcut = new JLabel();
        picPath = startDir + this.imageDir + "/opoint.png";
        lblMevcut.setIcon(new ImageIcon(picPath));
        lblMevcut.setBounds(220, 20, 50, 100);
        lblMevcut.setHorizontalAlignment(0);
        lblMevcut.setVerticalAlignment(1);
        this.lblMevcutKonum = new JLabel();
        this.lblMevcutKonum.setText("MEVCUT");
        this.lblMevcutKonum.setFont(this.fontLabel);
        this.lblMevcutKonum.setBounds(195, 95, 100, 100);
        this.lblMevcutKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblMevcutKonum.setHorizontalAlignment(0);
        this.lblMevcutKonum.setVerticalAlignment(1);
         lblGelecek = new JLabel();
        picPath = startDir + this.imageDir + "/ppoint.png";
        lblGelecek.setIcon(new ImageIcon(picPath));
        lblGelecek.setBounds(430, 20, 50, 100);
        lblGelecek.setHorizontalAlignment(0);
        lblGelecek.setVerticalAlignment(1);
        this.lblGelecekKonum = new JLabel();
        this.lblGelecekKonum.setText("GELECEK");
        this.lblGelecekKonum.setFont(this.fontLabel);
        this.lblGelecekKonum.setBounds(410, 95, 100, 100);
        this.lblGelecekKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblGelecekKonum.setHorizontalAlignment(0);
        this.lblGelecekKonum.setVerticalAlignment(1);
        JLabel lblHedef = new JLabel();
        picPath = startDir + this.imageDir + "/ppoint.png";
        lblHedef.setIcon(new ImageIcon(picPath));
        lblHedef.setBounds(630, 20, 50, 100);
        lblHedef.setHorizontalAlignment(4);
        lblHedef.setVerticalAlignment(1);
        this.lblHedefKonum = new JLabel();
        this.lblHedefKonum.setText("HEDEF");
        this.lblHedefKonum.setFont(this.fontLabel);
        this.lblHedefKonum.setBounds(605, 95, 100, 100);
        this.lblHedefKonum.setForeground(this.seciliTema.konumPanelForeground);
        this.lblHedefKonum.setHorizontalAlignment(0);
        this.lblHedefKonum.setVerticalAlignment(1);
        JLabel lblLine = new JLabel();
        picPath = startDir + this.imageDir + "/line1.png";
        lblLine.setIcon(new ImageIcon(picPath));
        lblLine.setBounds(40, 68, 620, 50);
        lblLine.setHorizontalAlignment(0);
        lblLine.setVerticalAlignment(0);
        kPanel.add(lblBaslangic);
        kPanel.add(this.lblBaslangicKonum);
        kPanel.add(lblMevcut);
        kPanel.add(this.lblMevcutKonum);
        kPanel.add(lblGelecek);
        kPanel.add(this.lblGelecekKonum);
        kPanel.add(lblHedef);
        kPanel.add(this.lblHedefKonum);
        kPanel.add(lblLine);
        return kPanel;
    }

    private JPanel RotaKurulumuPaneliniGetir() {
        int startX = 0;
        int startY = 35;
        JPanel panel = new JPanel();
        panel.setLayout((LayoutManager)null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(this.seciliTema.rotaKurulumuPanelBackground);
        //Font font = new Font("ARIAL", 1, 13);
        //Font fontLabel = new Font("ARIAL", 1, 12);
        String duzCizgiKonum = this.startDir + this.imageDir + "/duzCizgi.png";
        this.btnMescid = new JGradientButton("<html><center>MESCID-� SELAM</center></html>");
        this.btnMescid.setBounds(startX + 30, startY + 130, 130, 70);
        this.btnMescid.setActionCommand("MESCID-� SELAM");
        this.btnMescid.setFocusable(false);
        this.btnMescid.setPreferredSize(new Dimension(150, 80));
        this.btnMescid.setFont(this.fontLabel);
        this.btnMescid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.rotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaBaslangic.setText(e.getActionCommand());
                    MainClass.this.lblRotaBaslangic.setFont(fontLabel);

                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("HEDEF �STASYONU SE��N�Z");
                    MainClass.this.lblRotaUyari.setFont(fontLabel);

                } else if (MainClass.this.rotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaHedef.setText(e.getActionCommand());
                    MainClass.this.lblRotaHedef.setFont(fontLabel);

                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("");
                    MainClass.this.btnOnay.setEnabled(true);
                }

            }
        });
        panel.add(this.btnMescid);
      
        this.btnTopkap� = new JGradientButton("<html><center> TOPKAPI </center></html>");
        this.btnTopkap�.setBounds(startX + 600, startY + 130, 130, 70);
        this.btnTopkap�.setActionCommand("TOPKAPI");
        this.btnTopkap�.setFocusable(false);
        this.btnTopkap�.setPreferredSize(new Dimension(150, 80));
        this.btnTopkap�.setFont(this.fontLabel);
        this.btnTopkap�.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton srcButton = (JButton)e.getSource();
                MainClass var10000;
                if (MainClass.this.rotaSecilenIstasyon == 0) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaBaslangic.setText(e.getActionCommand());
                    MainClass.this.lblRotaBaslangic.setFont(fontLabel);

                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("HEDEF �STASYONU SE��N�Z");
                    MainClass.this.lblRotaUyari.setFont(fontLabel);

                } else if (MainClass.this.rotaSecilenIstasyon == 1) {
                    srcButton.setEnabled(false);
                    MainClass.this.lblRotaHedef.setText(e.getActionCommand());
                    MainClass.this.lblRotaHedef.setFont(fontLabel);

                    var10000 = MainClass.this;
                    var10000.rotaSecilenIstasyon = var10000.rotaSecilenIstasyon + 1;
                    MainClass.this.lblRotaUyari.setText("");
                    MainClass.this.btnOnay.setEnabled(true);
                }

            }
        });
        panel.add(this.btnTopkap�);
      
        JGradientButton btnMevcutRotaIptal = new JGradientButton("<html><center> MEVCUT ROTAYI S�L </center></html>");
        btnMevcutRotaIptal.setColors(this.seciliTema.mevcutRotaIptalButtonColor1, this.seciliTema.mevcutRotaIptalButtonColor2);
        btnMevcutRotaIptal.setBounds(startX + 30, startY + 260, 180, 70);
        btnMevcutRotaIptal.setActionCommand("MEVCUT ROTAYI S�L");
        btnMevcutRotaIptal.setFocusable(false);
        btnMevcutRotaIptal.setPreferredSize(new Dimension(150, 80));
        btnMevcutRotaIptal.setFont(this.fontLabel);
        btnMevcutRotaIptal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
            
                MainClass.this.trenBilgileri.setRotaBilgileri("", "", "", MainClass.this.takometrePasifEt);
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                MainClass.this.contentPane.requestFocus();
               // MainClass.this.SendRS232Data("10MY010015 ");
                //MainClass.this.SendRS232Data("20MY010015 asas");

            }
        });
        panel.add(btnMevcutRotaIptal);
        JLabel lblDuzCizgi1 = new JLabel();
        lblDuzCizgi1.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi1.setBounds(startX + 100, startY + 120 + 40, 220, 10);
        lblDuzCizgi1.setHorizontalAlignment(0);
        lblDuzCizgi1.setVerticalAlignment(1);
        panel.add(lblDuzCizgi1);
        JLabel lblDuzCizgi2 = new JLabel();
        lblDuzCizgi2.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi2.setBounds(startX + 250, startY + 120 + 40, 220, 10);
        lblDuzCizgi2.setHorizontalAlignment(0);
        lblDuzCizgi2.setVerticalAlignment(1);
        panel.add(lblDuzCizgi2);
        JLabel lblDuzCizgi3 = new JLabel();
        lblDuzCizgi3.setIcon(new ImageIcon(duzCizgiKonum));
        lblDuzCizgi3.setBounds(startX + 380, startY + 120 + 40, 220, 10);
        lblDuzCizgi3.setHorizontalAlignment(0);
        lblDuzCizgi3.setVerticalAlignment(1);
        panel.add(lblDuzCizgi3);
        JPanel rotaBilgiPanel = new JPanel();
        rotaBilgiPanel.setLayout((LayoutManager)null);
        rotaBilgiPanel.setBorder(BorderFactory.createTitledBorder(""));
        rotaBilgiPanel.setBackground(this.seciliTema.rotaBilgiPaneliBackground);
        rotaBilgiPanel.setBounds(35, 10, 700, 75);
        panel.add(rotaBilgiPanel);
        this.lblRotaUyari = new BlinkLabel("BA�LANGI� �STASYONU SE��N�Z");
        this.lblRotaUyari.setFont(this.fontLabel);
        this.lblRotaUyari.setFont(this.lblRotaUyari.getFont().deriveFont(16).deriveFont(1));
        this.lblRotaUyari.setBounds(5, 135, 275, 20);
        this.lblRotaUyari.setHorizontalAlignment(0);
        JLabel lblBaslangic = new JLabel();
        lblBaslangic.setText("Ba�lang�� �stasyonu:");
        lblBaslangic.setFont(fontLabel);
        lblBaslangic.setBounds(10, 2, 200, 40);
        lblBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(lblBaslangic);
        
        this.lblRotaBaslangic = new JLabel();
        this.lblRotaBaslangic.setText("-");
        this.lblRotaBaslangic.setBounds(200, 2, 200, 40);
        this.lblRotaBaslangic.setHorizontalAlignment(2);
        this.lblRotaBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(this.lblRotaBaslangic);
   
        JLabel lblHedef = new JLabel();
        lblHedef.setText("Hedef �stasyonu:");
        lblHedef.setFont(fontLabel);
        lblHedef.setBounds(10, 30, 200, 40);
        lblHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(lblHedef);
        
        this.lblRotaHedef = new JLabel();
        this.lblRotaHedef.setText("-");
        this.lblRotaHedef.setBounds(200, 30, 200, 40);
        this.lblRotaHedef.setHorizontalAlignment(2);
        this.lblRotaHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        rotaBilgiPanel.add(this.lblRotaHedef);
        this.btnOnay = new JGradientButton("<html><center> ONAY </center></html>");
        this.btnOnay.setBounds(450, 10, 115, 50);
        this.btnOnay.setFont(fontLabel);

        this.btnOnay.setActionCommand("ONAY");
        this.btnOnay.setFocusable(false);
        this.btnOnay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.trenBilgileri.setRotaBilgileri(MainClass.this.lblRotaBaslangic.getText(), MainClass.this.lblRotaBaslangic.getText(), MainClass.this.lblRotaHedef.getText(),MainClass.this.takometrePasifEt);
                MainClass.this.lblRotaBaslangic.setText("-");
                MainClass.this.lblRotaBaslangic.setFont(fontLabel);
                MainClass.this.lblRotaHedef.setText("-");
                MainClass.this.lblRotaHedef.setFont(fontLabel);

                MainClass.this.rotaSecilenIstasyon = 0;
                MainClass.this.btnMescid.setEnabled(true);
                MainClass.this.btnTopkap�.setEnabled(true);
                MainClass.this.btnOnay.setEnabled(false);
                MainClass.this.lblRotaUyari.setText("BA�LANGI� �STASYONU SE��N�Z");
                MainClass.this.tTabbedPane.setSelectedIndex(0);
                if (!MainClass.this.mevcutRota.equals(Rotalar.GECERS�Z)) {
                    MainClass.this.mevcutRota.equals(Rotalar.SECILMEDI);
                }

                MainClass.this.BaslangicAnonsuYap(MainClass.this.trenBilgileri.getHedefIstasyon(), MainClass.this.trenBilgileri.getMevcutIstasyon());
             //   MainClass.this.MevcutIstasyonButonKontrol();
            }
        });
        ImageIcon iconOnay = new ImageIcon(this.startDir + this.imageDir + "/onay.png");
        this.btnOnay.setIcon(iconOnay);
        this.btnOnay.setEnabled(false);
        rotaBilgiPanel.add(this.btnOnay);
        this.btnIptal = new JGradientButton("<html><center> �PTAL </center></html>");
        this.btnIptal.setBounds(570, 10, 115, 50);
        this.btnIptal.setActionCommand("�PTAL");
        this.btnIptal.setFont(fontLabel);

        this.btnIptal.setFocusable(false);
        this.btnIptal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainClass.this.lblRotaBaslangic.setText("-");
                MainClass.this.lblRotaHedef.setText("-");
                MainClass.this.rotaSecilenIstasyon = 0;
                MainClass.this.btnMescid.setEnabled(true);
                MainClass.this.btnTopkap�.setEnabled(true);
                MainClass.this.btnOnay.setEnabled(false);
                MainClass.this.lblRotaUyari.setText("BA�LANGI� �STASYONU SE��N�Z");
            }
        });
        ImageIcon iconIptal = new ImageIcon(this.startDir + this.imageDir + "/iptal.png");
        this.btnIptal.setIcon(iconIptal);
        rotaBilgiPanel.add(this.btnIptal);
        return panel;
    }

    public JPanel DetayliRotaPaneliniGetir() {
        JPanel istasyonAnonslariAnaPanel = new JPanel();
        istasyonAnonslariAnaPanel.setLayout((LayoutManager)null);
        istasyonAnonslariAnaPanel.setBackground(this.seciliTema.detayliRotaAnaPanelBackground);
        istasyonAnonslariAnaPanel.setBounds(0, 0, 800, 500);
        this.istasyonAnonslariPanel = new JPanel();
        this.istasyonAnonslariPanel.setLayout(new FlowLayout(0, 5, 5));
        this.istasyonAnonslariPanel.setBackground(this.seciliTema.detayliRotaIstasyonPanelBackground);
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";


        this.istasyonAnonslariPanel.setBounds(0, 75	, 800, 400);
        File istasyonlarFolder = new File(istasyonlarPath);
        File[] istasyonAnonsDosyalari = istasyonlarFolder.listFiles();
        istasyonAnonsDosyalari = this.Sirala(istasyonAnonsDosyalari);
        //jsonOku = new JSONOku();
        //jsonOku.main("/anonsName");
    if (jsonOku.T4_Istasyonlar_Topkap�Mescidiselam.size() != 0) {
    	JButton[] jButtonsOzel = new JButton[jsonOku.T4_Istasyonlar_Topkap�Mescidiselam.size()];

    for(int i = 0; i < jButtonsOzel.length; ++i) {

       // JGradientButton btnNewButton = new JGradientButton("<html><center>" + jsonOku.T4_Istasyonlar_MescidiselamTopkap�.get(i)+ "</center></html>");
        JGradientButton btnNewButton = new JGradientButton(jsonOku.T4_Istasyonlar_Topkap�Mescidiselam.get(i), true, jsonOku.T4_Istasyonlar_Topkap�Mescidiselam.get(i), false, this.fontDefault, this.listenerDetayliRota);
        btnNewButton.setPreferredSize(new Dimension(122, 73));
        this.istasyonAnonslariPanel.add(btnNewButton);
  

    }
}			
        JPanel rotaBilgiPanel = new JPanel();
        rotaBilgiPanel.setLayout((LayoutManager)null);
        rotaBilgiPanel.setBorder(BorderFactory.createTitledBorder(""));
        rotaBilgiPanel.setBackground(this.seciliTema.rotaBilgiPaneliBackground);
        rotaBilgiPanel.setBounds(35, 2, 700, 75);
        istasyonAnonslariAnaPanel.add(rotaBilgiPanel);
        JLabel lblBaslangic = new JLabel();
        lblBaslangic.setText("Mevcut �stasyonu:");
        lblBaslangic.setFont(fontLabel);
        lblBaslangic.setBounds(10, 2, 200, 40);
        lblBaslangic.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.lblDetayliRotaMevcutIstasyon = new JLabel();
        this.lblDetayliRotaMevcutIstasyon.setText("-");
        this.lblDetayliRotaMevcutIstasyon.setFont(fontLabel);

        this.lblDetayliRotaMevcutIstasyon.setBounds(200	, 2, 200, 40);
        this.lblDetayliRotaMevcutIstasyon.setHorizontalAlignment(2);
        this.lblDetayliRotaMevcutIstasyon.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        JLabel lblHedef = new JLabel();
        lblHedef.setText("Hedef �stasyonu:");
        lblHedef.setFont(fontLabel);
        lblHedef.setBounds(10, 30, 200, 40);
        
        lblHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.lblDetayliRotaHedef = new JLabel();
        this.lblDetayliRotaHedef.setText("-");
        this.lblDetayliRotaHedef.setFont(fontLabel);
        this.lblDetayliRotaHedef.setBounds(200, 30, 200, 40);
        this.lblDetayliRotaHedef.setHorizontalAlignment(2);
        this.lblDetayliRotaHedef.setForeground(this.seciliTema.rotaBilgiPaneliForegound);
        this.btnDetayliRotaOnay = new JGradientButton("ONAY", true, "ONAY", false, this.fontLabel, this.listenerDetayliRotaOnay, this.iconOnay, 450, 10, 115, 50);
        this.btnDetayliRotaOnay.setEnabled(false);
        this.btnDetayliRotaIptal = new JGradientButton("�PTAL", true, "�PTAL", false, this.fontLabel, this.listenerDetayliRotaIptal, this.iconIptal, 570, 10, 115, 50);
        rotaBilgiPanel.add(lblBaslangic);
        rotaBilgiPanel.add(this.lblDetayliRotaMevcutIstasyon);
        rotaBilgiPanel.add(lblHedef);
        rotaBilgiPanel.add(this.lblDetayliRotaHedef);
        rotaBilgiPanel.add(this.btnDetayliRotaOnay);
        rotaBilgiPanel.add(this.btnDetayliRotaIptal);
        istasyonAnonslariAnaPanel.add(this.istasyonAnonslariPanel);
        return istasyonAnonslariAnaPanel;
    }

    public void InitializeIO() {
        //this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
        //this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
   	 //  GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
      // this.gpio = GpioFactory.getInstance();
       GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
  	  //  this.gpio = GpioFactory.getInstance();
      //  this.amplifikator = this.gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_26, PinState.LOW);
       // this.amplifikator=this.gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_26, PinState.LOW);
  	 // this.amplifikator = gpio.provisionDigitalOutputPin (RaspiBcmPin.GPIO_19, PinState.LOW);

        //this.amplifikator = this.gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
//GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "name", PinState.LOW);

      //  this.anonsBaslatma = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, PinPullResistance.PULL_UP);
       this.gpio = GpioFactory.getInstance();
    	  // this.kapiButonu = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_UP);
        // this.takometre = this.gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_UP);
    	  /* this.�nput3 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_16, PinPullResistance.PULL_UP);
    	   this.�nput4 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_12, PinPullResistance.PULL_UP);
    	   this.�nput5 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_07, PinPullResistance.PULL_UP);
    	   this.�nput6 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_08, PinPullResistance.PULL_UP);
    	   this.�nput7 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_25, PinPullResistance.PULL_UP);
    	   this.�nput8 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_24, PinPullResistance.PULL_UP);
    	   this.�nput1 = this.gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_13, PinPullResistance.PULL_UP);*/

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

       // this.writeToSP(" ");
        /*this.kapiButonu.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> KAPI BUTONU: " + event.getPin() + " = " + event.getState());
                if (event.getState() == PinState.HIGH) {
                    MainClass.this.KapiDurumuDegistir(false);
                } else {
                    MainClass.this.KapiDurumuDegistir(true);
                }

            }
        }});*/
       /* this.takometre.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                System.out.println(" --> TAKOMETRE: " + event.getPin() + " = " + event.getState());
                if (event.getState() == PinState.HIGH) {
                    MainClass.this.TakometreArtt�r();
                }

            }
        }});*/
      /*  this.anonsBaslatma.addListener(new GpioPinListener[]{new GpioPinListenerDigital() {
           public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if (event.getState() == PinState.HIGH) {
                   System.out.println(" --> Anons Ba�latma: " + event.getPin() + " = " + event.getState());

                	MainClass.this.anonsYapma=true;
                    MainClass.this.player.Stop();
                }
            }
        }});*/
  
        if (this.serial != null && this.serial.isClosed()) {
            try {
				this.serial.open("/dev/ttyS0", 4800);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }

    /*public void writeToSP(String data) {
    	
        try {
            if (this.serial != null &&   this.serial.isClosed()) {
                this.serial.open("/dev/ttyAMA0", 4800);
            }

            if (this.serial != null && this.serial.isOpen()) {
                data = data.toUpperCase();

                try {
                    this.serial.flush();
                    String kisaString = this.IstasyonLedAdiGetir(data);
                    byte[] iso = kisaString.getBytes("ISO-8859-9");
                    byte[] ledFormat = this.ConvertToLedFormat(iso);
                    this.serial.write(ledFormat);
                    System.out.println(kisaString + " g�nderildi. Data length: " + iso.length);
                } catch (UnsupportedEncodingException var5) {
                    var5.printStackTrace();
                }	
            } else {
                System.out.println("Seri port kapal�! Data: " + data);
            }
        } catch (IllegalStateException var6) {
            var6.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    } */
    public void writeToSP(byte[] newDatas) {
    
	        try {
	            if (this.serial != null && this.serial.isClosed()) {
	                this.serial.open("/dev/ttyS0", 4800);
	            }

	            if (this.serial != null && this.serial.isOpen()) {

	                try {
						serial.write(newDatas, 0, newDatas.length);
	                } catch (UnsupportedEncodingException var5) {
	                    var5.printStackTrace();
	                } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	            } else {
	            		            	 
	                System.out.println("Seri port kapal�! Data: "+ newDatas );
	            }
	        } catch (IllegalStateException var6) {
	            var6.printStackTrace();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	public void  SendRS232Data(String data)
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
            MainClass.this.writeToSP(newDatas);

        }
        catch (Exception e)
        {
        }
    }


    private void KapiDurumuDegistir(final boolean durum) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainClass.this.trenBilgileri.KapiDurumuGuncelle(durum);
            }
        });
    }

    private void BaslangicAnonsuYap(String hedefIstasyon, String mevcutIstasyon) {
        String path = this.startDir + "/Anons/BASLANGIC/";
        String anonsAdi = "";
        System.out.println("mevcutIstasyon"+ mevcutIstasyon);
       // MainClass.this.SendRS232Data(TabelaIstasyoAdiGetir_Beyaz(mevcutIstasyon));

		if (mevcutIstasyon.equals("TOPKAPI")) {
			if (hedefIstasyon.equals("MESCID-� SELAM")) {
				anonsAdi = "TOPKAPI_MESCIDI_SELAM.mp3";
			}
			else if (hedefIstasyon.equals("50.YIL BASTABYA")) {
				anonsAdi = "TOPKAPI_50.YIL.mp3";
			} 
			else if (hedefIstasyon.equals("SULTANCIFTLIGI")) {
				anonsAdi = "TOPKAPI_HABIBLER.mp3";//EKLENMEL�
			}
			else if (hedefIstasyon.equals("SEHITLIK")) {
				anonsAdi = "TOPKAPI_HABIBLER.mp3";//EKLENMEL�
			}	
        } else if (mevcutIstasyon.equals("MESCID-� SELAM")) {
            if (hedefIstasyon.equals("TOPKAPI")) { 
                anonsAdi = "MESCIDI_SELAM_TOPKAPI.mp3";  
            } else  if (hedefIstasyon.equals("SEHITLIK")) { 
                anonsAdi = "MESCIDI_SELAM_TOPKAPI.mp3";  
            }    
        }
        else if (mevcutIstasyon.equals("50.YIL BASTABYA")) {
            if (hedefIstasyon.equals("EDIRNEKAPI")) { 
                anonsAdi = "50.YIL_EDIRNEKAPI.mp3"; 
            }   
            else if (hedefIstasyon.equals("SEHITLIK")) { 
                anonsAdi = "50.YIL_SEHITLIK.mp3";  
            }
            else if (hedefIstasyon.equals("TOPKAPI")) { 
                anonsAdi = "50.YIL_TOPKAPI.mp3";  
            }
        }
        if (!anonsAdi.equals("")) {
               	//MainClass.this.anonsYapma=true;
               	if(!MainClass.this.player.state)
               	{
                    MainClass.this.player.Play(path+ anonsAdi );  

                }else {
                	System.out.println("�st �ste anons yap�lamaz");
                }
                this.contentPane.requestFocus();

        }

    }

    private void YaklasimAnonsuYap(String baslangicIstasyonu, String gelecekIstasyon, String hedefIstasyon) {
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        System.out.println("YaklasimAnonsuYap"+ gelecekIstasyon );
        String path = istasyonlarPath + gelecekIstasyon + "/";
        String anonsAdi = "YAKLASIM.mp3";
        File f;
        if (hedefIstasyon.equals("TOPKAPI")) 
        {
            if (gelecekIstasyon.equals("VATAN")) 
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "AKTARMA.mp3";
                }
            } 
            else if(gelecekIstasyon.equals("SEHITLIK"))
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) 
                {
                    anonsAdi = "AKTARMA.mp3";
                }
            }
            else if(gelecekIstasyon.equals("K�PTA�-VEN."))
            {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                if (f.exists() && !f.isDirectory()) 
                {
                    anonsAdi = "AKTARMA.mp3";
                }
            }
        } 
        else if (hedefIstasyon.equals("MESCID-� SELAM")) 
        {
        	 if (gelecekIstasyon.equals("VATAN")) 
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) {
                     anonsAdi = "AKTARMA.mp3";
                 }
             } 
             else if(gelecekIstasyon.equals("SEHITLIK"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "AKTARMA.mp3";
                 }
             }
             else if(gelecekIstasyon.equals("K�PTA�-VEN"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "AKTARMA.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "AKTARMA.mp3";
                 }
             }
             else if(gelecekIstasyon.equals("MESCID-� SELAM"))
             {
                 f = new File(istasyonlarPath + gelecekIstasyon + "/" + "SON.mp3");
                 if (f.exists() && !f.isDirectory()) 
                 {
                     anonsAdi = "SON.mp3";
                 }
             }
        } 
        this.tTabbedPane.requestFocus();
        if(!MainClass.this.player.state){
            this.player.Play(path + anonsAdi);

        }
        else {
        	System.out.println("�st �ste anons yap�lamaz");
        }
           //	MainClass.this.anonsYapma=true;
            System.out.println(path + anonsAdi);
            System.out.println(anonsAdi +" yakla��m anonsu yap�ld�.");
            this.contentPane.requestFocus();

         
      
       
    }

    private void VarisAnonsuYap(String baslangicIstasyonu, String gelecekIstasyon, String hedefIstasyon) {
        String istasyonlarPath = this.startDir + "/Anons/ISTASYON/";
        String path = istasyonlarPath + gelecekIstasyon + "/";
        String anonsAdi = "VARIS.mp3";
        File f;
        /*if (hedefIstasyon.equals("K�RAZLI")) {
            if (gelecekIstasyon.equals("OTOGAR")) {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YEN�KAPIDAN K�RAZLIYA G�DER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YEN�KAPIDAN K�RAZLIYA G�DER.mp3";
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS K�RAZLIYA G�DER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS K�RAZLIYA G�DER.mp3";
                }
            }
        } else if (hedefIstasyon.equals("SEHITLIK")) {
            f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS OTOGARA G�DER.mp3");
            if (f.exists() && !f.isDirectory()) {
                anonsAdi = "VARIS OTOGARA G�DER.mp3";
            }
        } else if (hedefIstasyon.equals("ATAK�Y - ��R�NEVLER")) {
        	//de�i�
            if (gelecekIstasyon.equals("OTOGAR")) {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YEN�KAPIDAN ATAK�YE G�DER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YEN�KAPIDAN ATAK�YE G�DER.mp3";
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS ATAK�YE G�DER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS ATAK�YE G�DER.mp3";
                }
            }
        } else if (hedefIstasyon.equals("YEN�KAPI")) {
            if (gelecekIstasyon.equals("OTOGAR")) {
                if (baslangicIstasyonu.equals("ATAK�Y - ��R�NEVLER")) {
                	//de�i�
                    f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS ATAK�YDEN YEN�KAPIYA G�DER.mp3");
                    if (f.exists() && !f.isDirectory()) {
                        anonsAdi = "VARIS ATAK�YDEN YEN�KAPIYA G�DER.mp3";
                    }
                } else if (baslangicIstasyonu.equals("K�RAZLI")) {
                    f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS K�RAZLIDAN YEN�KAPIYA G�DER.mp3");
                    if (f.exists() && !f.isDirectory()) {
                        anonsAdi = "VARIS K�RAZLIDAN YEN�KAPIYA G�DER.mp3";
                    }
                }
            } else {
                f = new File(istasyonlarPath + gelecekIstasyon + "/" + "VARIS YEN�KAPIYA G�DER.mp3");
                if (f.exists() && !f.isDirectory()) {
                    anonsAdi = "VARIS YEN�KAPIYA G�DER.mp3";
                }
            }
        }*/

        this.tTabbedPane.requestFocus();
        if (!anonsAdi.equals("") && !gelecekIstasyon.isEmpty()) 
        {
        	 if(!MainClass.this.player.state){
                 this.player.Play(path + anonsAdi);

             }
        	 else {
             	System.out.println("�st �ste anons yap�lamaz");
             }
               //	MainClass.this.anonsYapma=true;
                System.out.println(path + anonsAdi);
                System.out.println(anonsAdi +" var�� anonsu yap�ld�.");
                this.contentPane.requestFocus();

               
        	
            
        }

    }

    public class EkranKoruyucuEngelleTask extends TimerTask {
        public EkranKoruyucuEngelleTask() {
        }

        public void run() {
            try {
                Robot robot = new Robot();
                robot.keyPress(16);

                try {
                    Thread.sleep(50L);
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
                }

                robot.keyRelease(16);
            } catch (AWTException var4) {
                var4.printStackTrace();
            }

        }
    }

}
