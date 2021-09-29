package mbs;

import java.util.ArrayList;
public class RotaBilgileri {
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkapý = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_TopkapýMescidiselam = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkapý = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_TopkapýMescidiselam = new ArrayList();
    public static String baslangicIstasyon;
    public RotaBilgileri() {
    }
    public static void Init() {
        JSONOku jsonOku;

      jsonOku = new JSONOku();
      //jsonOku.main("/anonsName");
    T4_Istasyonlar_MescidiselamTopkapý=jsonOku.T4_Istasyonlar_MescidiselamTopkapý;
       T4_Mesafeler_MescidiselamTopkapý=jsonOku.T4_Mesafeler_MescidiselamTopkapý;
    T4_Istasyonlar_TopkapýMescidiselam=jsonOku.T4_Istasyonlar_TopkapýMescidiselam;
       T4_Mesafeler_TopkapýMescidiselam=jsonOku.T4_Mesafeler_TopkapýMescidiselam;
      //TopkapýMescidiselam();
      //MescidiselamTopkapý();
    }

   static Rotalar rota; 
    public static String BaslangicIstasyonuBul(String mevcutIstasyon, String hedefIstasyon,Boolean takometrePasifEt) {
        baslangicIstasyon=mevcutIstasyon;

        String gelecekSonrakiIstasyon = getGelecekSonrakiIstasyon(mevcutIstasyon, hedefIstasyon);
        System.out.println(gelecekSonrakiIstasyon+"gelecekSonrakiIstasyon");
        String gelecekIstasyon = getGelecekIstasyon(mevcutIstasyon, hedefIstasyon);
        System.out.println(gelecekIstasyon+"gelecekIstasyon");


        rota = GetRota(mevcutIstasyon, gelecekIstasyon, hedefIstasyon,takometrePasifEt);
        return mevcutIstasyon;

        /*if (rota == Rotalar.T4MescidiselamTopkapý) {
            return "TOPKAPI";
        } else {
             return "MESCIDI SELAM"; 
        }*/
    }

