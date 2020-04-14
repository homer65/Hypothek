package pack;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MainMenu extends Menu
{
	private static final long serialVersionUID = 1L;
	private JLabel lab1 = new JLabel("Rest Kapital");
	private JLabel lab2 = new JLabel("Zins Satz");
	private JLabel lab3 = new JLabel("monatliche Zahlung");
	private JLabel lab4 = new JLabel("jaehrliche Sondertilgung");
	private JTextField tf1 = new JTextField(10); //Restkapital
	private JTextField tf2 = new JTextField(10); //ZinsSatz
	private JTextField tf3 = new JTextField(10); //monatlicheZahlung
	private JTextField tf4 = new JTextField(10); //jaehrlicheSondertilgung
	private JButton butt1 = new JButton("ok");
	private JButton butt2 = new JButton("cancel");
	private JPanel cpan = new JPanel();
	public MainMenu()
	{
		super("Hypothek");
		butt1.addActionListener(this);
		butt2.addActionListener(this);
		tf1.setText("" + Parameter.rest_kapital);
		tf2.setText("" + Parameter.zins_satz);
		tf3.setText("" + Parameter.monatliche_zahlung);
		tf4.setText("" + Parameter.jaehrliche_sonderzahlung);
		cpan.setLayout(new GridLayout(5,2));
		cpan.add(lab1);
		cpan.add(tf1);
		cpan.add(lab2);
		cpan.add(tf2);
		cpan.add(lab3);
		cpan.add(tf3);
		cpan.add(lab4);
		cpan.add(tf4);
		cpan.add(butt1);
		cpan.add(butt2);
		setContentPane(cpan);
		pack();
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object quelle = ae.getSource();
		if (quelle == butt1)
		{
			Parameter.rest_kapital = f(tf1.getText());
			Parameter.zins_satz = f(tf2.getText());
			Parameter.monatliche_zahlung = f(tf3.getText());
			Parameter.jaehrliche_sonderzahlung = f(tf4.getText());
			Verarbeitung v = new Verarbeitung();
			v.start();
			//this.dispose();
		}
		if (quelle == butt2)
		{
			this.dispose();
		}
	}
	public double f(String x)
	{
		return Double.parseDouble(x);
	}
}
