package stack;

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
import java.util.Stack;
import java.awt.event.ActionEvent;

public class StackFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack<Rectangle> stack = new Stack<Rectangle>();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
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
	public StackFrm() {
		setTitle ("IM 61-2016 Lazar Kalajdzic");
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
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
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
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista je prazna");
					getToolkit().beep();
					
				} else {
					StackDlg dialogStackDelete = new StackDlg();
					String [] split = dlm.firstElement().toString().split(" ");
					
					dialogStackDelete.getTxtXCoord().setText(split[1]);
					dialogStackDelete.getTxtYCoord().setText(split[4]);
					dialogStackDelete.getTxtWidth().setText(split[7]);
					dialogStackDelete.getTxtHeight().setText(split[10]);
					dialogStackDelete.getTxtXCoord().setEditable(false);
					dialogStackDelete.getTxtYCoord().setEditable(false);
					dialogStackDelete.getTxtWidth().setEditable(false);
					dialogStackDelete.getTxtHeight().setEditable(false);
					dialogStackDelete.setVisible(true);
					if(dialogStackDelete.isDelete()==true) {
						stack.pop();
						dlm.removeElementAt(0);
					}
				}
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDlg stackDlg = new StackDlg();
				stackDlg.setVisible(true);
				if (stackDlg.isOk == true) {
					
					Rectangle rec = new Rectangle (new Point(Integer.parseInt(stackDlg.getTxtXCoord().getText()),
							(Integer.parseInt(stackDlg.getTxtYCoord().getText()))),
							(Integer.parseInt(stackDlg.getTxtWidth().getText())),
							(Integer.parseInt(stackDlg.getTxtHeight().getText())));
					
					stack.push(rec);
					dlm.add(0, "X: " + rec.getUpperLeftPoint().getX() + " , Y: " + rec.getUpperLeftPoint().getY() + " , Width: " + rec.getWidth() + " , Height: " + rec.getHeight());
					System.out.println(stack);
					
					
					
							
				}
				
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(81)
					.addComponent(btnAdd)
					.addGap(73)
					.addComponent(btnRemove)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemove)
						.addComponent(btnAdd)))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}
