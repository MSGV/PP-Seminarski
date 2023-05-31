package Prozori;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Exceptions.DosloJeDoGreskeException;
import Resursi.CRUD_Ops;
import Zajednicko.Helper;
import Zajednicko.HelperPrikaz;

public class Lista_Knjiga extends JFrame {

	private JPanel contentPane;
	private JTextField txtNaziv;
	private JTextField txtAutor;
	private JTextField Žanrtxt;
	private JTextField Inventartxt;
	
	static Helper Helper = new Helper();
    HelperPrikaz HelperP = new HelperPrikaz();
	private JTable table;
	private JTextField IDtxt;
	private CRUD_Ops CRUD = new CRUD_Ops();
	private JTextField Cenatxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_Knjiga frame = new Lista_Knjiga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Lista_Knjiga() {
		
		initComponents();
		CRUD_Ops.prikaz(table);
	}
	
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Legion\\Desktop\\Milan Buric fakultet\\LOB.png"));
		setTitle("LISTA KNJIGA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1151, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Autor");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(35, 108, 75, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Žanr");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 132, 75, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Inventar");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(35, 157, 75, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Naziv");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(35, 82, 75, 19);
		panel.add(lblNewLabel_4);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(145, 82, 186, 19);
		panel.add(txtNaziv);
		txtNaziv.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(145, 108, 186, 19);
		panel.add(txtAutor);
		txtAutor.setColumns(10);
		
		Žanrtxt = new JTextField();
		Žanrtxt.setBounds(145, 133, 186, 19);
		panel.add(Žanrtxt);
		Žanrtxt.setColumns(10);
		
		Inventartxt = new JTextField();
		Inventartxt.setBounds(145, 158, 186, 19);
		panel.add(Inventartxt);
		Inventartxt.setColumns(10);

		
		JButton btnNewButton = new JButton("Izlaz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(10, 650, 146, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DODAJ");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					CRUD_Ops.Dodaj(txtNaziv.getText(), Žanrtxt.getText(), txtAutor.getText(), Inventartxt.getText(), Cenatxt.getText());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				CRUD_Ops.prikaz(table);
				
				txtNaziv.setText("");
				Žanrtxt.setText("");
				txtAutor.setText("");
				Inventartxt.setText("");
				Cenatxt.setText("");
				

			}
		});
		btnNewButton_1.setBounds(10, 280, 145, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("IZMENI");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					CRUD_Ops.Izmeni(txtNaziv.getText(), Žanrtxt.getText(), txtAutor.getText(), Inventartxt.getText(), IDtxt.getText(), Cenatxt.getText());
							
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				CRUD_Ops.prikaz(table);
				
				txtNaziv.setText("");
				Žanrtxt.setText("");
				txtAutor.setText("");
				Inventartxt.setText("");
				Cenatxt.setText("");
						
				
			}
		});
		
		btnNewButton_2.setBounds(186, 280, 145, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("OBRIŠI");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				CRUD_Ops.Obrisi(txtNaziv.getText(), Žanrtxt.getText(), txtAutor.getText(), Inventartxt.getText(), IDtxt.getText(), Cenatxt.getText());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
			CRUD_Ops.prikaz(table);
				
				txtNaziv.setText("");
				Žanrtxt.setText("");
				txtAutor.setText("");
				Inventartxt.setText("");
				Cenatxt.setText("");
			
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(10, 324, 145, 21);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("LISTA KNJIGA");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(10, 0, 266, 60);
		panel.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(354, 24, 761, 632);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		
		IDtxt = new JTextField();
		IDtxt.setBounds(145, 209, 48, 20);
		panel.add(IDtxt);
		IDtxt.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("OSVEŽI");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUD_Ops.prikaz(table);
				txtNaziv.setText("");
				Žanrtxt.setText("");
				txtAutor.setText("");
				Inventartxt.setText("");
				Cenatxt.setText("");
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(187, 324, 144, 23);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cena");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(35, 181, 75, 20);
		panel.add(lblNewLabel_3_1);
		
		Cenatxt = new JTextField();
		Cenatxt.setColumns(10);
		Cenatxt.setBounds(145, 182, 186, 19);
		panel.add(Cenatxt);
		IDtxt.setVisible(false);

		rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        			        
		        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		        		        
		        
		        	int selRow = table.getSelectedRow();
		        	String idForEdit = table.getModel().getValueAt(selRow, 0).toString();
		        	String Naziv = table.getModel().getValueAt(selRow, 1).toString();
		        	String Žanr = table.getModel().getValueAt(selRow, 2).toString();
		        	String Autor = table.getModel().getValueAt(selRow, 3).toString();
		        	String Inventar = table.getModel().getValueAt(selRow, 4).toString();
		        	String Cena = table.getModel().getValueAt(selRow, 5).toString();
		        	
		        	txtNaziv.setText(Naziv);
		        	Žanrtxt.setText(Žanr);
		        	txtAutor.setText(Autor);
					Inventartxt.setText(Inventar);
					Cenatxt.setText(Cena);
					IDtxt.setText(idForEdit);		        	
		        }

		    });
	}
}
