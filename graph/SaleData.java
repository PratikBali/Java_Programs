package com.ComputerBillingSystem;

import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;

public class SaleData extends JFrame{
	
	JLabel imagelogo,imagelogo2,custname,custcontact,custaddress,date,product,serialno,repairing,purchaseprice,sellingprice,benefit,dealer,paidornot,paiddate,updatetableentry,enterino,uppaidornot,upproduct,upspecif,upserialno;
	JTextField txtCustName,txtdate,txtcustcontact,txtcustaddress,txtproduct,txtspecno,txtserialno,txtrepairing,txtpurchaseprice,txtsellingprice,txtbenefit,txtdealer,txtpaidornot,txtpaiddate,txtenterino,txtuppaidornot,txtupproduct,txtupspecif,txtupserialno;
	JTextArea datetext;
	JComboBox item,specif,cmbupproduct,cmbupspecif;
	JButton storedata,confirm,update,delete,addtocart,checkavilability,shoplogo;
	JPanel panel;
	double purchase,sell,benif;
	String strpurchase,strsell,profit,url="jdbc:oracle:thin:@localhost:1521:XE";
	java.util.Date day;
	static boolean checkavail=false,confirmcheck=false;
	static int requiredno=0;
	static int avail=0;
	//JDBC Containts
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	PreparedStatement updateSales = null;
	
