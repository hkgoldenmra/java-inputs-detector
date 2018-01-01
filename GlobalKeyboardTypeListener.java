
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyboardTypeListener implements NativeKeyListener {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private Map<Integer, JLabel> mapping;
	private JTextArea jtaLog;
	private Set<Integer> keys = new HashSet<>();

	public GlobalKeyboardTypeListener(Map<Integer, JLabel> mapping, JTextArea jtaLog) {
		this.mapping = mapping;
		this.jtaLog = jtaLog;
	}

	private String toPressedString() {
		Calendar calendar = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append(this.sdf.format(calendar.getTime()));
		sb.append(" - Keyboard - ");
		List<String> buttons = new ArrayList<>();
		for (Integer key : this.keys) {
			if (this.mapping.containsKey(key)) {
				JLabel jlabel = this.mapping.get(key);
				jlabel.setOpaque(true);
				jlabel.repaint();
				buttons.add(jlabel.getText());
			}
			key = -key;
			if (this.mapping.containsKey(key)) {
				JLabel jlabel = this.mapping.get(key);
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
		for (Integer keyCode : this.mapping.keySet()) {
			JLabel jlabel = this.mapping.get(keyCode);
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
	public void nativeKeyPressed(NativeKeyEvent e) {
		int key = e.getKeyCode();
		this.keys.add(key);
		this.changePressedReleased();
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		int key = e.getKeyCode();
		this.keys.remove(key);
		this.changePressedReleased();
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
	}
}
