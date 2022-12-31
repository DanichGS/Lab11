package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Timber;
import model.Waste;
import model.Wood;
import store.ProductStore;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

public class DlgWaste extends JDialog {
	private ProductStore ps = new ProductStore();
	private Waste object = null;
	public Waste getObject() {
		return object;
	}
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgWaste dialog = new DlgWaste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWaste() {
		setModal(true);
		setTitle("Waste Information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textField = new JTextField();
			textField.setBorder(new TitledBorder(null, "Weight, kg", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
			textField.setPreferredSize(new Dimension(500, 50));
			contentPanel.add(textField);
			textField.setColumns(30);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void onCancel() {
		// TODO Auto-generated method stub
		object = null;
		this.setVisible(false);
	}

	protected void onOk() {
		// TODO Auto-generated method stub
		float weight = Integer.parseInt(textField.getText());
		try {
			object = new Waste(weight);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Введення продуктів", JOptionPane.ERROR_MESSAGE);
			object=null;
		}
		this.setVisible(false);
	}

	public JTextField getTextField() {
		return textField;
	}
}
