import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {
	public ArrayList<Item> listaItems = new ArrayList<>();

	public View() {

		// JFRAME PRINCIPAL
		JFrame Pantalla = new JFrame();
		Pantalla.setVisible(true);
		Pantalla.setSize(300, 200);
		Pantalla.setTitle("Supermercado");
		Pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// JPANEL
		JPanel menuPan = new JPanel();

		// BOTONES
		JButton AgregarItem = new JButton("Nuevo Item");
		JButton Mostrar = new JButton("Mostrar");
		JButton Estadisticas = new JButton("Estadisticas");
		JButton Buscar = new JButton("Buscar");

		// JMENU
		JMenuBar Menu = new JMenuBar();
		Menu.setLayout(new GridLayout(5, 1, 1, 1));

		// JLabel
		JLabel tit = new JLabel("MENU");

		// SOLAPEO
		Pantalla.add(menuPan);
		menuPan.add(Menu);
		Menu.add(tit);
		Menu.add(AgregarItem);
		Menu.add(Mostrar);
		Menu.add(Estadisticas);
		Menu.add(Buscar);

		AgregarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AgregarItem();
			}
		});

		Mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mostrar();
			}
		});

	}

	void AgregarItem() {
		JFrame AItem = new JFrame();
		AItem.setTitle("AgregarItem");
		AItem.setSize(400, 200);
		AItem.setVisible(true);

		// JPANEL
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 1, 1));

		// JTextField
		JTextField id = new JTextField();
		id.setText("ID");
		JTextField desc = new JTextField();
		desc.setText("DESCRIPCION");

		// JBoton
		JButton agregar = new JButton("Agregar");
		JLabel op = new JLabel("   ITEM AGREGADO  ");

		AItem.add(panel);
		panel.add(id);
		panel.add(desc);
		panel.add(agregar);
		panel.add(op);
		op.setVisible(false);

		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Item nuevo = new Item(Integer.parseInt(id.getText()), desc.getText());
				listaItems.add(nuevo);
				op.setVisible(true);
			}
		});
	}

	void Mostrar() {
		JFrame Mostrar = new JFrame();
		Mostrar.setTitle("Mostrar");
		Mostrar.setSize(400, 200);
		Mostrar.setVisible(true);
		
		JPanel panel=new JPanel();
		JTable tabla=new JTable();
		DefaultTableModel md=new DefaultTableModel(crearMatriz(),new String[]{"ID","Desc."});
		tabla.setModel(md);
		
		Mostrar.add(panel);
		panel.add(tabla);
		
		
	}

	public Object[][] crearMatriz() {
		String matriz[][] = new String[listaItems.size()][2];
		for (int i = 0; i < listaItems.size(); i++) {

			matriz[i][0] = listaItems.get(i).intToString();
			matriz[i][1] = listaItems.get(i).getDesc();
		}
		return matriz;
	}
	
	
}
