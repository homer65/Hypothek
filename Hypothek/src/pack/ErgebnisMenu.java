package pack;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class ErgebnisMenu extends Menu
{
	private static final long serialVersionUID = 1L;
	private JTextArea ta = new JTextArea();
	private JScrollPane sp = null;
	private JPanel cpan = new JPanel();
	public ErgebnisMenu()
	{
		super("Ergebnis");
	}
	public void addSatz(String satz)
	{
		ta.append(satz + "\n");
	}
	public void build()
	{
		sp = new JScrollPane(ta);
		sp.createHorizontalScrollBar();
		sp.createVerticalScrollBar();
		sp.setPreferredSize(new Dimension(400,800));
		cpan.add(sp);
		setContentPane(cpan);
		pack();
	}
}
