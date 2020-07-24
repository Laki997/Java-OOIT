package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	static Color outline = Color.black;
	static Color area = Color.white;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrm() {
		setTitle(" IM 61-2016 Lazar Kalajdzic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlButton = new JPanel();
		contentPane.add(pnlButton, BorderLayout.EAST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj=1;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj=2;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj=3;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj=4;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj=5;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nemamo sta da selektujemo, lista je prazna");
					return ;
				} else {
					PnlDrawing.obj = 6;
				}
			}
		});
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nemamo sta da modifikujemo");
					return;
				}
				for (Shape shape: PnlDrawing.shapesArrList) {
					if (shape.isSelected()) {
						shape.DialogEdit();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Morate prvo selektovati objekat");
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nemamo sta da obrisemo");
					return;
				}
				for (Shape shape: PnlDrawing.shapesArrList) {
					if (shape.isSelected()) {
						int ans = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete");
						if (ans == 0) {
							PnlDrawing.shapesArrList.remove(shape);
							
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Morate prvo selektovati objekat");
			}
		});
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Izaberite boju", Color.black);
				if (outline == null) {
					outline = Color.black;
				}
			}
		});
		
		JButton btnAreaColor = new JButton("Area Color");
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				area = JColorChooser.showDialog(null, "Izaberite boju", Color.white);
				if (area == null) {
					area = Color.white;
				}
			}
		});
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setBorder(null);
		GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
		gl_pnlButton.setHorizontalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlButton.createSequentialGroup()
					.addComponent(pnlDrawing, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_pnlButton.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnLine, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPoint, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnRectangle)
						.addComponent(btnCircle)
						.addComponent(btnDonut)
						.addComponent(btnSelect)
						.addComponent(btnModify)
						.addComponent(btnDelete)
						.addGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING)
							.addComponent(btnAreaColor)
							.addComponent(btnOutlineColor)))
					.addContainerGap())
		);
		gl_pnlButton.setVerticalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDonut)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOutlineColor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAreaColor)
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(pnlDrawing, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
		);
		pnlButton.setLayout(gl_pnlButton);
	}

}
