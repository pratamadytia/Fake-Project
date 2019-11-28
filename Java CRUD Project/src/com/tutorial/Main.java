package com.tutorial;
import java.io.*;
import java.sql.SQLOutput;
import java.time.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.println("Database Perpustakaan\n");
            System.out.println("1.\tLihat seluruh buku");
            System.out.println("2.\tCari data buku");
            System.out.println("3.\tTambah data buku");
            System.out.println("4.\tUbah data buku");
            System.out.println("5.\tHapus data buku");

            System.out.print("\n\nPilihan anda: ");
            pilihanUser = terminalInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("\n=================");
                    System.out.println("LIST SELURUH BUKU");
                    System.out.println("=================");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("\n=========");
                    System.out.println("CARI BUKU");
                    System.out.println("=========");
                    caridata();
                    // cari data
                    break;
                case "3":
                    System.out.println("\n================");
                    System.out.println("TAMBAH DATA BUKU");
                    System.out.println("================");
                    Tambahbuku();
                    tampilkanData();
                    // tambah data
                    break;
                case "4":
                    System.out.println("\n==============");
                    System.out.println("UBAH DATA BUKU");
                    System.out.println("==============");
                    // ubah data
                    updatebuku();
                    break;
                case "5":
                    System.out.println("\n===============");
                    System.out.println("HAPUS DATA BUKU");
                    System.out.println("===============");
                    deletebuku();
                    // hapus data
                    break;
                default:
                    System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-5]");
            }

            isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
        }
    }

    //nampilin data
    private static void tampilkanData() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;
        //cek DB di file
        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Database Tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahoeloe");
            Tambahbuku();
            return;
        }

        System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        String data = bufferInput.readLine();
        int nomorData = 0;
        while (data != null) {
            nomorData++;

            StringTokenizer stringToken = new StringTokenizer(data, ",");

            stringToken.nextToken();
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%s   ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
    } //function 1

    //search data
    private static void caridata() throws IOException {//baca db ada atau tidak
        try {
            File file = new File("database.txt");
        } catch (Exception e) {
            System.err.println("Database Tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahoeloe");
            Tambahbuku();
            return;
        }
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("Masukan Kata Kunci untuk mencari2 buku");
        String caristring = terminalInput.nextLine();
        String[] keyword = caristring.split("\\s");
        System.out.println(keyword[0]);
        System.out.println(keyword[0]);
        cekbukuDB(keyword,true);
    } //function 2

    //cek data di db
    private static boolean cekbukuDB(String[] Keyword,boolean isDisplay) throws IOException {
        //Panggil database
        FileReader fileinput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileinput);
        String data = bufferInput.readLine();
        ///
        boolean isExist = false;
        int jumlhdata = 0;
        while (data != null) {
            //cek kata di db
            //jumlhdata++;
            // System.out.println(jumlhdata);
            //perbaris
            isExist = true;

            System.out.println(data);
            System.out.println(Arrays.toString(Keyword));
            for (String keyword : Keyword) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
                System.out.println(isExist);
            }
            //System.out.println(data);
            //System.out.println(Arrays.toString(Keyword));
            //keyword cocok baru tampil
            System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            if (isExist) {
                if (isDisplay) {
                    int nomorData = 0;
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    stringToken.nextToken();
                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%s   ", stringToken.nextToken());
                    System.out.print("\n");
                }else {
                    break;
                }
            }
            System.out.println(false);
            data = bufferInput.readLine();
        }

        System.out.println("----------------------------------------------------------------------------------------------------------");

        //ganti ke boolean untuk voidnya
        return isExist;
    }

    //tambah data
    private static void Tambahbuku () throws IOException {
        FileWriter fileoutput = new FileWriter("database.txt", true);
        BufferedWriter bufferoutput = new BufferedWriter(fileoutput);

        //ambil input user
        Scanner terminalInput = new Scanner(System.in);
        String penulis, judul, penerbit, tahun;

        //penulis
        System.out.print("Masukan nama Penulis  :");
        penulis = terminalInput.nextLine();
        //judul
        System.out.print("Masukan Nama Penerbit :");
        penerbit = terminalInput.nextLine();
        //penerbit
        System.out.print("Masukan Judul Buku    :");
        judul = terminalInput.nextLine();
        //tahun
        System.out.print("Masukan Tahun Terbit  :  ");
        tahun = checktahun();

        //cek buku di database pake string
        String[] Keyword = {tahun + "," + penulis + "," + penerbit + "," + judul};
        System.out.println(Arrays.toString(Keyword));

        //cek buku ada di db
        boolean isExist = cekbukuDB(Keyword, false);
        System.out.println(isExist);

        //add buku di db
        if (!isExist) {
            //fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
            System.out.println(ambilnoentry(penulis,tahun));
            long nomorentry = ambilnoentry(penulis,tahun)+1;
            String tanpaspasi = penulis.replaceAll("\\s+", "");
            String primaryKey = tanpaspasi + "_" + tahun + "_" + nomorentry;
            System.out.println("\n data yang dimasukan adalah ");
            System.out.println("====================================");
            System.out.println("primary key  : " + primaryKey);
            System.out.println("tahun terbit :" + tahun);
            System.out.println("Penulis      : " + penulis);
            System.out.println("Judul        :" + judul);
            System.out.println("penerbit     :"+ penerbit);

            //check tambah data di database
            boolean istambah = getYesorNo("mau tambah data atau tidak ?  :");
            if (istambah){
                bufferoutput.write(primaryKey+","+tahun+","+penulis+","+penerbit+","+judul);
                bufferoutput.newLine();
                bufferoutput.flush();
            }
            }else {
            System.out.println("Buku yang anda masukan sudah ada ");
            cekbukuDB(Keyword,true);
        }

             bufferoutput.close();
        }

        //delete buku
     private static void deletebuku () throws IOException{
    //ambil db original
         File database = new File("database.txt");
         FileReader fileInput = new FileReader(database);
         BufferedReader bufferInput = new BufferedReader(fileInput);
    //buat db sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        //nampilin data
         System.out.println("List buku");
         tampilkanData();

    //ambil user input
        Scanner terminalInput = new Scanner(System.in);
         System.out.println("\n\n Masukan nomor Buku yang dihapus :");
         int delnum = terminalInput.nextInt();
    //looping untuk baca tiap baris /skip yang di delete

       int datacount = 0;
       String data = bufferInput.readLine();

       while (data !=null) {
       datacount++;
       Boolean isdelete = false;
       StringTokenizer st = new StringTokenizer(data,",");
       //tampil data di hapus
           if (delnum == datacount) {
               System.out.println("\n\nData yang Mau dihapus adalah : ");
               System.out.println("-----------------------------------");
               System.out.println("Refference         :" +st.nextToken());
               System.out.println("Tahun              :" +st.nextToken());
               System.out.println("Penulis            :" +st.nextToken());
               System.out.println("Penerbit           :" +st.nextToken());
               System.out.println("Judul              :" +st.nextToken());

                isdelete=getYesorNo("Apakah Ingin dihapus ?");
           }
           if(isdelete){
               //skip data dari DB ori ke temp
               System.out.println("data sukses di hapus");
           }else{
               //pindahin data dari db ori ke temp;
               bufferOutput.write(data);
               bufferOutput.newLine();
           }

           data =bufferInput.readLine();
       }
       //menulis data ke file
       bufferOutput.flush();

       //delete ori file
         database.delete();
       // rename
         tempDB.renameTo(database);

     }



     private static void updatebuku() throws IOException{
        //ambil data dulu
         File database = new File("database.txt");
         FileReader fileinput = new FileReader(database);
         BufferedReader bufferInput = new BufferedReader(fileinput);

         //buat temporary db
         File tempDB = new File("tempDB.txt");
         FileWriter fileoutput = new FileWriter(tempDB);
         BufferedWriter bufferoutput = new BufferedWriter(fileoutput);

         //tampilkan data
         System.out.println("List Buku");
         tampilkanData();

         //ambil input user
         Scanner terminalInput = new Scanner(System.in);
         System.out.println("\nMasukan nomor buku yang mau di update :");
         int updatenum = terminalInput.nextInt();

         //tampilin data yang di update
         String data = bufferInput.readLine();
         int entryCount = 0;
         while (data != null) {
             entryCount ++;
             StringTokenizer st = new StringTokenizer(data,",");

             //tampilin nomor entry
             if(updatenum == entryCount){
                 System.out.println("\n Data Yang akan di update adalah :");
                 System.out.println("====================================");
                 System.out.println("Referensi          : "+ st.nextToken());
                 System.out.println("Penulis            :"+ st.nextToken());
                 System.out.println("Judul              : "+st.nextToken());
                 System.out.println("Penerbit           : "+st.nextToken());
                 System.out.println("Tahun              : "+st.nextToken());

                 //update data

                 //ambil inputan baru
                 String [] fielddata = {"penulis","judul","penerbit","tahun"};
                 String[] tempdata = new String[4];
                 for (int i = 0 ; i<fielddata.length;i++){
                     boolean isUpdate =getYesorNo("apakah anda ingin merubah nama " + field);

                     if (isUpdate){
                         terminalInput = new Scanner(System.in);
                         System.out.println("\n Masukan : " + fielddata[i]+ "baru :");
                            tempdata [i] = terminalInput.nextLine();
                     }else {
                         tempdata [i] = fielddata [i];
                     }
                 }
                 System.out.println(Arrays.toString(tempdata));

             }else {
                 bufferoutput.write(data);
                 bufferoutput.newLine();
             }
             data = bufferInput.readLine();
         }
     }

        //ambil entry dari tahun
    private static long ambilnoentry(String penulis,String tahun ) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        long nomorentry = 0;
        String data = bufferInput.readLine();
        Scanner datascanner;
        String primaryKey;

        while (data !=null){
            //data 1
            datascanner=new Scanner(data);
            datascanner.useDelimiter(",");
            primaryKey =datascanner.next();
            // data 2
            datascanner = new Scanner(primaryKey);
            datascanner.useDelimiter("_");

            penulis=penulis.replaceAll("\\s","");

            if (penulis.equalsIgnoreCase(datascanner.next()) && tahun.equalsIgnoreCase(datascanner.next())) {
                nomorentry=datascanner.nextInt();
            }
                data = bufferInput.readLine();
        }

        return nomorentry;
    }

    //additional function 2 buat check tahun
    private static String checktahun () throws IOException {
        boolean tahunvalid =false;
        Scanner terminalInput =new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();
        while(!tahunvalid){
            try {
                Year.parse(tahunInput);
                tahunvalid = true;
            }catch (Exception e) {
                System.err.println("Masukan Format yang benar [YYYY] :");
                System.err.print("masukan format lagi :");
                tahunInput =terminalInput.nextLine();
            }

        }
        return tahunInput;
    }

    //question respond
    private static boolean getYesorNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihanUser = terminalInput.next();

        while(!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    //clean
    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex){
            System.err.println("tidak bisa clear screen");
        }
    }
}











