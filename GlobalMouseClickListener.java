
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class GlobalMouseClickListener implements NativeMouseListener {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private Map<Integer, JLabel> mapping;
	private JTextArea jtaLog;
	private Set<Integer> keys = new HashSet<>();

	public GlobalMouseClickListener(Map<Integer, JLabel> mapping, JTextArea jtaLog) {
		this.mapping = mapping;
		this.jtaLog = jtaLog;
	}

	private String toPressedString() {
		Calendar calendar = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append(this.sdf.format(calendar.getTime()));
		sb.append(" - Mouse - ");
		List<String> buttons = new ArrayList<>();
		for (Integer button : this.keys) {
			if (this.mapping.containsKey(button)) {
				JLabel jlabel = this.mapping.get(button);
				jlabel.setOpaque(true);
				jlabel.repaint();
				buttons.add(jlabel.getText());
			}
			button = -button;
			if (this.mapping.containsKey(button)) {
				JLabel jlabel = this.mapping.get(button);
				jlabel.setOpaque(true);
				jlabel.repaint();
			}
		}
		String string = buttons.toString();
		sb.append(string.substring(1, string.length() - 1));
		string = sb.toString();
		System.out.println(string);
		return string;
	}

	private void changePressedReleased() {
		for (Integer button : this.mapping.keySet()) {
			JLabel jlabel = this.mapping.get(button);
			jlabel.setOpaque(false);
			jlabel.repaint();
		}
		String string = this.toPressedString();
		try {
			StringBuilder sb = new StringBuilder(this.jtaLog.getText());
			sb.insert(0, string + "\r\n");
			this.jtaLog.setText(sb.toString().trim());
		} catch (Exception ex) {
		}
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) {
		int key = e.getButton();
		this.keys.add(key);
		this.changePressedReleased();
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e) {
		int button = e.getButton();
		this.keys.remove(button);
		this.changePressedReleased();
	}
}
