package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Controller.LoadPageTable;
import Controller.LoadProcessTable;
import Controller.ProRequestHandler;
import Controller.ReqValidation;
import Controller.SplitProcess;


public class SplitPane extends JFrame implements ActionListener {


private     JPanel      panel1;
private     JPanel      panel2;
private     JPanel      panel3;
private JPanel topPanel;
private JPanel topPanel2;
String pro,lin,val;
int pno,sum=0;
JButton b1,b2,b3,b4;
JTextField tf,tf1;
JComboBox<String> jc1,jc2,jc3;
SplitProcess sp=new SplitProcess();
LoadProcessTable lp=new LoadProcessTable();
JTable tb1;
JTable t2=new JTable(4,1);
public SplitPane(){
    setTitle( "Memory Information" );
    setBackground( Color.darkGray );

    topPanel = new JPanel();
    topPanel2 = new JPanel();
    topPanel2.setLayout(null);
    topPanel.setPreferredSize( new Dimension( 800, 400 ) );
    topPanel.setLayout( new GridLayout(1,2));
    getContentPane().add( topPanel );
    JTabbedPane tabs= new JTabbedPane();
    topPanel.setBackground(Color.DARK_GRAY);
    // Create the panels
   
    createPanel1();
    createPanel2();
    createPanel3();
    b1=new JButton("Load");
    b2=new JButton("Mapping");
    b3=new JButton("Exit");
    b1.setBounds(20, 50, 100, 50);
    b2.setBounds(140, 50, 100, 50);
    b3.setBounds(260, 50, 100, 50);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			setVisible(false);
			System.exit(0);
		}
	});
    topPanel2.add(b1);
    topPanel2.add(b2);
    topPanel2.add(b3);
    LineBorder border = new LineBorder(Color.black, 1, true);
    topPanel2.setBorder(border);
    tabs.add("Page Table",panel1);
    tabs.add("Main Memory",panel2);
    tabs.add("Seconday Memory",panel3);
    topPanel.add(tabs);
    topPanel.add(topPanel2);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


public void createPanel1(){
	
	panel3 = new JPanel();
	panel3.setLayout(null);
	panel3.setPreferredSize(new Dimension(400,150));
	panel3.setBounds(0, 10, 300, 100);
    JScrollPane vertical;
    JLabel l6,l7,l8,l9,l10;
    JTextField l1,l2,l3,l4,l5;
    l1=new JTextField();
    l2=new JTextField();
    l3=new JTextField();
    l4=new JTextField();
    l5=new JTextField();
    l6=new JLabel("Process 1");
    l7=new JLabel("Process 2");
    l8=new JLabel("Process 3");
    l9=new JLabel("Process 4");
    l10=new JLabel("Process 5");
    l1.setBounds(10, 210, 40, 40);
    l1.setBackground(Color.YELLOW);
    l6.setBounds(60,210,80,40);
    l2.setBounds(150, 210, 40, 40);
    l2.setBackground(Color.ORANGE);
    l7.setBounds(200, 210, 80, 40);
    l3.setBounds(10, 260, 40, 40);
    l3.setBackground(Color.CYAN);
    l8.setBounds(60, 260, 80, 40);
    l4.setBounds(150, 260, 40, 40);
    l4.setBackground(Color.GREEN);
    l9.setBounds(200, 260, 80, 40);
    l5.setBounds(10, 310, 40, 40);
    l5.setBackground(Color.PINK);
    l10.setBounds(60, 310, 80, 40);
    //JPanel panel3_alt = new JPanel();
    int count=0;
    panel3.add(l1);
    panel3.add(l2);
    panel3.add(l6);
    panel3.add(l7);
    panel3.add(l3);
    panel3.add(l4);
    panel3.add(l8);
    panel3.add(l9);
    panel3.add(l5);
    panel3.add(l10);
    File folder = new File("/home/paras/Desktop/sec_mem");
    File[] name=folder.listFiles();
	ArrayList<String> listoffiles = new ArrayList<String>();
	for(File item : name)
	{
		if(item.isFile())
		{
			listoffiles.add(item.getName());
			count++;
		}
	}
	tb1=new JTable(count, 1);
	ArrayList<Integer> filenumber=new ArrayList<Integer>();
	for(String i: listoffiles )
		filenumber.add(Integer.parseInt(i.substring (3, i.length())));
	 Collections.sort(filenumber);
    listoffiles.clear();
	for(Integer i:filenumber)
		listoffiles.add("pro"+i);
	
	String []array_name=new String[count];
	
	int i=0;
	for(String item: listoffiles)
	{
		array_name[i++]=item;
	}
	for(int j=0;j<i;j++){
		String name1 = array_name[j];
		tb1.setValueAt(name1, j, 0);
	}
	//JList<String> lm1=new JList<String>(array_name);
	tb1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
    {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
        	int set = 0;
        	 final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
             val=(String) tb1.getValueAt(row, 0);
             if(val!=null)
             {
	             pno=Integer.parseInt((String)val.subSequence(3, val.length()));
	          
	             if(pno<lp.processcolom[0])
	             	c.setBackground(Color.YELLOW);
	             else if(pno>=lp.processcolom[0] && pno<lp.processcolom[0]+lp.processcolom[1])
	             	c.setBackground(Color.ORANGE);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2])
	             	c.setBackground(Color.CYAN);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3])
	             	c.setBackground(Color.GREEN);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3]+lp.processcolom[4])
	             	c.setBackground(Color.PINK);
             }
             else
            	 c.setBackground(Color.white);
        	 return c;
        }
    });
	
	
	vertical = new JScrollPane(tb1);
    vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    vertical.setBounds(25, 30, 250, 180);
    LineBorder border = new LineBorder(Color.black,1,true);
    TitledBorder tborder = new TitledBorder(border,"Secondary Memory",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,14),Color.black);
    panel3.add(vertical);
}