	public SaleData() throws ClassNotFoundException{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (InstantiationException e2) {
			
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			
			e2.printStackTrace();
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, "system", "tan13");
			System.out.println("Connection successful:"+con);
			
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			GenerateTable.createTables(con, stmt);
			rs=stmt.executeQuery("select * from VishwaSaleData1");
			System.out.println(rs);
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32,178,170));
		ImageIcon pic=new ImageIcon("v3.jpg");
		ImageIcon pic2=new ImageIcon("pic.jpg");
		final SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy"); 
		final JXDatePicker picker=new JXDatePicker();
		   picker.setDate(Calendar.getInstance().getTime());
	        picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
	        
	        final JXDatePicker picker1=new JXDatePicker();
			   picker1.setDate(Calendar.getInstance().getTime());
		        picker1.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		        picker1.setEditable(false);
		
		custname=new JLabel("Customer Name:");
		custname.setFont(new Font("Serif",Font.ITALIC, 17));
		custcontact=new JLabel("No:");
		custcontact.setFont(new Font("Serif",Font.ITALIC, 17));
		custaddress=new JLabel("Address:");
		custaddress.setFont(new Font("Serif",Font.ITALIC, 17));
		date=new JLabel("Date:");
		date.setFont(new Font("Serif", Font.ITALIC, 17));
		product=new JLabel("Product:");
		product.setFont(new Font("Serif",Font.ITALIC, 17));
		serialno=new JLabel("Serial No:");
		serialno.setFont(new Font("Serif",Font.ITALIC, 17));
		repairing=new JLabel("Repairing:");
		repairing.setFont(new Font("Serif", Font.ITALIC, 17));
		purchaseprice=new JLabel("Purchase Price:");
		purchaseprice.setFont(new Font("Serif",Font.ITALIC, 17));
		sellingprice=new JLabel("Selling Price:");
		sellingprice.setFont(new Font("Serif",Font.ITALIC, 17));
		benefit=new JLabel("Profit:");
		benefit.setFont(new Font("Serif",  Font.ITALIC, 17));
		dealer=new JLabel("Dealer");
		dealer.setFont(new Font("Serif",  Font.ITALIC, 17));
		paidornot=new JLabel("Paid/Unpaid:");
		paidornot.setFont(new Font("Serif",  Font.ITALIC, 17));
		paiddate=new JLabel("Paid Date");
		paiddate.setFont(new Font("Serif", Font.ITALIC, 17));
		updatetableentry=new JLabel("*Update Table Entry*");
		updatetableentry.setFont(new Font("Serif",Font.ITALIC, 17));
		enterino=new JLabel("Enter I_No:");
		enterino.setFont(new Font("Serif", Font.ITALIC, 17));
		uppaidornot=new JLabel("Re-Enter Paid Type:");
		uppaidornot.setFont(new Font("Serif", Font.ITALIC, 17));
		upproduct=new JLabel("Re-Enter Product:");
		upproduct.setFont(new Font("Serif", Font.ITALIC, 17));
		upspecif=new JLabel("Re-Enter Specification:");
		upspecif.setFont(new Font("Serif", Font.ITALIC, 17));
		upserialno=new JLabel("Re-Enter Serial No:");
		upserialno.setFont(new Font("Serif", Font.ITALIC, 17));
		
		
		
		imagelogo=new JLabel(pic,JLabel.CENTER);
		imagelogo2=new JLabel(pic2,JLabel.CENTER);
		
		datetext=new JTextArea();
		
		txtCustName=new JTextField(25);
		txtcustcontact=new JTextField(25);
		
		txtcustcontact.setText("Contact");
		txtcustaddress=new JTextField(25);
		txtcustaddress.setText("NA");
		txtdate=new JTextField(25);
		txtdate.setEditable(false);
		
		txtspecno=new JTextField();
		txtproduct=new JTextField(20);
		txtserialno=new JTextField(20);
		txtserialno.setText("NA");
		txtrepairing=new JTextField(15);
		txtrepairing.setText("NA");
		txtpurchaseprice=new JTextField(10);
		txtpurchaseprice.setEditable(false);
		txtsellingprice=new JTextField(10);
		txtbenefit=new JTextField(10);
		txtbenefit.setEditable(false);
		txtdealer=new JTextField(20);
		txtpaidornot=new JTextField(10);
		txtpaiddate=new JTextField(20);
		txtenterino=new JTextField(10);
		txtuppaidornot=new JTextField(15);
		txtupserialno=new JTextField(20);
		
		//Jcombobox
		item=new JComboBox();
		item.addItem("Select Item");
		item.addItem("HDD Seagate");
		item.addItem("HDD Hitachi");
		item.addItem("HDD WD");
		item.addItem("HDD other");
		item.addItem("DVDWR LG");
		item.addItem("DVDWR Samsung");
		item.addItem("DVDWR Sony");
		item.addItem("DVDWR Asus");
		item.addItem("DVDWR Others");
		item.addItem("RAM DDR1");
		item.addItem("RAM DDR2");
		item.addItem("RAM DDR3");
		item.addItem("RAM Other");
		item.addItem("Keyboard Logitech");
		item.addItem("Keyboard Circle");
		item.addItem("Keyboard Other");
		item.addItem("Mouse");
		item.addItem("AntiVirus Netlux");
		item.addItem("AntiVirus NP");
		item.addItem("AntiVirus QH");
		item.addItem("AntiVirus Norton");
		item.addItem("AntiVirus Other");
		item.addItem("Processor Intel");
		item.addItem("Processor AMD");
		item.addItem("Processor Other");
		item.addItem("Mainboard Gigabyte");
		item.addItem("Mainboard Intel");
		item.addItem("Mainboard Asus");
		item.addItem("Mainboard Other");
		item.addItem("Pendrive Sony");
		item.addItem("Pendrive ScanDisk");
		item.addItem("Pendrive Other");
		item.addItem("Cabinate");
		item.addItem("UPS Asian Power");
		item.addItem("UPS Numeric");
		item.addItem("UPS Other");
		item.addItem("Head Phones");
		item.addItem("Card Reader");
		item.addItem("Desk-Top");
		item.addItem("Desk-Top");
		item.addItem("Desk-Top");
		item.addItem("LCD");
		item.addItem("LCD");
		item.addItem("LCD Acer");
		item.addItem("OTHER");
		
		
		cmbupproduct=new JComboBox();
		cmbupproduct.addItem("HDD Seagate");
		cmbupproduct.addItem("HDD Hitachi");
		cmbupproduct.addItem("HDD WD");
		cmbupproduct.addItem("HDD other");
		cmbupproduct.addItem("DVDWR LG");
		cmbupproduct.addItem("DVDWR Samsung");
		cmbupproduct.addItem("DVDWR Sony");
		cmbupproduct.addItem("DVDWR Asus");
		cmbupproduct.addItem("DVDWR Others");
		cmbupproduct.addItem("RAM DDR1");
		cmbupproduct.addItem("RAM DDR2");
		cmbupproduct.addItem("RAM DDR3");
		cmbupproduct.addItem("RAM Other");
		cmbupproduct.addItem("Keyboard Logitech");
		cmbupproduct.addItem("Keyboard Circle");
		cmbupproduct.addItem("Keyboard Other");
		cmbupproduct.addItem("Mouse");
		cmbupproduct.addItem("AntiVirus Netlux");
		cmbupproduct.addItem("AntiVirus NP");
		cmbupproduct.addItem("AntiVirus QH");
		cmbupproduct.addItem("AntiVirus Norton");
		cmbupproduct.addItem("AntiVirus Other");
		cmbupproduct.addItem("Processor Intel");
		cmbupproduct.addItem("Processor AMD");
		cmbupproduct.addItem("Processor Other");
		cmbupproduct.addItem("Mainboard Gigabyte");
		cmbupproduct.addItem("Mainboard Intel");
		cmbupproduct.addItem("Mainboard Asus");
		cmbupproduct.addItem("Mainboard Other");
		cmbupproduct.addItem("Pendrive Sony");
		cmbupproduct.addItem("Pendrive ScanDisk");
		cmbupproduct.addItem("Pendrive Other");
		cmbupproduct.addItem("Cabinate");
		cmbupproduct.addItem("UPS Asian Power");
		cmbupproduct.addItem("UPS Numeric");
		cmbupproduct.addItem("UPS Other");
		cmbupproduct.addItem("Head Phones");
		cmbupproduct.addItem("Card Reader");
		cmbupproduct.addItem("Desk-Top");
		cmbupproduct.addItem("Desk-Top");
		cmbupproduct.addItem("Desk-Top");
		cmbupproduct.addItem("LCD");
		cmbupproduct.addItem("LCD");
		cmbupproduct.addItem("LCD Acer");
		cmbupproduct.addItem("OTHER");
		
		
		
		specif=new JComboBox();
		specif.addItem("None");
		specif.addItem("512MB");
		specif.addItem("1GB");
		specif.addItem("2GB");
		specif.addItem("4GB");
		specif.addItem("8GB");
		specif.addItem("16GB");
		specif.addItem("32GB");
		specif.addItem("80GB");
		specif.addItem("160GB");
		specif.addItem("250GB");
		specif.addItem("500GB");
		specif.addItem("1TB");
		specif.addItem("2TB");
		specif.addItem("P4");
		specif.addItem("Dual Core");
		specif.addItem("C2D");
		specif.addItem("i3");
		specif.addItem("i4");
		specif.addItem("i5");
		specif.addItem("i7");
		
		
		cmbupspecif=new JComboBox();
		cmbupspecif.addItem("None");
		cmbupspecif.addItem("512MB");
		cmbupspecif.addItem("1GB");
		cmbupspecif.addItem("2GB");
		cmbupspecif.addItem("4GB");
		cmbupspecif.addItem("8GB");
		cmbupspecif.addItem("16GB");
		cmbupspecif.addItem("32GB");
		cmbupspecif.addItem("80GB");
		cmbupspecif.addItem("160GB");
		cmbupspecif.addItem("250GB");
		cmbupspecif.addItem("500GB");
		cmbupspecif.addItem("1TB");
		cmbupspecif.addItem("2TB");
		cmbupspecif.addItem("P4");
		cmbupspecif.addItem("Dual Core");
		cmbupspecif.addItem("C2D");
		cmbupspecif.addItem("i3");
		cmbupspecif.addItem("i4");
		cmbupspecif.addItem("i5");
		cmbupspecif.addItem("i7");
		
		
		
		
		
		storedata=new JButton("Store Data");
		storedata.setFont(new Font("Serif", Font.ITALIC, 17));
		confirm=new JButton("Confirm It!");
		confirm.setFont(new Font("Serif", Font.ITALIC, 17));
		update=new JButton("Update");
		update.setFont(new Font("Serif", Font.ITALIC, 17));
		delete=new JButton("Delete");
		delete.setFont(new Font("Serif", Font.ITALIC, 17));
		addtocart=new JButton("Add to Stock");
		addtocart.setFont(new Font("Serif", Font.ITALIC, 17));
		checkavilability=new JButton("Check For Product Availability");
		checkavilability.setFont(new Font("Serif", Font.ITALIC, 17));
		shoplogo=new JButton();
		//shoplogo.setIcon(new ImageIcon(SaleData.class.getResource("img.png")));
		
		
		
		panel.add(shoplogo).setBounds(30, 10, 640, 140);
		panel.add(addtocart).setBounds(500, 165, 150, 35);
		panel.add(custname).setBounds(30, 160, 120, 30);
		panel.add(txtCustName).setBounds(160, 160, 252, 30);
		panel.add(custaddress).setBounds(30, 200, 100, 30);
		panel.add(txtcustaddress).setBounds(160, 200, 252, 30);
		panel.add(date).setBounds(30, 240, 40, 30);
		panel.add(picker1).setBounds(110, 240, 150, 30);
		panel.add(custcontact).setBounds(270, 240, 30, 30);
		panel.add(txtcustcontact).setBounds(303, 240, 110, 30);
		panel.add(product).setBounds(30, 280, 120, 30);
		panel.add(item).setBounds(160, 280, 150, 25);
		panel.add(txtspecno).setBounds(320, 280, 90, 25);
		panel.add(checkavilability).setBounds(160, 315, 252, 25);
		panel.add(serialno).setBounds(30, 350, 120, 30);
		panel.add(txtserialno).setBounds(160, 350, 252, 30);
		panel.add(repairing).setBounds(30, 390, 120, 30);
		panel.add(txtrepairing).setBounds(160, 390, 252, 30);
		panel.add(purchaseprice).setBounds(30, 430, 120, 30);
		panel.add(txtpurchaseprice).setBounds(160, 430, 70, 30);
		panel.add(sellingprice).setBounds(240, 430, 100, 30);
		panel.add(txtsellingprice).setBounds(350, 430, 62, 30);
		panel.add(benefit).setBounds(30, 470, 120, 30);
		panel.add(txtbenefit).setBounds(160, 470, 252, 30);
		panel.add(dealer).setBounds(30, 510, 120, 30);
		panel.add(txtdealer).setBounds(160, 510, 252, 30);
		panel.add(paidornot).setBounds(30, 550, 120, 30);
		panel.add(txtpaidornot).setBounds(160, 550, 252, 30);
		panel.add(paiddate).setBounds(30, 590, 120, 30);
		panel.add(picker).setBounds(160, 590, 252, 30);
		panel.add(confirm).setBounds(140, 630, 140, 40);
		panel.add(storedata).setBounds(290, 630, 140, 40);
		
		/*panel.add(imagelogo2).setBounds(455, 10, 230, 150);
		panel.add(updatetableentry).setBounds(470, 160, 170, 30);
		panel.add(enterino).setBounds(450, 210, 120, 30);
		panel.add(txtenterino).setBounds(510, 250, 120, 25);
		panel.add(upproduct).setBounds(450, 285, 150, 30);
		panel.add(cmbupproduct).setBounds(510, 330, 120, 30);
		panel.add(upspecif).setBounds(450, 370, 180, 30);
		panel.add(cmbupspecif).setBounds(510, 410, 120, 30);
		panel.add(upserialno).setBounds(450, 450, 150, 30);
		panel.add(txtupserialno).setBounds(510, 490, 120, 30);
		
		panel.add(uppaidornot).setBounds(450, 530, 150, 30);
		panel.add(txtuppaidornot).setBounds(510, 570, 120, 30);
		
		panel.add(update).setBounds(450, 610, 90, 30);
		panel.add(delete).setBounds(560, 610, 90, 30);*/
		
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==confirm){
					if(checkavail){
					datetext.setText("");
					day=new java.util.Date();
					datetext.append(""+new Timestamp(day.getTime()));
					
					txtdate.setText(datetext.getText());
					if(txtpurchaseprice.getText().length()>=1 && txtsellingprice.getText().length()>=1 ){
					purchase=Integer.parseInt(txtpurchaseprice.getText());
					sell=Integer.parseInt(txtsellingprice.getText());
					}
					benif=(sell*requiredno)-(purchase*requiredno);
					
					//profit=String.valueOf(benif);
					txtbenefit.setText(String.valueOf(benif));
					confirmcheck=true;
					OKDialogue.okdia("Confirmed");
					
				}else{
					OKDialogue.okdia("Check For Product Availability First");
				}
				}
				
				
			}
		});
		checkavilability.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				checkavail=false;
			    if(item.getSelectedIndex()>0){
			    	String item12=item.getSelectedItem().toString();
			    	if(txtspecno.getText().length()>=1){
			    		int req=Integer.parseInt(txtspecno.getText());
			    		try {
							rs=stmt.executeQuery("select * from StockTab where name1='"+item12+"'");
							if(rs.next()){ 
								avail=rs.getInt(2);
								if(avail>=req){
									checkavail=true;
									requiredno=req;
									
								}else{
									OKDialogue.okdia("Required Product Strength is not Avilable"+System.getProperty("line.separator")+"We have only "+avail+" at Present");
								}
								}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		
			    	}else{
			    		OKDialogue.okdia("Specify Product Numbers");
			    	}
			    	
			    }else{
			    	OKDialogue.okdia("Please..!!Select Product First");
			    }	
			}
		});
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(item.getSelectedIndex()>0){
					checkavail=false;
					String itmname=item.getSelectedItem().toString();
					System.out.println("Right Data:");
					try {
						rs=stmt.executeQuery("select * from StockTab where name1='"+itmname+"'");
						if(rs.next()){
							txtpurchaseprice.setText(String.valueOf(rs.getInt(3)));
							
							
						}else{
							OKDialogue.okdia("Selected Item is Not Present in stock");
							item.setSelectedIndex(0);
							txtpurchaseprice.setText("");
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					System.out.println("Wrong Selection");
				}
			}
		});
		addtocart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			try {
				new AddToCart(stmt,con);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
		});
		
		
		txtpurchaseprice.addKeyListener(new KeyAdapter() {
    	    public void keyTyped(KeyEvent e) {
    	      char c = e.getKeyChar();
    	      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)  ))
    	      {
    	        getToolkit().beep();
    	        e.consume();
    	      }
    	     
    	      
