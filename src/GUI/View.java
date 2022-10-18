package GUI;
import filecompressor.Compressed;
import filecompressor.Decompressor;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class View extends JFrame implements ActionListener{
    JButton compress;
    JButton dcompress;
    View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compress = new JButton("Select a file to compress");
        compress.addActionListener(this);
        compress.setBounds(20, 100, 200, 30);
        dcompress = new JButton("Selet a file to decompress");
        dcompress.addActionListener(this);
        dcompress.setBounds(250, 100, 200, 30);
        
        this.add(compress);
        this.add(dcompress);
        this.setSize(500,500);
        this.getContentPane().setBackground(Color.blue);
    }
    @Override 
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == compress) {
          JFileChooser choose = new JFileChooser();
          int response = choose.showSaveDialog(null);
          if(response == JFileChooser.APPROVE_OPTION) {
              File file = new File(choose.getSelectedFile().getAbsolutePath());
              System.out.print(file);
              try {
                  Compressed.method(file);
                  JOptionPane.showMessageDialog(null, "Compression Successful");
              } catch(Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.toString());
              }
          }
      }  if(e.getSource() == dcompress) {
          JFileChooser choose = new JFileChooser();
          int response = choose.showSaveDialog(null);
          if(response == JFileChooser.APPROVE_OPTION) {
              File file = new File(choose.getSelectedFile().getAbsolutePath());
              System.out.print(file);
              try {
                  Decompressor.method(file);
                  JOptionPane.showMessageDialog(null, "Decompression Successful");
              } catch(Exception ex) {
                  JOptionPane.showMessageDialog(null, ex.toString());
              }
          }
      }
    }
    public static void main(String [] args) {
        View frame = new View();
        frame.setVisible(true);
    }
}