public void createPanel2(){
	
	int count=0;
	JTable tp2;
    panel2 = new JPanel();
    panel2.setLayout(null);
    JLabel l6,l7,l8,l9,l10;
    JTextField l1,l2,l3,l4,l5;
    l1=new JTextField();
    l2=new JTextField();
    l3=new JTextField();
    l4=new JTextField();
    l5=new JTextField();
    l6=new JLabel("Process 1");
    l7=new JLabel("Process 2");
    l8=new JLabel("Process 3");
    l9=new JLabel("Process 4");
    l10=new JLabel("Process 5");
    l1.setBounds(10, 210, 40, 40);
    l1.setBackground(Color.YELLOW);
    l6.setBounds(60,210,80,40);
    l2.setBounds(150, 210, 40, 40);
    l2.setBackground(Color.ORANGE);
    l7.setBounds(200, 210, 80, 40);
    l3.setBounds(10, 260, 40, 40);
    l3.setBackground(Color.CYAN);
    l8.setBounds(60, 260, 80, 40);
    l4.setBounds(150, 260, 40, 40);
    l4.setBackground(Color.GREEN);
    l9.setBounds(200, 260, 80, 40);
    l5.setBounds(10, 310, 40, 40);
    l5.setBackground(Color.PINK);
    l10.setBounds(60, 310, 80, 40);
    panel2.add(l1);
    panel2.add(l2);
    panel2.add(l6);
    panel2.add(l7);
    panel2.add(l3);
    panel2.add(l4);
    panel2.add(l8);
    panel2.add(l9);
    panel2.add(l5);
    panel2.add(l10);
    JScrollPane vertical;
   // JPanel panel2_alt= new JPanel();
    File folder = new File("/home/paras/Desktop/main_mem");
	File[] name=folder.listFiles();
	ArrayList<String> listoffiles = new ArrayList<String>();
	
	for(File item : name)
	{
		if(item.isFile())
		{
			listoffiles.add(item.getName());
		}
	}
	
	int i=0;
	
	
	for(String item: listoffiles)
	{
		t2.setValueAt(item, i, 0);
		
		
		i++;
	}
	//JScrollPane vertical = new JScrollPane(new JList<String>(array_name));
	t2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
    {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
        	int set = 0;
        	 final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
             val=(String) t2.getValueAt(row, 0);
             System.out.println("combo :: "+val);
             if(val!=null)
             {
	             pno=Integer.parseInt((String)val.subSequence(3, val.length()));
	           /*  for(int i=0;i<sp.process;i++)
	             {
	            	 sum=sum+lp.processcolom[i];
	            	 if(pno<sum)
	            	 {
	            		 set=i;
	            		 break;
	            	 }
	             }
	             c.setBackground(arr[set]); */
	             if(pno<lp.processcolom[0])
	             	c.setBackground(Color.YELLOW);
	             else if(pno>=lp.processcolom[0] && pno<lp.processcolom[0]+lp.processcolom[1])
	             	c.setBackground(Color.ORANGE);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2])
	             	c.setBackground(Color.CYAN);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3])
	             	c.setBackground(Color.GREEN);
	             else if(pno>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3] && pno<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3]+lp.processcolom[4])
	             	c.setBackground(Color.PINK);
             }
             else
            	 c.setBackground(Color.white);
        	 return c;
        }
    });
    t2.setBounds(50, 50, 250, 65);
    vertical = new JScrollPane(t2);
    vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    vertical.setBounds(25, 30, 250, 80);
   // LineBorder border = new LineBorder(Color.black,1,true);
   // TitledBorder tborder = new TitledBorder(border,"Main Memory",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION,new Font("arial",Font.BOLD,14),Color.black);
   // panel2_alt.setBorder(tborder);
    panel2.add(vertical);
    //panel2.add(tborder);  
}

