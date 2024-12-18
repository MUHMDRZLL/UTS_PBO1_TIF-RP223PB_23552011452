
package manajementransportasi;

public class Manajementransportasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   from abc import ABC, abstractmethod
from typing import List

# Interface untuk menghitung biaya perjalanan
class BiayaPerjalanan(ABC):
    @abstractmethod
    def hitung_biaya(self, jarak: float, tarif_per_km: float) -> float:
        pass

# Abstraksi untuk kendaraan
class Kendaraan(ABC):
    def __init__(self, id_kendaraan: str, nama: str, kapasitas: int):
        self.id_kendaraan = id_kendaraan
        self.nama = nama
        self.kapasitas = kapasitas

    @abstractmethod
    def tampilkan_info(self):
        pass

# Implementasi kendaraan mobil
class Mobil(Kendaraan, BiayaPerjalanan):
    def __init__(self, id_kendaraan: str, nama: str, kapasitas: int, tipe: str):
        super().__init__(id_kendaraan, nama, kapasitas)
        self.tipe = tipe

    def tampilkan_info(self):
        print(f"ID Kendaraan: {self.id_kendaraan}")
        print(f"Nama Kendaraan: {self.nama}")
        print(f"Kapasitas: {self.kapasitas} orang")
        print(f"Tipe: {self.tipe}")

    def hitung_biaya(self, jarak: float, tarif_per_km: float) -> float:
        return jarak * tarif_per_km

# Implementasi kendaraan bus
class Bus(Kendaraan, BiayaPerjalanan):
    def __init__(self, id_kendaraan: str, nama: str, kapasitas: int, jalur: str):
        super().__init__(id_kendaraan, nama, kapasitas)
        self.jalur = jalur

    def tampilkan_info(self):
        print(f"ID Kendaraan: {self.id_kendaraan}")
        print(f"Nama Kendaraan: {self.nama}")
        print(f"Kapasitas: {self.kapasitas} orang")
        print(f"Jalur: {self.jalur}")

    def hitung_biaya(self, jarak: float, tarif_per_km: float) -> float:
        return jarak * tarif_per_km

# Kelas untuk manajemen rute
class Rute:
    def __init__(self, asal: str, tujuan: str, jarak: float):
        self.asal = asal
        self.tujuan = tujuan
        self.jarak = jarak

    def tampilkan_rute(self):
        print(f"Rute: {self.asal} -> {self.tujuan}")
        print(f"Jarak: {self.jarak} km")

# Kelas untuk laporan perjalanan
class LaporanPerjalanan:
    def __init__(self):
        self.perjalanan = []

    def tambah_perjalanan(self, kendaraan: Kendaraan, rute: Rute, biaya: float):
        self.perjalanan.append({
            "kendaraan": kendaraan,
            "rute": rute,
            "biaya": biaya
        })

    def tampilkan_laporan(self):
        print("Laporan Perjalanan:")
        for perjalanan in self.perjalanan:
            kendaraan = perjalanan["kendaraan"]
            rute = perjalanan["rute"]
            print(f"\nKendaraan: {kendaraan.nama} (ID: {kendaraan.id_kendaraan})")
            rute.tampilkan_rute()
            print(f"Biaya Perjalanan: {perjalanan['biaya']}")

# Kelas untuk registrasi kendaraan
class RegistrasiKendaraan:
    def __init__(self):
        self.kendaraan_list = []

    def tambah_kendaraan(self, kendaraan: Kendaraan):
        self.kendaraan_list.append(kendaraan)

    def tampilkan_kendaraan(self):
        print("Daftar Kendaraan:")
        for kendaraan in self.kendaraan_list:
            kendaraan.tampilkan_info()
            print("------")

# Contoh penggunaan
if __name__ == "__main__":
    # Registrasi kendaraan
    reg = RegistrasiKendaraan()
    
    mobil1 = Mobil("M001", "Toyota Avanza", 7, "MPV")
    bus1 = Bus("B001", "Bus Trans Jakarta", 30, "Jakarta - Bogor")
    
    reg.tambah_kendaraan(mobil1)
    reg.tambah_kendaraan(bus1)
    
    reg.tampilkan_kendaraan()

    # Manajemen rute dan biaya
    rute1 = Rute("Jakarta", "Bandung", 150)
    rute2 = Rute("Jakarta", "Bogor", 50)
    
    tarif_per_km_mobil = 1000  # Tarif per km untuk mobil
    tarif_per_km_bus = 800  # Tarif per km untuk bus
    
    biaya_mobil1 = mobil1.hitung_biaya(rute1.jarak, tarif_per_km_mobil)
    biaya_bus1 = bus1.hitung_biaya(rute2.jarak, tarif_per_km_bus)
    
    # Laporan perjalanan
    laporan = LaporanPerjalanan()
    laporan.tambah_perjalanan(mobil1, rute1, biaya_mobil1)
    laporan.tambah_perjalanan(bus1, rute2, biaya_bus1)
    
    laporan.tampilkan_laporan()// TODO code application logic here
    }
    
}