//    	      
    	    }
    	  });
		txtsellingprice.addKeyListener(new KeyAdapter() {
    	    public void keyTyped(KeyEvent e) {
      	      char c = e.getKeyChar();
      	      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)  ))
      	      {
      	        getToolkit().beep();
      	        e.consume();
      	      }
      	     
      	      
//      	      
      	    }
      	  });
		txtspecno.addKeyListener(new KeyAdapter() {
    	    public void keyTyped(KeyEvent e) {
        	      char c = e.getKeyChar();
        	      if (!((c >= '0') && (c <= '9') ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)  ))
        	      {
        	        getToolkit().beep();
        	        e.consume();
        	      }
        	     
        	      
//        	      
        	    }
        	  });
		
		storedata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==storedata){
					if(txtCustName.getText().length()>=1 && txtcustaddress.getText().length()>=1 && txtcustcontact.getText().length()>=1 && txtserialno.getText().length()>=1 && txtrepairing.getText().length()>=1 && txtpurchaseprice.getText().length()>=1 && txtspecno.getText().length()>=1 && txtsellingprice.getText().length()>=1 &&  txtdealer.getText().length()>=1 && txtpaidornot.getText().length()>=1){
					if(checkavail && confirmcheck){
						int no=Integer.parseInt(txtspecno.getText());
						try {
						rs=stmt.executeQuery("select * from VishwaSaleData1 order by id1 asc");
						int i,j;
						if(rs.next()){
							System.out.println("Data Present in Table");
							rs.last();
							j=rs.getInt(1)+1;
						}else{
							System.out.println("Empty in Table");
							j=1;
						}
						
						/*rs.last();
						int i=rs.getInt(1);
						
						System.out.println("last id is:"+i);*/
						String pick=formater.format(picker.getDate());
						String pick1=formater.format(picker1.getDate());
						PreparedStatement pstat=con.prepareStatement("insert into VishwaSaleData1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pstat.setInt(1, j);
						pstat.setString(2,txtCustName.getText() );
						pstat.setString(3, txtcustaddress.getText());
						pstat.setString(4, pick1);
						pstat.setString(5, txtcustcontact.getText());
						pstat.setString(6, item.getSelectedItem().toString());
						pstat.setInt(7, no);
						pstat.setString(8, txtserialno.getText());
						pstat.setString(9, txtrepairing.getText());
						pstat.setString(10, txtpurchaseprice.getText());
						pstat.setString(11, txtsellingprice.getText());
						pstat.setString(12, txtbenefit.getText());
						pstat.setString(13, txtdealer.getText());
						pstat.setString(14, txtpaidornot.getText());
						pstat.setString(15, pick);
						pstat.execute();
						
						int remain=avail-requiredno;
						rs=stmt.executeQuery("update StockTab set noofitm="+remain+" where name1='"+item.getSelectedItem().toString()+"'");
						
						checkavail=false;
						confirmcheck=false;
						txtCustName.setText("");
						txtcustaddress.setText("");
						txtbenefit.setText("");
						txtcustcontact.setText("");
						txtdealer.setText("");
						txtpaidornot.setText("");
						txtpurchaseprice.setText("");
						txtrepairing.setText("");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						OKDialogue.okdia("First Check Availability And Then Confirm Transaction");
					}
					}else{
						OKDialogue.okdia("Don't left Any field Blank "+System.getProperty("line.separator")+"Also First Check Availability And Then Confirm Transaction");
					}
					
				}
				
			}
		});
		
		/*update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==update){
					try {
						int f=Integer.parseInt(txtenterino.getText());
						String strproduct=cmbupproduct.getSelectedItem().toString();
						String strspecific=cmbupspecif.getSelectedItem().toString();
						String strsrno=txtupserialno.getText();
						String strpaidornot=txtuppaidornot.getText();
						
						
						"update " + dbName + ".COFFEES " +
				        "set SALES = ? where COF_NAME = ?";

						String strquiries="update VishalSaleData" + "set Product=?,Specifictn=?,Sr_No=?,Paid=?" + "where I_No=?";
						con.setAutoCommit(false);
						updateSales=con.prepareStatement(strquiries);
						updateSales.setString(5, strproduct);
						updateSales.setString(7, strsrno);
						updateSales.setString(13, strpaidornot);
						updateSales.setInt(0, f);
						updateSales.executeUpdate();
						con.commit();
						
						//stmt.executeQuery("update VishalSaleData set Product="+strproduct+",Specifictn="+strspecific+",Sr_No="+strsrno+",Paid="+strpaidornot+" where I_No="+f);
						//con.setAutoCommit(false);
						stmt.executeQuery("update VishalSaleData set Product='"+strproduct+"' where I_No="+f);
						stmt.executeQuery("update VishalSaleData set Specifictn='"+strspecific+"'where I_No="+f);
						stmt.executeQuery("update VishalSaleData set Sr_No='"+strsrno+"' where I_No="+f);
						stmt.executeQuery("update VishalSaleData set Paid='"+strpaidornot+"' where I_No="+f);
						//con.commit();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});*/
		
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==delete){
					
					try { 
						int h=Integer.parseInt(txtenterino.getText());
						stmt.executeQuery("delete from VishalSaleData where I_No="+h);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		
		this.add(panel);
		
	}

	
	public static void main(String[] args) throws ClassNotFoundException {
		SaleData sd=new SaleData();
		sd.setTitle("Vishwa Computer Sales and Billing");
		sd.setSize(700, 720);
		sd.setResizable(false);
		sd.setVisible(true);
		
		

	}

}
                      