public void createPanel3(){
	int i,count=0;
	JTable t1;
    panel1 = new JPanel();
    panel1.setLayout(null);
    JLabel l6,l7,l8,l9,l10;
    JTextField l1,l2,l3,l4,l5;
    l1=new JTextField();
    l2=new JTextField();
    l3=new JTextField();
    l4=new JTextField();
    l5=new JTextField();
    l6=new JLabel("Process 1");
    l7=new JLabel("Process 2");
    l8=new JLabel("Process 3");
    l9=new JLabel("Process 4");
    l10=new JLabel("Process 5");
    l1.setBounds(10, 210, 40, 40);
    l1.setBackground(Color.YELLOW);
    l6.setBounds(60,210,80,40);
    l2.setBounds(150, 210, 40, 40);
    l2.setBackground(Color.ORANGE);
    l7.setBounds(200, 210, 80, 40);
    l3.setBounds(10, 260, 40, 40);
    l3.setBackground(Color.CYAN);
    l8.setBounds(60, 260, 80, 40);
    l4.setBounds(150, 260, 40, 40);
    l4.setBackground(Color.GREEN);
    l9.setBounds(200, 260, 80, 40);
    l5.setBounds(10, 310, 40, 40);
    l5.setBackground(Color.PINK);
    l10.setBounds(60, 310, 80, 40);
    panel1.add(l1);
    panel1.add(l2);
    panel1.add(l6);
    panel1.add(l7);
    panel1.add(l3);
    panel1.add(l4);
    panel1.add(l8);
    panel1.add(l9);
    panel1.add(l5);
    panel1.add(l10);
   // panel1.setPreferredSize( new Dimension(300, 100 ) );
    JLabel j1=new JLabel("      PageTable");
    j1.setBounds(10, 10, 300, 30);
    //j1.setPreferredSize(new Dimension(50, 10));
    panel1.add(j1);
   
    for(i=1;i<LoadPageTable.pageTable.length;i++)
    {
    	if(LoadPageTable.pageTable[i]!=null)
    	{
    		count++;
    	}
    	else
    		break;
    }
	t1=new JTable(count,2);

	//t1.setBackground(Color.RED);
	t1.setEnabled(false);
	JTableHeader th = t1.getTableHeader();
	TableColumnModel tcm = th.getColumnModel();
	TableColumn tc = tcm.getColumn(0);
	tc.setHeaderValue( "Page" );
	th.repaint();
	TableColumn tc1 = tcm.getColumn(1);
	tc1.setHeaderValue( "Frame" );
	th.repaint();
	//Model[] array1 = new Model[count+1];
	String[] array1=new String[count+1];
    for(i=1;i<=count;i++)
    {
    	t1.setValueAt("Page"+i, i-1, 0);
    	t1.setValueAt(LoadPageTable.pageTable[i], i-1, 1);
    }
    t1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
    {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if(row<lp.processcolom[0])
            	c.setBackground(Color.YELLOW);
            else if(row>=lp.processcolom[0] && row<lp.processcolom[0]+lp.processcolom[1])
            	c.setBackground(Color.ORANGE);
            else if(row>=lp.processcolom[0]+lp.processcolom[1] && row<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2])
            	c.setBackground(Color.CYAN);
            else if(row>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2] && row<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3])
            	c.setBackground(Color.GREEN);
            else if(row>=lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3] && row<lp.processcolom[0]+lp.processcolom[1]+lp.processcolom[2]+lp.processcolom[3]+lp.processcolom[4])
            	c.setBackground(Color.PINK);
            return c;
        }
    });
    
    JScrollPane vertical = new JScrollPane(t1);
    vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    vertical.setBounds(20, 50, 350, 150);
   
    panel1.add(vertical);
	
}

