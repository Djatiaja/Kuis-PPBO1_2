import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.text.SimpleDateFormat;
import java.util.*;

public class Window {
    JFrame jFrame;
    boolean login=false;
    JPanel jPanel;
    ArrayList<Buku> listBuku = new ArrayList<>();
    public Window(JPanel jPanel){
        this.jFrame = new JFrame();
        this.jPanel = jPanel;
        Buku buku1 = new Buku("B001","Cara menjadi orang kaya part 1","Joko dadi","Ekonomi","12-12-1998");
        Buku buku2 = new Buku("B002","Cara menjadi orang kaya part 2", "Joko dadi","Ekonomi","12-12-1998");
        this.listBuku.add(buku1);
        this.listBuku.add(buku2);
        dataDisplay();
        setjFrame();
    }
    public void dataDisplay(){
        final String[][][] data = {dataHandle()};
        String[] coloumnNames= {
                "BukuId", "Judul", "Penulis", "Genre", "Tanggal terbit", "Tanggal ditambahkan"
        };

        JButton jButton = new JButton("Edit");
        jButton.setSize(10,10);

        jButton.addActionListener(e -> {
            data[0] = Arrays.copyOf(data[0], data[0].length + 1);
            data[0][2] = listBuku.get(1).getData();
        });
        JTable tabel = new JTable(data[0], coloumnNames);
        tabel.setBounds(30,30,200,300);
        JScrollPane sp = new JScrollPane(tabel);

        jPanel.add(jButton);
        jPanel.add(sp);
        jFrame.add(jPanel);
    }
    public void setjFrame(){
        jFrame.setSize(800,400);
        jFrame.setResizable(false);
        jFrame.requestFocus();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Inventaris buku");
        jFrame.setVisible(true);
    }

    public String[][] dataHandle(){
        String[][] data={
                this.listBuku.get(0).getData(),
                this.listBuku.get(1).getData()};
        return data;
    };

    public void inputJframe(){
        JButton jButton = new JButton("Edit");
        jButton.setSize(10,10);
        jPanel.add(jButton);
        jFrame.add(jPanel);
        jFrame.revalidate();
    }
}
