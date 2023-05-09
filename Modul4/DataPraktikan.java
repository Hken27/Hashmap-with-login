package Modul4;

import java.util.*;

public class DataPraktikan {

    HashMap<String, String> tabelData;
    
    public DataPraktikan() {
        tabelData = new HashMap<String, String>();
    }
    
    public boolean tambahData(String nimPraktikan, String namaAslab) {
        if (nimPraktikan.contains("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAslab);
            return true;
        }
        return false;
    }
    
    public void editData(String key, String value) {
        tabelData.replace(key, value);
    }

    public boolean hapusData(String key) {
        if (tabelData.containsKey(key)) {
            tabelData.remove(key);
            return true;
        } else {
            return false;
        }
    }
    
    public String getData(String key) {
        return tabelData.get(key);
    }
    
    public boolean tampil(String key) {
        return tabelData.containsKey(key);
    }
    
    public int totalEmail() {
        return tabelData.size();
    }

    public void listNamaAslab() {
        System.out.println("\n--------------------- ");
        System.out.println("Daftar Nama Aslab: ");
        System.out.println("--------------------- ");
        for (String value : tabelData.values()) {
            String[] splitData = value.split("\\|");
            System.out.println(splitData[1].trim());
        }
    }

    public void listNimPraktikan() {
        System.out.println("\n--------------------- ");
        System.out.println("Daftar NIM Praktikan: ");
        System.out.println("--------------------- ");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }

    public String jumlahData() {
        return null;
    }

    public void listNim() {
    }

    public boolean tambahData(String nim, String namaDepan, String namaBelakang, String namaAslab) {
        return false;
    }
    
}