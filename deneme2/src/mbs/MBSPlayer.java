//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.event.EventListenerList;

import com.pi4j.io.gpio.PinState;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

public class MBSPlayer implements BasicPlayerListener {
    BasicPlayer player = new BasicPlayer();
    public static int mp3Second;
    BasicController control;
    public String[] co;
    public Process p ;
    protected EventListenerList listenerList = new EventListenerList();
    public static Boolean state=false; 
    long mp3Pid=0;
    long mp3Pid1=0;
    public void addMyEventListener(MyEventListener listener) {
        this.listenerList.add(MyEventListener.class, listener);
    	
    }

    public void removeMyEventListener(MyEventListener listener) {
        this.listenerList.remove(MyEventListener.class, listener);
    }

    void fireMyEvent(BasicPlayerEvent evt) {
        Object[] listeners = this.listenerList.getListenerList();

        for(int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == MyEventListener.class) {
                ((MyEventListener)listeners[i + 1]).myEventOccurred(evt);
            }
        }

    }

    public MBSPlayer() {
        this.control = this.player;
        this.player.addBasicPlayerListener(this);
    }
    public  void RoleGuncelle() {
    	if (TrenBilgileri.role != null) {//çalýyor ise high olmalý
          

    		System.out.println("role güncelleye girdi  ");
  	      System.out.println(TrenBilgileri.role.isHigh()+"role kapalý");

    		TrenBilgileri.role.setState(PinState.HIGH);
    	      System.out.println(TrenBilgileri.role.isHigh()+"role açýldý");
     	   Timer myTimer=new Timer();
     	   TimerTask gorev =new TimerTask() {   
     	         @Override
     	         public void run() {
     	        	 if(MBSPlayer.mp3Second+1<=0) {
     	        		TrenBilgileri.role.setState(PinState.LOW);

     						myTimer.cancel();
     					}else {
     						
     	     	        	MBSPlayer.mp3Second=MBSPlayer.mp3Second-1;
     					}
		    	
     	         }
     	  };
     	  myTimer.schedule(gorev,0,1000);
    			
    		}
        }
 public void Play(String filePath)  {
        if (OSValidator.isWindows()) {
        	try {
                this.player.addBasicPlayerListener(this);

                try {
                    this.control.open(new URL("file:///" + filePath));
                    File file = new File( filePath);
                    AudioFileFormat baseFileFormat;
					try {
						baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
						  Map properties = baseFileFormat.properties();
		                    Long duration = (Long) properties.get("duration");
		                    int second = duration.intValue();
		                    second=second/1000000;
		                    mp3Second =second;
		                    System.out.println("second: "+second);		                  

					} catch (UnsupportedAudioFileException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    this.control.play();
                } catch (MalformedURLException var3) {
                    var3.printStackTrace();
                }
            } catch (BasicPlayerException var4) {
                var4.printStackTrace();
            }
        }else {
            this.player.addBasicPlayerListener(this);
            System.out.print("deneniyor");
            // this.control.open(new URL("file:///" + filePath));
			File file = new File( filePath);
			AudioFileFormat baseFileFormat;
			try {

				baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
				  Map properties = baseFileFormat.properties();
			        Long duration = (Long) properties.get("duration");
			        int second = duration.intValue();
			        second=second/1000000;
			        mp3Second =second;
			        System.out.println("second: "+second);
			        RoleGuncelle();
			        //co = new String[]{"/bin/sh", "-c", "sudo ffplay -autoexit -nodisp "+ filePath };
					// co = new String[]{"/bin/sh", "-c", " /usr/bin/cvlc "+ filePath };
		    	//  co = new String[]{"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",  filePath };
					 //co = new String[]{"/bin/sh", "-c", "sudo ffplay -autoexit -nodisp "+ filePath };
				    System.out.println(filePath);

		             String[] co = new String[]{"/bin/sh", "-c", " /usr/bin/cvlc "+filePath };
		             ProcessBuilder pb = new ProcessBuilder(co);
		             p=pb.start();
		             mp3Pid=p.pid();
		             mp3Pid1=mp3Pid+1;
		             System.out.println("pid"+mp3Pid);

			        

				
				    //Runtime.getRuntime().exec(co);
				     //BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				    	//	this.control.open(new URL("file:///" + filePath));
				//    this.control.play();

			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//this.control.play();
			
   /* if(!state) {
			//state=true;
			try {
				co = new String[]{"/bin/sh", "-c", "sudo ffplay -autoexit -nodisp "+ filePath };
							// co = new String[]{"/bin/sh", "-c", " /usr/bin/cvlc "+ filePath };
				    	//  co = new String[]{"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",  filePath };
							 //co = new String[]{"/bin/sh", "-c", "sudo ffplay -autoexit -nodisp "+ filePath };
						    Runtime.getRuntime().exec(co);
						     //BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						    	//	this.control.open(new URL("file:///" + filePath));
						//    this.control.play();
						    System.out.println(filePath);
						} catch (MalformedURLException var3) {
						    var3.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        }*/
        }
	
    }
  
    public void Stop() throws IOException {
       	System.out.println("kill deneniyor."+mp3Pid1);
        	String[] kill9=new String[] {"kill -9 "+mp3Pid1};
            Runtime.getRuntime().exec(kill9);
        
    }

    public void opened(Object stream, Map properties) {
    }

    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
    }

    public void setController(BasicController controller) {
    }

    public void stateUpdated(BasicPlayerEvent event) {
        this.fireMyEvent(event);
    }
}