    public static boolean IstasyonRotadaMi(Rotalar rota, String istasyonAdi, String baslangic, String hedef) {
        int indexBaslangic;
        int indexHedef;
        int indexMevcut;
        if (!rota.equals(Rotalar.T4MescidiselamTopkapý) ) {
            if (rota.equals(Rotalar.T4TopkapýMescidiselam)) {
                indexBaslangic = T4_Istasyonlar_TopkapýMescidiselam.indexOf(baslangic.toUpperCase());
                indexHedef = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedef.toUpperCase());
                indexMevcut = T4_Istasyonlar_TopkapýMescidiselam.indexOf(istasyonAdi.toUpperCase());
                if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                    return true;
                }
            }
        } else if (T4_Istasyonlar_MescidiselamTopkapý.contains(istasyonAdi.toUpperCase())) {
             
            indexBaslangic = T4_Istasyonlar_MescidiselamTopkapý.indexOf(baslangic.toUpperCase());
            indexHedef = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedef.toUpperCase());
            indexMevcut = T4_Istasyonlar_MescidiselamTopkapý.indexOf(istasyonAdi.toUpperCase());
            if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                return true;
            }
        }

        return false;
    }

    public static Rotalar GetRota(String mevcutIstasyon, String gelecekIstasyon, String hedefIstasyon, Boolean takometrePasifEt) {

        if (hedefIstasyon.equals("")) {
            return Rotalar.SECILMEDI;
        } else if (mevcutIstasyon.equals("")) {

            return Rotalar.SECILMEDI;
        }  else if (gelecekIstasyon.equals("")) {
           

            return Rotalar.Kur;
        } else {
            HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
            Yonler yon = getYon(mevcutIstasyon, hedefIstasyon);
            if (yon == Yonler.TOPKAPI) {
                return Rotalar.T4MescidiselamTopkapý;//T4TopkapýMescidiselam
            } else if (yon == Yonler.MESCÝDÝSELAM) {
                return Rotalar.T4TopkapýMescidiselam;//T4MescidiselamTopkapý
            }/* else if (yon == Yonler.YENIKAPI) {
                if (hatTipi.equals(HatTipi.TopkapýMescidiselam)) {
                    return Rotalar.T4TopkapýMescidiselam;
                } else {
                    return hatTipi.equals(HatTipi.MescidiselamTopkapý) ? Rotalar.T4MescidiselamTopkapý : Rotalar.GECERSÝZ;
                }
            } */else {

                return Rotalar.GECERSÝZ;
            }
        }
    }
   /* public static Yonler getYon(String mevcutIstasyon, String hedefIstasyon) {
        int indexMevcut;
        int indexHedef;
   
        if (T4_Istasyonlar_MescidiselamTopkapý.get(0).toString().contains(mevcutIstasyon)==true) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_TopkapýMescidiselam.get(0).toString().contains(mevcutIstasyon)==true) {
            indexMevcut = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESCÝDÝSELAM;
            } else {

                return  Yonler.GECERSIZ;
            }
        } else {
             
            return Yonler.GECERSIZ;
        }
    }*/
    public static Yonler getYon(String mevcutIstasyon, String hedefIstasyon) {
        int indexMevcut;
        int indexHedef;
        if(mevcutIstasyon!="" && hedefIstasyon!="") {

        if (T4_Istasyonlar_MescidiselamTopkapý.contains(mevcutIstasyon) && T4_Istasyonlar_MescidiselamTopkapý.contains(hedefIstasyon)) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_TopkapýMescidiselam.contains(mevcutIstasyon) && T4_Istasyonlar_TopkapýMescidiselam.contains(hedefIstasyon)) {
            indexMevcut = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESCÝDÝSELAM;
            } else {
                return  Yonler.GECERSIZ;
            }
        } else {
            return Yonler.GECERSIZ;
        }
        }else {
            return Yonler.GECERSIZ;

        }
    }

    public static HatTipi getHatTipi(String mevcutIstasyon, String hedefIstasyon) { //kontrol et doðru mu yazýyor rotalaro
      //burdaaaaaaaa
      //sorun þu else giriyot
      
      //hedef topkapý
      //hedef mescidi
      //hedef bastabya
      //hedef sultan cifligi 
    
       int mevcutIndex;
         int hedefIndex;
         
      mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon); //1
        hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);//2
        if(mevcutIstasyon!="" && hedefIstasyon!="") {
          
        if(mevcutIndex<hedefIndex) {
              return HatTipi.TopkapýMescidiselam;
             
        }
        else {
               return  HatTipi.MescidiselamTopkapý;
             
        }
        }else {
             return HatTipi.GECERSÝZ;
        }
      /*  if(T4_Istasyonlar_TopkapýMescidiselam.get(0).toString().contains(hedefIstasyon)==true) { //hedef topkapý ise mescidi selam yönü olur
               return HatTipi.MescidiselamTopkapý;
         }else {
               
                return HatTipi.TopkapýMescidiselam;
         }*/
      
      
      
        /*if (T4_Istasyonlar_MescidiselamTopkapý.get(0).toString().contains(hedefIstasyon)==true) {


            return HatTipi.TopkapýMescidiselam;//MescidiselamTopkapý
        } else {


            return  HatTipi.MescidiselamTopkapý;//TopkapýMescidiselam
        }*/
    }
   public static String getHatTipix(String mevcutIstasyon, String hedefIstasyon) {
      //burdaaaaaaaa
      //sorun þu else giriyot
         /* if(T4_Istasyonlar_TopkapýMescidiselam.get(0).toString().contains(hedefIstasyon)==true) { //hedef topkapý ise mescidi selam yönü olur
                return "MescidiselamTopkapý";
          }else {
                
                return "TopkapýMescidiselam";
          }
     /*   if (T4_Istasyonlar_MescidiselamTopkapý.get(0).toString().contains(mevcutIstasyon)==true) {
             return "MescidiselamTopkapý";
        } else {
             return "TopkapýMescidiselam";
        }*/
          int  mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
            int  hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
            if(mevcutIstasyon!="" && hedefIstasyon!="") {
            if(hedefIndex>mevcutIndex) 
            {
              System.out.println(" Tren yönü ----> TopkapýMescidiselam");
                       return "TopkapýMescidiselam";

            }else {
              System.out.println(" Tren yönü ----> MescidiselamTopkapý");

                       return "MescidiselamTopkapý";
            }
            }
            return "";
    }
    public static String deneme;
    public static Boolean control=false;//burdaaa controle 1 kere giriyor
    public static HatTipi hatTipix;
    public static int getGelecekIstasyonMesafe(String mevcutIstasyon, String hedefIstasyon, String rota) {
            if(mevcutIstasyon!="" && hedefIstasyon!="") {

      if(rota =="MescidiselamTopkapý") {
           
             hatTipix=HatTipi.MescidiselamTopkapý;
            }
            else {hatTipix=HatTipi.TopkapýMescidiselam;}
      int mevcutIndex;
        int hedefIndex;
        int val;



        if (hatTipix==HatTipi.MescidiselamTopkapý) {

            mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);


            if (mevcutIndex >= 0 && hedefIndex >= 0) {
            if(mevcutIndex==0) 
             {
                   val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex);

                    return val;
            }
            
             else if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex);

                    //val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex+1);

                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
                
            }
        } else if (hatTipix == HatTipi.TopkapýMescidiselam) {

            mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
            if(mevcutIndex==0) 
             {
                   val = (Integer)T4_Mesafeler_TopkapýMescidiselam.get(mevcutIndex);

                    return val;
            }
            
             else if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_TopkapýMescidiselam.get(mevcutIndex);

                    //val = (Integer)T4_Mesafeler_MescidiselamTopkapý.get(mevcutIndex + 1);
                    return val;
                } 
                 else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_TopkapýMescidiselam.get(mevcutIndex+1);
                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
            }
            else {return 0;}
      
        
    }
    public static String getGelecekSonrakiIstasyon(String mevcutIstasyon,String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        String val2;
            if(mevcutIstasyon=="" && hedefIstasyon=="") {
              return "";
            }
            else {

              if (hatTipi == HatTipi.MescidiselamTopkapý) {

                    mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
                    hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
                    if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if(hedefIndex-mevcutIndex==1) {
                           return "";
                           
                     }
                    else if (mevcutIndex < hedefIndex) {
                           System.out.println("mevcutIndex1 "+mevcutIndex);
                            val2 = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
                            return val2 != null ? val2 : "";
                        } else {
                           System.out.println("mevcutIndex2 "+mevcutIndex);

                                if(mevcutIndex + 2>=T4_Istasyonlar_MescidiselamTopkapý.size()) {}
                            val2 = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
         
                            return val2 != null ? val2 : "";
                        }
                    } else {
                        return "";
                    }
                } else if (hatTipi == HatTipi.TopkapýMescidiselam)  {

                    mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
                    hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
                    if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if(hedefIndex-mevcutIndex==1) {
                           return "";
                           
                     }
                    else if (mevcutIndex < hedefIndex) {
                           System.out.println("mevcutIndex3 "+mevcutIndex);

                            val2 = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
                            return val2 != null ? val2 : "";
                        } else {
                          if((mevcutIndex -2)>=0) { 
                                 System.out.println("mevcutIndex4 "+mevcutIndex);

                                val2 = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex -2);
                                 System.out.println("val2 "+val2);

//                              if(val2.contains(hedefIstasyon)==true) {
//                              return "";
//                              }
                                return val2 != null ? val2 : "";
                          }

                            return  "";
                        }
                    } else {
                        return "";
                    }
                }  else {
                    return "";
                }
              
              
              
            }
       
    }
    

    public static String getGelecekIstasyon(String mevcutIstasyon,String hedefIstasyon) {
        HatTipi hatTipi = getHatTipi(mevcutIstasyon, hedefIstasyon);
        int mevcutIndex;
        int hedefIndex;
        String val;
        if(mevcutIstasyon=="" && hedefIstasyon=="") {


              return "";
            }
        else {
             if (hatTipi == HatTipi.MescidiselamTopkapý) {
            mevcutIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(mevcutIstasyon);
                hedefIndex = T4_Istasyonlar_MescidiselamTopkapý.indexOf(hedefIstasyon);
                if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if (mevcutIndex < hedefIndex) {
                        val = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex + 1);
//                       if(val.contains(hedefIstasyon)==true) {
//                              return "";
//                        }


                        return val != null ? val : "";
                    } else if (mevcutIndex > hedefIndex) {
                        val = (String)T4_Istasyonlar_MescidiselamTopkapý.get(mevcutIndex - 1);
//                        if(val.contains(hedefIstasyon)==true) {
//                              return "";
//                        }

                        return val != null ? val : "";
                    } else {


                        return "";
                    }
                } else {


                    return "";
                }
            } else if (hatTipi == HatTipi.TopkapýMescidiselam) {
                mevcutIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(mevcutIstasyon);
                hedefIndex = T4_Istasyonlar_TopkapýMescidiselam.indexOf(hedefIstasyon);
                if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if (mevcutIndex < hedefIndex) {
                        val = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex + 1);
//                        if(val.contains(hedefIstasyon)==true) {
//                              return "";
//                        }

                        return val != null ? val : "";
                    } else if (mevcutIndex > hedefIndex) {
                        val = (String)T4_Istasyonlar_TopkapýMescidiselam.get(mevcutIndex - 1);
                                 /*
                                  * if(val.contains(hedefIstasyon)==true) { return ""; }
                                  */

                        return val != null ? val : "";
                    } else {


                        return "";
                    }
                } else {


                    return "";
                }
            } else {


                return "";
            }
             
        }
        
    }
}
