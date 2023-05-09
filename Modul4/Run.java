package Modul4;

import java.util.*;

public class Run {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DataPraktikan dataPraktikan = new DataPraktikan();
        String username, password;
        boolean loginSuccess = false;

        do {
            System.out.println("\n\t\t===================");
            System.out.print("\t\t| Username: ");
            username = input.nextLine();
            System.out.print("\t\t| Password: ");
            password = input.nextLine();
            System.out.println("\t\t===================");

            if (username.equals("a") && password.equals("123")) {
                System.out.println("\n\t\tLogin berhasil.");
                System.out.println("\t\t...............\n\n");
                loginSuccess = true;
            } else {
                System.out.println("\n\t\tLogin gagal.");
                System.out.println("\t\t............\n\n");
            }
        } while (!loginSuccess);

        int pilihan = 0;
        
        do {
            System.out.println(">>== Menu ==<<");
            System.out.println("==============");
            System.out.println("1. Tambah Data");
            System.out.println("2. Ubah Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Lihat Data Nim Praktikan");
            System.out.println("6. Lihat Data Nama Aslab");
            System.out.println("7. Jumlah Data");
            System.out.println("8. Keluar");
            System.out.println("\n");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    // System.out.println("-----------------");
                    // System.out.print("Masukkan Nama: ");
                    // String nama = input.next();
                    // System.out.print("Masukkan NIM: ");
                    // String nim = input.next();
                    // System.out.print("Nama Aslab: ");
                    // String aslab = input.next();
                    // dataPraktikan.tambahData(nim, nama + " | " + "Aslab : " + aslab);
                    // System.out.println("\n----------------------------- ");
                    // System.out.println("Data berhasil ditambahkan!");
                    // System.out.println("----------------------------- ");

                    System.out.println("= Tambah Data =");
                    System.out.print("NIM       : ");
                    String nim = input.next();
                    System.out.print("Nama      : ");
                    String nama = input.next();
                    System.out.print("Nama Aslab: ");
                    String aslab = input.next();

                    // Memisahkan nama menjadi dua kata menggunakan method split()
                    String[] namaArray = nama.split(" ");
                    String namaDepan = " ";
                    String namaBelakang = " ";
                    if (namaArray.length == 2) {
                        namaDepan = namaArray[0];
                        namaBelakang = namaArray[1];
                    } else {
                        System.out.println("Format nama tidak valid. Harap masukkan dua kata.");
                        return;
                    }

                    // Menambahkan data ke objek dataPraktikan
                    if (dataPraktikan.tambahData(nim, namaDepan, namaBelakang, aslab)) {
                        System.out.println("\n----------------------------- ");
                        System.out.println("Data berhasil ditambahkan!");
                        System.out.println("----------------------------- ");
                    } else {
                        System.out.println("NIM sudah terdaftar.");
                    }
                break;

                case 2:
                    System.out.print("\nMasukkan NIM yang ingin diubah: ");
                    nim = input.next();
                    if (dataPraktikan.tampil(nim)) {
                        System.out.print("Masukkan Nama baru: ");
                        nama = input.next();
                        System.out.print("Masukkan Nama Aslab baru: ");
                        aslab = input.next();
                        dataPraktikan.editData(nim, nama + " | " + "Aslab : " + aslab);
                        System.out.println("----------------------------- ");
                        System.out.println("Data berhasil diubah!");
                        System.out.println("----------------------------- ");
                    } else {
                        System.out.println("Data dengan NIM tersebut tidak ditemukan.");
                    }
                break;

                case 3:
                    System.out.println("\n---------------------------------- ");
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    nim = input.next();
                    System.out.println("---------------------------------- ");
                    if (dataPraktikan.tampil(nim)) {
                        dataPraktikan.hapusData(nim);
                        System.out.println("----------------------------- ");
                        System.out.println("Data berhasil dihapus!");
                        System.out.println("----------------------------- ");
                    } else {
                        System.out.println("----------------------------- ");
                        System.out.println("Data dengan NIM tersebut tidak ditemukan.");
                        System.out.println("----------------------------- ");
                    }
                break;   
                    
                case 4:
                    System.out.println("\n--------------------- ");
                    System.out.println("Daftar Data Praktikan ");
                    System.out.println("--------------------- ");
                    System.out.println("Total data yang berhasil diinputkan : " + dataPraktikan.totalEmail());
                    for (String nimPraktikan : dataPraktikan.tabelData.keySet()) {
                        System.out.println("Nim : " + nimPraktikan + " | " + "Nama Praktikum : " + dataPraktikan.getData(nimPraktikan));
                        System.out.println("----------------------------------- ");
                    }
                break;

                case 5:
                    dataPraktikan.listNimPraktikan();
                break;

                case 6:
                    dataPraktikan.listNamaAslab();
                break;

                case 7:
                    System.out.println("\n--------------------- ");
                    System.out.println("Jumlah data praktikan : " + dataPraktikan.totalEmail());
                    System.out.println("--------------------- ");
                    break;
                    
                    case 8:
                    System.out.println("\t----------------");
                    System.out.println("\t|Terima kasih! |");
                    System.out.println("\t----------------");
                break;

                default:
                    System.out.println("\t----------------------");
                    System.out.println("\t|Pilihan tidak valid!|");
                    System.out.println("\t----------------------");
            }

            System.out.println();

        } while (pilihan != 8);
    }

}