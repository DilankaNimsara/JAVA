/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmanagement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author 2017is014
 */
public class Sales extends javax.swing.JFrame {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    float panel_2;
    float panel_1=0;

    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
        con = DBconnect.getConnection();
        fillcombobox();
        setLogo();
        showdate();
        showTime();
        Random();
        progressbar();
    }

    public Sales(String name) {
        initComponents();
        jLabel7.setText(name);
        con = DBconnect.getConnection();
        fillcombobox();
        setLogo();
        showdate();
        showTime();
        Random();
        progressbar();
        
    }

    // genarate random number
    String id;
    public void Random() {
        Random rd = new Random();
        id = "" + rd.nextInt(1000000 + 1);
    }
    // set image to title bar

    private void setLogo() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icons/logo.jpg")));
    }

    // show date
    void showdate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        jLabel9.setText(s.format(d));

    }
    // display target---------------------
    public void progressbar(){
        try {
            String sql="Select * from salesperson where Username='"+jLabel7.getText()+"'";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                float soltbill=rs.getFloat(8);
                float target=rs.getFloat(7);
                
                float p=(soltbill/target)*100;
                int x=(int)p;
                jLabel11.setText(String.valueOf(x)+"%");
                jProgressBar1.setValue(x);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }
    
    // clear fields
    public void clear(){
        jTextField27.setText("");jTextField1.setText("");
        jTextField2.setText("");jTextField28.setText("");
        jTextField3.setText("");jTextField29.setText("");
        jTextField4.setText("");jTextField30.setText("");
        jTextField5.setText("");jTextField31.setText("");
        jTextField6.setText("");jTextField32.setText("");
        jTextField7.setText("");jTextField33.setText("");
        jTextField8.setText("");jTextField34.setText("");
        jTextField9.setText("");jTextField35.setText("");
        jTextField10.setText("");jTextField36.setText("");
        jTextField11.setText("");jTextField37.setText("");
        jTextField12.setText("");jTextField38.setText("");
        jTextField13.setText("");jTextField39.setText("");
        jTextField14.setText("");jTextField40.setText("");
        jTextField15.setText("");jTextField41.setText("");
        jTextField16.setText("");jTextField42.setText("");
        jTextField17.setText("");jTextField43.setText("");
        jTextField18.setText("");jTextField44.setText("");
        jTextField19.setText("");jTextField45.setText("");
        jTextField20.setText("");jTextField46.setText("");
        jTextField21.setText("");jTextField47.setText("");
        jTextField22.setText("");
        jTextField23.setText("");jTextField25.setText("");
        jTextField24.setText("");jTextField26.setText("");    
    }

    //show time
    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                java.util.Date d = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                jLabel10.setText(s.format(d));
            }
        }).start();

    }

    
    // set values to combobox
    public void fillcombobox() {
        try {
            String sql = "select * from itemprice";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String item1 = rs.getString("item");
                jComboBox1.addItem(item1);
                String item2 = rs.getString("item");
                jComboBox2.addItem(item2);
                String item3 = rs.getString("item");
                jComboBox3.addItem(item3);
                String item4 = rs.getString("item");
                jComboBox4.addItem(item4);
                String item5 = rs.getString("item");
                jComboBox5.addItem(item5);
                String item6 = rs.getString("item");
                jComboBox6.addItem(item6);
                String item7 = rs.getString("item");
                jComboBox12.addItem(item7);
                String item8 = rs.getString("item");
                jComboBox13.addItem(item8);
                String item9 = rs.getString("item");
                jComboBox9.addItem(item9);
                String item10 = rs.getString("item");
                jComboBox10.addItem(item10);
                String item11 = rs.getString("item");
                jComboBox11.addItem(item11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // combobox 1 select
    public void combobox1Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox1.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField47.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 2 select
    public void combobox2Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox2.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField37.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 3 select
    public void combobox3Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox3.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField38.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 4 select
    public void combobox4Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox4.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField39.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 5 select
    public void combobox5Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox5.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField40.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    // combobox 6 select

    public void combobox6Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox6.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField41.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 7 select
    public void combobox7Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox12.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField42.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 8 select
    public void combobox8Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox13.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField43.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 9 select
    public void combobox9Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox9.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField44.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 10 select
    public void combobox10Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox10.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField45.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    // combobox 11 select
    public void combobox11Select() {
        try {
            String sql = "select * from itemprice where item=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, (String) jComboBox11.getSelectedItem());
            rs = ps.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("price");
                jTextField46.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void update() {
        try {
            String sql = "select * from salesperson where Username= '" + jLabel7.getText() + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String item = rs.getString("soltbill");
                float t = Float.valueOf(item);
                float tot = t + Float.valueOf(jTextField48.getText());

                try {
                    String sql2 = "update salesperson set soltbill='" + tot + "'where Username='" + jLabel7.getText() + "'";
                    ps = con.prepareStatement(sql2);
                    ps.execute();
                    ps.close();
                    rs.close();
                    //JOptionPane.showMessageDialog(this, "updated");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Update fail", "Error", JOptionPane.ERROR_MESSAGE);
                }
                

                rs.close();
                ps.close();
            } else {
                JOptionPane.showMessageDialog(this, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
public void item1(){
            float price = Float.valueOf(jTextField47.getText());
        int qty = Integer.valueOf(jTextField1.getText());
        if (jTextField2.getText().equals("")) {
            float tot = price * qty;
            jTextField3.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField2.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField3.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField47.getText()) * Float.valueOf(jTextField1.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "1");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox1.getSelectedItem());
            ps.setString(5, jTextField1.getText());
            ps.setString(6, jTextField47.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField3.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append("///////////////////////////////////////////////////////////////////////////////////////////////// \n"
               
                + "========================================= \n"
                + "========================================= \n"
                +"Item\tPrice\tQTY\tTot\n \n"
                + (String) jComboBox1.getSelectedItem()+"\t"+jTextField47.getText()+"\t"+jTextField1.getText()+"\t"+jTextField3.getText()+"\n");

}

public void item2(){
        float price = Float.valueOf(jTextField37.getText());
        int qty = Integer.valueOf(jTextField4.getText());
        if (jTextField5.getText().equals("")) {
            float tot = price * qty;
            jTextField6.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField5.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField6.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField37.getText()) * Float.valueOf(jTextField4.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox2.getSelectedItem());
            ps.setString(5, jTextField4.getText());
            ps.setString(6, jTextField37.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField6.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
         jTextArea1.append((String) jComboBox2.getSelectedItem()+"\t"+jTextField37.getText()+"\t"+jTextField4.getText()+"\t"+jTextField6.getText()+"\n");

}

public void item3(){
 float price = Float.valueOf(jTextField38.getText());
        int qty = Integer.valueOf(jTextField7.getText());
        if (jTextField8.getText().equals("")) {
            float tot = price * qty;
            jTextField9.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField8.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField9.setText(String.valueOf(netTotal));
        }
        float total = Float.valueOf(jTextField38.getText()) * Float.valueOf(jTextField7.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "2");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox3.getSelectedItem());
            ps.setString(5, jTextField7.getText());
            ps.setString(6, jTextField38.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField9.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        jTextArea1.append((String) jComboBox3.getSelectedItem()+"\t"+jTextField38.getText()+"\t"+jTextField7.getText()+"\t"+jTextField9.getText()+"\n");
}

public void item4(){
float price = Float.valueOf(jTextField39.getText());
        int qty = Integer.valueOf(jTextField10.getText());
        if (jTextField11.getText().equals("")) {
            float tot = price * qty;
            jTextField12.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField11.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField12.setText(String.valueOf(netTotal));
        }
        float total = Float.valueOf(jTextField39.getText()) * Float.valueOf(jTextField10.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "3");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox4.getSelectedItem());
            ps.setString(5, jTextField10.getText());
            ps.setString(6, jTextField39.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField12.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append((String) jComboBox4.getSelectedItem()+"\t"+jTextField39.getText()+"\t"+jTextField10.getText()+"\t"+jTextField12.getText()+"\n");
        
}

public void item5(){
float price = Float.valueOf(jTextField40.getText());
        int qty = Integer.valueOf(jTextField13.getText());
        if (jTextField14.getText().equals("")) {
            float tot = price * qty;
            jTextField15.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField14.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField15.setText(String.valueOf(netTotal));
        }
        float total = Float.valueOf(jTextField40.getText()) * Float.valueOf(jTextField13.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "4");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox5.getSelectedItem());
            ps.setString(5, jTextField13.getText());
            ps.setString(6, jTextField40.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField15.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        

        jTextArea1.append((String) jComboBox5.getSelectedItem()+"\t"+jTextField40.getText()+"\t"+jTextField13.getText()+"\t"+jTextField15.getText()+"\n");
        
}

public void item6(){
float price = Float.valueOf(jTextField41.getText());
        int qty = Integer.valueOf(jTextField16.getText());
        if (jTextField17.getText().equals("")) {
            float tot = price * qty;
            jTextField18.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField17.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField18.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField41.getText()) * Float.valueOf(jTextField16.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "5");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox6.getSelectedItem());
            ps.setString(5, jTextField16.getText());
            ps.setString(6, jTextField41.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField18.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append((String) jComboBox6.getSelectedItem()+"\t"+jTextField41.getText()+"\t"+jTextField16.getText()+"\t"+jTextField18.getText()+"\n");
        
}

public void item7(){
float price = Float.valueOf(jTextField42.getText());
        int qty = Integer.valueOf(jTextField19.getText());
        if (jTextField24.getText().equals("")) {
            float tot = price * qty;
            jTextField25.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField24.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField25.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField42.getText()) * Float.valueOf(jTextField19.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "6");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox12.getSelectedItem());
            ps.setString(5, jTextField19.getText());
            ps.setString(6, jTextField42.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField25.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        jTextArea1.append((String) jComboBox12.getSelectedItem()+"\t"+jTextField42.getText()+"\t"+jTextField19.getText()+"\t"+jTextField25.getText()+"\n");
        
}

public void item8(){
float price = Float.valueOf(jTextField43.getText());
        int qty = Integer.valueOf(jTextField20.getText());
        if (jTextField23.getText().equals("")) {
            float tot = price * qty;
            jTextField26.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField23.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField26.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField43.getText()) * Float.valueOf(jTextField20.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "7");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox13.getSelectedItem());
            ps.setString(5, jTextField20.getText());
            ps.setString(6, jTextField43.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField25.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        jTextArea1.append((String) jComboBox13.getSelectedItem()+"\t"+jTextField43.getText()+"\t"+jTextField20.getText()+"\t"+jTextField26.getText()+"\n");
        
}

public void item9(){
float price = Float.valueOf(jTextField44.getText());
        int qty = Integer.valueOf(jTextField21.getText());
        if (jTextField22.getText().equals("")) {
            float tot = price * qty;
            jTextField27.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField22.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField27.setText(String.valueOf(netTotal));
        }
        float total = Float.valueOf(jTextField44.getText()) * Float.valueOf(jTextField21.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "8");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox9.getSelectedItem());
            ps.setString(5, jTextField21.getText());
            ps.setString(6, jTextField44.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField27.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append((String) jComboBox9.getSelectedItem()+"\t"+jTextField44.getText()+"\t"+jTextField21.getText()+"\t"+jTextField27.getText()+"\n");
        
}

public void item10(){
float price = Float.valueOf(jTextField45.getText());
        int qty = Integer.valueOf(jTextField31.getText());
        if (jTextField33.getText().equals("")) {
            float tot = price * qty;
            jTextField35.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField33.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField35.setText(String.valueOf(netTotal));
        }

        float total = Float.valueOf(jTextField45.getText()) * Float.valueOf(jTextField31.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "9");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox10.getSelectedItem());
            ps.setString(5, jTextField31.getText());
            ps.setString(6, jTextField45.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField35.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append((String) jComboBox10.getSelectedItem()+"\t"+jTextField45.getText()+"\t"+jTextField31.getText()+"\t"+jTextField35.getText()+"\n");
        
}

public void item11(){
float price = Float.valueOf(jTextField46.getText());
        int qty = Integer.valueOf(jTextField32.getText());
        if (jTextField34.getText().equals("")) {
            float tot = price * qty;
            jTextField36.setText(String.valueOf(tot));
        } else {
            float discount = Float.valueOf(jTextField34.getText());
            float tot = price * qty;
            float dis = (tot * discount) / 100;
            float netTotal = tot - dis;
            jTextField36.setText(String.valueOf(netTotal));
        }
float total = Float.valueOf(jTextField46.getText()) * Float.valueOf(jTextField32.getText());
        try {

            String sql = "Insert into sales(id,date,time,item,quantity,price,total,total_with_discount) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, id + "10");
            ps.setString(2, jLabel9.getText());
            ps.setString(3, jLabel10.getText());
            ps.setString(4, (String) jComboBox11.getSelectedItem());
            ps.setString(5, jTextField32.getText());
            ps.setString(6, jTextField46.getText());
            ps.setString(7, String.valueOf(total));
            ps.setString(8, jTextField36.getText());
            ps.execute();
            ps.close();
            //JOptionPane.showMessageDialog(this, "insetted");
        } catch (Exception e) {
        }
        
        jTextArea1.append((String) jComboBox11.getSelectedItem()+"\t"+jTextField46.getText()+"\t"+jTextField32.getText()+"\t"+jTextField36.getText()+"\n");
        
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField30 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField32 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox13 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Management System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Next Coustomer >>");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField34.setForeground(new java.awt.Color(0, 0, 255));
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField36.setEditable(false);
        jTextField36.setForeground(new java.awt.Color(255, 0, 0));
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setText("0");

        jTextField35.setEditable(false);
        jTextField35.setForeground(new java.awt.Color(255, 0, 0));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText("0");
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });

        jTextField33.setForeground(new java.awt.Color(0, 0, 255));
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField22.setForeground(new java.awt.Color(0, 0, 255));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField27.setEditable(false);
        jTextField27.setForeground(new java.awt.Color(255, 0, 0));
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setText("0");

        jTextField26.setEditable(false);
        jTextField26.setForeground(new java.awt.Color(255, 0, 0));
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setText("0");

        jTextField23.setForeground(new java.awt.Color(0, 0, 255));
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField24.setForeground(new java.awt.Color(0, 0, 255));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField25.setEditable(false);
        jTextField25.setForeground(new java.awt.Color(255, 0, 0));
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText("0");

        jTextField18.setEditable(false);
        jTextField18.setForeground(new java.awt.Color(255, 0, 0));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("0");

        jTextField17.setForeground(new java.awt.Color(0, 0, 255));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField2.setForeground(new java.awt.Color(0, 0, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField5.setForeground(new java.awt.Color(0, 0, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField8.setForeground(new java.awt.Color(0, 0, 255));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField11.setForeground(new java.awt.Color(0, 0, 255));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField14.setForeground(new java.awt.Color(0, 0, 255));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jTextField3.setEditable(false);
        jTextField3.setForeground(new java.awt.Color(255, 0, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");

        jTextField6.setEditable(false);
        jTextField6.setForeground(new java.awt.Color(255, 0, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");

        jTextField9.setEditable(false);
        jTextField9.setForeground(new java.awt.Color(255, 0, 0));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");

        jTextField12.setEditable(false);
        jTextField12.setForeground(new java.awt.Color(255, 0, 0));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");

        jTextField15.setEditable(false);
        jTextField15.setForeground(new java.awt.Color(255, 0, 0));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Discount(%)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Total (RS)");

        jTextField37.setEditable(false);
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField38.setEditable(false);
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField39.setEditable(false);
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField40.setEditable(false);
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField41.setEditable(false);
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField42.setEditable(false);
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField43.setEditable(false);
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField44.setEditable(false);
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField45.setEditable(false);
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField46.setEditable(false);
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Price (RS)");

        jTextField47.setEditable(false);
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Item ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 2" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 3" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 4" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 5" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 6" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 7" }));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 8" }));
        jComboBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox13ActionPerformed(evt);
            }
        });

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 9" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 10" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 11" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(102, 0, 102));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Total");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(102, 0, 102));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Add more Items");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox10, 0, 129, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField20)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField6)
                            .addComponent(jTextField9)
                            .addComponent(jTextField26)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField15)
                                    .addComponent(jTextField18)
                                    .addComponent(jTextField25)
                                    .addComponent(jTextField36)
                                    .addComponent(jTextField35)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jTextField27))))
                        .addGap(173, 173, 173))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField7)
                                .addComponent(jTextField13)
                                .addComponent(jTextField31)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton13.setBackground(new java.awt.Color(255, 153, 153));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salesmanagement/Icons/logout.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("logged as");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("jLabel7");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total :");

        jTextField48.setEditable(false);
        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("RS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel9");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("jLabel10");

        jProgressBar1.setToolTipText("adad");
        jProgressBar1.setString("");

        jLabel11.setForeground(new java.awt.Color(255, 204, 204));
        jLabel11.setText("jLabel11");

        jLabel12.setForeground(new java.awt.Color(255, 204, 204));
        jLabel12.setText("Target Completed");

        jButton15.setBackground(new java.awt.Color(102, 0, 102));
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("PRINT");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText("");
        jTextField48.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print data");
        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.PORTRAIT);
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(1, 1);
                jLabel1.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        item1();
        item2();
        item3();
        item4();
        item5();
        item6();
        item7();
        item8();
        item9();
        item10();
        item11();

        
        jTextArea1.append("\n=========================================\n"
            + "Date : "+jLabel9.getText()+"\t Time : "+jLabel10.getText()+"\n"
            + "- - - - - - - - - - - - - - - -THANK YOU- - - - - - - - - - - - - - - -\t \n\n"
            + "\t   Come again! \t\n");
        panel_2 = Float.valueOf(jTextField3.getText()) + Float.valueOf(jTextField6.getText()) + 
                Float.valueOf(jTextField9.getText()) + Float.valueOf(jTextField12.getText()) + 
                Float.valueOf(jTextField15.getText()) + Float.valueOf(jTextField18.getText()) + 
                Float.valueOf(jTextField25.getText()) + Float.valueOf(jTextField26.getText()) + 
                Float.valueOf(jTextField27.getText()) + Float.valueOf(jTextField35.getText()) + 
                Float.valueOf(jTextField36.getText());
        
        jTextField48.setText(String.valueOf(panel_1+panel_2));
        
        update();
        clear();
        progressbar();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        combobox11Select();
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        combobox10Select();
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        combobox9Select();
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
        combobox8Select();
    }//GEN-LAST:event_jComboBox13ActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        combobox7Select();
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        combobox6Select();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        combobox5Select();
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        combobox4Select();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        combobox3Select();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        combobox2Select();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        combobox1Select();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        item1();
        item2();
        item3();
        item4();
        item5();
        item6();
        item7();
        item8();
        item9();
        item10();
        item11();
        panel_1 = Float.valueOf(jTextField3.getText()) + Float.valueOf(jTextField6.getText()) + 
                Float.valueOf(jTextField9.getText()) + Float.valueOf(jTextField12.getText()) + 
                Float.valueOf(jTextField15.getText()) + Float.valueOf(jTextField18.getText()) + 
                Float.valueOf(jTextField25.getText()) + Float.valueOf(jTextField26.getText()) + 
                Float.valueOf(jTextField27.getText()) + Float.valueOf(jTextField35.getText()) + 
                Float.valueOf(jTextField36.getText());
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
