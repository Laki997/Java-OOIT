package sort;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class SortFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Rectangle> arrayListRect = new ArrayList<Rectangle>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
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
	public SortFrm() {
		setTitle("Im 61-2016 Lazar Kalajdzic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList list = new JList();
		
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
		
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortDlg sortDlg = new SortDlg();
				sortDlg.setVisible(true);
				if(sortDlg.isOk ==true) {
					Rectangle rec = new Rectangle (new Point(Integer.parseInt(sortDlg.getTxtXCoord().getText()),
							(Integer.parseInt(sortDlg.getTxtYCoord().getText()))),
							(Integer.parseInt(sortDlg.getTxtWidth().getText())),
							(Integer.parseInt(sortDlg.getTxtHeight().getText())));
					
					
					arrayListRect.add(rec);
					Collections.sort(arrayListRect);
					
					dlm.add(arrayListRect.indexOf(rec), "X: " + rec.getUpperLeftPoint().getX() + " , Y: " + rec.getUpperLeftPoint().getY() + " , Width: " +rec.getWidth() + " , Height: " + rec.getHeight());
				}
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema nista u listi");
				} else {
					SortDlg dlgSortDelete = new SortDlg();
					String [] split = dlm.firstElement().toString().split(" ");
					
					dlgSortDelete.getTxtXCoord().setText(split[1]);
					dlgSortDelete.getTxtYCoord().setText(split[4]);
					dlgSortDelete.getTxtWidth().setText(split[7]);
					dlgSortDelete.getTxtHeight().setText(split[10]);
					dlgSortDelete.getTxtXCoord().setEditable(false);
					dlgSortDelete.getTxtYCoord().setEditable(false);
					dlgSortDelete.getTxtWidth().setEditable(false);
					dlgSortDelete.getTxtHeight().setEditable(false);
					dlgSortDelete.setVisible(true);
					if(dlgSortDelete.isDelete()== true) {
						arrayListRect.remove(0);
						dlm.removeElementAt(0);

						
					}
				}
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(102)
					.addComponent(btnAdd)
					.addGap(90)
					.addComponent(btnRemove)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlDown.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnRemove)))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}
