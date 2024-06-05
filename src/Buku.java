import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Buku {
    String BukuId, judul,penulis, genre;
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date tglTerbit, tglTambah;

    public Buku(String bukuId, String judul, String penulis, String genre, String  tglTerbit) {
        BukuId = bukuId;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        try {
            this.tglTerbit = simpleDateFormat.parse(tglTerbit);
            this.tglTambah = simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String[] getData(){
        return new String[]{this.BukuId, this.judul,this.penulis,this.genre, String.valueOf(this.tglTerbit), String.valueOf(this.tglTambah)};
    }
}
