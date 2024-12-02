import java.util.ArrayList;
import java.util.List;

class Mahasiswa {
    String nama;
    String nim;
    private final List<Matkul> daftarMatkul;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.daftarMatkul = new ArrayList<>();
    }

    public void daftarMatkul(Matkul matkul) {
        daftarMatkul.add(matkul);
        matkul.tambahMahasiswa(this);
    }

    public void tampilkanMatkul() {
        System.out.println("Mata kuliah yang diambil oleh " + nama + " (" + nim + "):");
        for (Matkul matkul : daftarMatkul) {
            System.out.println("- " + matkul.getNama());
        }
    }
}

class Matkul {
    private final String nama;
    private final Pengajar pengajar;
    private final List<Mahasiswa> mahasiswa;

    public Matkul(String nama, String kode, Pengajar pengajar) {
        this.nama = nama;
        this.pengajar = pengajar;
        this.mahasiswa = new ArrayList<>();
    }

    public void tambahMahasiswa(Mahasiswa mhs) {
        mahasiswa.add(mhs);
    }

    public String getNama() {
        return nama;
    }

    public Pengajar getPengajar() {
        return pengajar;
    }

    public void tampilkanMahasiswa() {
        System.out.println("Mahasiswa yang terdaftar di mata kuliah " + nama + ":");
        for (Mahasiswa mhs : mahasiswa) {
            System.out.println("- " + mhs.nama + " (" + mhs.nim + ")");
        }
    }
}

class Pengajar {
    private final String nama;

    public Pengajar(String nama, int idPengajar) {
        this.nama = nama;
    }

    public void ajar() {
        System.out.println(nama + " sedang mengajar.");
    }

    public String getNama() {
        return nama;
    }
}

public class main {
    public static void main(String[] args) {
        Pengajar pengajar1 = new Pengajar("Yoga", 312310569);
        Pengajar pengajar2 = new Pengajar("Agus", 312310597);

        Matkul matkul1 = new Matkul("Pemrograman Web", "CS101", pengajar1);
        Matkul matkul2 = new Matkul("Pemrograman Mobile", "CS102", pengajar2);

        Mahasiswa mhs1 = new Mahasiswa("Radit", "312310644");
        Mahasiswa mhs2 = new Mahasiswa("Romi", "312310581");

        mhs1.daftarMatkul(matkul1);
        mhs1.daftarMatkul(matkul2);
        mhs2.daftarMatkul(matkul1);

        mhs1.tampilkanMatkul();
        mhs2.tampilkanMatkul();

        matkul1.tampilkanMahasiswa();
        matkul2.tampilkanMahasiswa();

        System.out.println("Pengajar mata kuliah " + matkul1.getNama() + ": " + matkul1.getPengajar().getNama());
        pengajar1.ajar();
        System.out.println("Pengajar mata kuliah " + matkul2.getNama() + ": " + matkul2.getPengajar().getNama());
        pengajar2.ajar();
    }
}
