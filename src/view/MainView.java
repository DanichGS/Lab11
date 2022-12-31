package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import event.IProductListener;
import event.ProductEvent;
import model.Cylinder;
import model.IWeight;
import model.LongCyl;
import model.LongTim;
import model.Timber;
import model.Waste;
import model.Wood;
import store.AbstractStore;
import store.ProductStore;
import store.WoodDirectory;

import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.awt.Insets;

public class MainView {

	private WoodDirectory wd = new WoodDirectory();
	private ProductStore ps = new ProductStore();
	//private AbstractStore as = new AbstractStore();
	private LongTim lt = new LongTim();
	private LongCyl lc = new LongCyl();
	private JFrame frmLabOop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmLabOop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Date date = new Date();
		try {
			BufferedWriter prot = new BufferedWriter(new FileWriter("protocol.txt", true));
			prot.write("Даніч Гліб ");
			prot.write(date.toString());
			prot.newLine();
			prot.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}


		frmLabOop = new JFrame();
		frmLabOop.setTitle("Danich KI-211 lab11");
		frmLabOop.setBounds(100, 100, 355, 300);


		JMenuBar menuBar = new JMenuBar();
		frmLabOop.setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuItemStore = new JMenuItem("Store");
		menuItemStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStoreClick();
			}
		});
		menuFile.add(menuItemStore);

		JMenuItem menuItemRestore = new JMenuItem("Restore");
		menuItemRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestoreClick();
			}
		});
		menuFile.add(menuItemRestore);

		JMenuItem menuItemShowProtocol = new JMenuItem("Show Protocol");
		menuItemShowProtocol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onProtocolClick();
			}
		});
		menuFile.add(menuItemShowProtocol);

		JMenu menuWood = new JMenu("Wood");
		menuBar.add(menuWood);

		JMenuItem menuItemShow = new JMenuItem("Show");
		menuItemShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onWoodShowClick();
			}
		});
		menuWood.add(menuItemShow);

		JMenuItem menuItemAddWood = new JMenuItem("Add");
		menuItemAddWood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddWood();

			}
		});
		menuWood.add(menuItemAddWood);

		JMenuItem menuItemDelWood = new JMenuItem("Delete");
		menuWood.add(menuItemDelWood);

		JMenuItem menuItemEditWood = new JMenuItem("Edit");
		menuWood.add(menuItemEditWood);

		JMenu menuProduct = new JMenu("Product");
		menuBar.add(menuProduct);

		JMenuItem menuItemShowProduct = new JMenuItem("ShowAll");
		menuItemShowProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onProductShowClick();
			}
		});
		menuProduct.add(menuItemShowProduct);

		JMenu menuAddProduct = new JMenu("Add");
		menuProduct.add(menuAddProduct);

		JMenuItem menuItemAddTimber = new JMenuItem("Timber");
		menuItemAddTimber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddTimber(); 

			}
		});
		menuAddProduct.add(menuItemAddTimber);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cylinder");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddCylinder();

			}
		});
		menuAddProduct.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Waste");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddWaste();

			}
		});
		menuAddProduct.add(mntmNewMenuItem_1);

		menuItemInfo = new JMenuItem("Info\r\n");
		menuItemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onInfoClick();

			}
		});

		JMenu mnNewMenu = new JMenu("Event");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Listener");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddLis();

			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Remove Listener");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemoveLis();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("Lambda");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("ShowOverweight");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onShowOverweight();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("RemoveOverweight");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemoveOverweight();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("RepLngTimb&Cylind");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRepLngTimbandCylind();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		menuItemInfo.setActionCommand("Info\r\n");
		menuBar.add(menuItemInfo);
		frmLabOop.getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		frmLabOop.getContentPane().add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setMargin(new Insets(2, 2, 50, 2));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);

		JMenuItem menuItemTextAreaClear = new JMenuItem("Clear");
		menuItemTextAreaClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearTextArea();
			}
		});
		popupMenu.add(menuItemTextAreaClear);


	}




	protected void onRepLngTimbandCylind() {
		// TODO Auto-generated method stub
		textArea.setText("");
		String maxLength = JOptionPane.showInputDialog(textArea,"Введіть максимальну довжину");
		float maxL = Float.parseFloat(maxLength);
		Predicate<Object> prd = new Predicate<Object>() {
			@Override
			public boolean test(Object t) {
				if(t instanceof Timber && ((Timber) t).getLength() > maxL) {
					lt.add((Timber) t);
				}
				return t instanceof Timber && ((Timber) t).getLength() > maxL;
			}			
		};
		textArea.append("\n LongTimber: ");
		ps.remove(prd);
		lt.doForAll((t) ->textArea.append("\n "+ t.toString()));

		Predicate<Object> prd1 = new Predicate<Object>() {
			@Override
			public boolean test(Object t) {
				if(t instanceof Cylinder && ((Cylinder) t).getLength() > maxL) {
					lc.add((Cylinder) t);
				}
				return t instanceof Cylinder && ((Cylinder) t).getLength() > maxL;
			}			
		};
		ps.remove(prd1);
		textArea.append("\n LongCylinder: ");
		lc.doForAll((t) ->textArea.append("\n " + t.toString()));
	}
		
	

	protected void onRemoveOverweight() {
		// TODO Auto-generated method stub
		textArea.setText("");
		String maxWeight = JOptionPane.showInputDialog(textArea,"Введіть критичну вагу");
		float maxW = Float.parseFloat(maxWeight);
		Predicate<Object> prd = new Predicate<Object>() {

			public boolean test(Object k) {
				
				return k instanceof Object && ((IWeight) k).weight() > maxW;
				
			}
			
		};
		
		ps.remove(prd);
		textArea.append("Елементи сховища без критичної ваги: ");
		ps.doForAll((t) ->textArea.append("\n" + t.toString()));
	}

	protected void onShowOverweight() {
		// TODO Auto-generated method stub
		textArea.setText("");
		String maxWeight = JOptionPane.showInputDialog(textArea,"Введіть критичну вагу");
		float maxW = Float.parseFloat(maxWeight);
		textArea.append("Елементи сховища з критичною вагою: ");
		ps.doOnlyFor((t) -> textArea.append("\n" + t.toString()), maxW);
		

	}





	IProductListener pLis = null;
	protected void onAddLis() {
		// TODO Auto-generated method stub

		pLis = new IProductListener() {

			@Override
			public void onProductEvent(ProductEvent e) {
				System.out.println(e);
				writeString(e.toString());
			}

		};	
		ps.addProductListener(pLis);
		textArea.setText("Додано слухача.");
	}
	protected void onRemoveLis() {

		ps.removeProductListener(pLis);
		textArea.setText("Слухача видалено.");
	}

	protected void onProtocolClick() {
		try {
			showProtocol();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
	private void writeString(String s) {
		try {
			BufferedWriter protocol = new BufferedWriter(new FileWriter("protocol.txt", true));
			protocol.write(s);
			protocol.newLine();
			protocol.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void showProtocol() throws Exception {
		// TODO Auto-generated method stub
		textArea.setText("");
		BufferedReader file = new BufferedReader(new FileReader("protocol.txt"));
		try {
			String line;
			while ((line = file.readLine()) != null) {

				textArea.append(line);
				textArea.append("\n");

			}
			file.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void onRestoreClick() {
		// TODO Auto-generated method stub
		File f = new File("wd.object");
		File ff = new File("DanichKI-211ps.object");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			wd = (WoodDirectory) ois.readObject();
			ois.close();
			FileInputStream fis2 = new FileInputStream(ff);
			ObjectInputStream ois2 = new ObjectInputStream(fis2);
			ps = (ProductStore) ois2.readObject();
			ois2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		textArea.setText("Дані додані з файлу.");
	}



	protected void onStoreClick() {
		File f = new File("wd.object");
		File ff = new File("DanichKI-211ps.object");
		try{
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(wd);
			oos.close();
			FileOutputStream fos2 = new FileOutputStream(ff);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(ps);
			oos2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		textArea.setText("Дані додані до файлу.");

	}

	protected void onAddWaste() {
		// TODO Auto-generated method stub
		dlgWaste.setVisible(true);
		Waste newWaste = dlgWaste.getObject();
		if(newWaste != null) {
			ps.add(newWaste);}

		onProductShowClick();

	}

	protected void onAddTimber() {
		dlgTimber.setWoodDirectory(wd);
		dlgTimber.setVisible(true);
		Timber newTimber = dlgTimber.getObject();
		if(newTimber != null) {
			ps.add(newTimber);}
		onProductShowClick();


	}
	protected void onAddCylinder() {
		dlgCylinder.setWoodDirectory(wd);
		dlgCylinder.setVisible(true);
		Cylinder newCylinder = dlgCylinder.getObject();
		if(newCylinder != null) {
			ps.add(newCylinder);}
		onProductShowClick();

	}

	protected void onAddWood() {
		int newId = wd.maxId() + 1;
	      dlgWood.getTextFieldId().setText(String.valueOf(newId));
		dlgWood.setVisible(true);
		Wood newWood = dlgWood.getObject();
		if (newWood != null) {
			writeString("Користувач додав: " + newWood);
			wd.add(newWood);}
		onWoodShowClick();

	}

	protected void onWoodShowClick() {

		textArea.setText(wd.toString());

	}
	protected void onInfoClick() {
		infoFrame.setLocation(infoFrame.getLocation().x + infoFrame.getWidth(), infoFrame.getLocation().y);
		infoFrame.setVisible(true);
	}
	protected void onClearTextArea() {
		textArea.setText("");
	}
	private void onProductShowClick() {
		textArea.setText(ps.toSortedString());

	}

	private DlgWaste dlgWaste = new DlgWaste();
	private DlgTimber dlgTimber = new DlgTimber();
	private DlgCylinder dlgCylinder = new DlgCylinder();
	private DlgWood dlgWood = new DlgWood();
	private InfoFrame infoFrame = new InfoFrame();
	private JMenuItem menuItemInfo;
	private JTextArea textArea;
	public JTextArea getTextArea() {
		return textArea;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
