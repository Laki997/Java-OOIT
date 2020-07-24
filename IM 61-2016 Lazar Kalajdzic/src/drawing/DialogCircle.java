package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DialogCircle extends JDialog {

	private final JPanel pnlCircle = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	public boolean isOk;
	private Color outline;
	private Color area;
	private boolean outlineBool;
	private boolean areaBool;

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getArea() {
		return area;
	}

	public void setArea(Color area) {
		this.area = area;
	}

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}

	public boolean isAreaBool() {
		return areaBool;
	}

	public void setAreaBool(boolean areaBool) {
		this.areaBool = areaBool;
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCircle dialog = new DialogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCircle() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCircle.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCircle, BorderLayout.CENTER);
		JLabel lblXCoord = new JLabel("X Coordinate");
		JLabel lblYCoord = new JLabel("Y Coordinate");
		JLabel lblRadius = new JLabel("Radius");
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && c<='9')) || (c == KeyEvent.VK_BACK_SPACE)){
			e.consume();
			getToolkit().beep();
		}
			}
		});
		txtXCoord.setColumns(10);
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && c<='9')) || (c == KeyEvent.VK_BACK_SPACE)){
			e.consume();
			getToolkit().beep();
		}
			}
		});
		txtYCoord.setText("");
		txtYCoord.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && c<='9')) || (c == KeyEvent.VK_BACK_SPACE)){
			e.consume();
			getToolkit().beep();
		}
			}
		});
		txtRadius.setText("");
		txtRadius.setColumns(10);
		
		JButton btnAreaColor = new JButton("Area Color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area = JColorChooser.showDialog(null, "Unesite boju", Color.white);
				areaBool = true;
				if (area == null) {
					area = Color.white;
				}
			}
		});
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Unesite boju", Color.black);
				outlineBool = true;
				if (outline == null) {
					outline = Color.black;
				}
			}
		});
		GroupLayout gl_pnlCircle = new GroupLayout(pnlCircle);
		gl_pnlCircle.setHorizontalGroup(
			gl_pnlCircle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCircle.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXCoord)
						.addComponent(lblRadius)
						.addComponent(lblYCoord))
					.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.LEADING)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
				.addGroup(gl_pnlCircle.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAreaColor)
					.addGap(65)
					.addComponent(btnOutlineColor)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		gl_pnlCircle.setVerticalGroup(
			gl_pnlCircle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCircle.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoord)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoord)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_pnlCircle.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAreaColor)
						.addComponent(btnOutlineColor))
					.addGap(23))
		);
		pnlCircle.setLayout(gl_pnlCircle);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Unesite sva polja");
							getToolkit().beep();
						} else {
							for (Shape shape: PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoord.getText()), Integer.parseInt(txtYCoord.getText()));
									
									((Circle)shape).setRadius(Integer.parseInt(txtRadius.getText()));
									
									if(isOutlineBool() == true) {
										shape.setOutline(outline);
										setOutlineBool(false);
									}
									
									if (isAreaBool() == true) {
										shape.setFill(area);
										setAreaBool(false);
									}
								}
							}
							isOk=true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				btnPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				btnPanel.add(cancelButton);
			}
		}
	}

}
