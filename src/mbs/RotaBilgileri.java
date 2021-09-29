package mbs;

import java.util.ArrayList;
public class RotaBilgileri {
    private static ArrayList<String> T4_Istasyonlar_MescidiselamTopkap� = new ArrayList();
    private static ArrayList<String> T4_Istasyonlar_Topkap�Mescidiselam = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_MescidiselamTopkap� = new ArrayList();
    private static ArrayList<Integer> T4_Mesafeler_Topkap�Mescidiselam = new ArrayList();
    public static String baslangicIstasyon;
    public RotaBilgileri() {
    }
    public static void Init() {
        JSONOku jsonOku;

      jsonOku = new JSONOku();
      //jsonOku.main("/anonsName");
    T4_Istasyonlar_MescidiselamTopkap�=jsonOku.T4_Istasyonlar_MescidiselamTopkap�;
       T4_Mesafeler_MescidiselamTopkap�=jsonOku.T4_Mesafeler_MescidiselamTopkap�;
    T4_Istasyonlar_Topkap�Mescidiselam=jsonOku.T4_Istasyonlar_Topkap�Mescidiselam;
       T4_Mesafeler_Topkap�Mescidiselam=jsonOku.T4_Mesafeler_Topkap�Mescidiselam;
      //Topkap�Mescidiselam();
      //MescidiselamTopkap�();
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

        /*if (rota == Rotalar.T4MescidiselamTopkap�) {
            return "TOPKAPI";
        } else {
             return "MESCIDI SELAM"; 
        }*/
    }