public static void run( String args[] ){
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception evt) {}
    // Create an instance of the test application
    SplitPane maintopPanel2 = new SplitPane();
    maintopPanel2.pack();
    maintopPanel2.setVisible( true );
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	if(arg0.getSource()==b1)
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		JLabel lb1=new JLabel("Enter Process:: ");
		lb1.setFont(lb1.getFont().deriveFont (18.0f) );
		lb1.setForeground(Color.red);
		lb1.setBounds(0, 150, 150, 60);
		topPanel2.add(lb1);
		jc3=new JComboBox<String>();
		tf=new JTextField();
		
		File folder = new File("/home/paras/Desktop/processes");
		File[] name=folder.listFiles();
		ArrayList<String> listoffiles = new ArrayList<String>();
		for(File item : name)
		{
			if(item.isFile())
			{
				listoffiles.add(item.getName());
				
			}
		}
		ArrayList<Integer> filenumber=new ArrayList<Integer>();
		for(String i: listoffiles )
		{
			
			jc3.addItem(i);
		}
		
		jc3.setBounds(150, 150, 200, 60);
		//topPanel2.add(tf);
		topPanel2.add(jc3);
		JButton jb1=new JButton("Submit");
		jb1.setBounds(200, 240, 150, 50);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name=(String)jc3.getSelectedItem();
					//System.out.println(name);
					String chk="/home/paras/Desktop/processes/"+name;
					File f=new File(chk);
						if(f.exists() && !(name.isEmpty()))
						{
						SplitProcess.split(name);
						setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Enter valid process name");
							tf.setText(null);
							
						}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "Execute Process Error");
					
				}
			}
		});
		topPanel2.add(jb1);
		JButton jb2=new JButton("Back");
		jb2.setBounds(20, 240, 150, 50);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				SplitPane sp=new SplitPane();
				sp.run(null);
			}
		});
		topPanel2.add(jb2);
		topPanel2.revalidate();
		topPanel2.repaint();
	}
	
	else if(arg0.getSource()==b2)
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		JLabel lb1=new JLabel("Enter Logical Address:: ");
		JLabel lb2=new JLabel("LA=(ProcessNo InstructionNo) ");
		lb1.setFont(lb1.getFont().deriveFont (20.0f) );
		lb1.setForeground(Color.red);
		lb1.setBounds(50, 100, 300, 70);
		lb2.setBounds(150, 200, 300, 50);
		topPanel2.add(lb1);
		topPanel2.add(lb2);
		
		jc1=new JComboBox<String>();
		jc2=new JComboBox<String>();
			for(int i=0;i<sp.process;i++)
			{
				jc1.addItem("Process "+(i+1));
			}
			jc2.setBounds(210, 150, 100, 50);
			jc2.setEnabled(false);
			topPanel2.add(jc2);
			jc1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pro=(String) jc1.getSelectedItem();
				jc1.setEnabled(false);
				System.out.println("Selected process is :: "+pro);
				jc2.setEnabled(true);
				int p=Integer.parseInt((String)pro.subSequence(8, pro.length()));
				System.out.println("Process name is :: "+p);
				for(int i=0;i<sp.lines[p-1];i++)
				{
					jc2.addItem("Line "+(i+1));
				}
				
			}
		});
		
		//jc1.addItem(item);
		jc1.setBounds(100, 150, 100, 50);
		topPanel2.add(jc1);
		
		JButton jb1=new JButton("Submit");
		jb1.setBounds(200, 330, 150, 50);
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				lin=(String) jc2.getSelectedItem();
				lin=(String)lin.subSequence(5, lin.length());
				pro=(String)pro.subSequence(8, pro.length());
				String adrs=pro+" "+lin;
				String[] str  = adrs.split(" ");
				if(str.length==2)
				{
					try
					{
					    int processline=Integer.parseInt(str[1]);
					    int processno=Integer.parseInt(str[0]);
					    boolean reqstatus=ReqValidation.validate(processno, processline);
					    if(reqstatus)
					    {
						    ProRequestHandler.HandleReq(adrs);
						    setVisible(false);
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(null, "Enter valid address");
					    	tf1.setText("");
					    }
					}
					catch(Exception err)
					{
						JOptionPane.showMessageDialog(null, "Enter valid address");
						tf1.setText("");
						
					}
				}
				else
					tf1.setText("");
			}
		});
		JButton jb2=new JButton("Back");
		jb2.setBounds(20, 330, 150, 50);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				SplitPane sp=new SplitPane();
				sp.run(null);
			}
		});
		topPanel2.add(jb2);
		topPanel2.add(jb1);
		topPanel2.revalidate();
		topPanel2.repaint();
	}
	}
}