    public static boolean IstasyonRotadaMi(Rotalar rota, String istasyonAdi, String baslangic, String hedef) {
        int indexBaslangic;
        int indexHedef;
        int indexMevcut;
        if (!rota.equals(Rotalar.T4MescidiselamTopkap�) ) {
            if (rota.equals(Rotalar.T4Topkap�Mescidiselam)) {
                indexBaslangic = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(baslangic.toUpperCase());
                indexHedef = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedef.toUpperCase());
                indexMevcut = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(istasyonAdi.toUpperCase());
                if (indexMevcut < indexHedef && indexMevcut >= indexBaslangic || indexMevcut > indexHedef && indexMevcut <= indexBaslangic) {
                    return true;
                }
            }
        } else if (T4_Istasyonlar_MescidiselamTopkap�.contains(istasyonAdi.toUpperCase())) {
             
            indexBaslangic = T4_Istasyonlar_MescidiselamTopkap�.indexOf(baslangic.toUpperCase());
            indexHedef = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedef.toUpperCase());
            indexMevcut = T4_Istasyonlar_MescidiselamTopkap�.indexOf(istasyonAdi.toUpperCase());
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
                return Rotalar.T4MescidiselamTopkap�;//T4Topkap�Mescidiselam
            } else if (yon == Yonler.MESC�D�SELAM) {
                return Rotalar.T4Topkap�Mescidiselam;//T4MescidiselamTopkap�
            }/* else if (yon == Yonler.YENIKAPI) {
                if (hatTipi.equals(HatTipi.Topkap�Mescidiselam)) {
                    return Rotalar.T4Topkap�Mescidiselam;
                } else {
                    return hatTipi.equals(HatTipi.MescidiselamTopkap�) ? Rotalar.T4MescidiselamTopkap� : Rotalar.GECERS�Z;
                }
            } */else {

                return Rotalar.GECERS�Z;
            }
        }
    }
   /* public static Yonler getYon(String mevcutIstasyon, String hedefIstasyon) {
        int indexMevcut;
        int indexHedef;
   
        if (T4_Istasyonlar_MescidiselamTopkap�.get(0).toString().contains(mevcutIstasyon)==true) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_Topkap�Mescidiselam.get(0).toString().contains(mevcutIstasyon)==true) {
            indexMevcut = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESC�D�SELAM;
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

        if (T4_Istasyonlar_MescidiselamTopkap�.contains(mevcutIstasyon) && T4_Istasyonlar_MescidiselamTopkap�.contains(hedefIstasyon)) 
        {
            indexMevcut = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.TOPKAPI;
            } else {

                return  Yonler.TOPKAPI;
            }
        } else if (T4_Istasyonlar_Topkap�Mescidiselam.contains(mevcutIstasyon) && T4_Istasyonlar_Topkap�Mescidiselam.contains(hedefIstasyon)) {
            indexMevcut = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            indexHedef = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if (indexHedef > indexMevcut) {
                return Yonler.MESC�D�SELAM;
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

    public static HatTipi getHatTipi(String mevcutIstasyon, String hedefIstasyon) { //kontrol et do�ru mu yaz�yor rotalaro
      //burdaaaaaaaa
      //sorun �u else giriyot
      
      //hedef topkap�
      //hedef mescidi
      //hedef bastabya
      //hedef sultan cifligi 
    
       int mevcutIndex;
         int hedefIndex;
         
      mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon); //1
        hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);//2
        if(mevcutIstasyon!="" && hedefIstasyon!="") {
          
        if(mevcutIndex<hedefIndex) {
              return HatTipi.Topkap�Mescidiselam;
             
        }
        else {
               return  HatTipi.MescidiselamTopkap�;
             
        }
        }else {
             return HatTipi.GECERS�Z;
        }
      /*  if(T4_Istasyonlar_Topkap�Mescidiselam.get(0).toString().contains(hedefIstasyon)==true) { //hedef topkap� ise mescidi selam y�n� olur
               return HatTipi.MescidiselamTopkap�;
         }else {
               
                return HatTipi.Topkap�Mescidiselam;
         }*/
      
      
      
        /*if (T4_Istasyonlar_MescidiselamTopkap�.get(0).toString().contains(hedefIstasyon)==true) {


            return HatTipi.Topkap�Mescidiselam;//MescidiselamTopkap�
        } else {


            return  HatTipi.MescidiselamTopkap�;//Topkap�Mescidiselam
        }*/
    }
   public static String getHatTipix(String mevcutIstasyon, String hedefIstasyon) {
      //burdaaaaaaaa
      //sorun �u else giriyot
         /* if(T4_Istasyonlar_Topkap�Mescidiselam.get(0).toString().contains(hedefIstasyon)==true) { //hedef topkap� ise mescidi selam y�n� olur
                return "MescidiselamTopkap�";
          }else {
                
                return "Topkap�Mescidiselam";
          }
     /*   if (T4_Istasyonlar_MescidiselamTopkap�.get(0).toString().contains(mevcutIstasyon)==true) {
             return "MescidiselamTopkap�";
        } else {
             return "Topkap�Mescidiselam";
        }*/
          int  mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
            int  hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
            if(mevcutIstasyon!="" && hedefIstasyon!="") {
            if(hedefIndex>mevcutIndex) 
            {
              System.out.println(" Tren y�n� ----> Topkap�Mescidiselam");
                       return "Topkap�Mescidiselam";

            }else {
              System.out.println(" Tren y�n� ----> MescidiselamTopkap�");

                       return "MescidiselamTopkap�";
            }
            }
            return "";
    }
    public static String deneme;
    public static Boolean control=false;//burdaaa controle 1 kere giriyor
    public static HatTipi hatTipix;
    public static int getGelecekIstasyonMesafe(String mevcutIstasyon, String hedefIstasyon, String rota) {
            if(mevcutIstasyon!="" && hedefIstasyon!="") {

      if(rota =="MescidiselamTopkap�") {
           
             hatTipix=HatTipi.MescidiselamTopkap�;
            }
            else {hatTipix=HatTipi.Topkap�Mescidiselam;}
      int mevcutIndex;
        int hedefIndex;
        int val;



        if (hatTipix==HatTipi.MescidiselamTopkap�) {

            mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
            hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);


            if (mevcutIndex >= 0 && hedefIndex >= 0) {
            if(mevcutIndex==0) 
             {
                   val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex);

                    return val;
            }
            
             else if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex);

                    //val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex + 1);
                    return val;
                } else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex+1);

                    return val;
                } else {
                    return 0;
                }
            } else {
                return 0;
                
            }
        } else if (hatTipix == HatTipi.Topkap�Mescidiselam) {

            mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);

            hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);

            if (mevcutIndex >= 0 && hedefIndex >= 0) {
            if(mevcutIndex==0) 
             {
                   val = (Integer)T4_Mesafeler_Topkap�Mescidiselam.get(mevcutIndex);

                    return val;
            }
            
             else if (mevcutIndex < hedefIndex) {
                    val = (Integer)T4_Mesafeler_Topkap�Mescidiselam.get(mevcutIndex);

                    //val = (Integer)T4_Mesafeler_MescidiselamTopkap�.get(mevcutIndex + 1);
                    return val;
                } 
                 else if (mevcutIndex > hedefIndex) {
                    val = (Integer)T4_Mesafeler_Topkap�Mescidiselam.get(mevcutIndex+1);
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

              if (hatTipi == HatTipi.MescidiselamTopkap�) {

                    mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
                    hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
                    if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if(hedefIndex-mevcutIndex==1) {
                           return "";
                           
                     }
                    else if (mevcutIndex < hedefIndex) {
                           System.out.println("mevcutIndex1 "+mevcutIndex);
                            val2 = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
                            return val2 != null ? val2 : "";
                        } else {
                           System.out.println("mevcutIndex2 "+mevcutIndex);

                                if(mevcutIndex + 2>=T4_Istasyonlar_MescidiselamTopkap�.size()) {}
                            val2 = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
         
                            return val2 != null ? val2 : "";
                        }
                    } else {
                        return "";
                    }
                } else if (hatTipi == HatTipi.Topkap�Mescidiselam)  {

                    mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
                    hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
                    if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if(hedefIndex-mevcutIndex==1) {
                           return "";
                           
                     }
                    else if (mevcutIndex < hedefIndex) {
                           System.out.println("mevcutIndex3 "+mevcutIndex);

                            val2 = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex + 2);
                           System.out.println("val2 "+val2);

//                          if(val2.contains(hedefIstasyon)==true) {
//                               return "";
//                          }
                            return val2 != null ? val2 : "";
                        } else {
                          if((mevcutIndex -2)>=0) { 
                                 System.out.println("mevcutIndex4 "+mevcutIndex);

                                val2 = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex -2);
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
             if (hatTipi == HatTipi.MescidiselamTopkap�) {
            mevcutIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(mevcutIstasyon);
                hedefIndex = T4_Istasyonlar_MescidiselamTopkap�.indexOf(hedefIstasyon);
                if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if (mevcutIndex < hedefIndex) {
                        val = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex + 1);
//                       if(val.contains(hedefIstasyon)==true) {
//                              return "";
//                        }


                        return val != null ? val : "";
                    } else if (mevcutIndex > hedefIndex) {
                        val = (String)T4_Istasyonlar_MescidiselamTopkap�.get(mevcutIndex - 1);
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
            } else if (hatTipi == HatTipi.Topkap�Mescidiselam) {
                mevcutIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(mevcutIstasyon);
                hedefIndex = T4_Istasyonlar_Topkap�Mescidiselam.indexOf(hedefIstasyon);
                if (mevcutIndex >= 0 && hedefIndex >= 0) {
                    if (mevcutIndex < hedefIndex) {
                        val = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex + 1);
//                        if(val.contains(hedefIstasyon)==true) {
//                              return "";
//                        }

                        return val != null ? val : "";
                    } else if (mevcutIndex > hedefIndex) {
                        val = (String)T4_Istasyonlar_Topkap�Mescidiselam.get(mevcutIndex - 1);
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
