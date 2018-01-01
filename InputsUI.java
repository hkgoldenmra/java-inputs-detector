
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeSystem.Family;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

public class InputsUI {

	public static final int VC_RSHIFT = 3638;
	public static final int VC_NUM_MINUS = 3658;
	public static final int VC_NUM_PLUS = 3662;
	public static final int VC_RALT = -NativeKeyEvent.VC_ALT;
	public static final int VC_RCONTROL = -NativeKeyEvent.VC_CONTROL;
	public static final int VC_NUM_DIVIDE = -NativeKeyEvent.VC_SLASH;
	private Map<Integer, JLabel> jlabelKeyboard = new HashMap<>();
	private Map<Integer, JLabel> jlabelMouse = new HashMap<>();
	private JTextArea jtaLog = new JTextArea();

	public InputsUI() {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
		}
		Family family = org.jnativehook.NativeSystem.getFamily();
		GlobalScreen.addNativeKeyListener(new GlobalKeyboardTypeListener(this.jlabelKeyboard, this.jtaLog));
		GlobalScreen.addNativeMouseListener(new GlobalMouseClickListener(this.jlabelMouse, this.jtaLog));
		int jframeX = 100;
		int jframeY = 100;
		Font defaultFont = new Font("Serif", Font.BOLD, 12);
		Font singleFont = new Font("Serif", Font.BOLD, 20);
		Font doubleFont = new Font("Serif", Font.BOLD, 16);

		//<editor-fold defaultstate="collapsed" desc="initial keyboard labels">
		this.jlabelKeyboard.put(NativeKeyEvent.VC_ESCAPE, new JLabel("Esc"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F1, new JLabel("F1"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F2, new JLabel("F2"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F3, new JLabel("F3"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F4, new JLabel("F4"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F5, new JLabel("F5"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F6, new JLabel("F6"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F7, new JLabel("F7"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F8, new JLabel("F8"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F9, new JLabel("F9"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F10, new JLabel("F10"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F11, new JLabel("F11"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F12, new JLabel("F12"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_BACKQUOTE, new JLabel("`"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_1, new JLabel("1"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_2, new JLabel("2"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_3, new JLabel("3"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_4, new JLabel("4"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_5, new JLabel("5"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_6, new JLabel("6"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_7, new JLabel("7"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_8, new JLabel("8"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_9, new JLabel("9"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_0, new JLabel("0"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_MINUS, new JLabel("-"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_EQUALS, new JLabel("="));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_BACKSPACE, new JLabel("Backspace"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_INSERT, new JLabel("Ins"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_HOME, new JLabel("Hom"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_PAGE_UP, new JLabel("P Up"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_NUM_LOCK, new JLabel("N LK"));
		this.jlabelKeyboard.put(InputsUI.VC_NUM_DIVIDE, new JLabel("/"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_PRINTSCREEN, new JLabel("*"));
		this.jlabelKeyboard.put(InputsUI.VC_NUM_MINUS, new JLabel("-"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_TAB, new JLabel("Tab"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_Q, new JLabel("q"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_W, new JLabel("w"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_E, new JLabel("e"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_R, new JLabel("r"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_T, new JLabel("t"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_Y, new JLabel("y"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_U, new JLabel("u"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_I, new JLabel("i"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_O, new JLabel("o"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_P, new JLabel("p"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_OPEN_BRACKET, new JLabel("["));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_CLOSE_BRACKET, new JLabel("]"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_BACK_SLASH, new JLabel("\\"));

		this.jlabelKeyboard.put(-NativeKeyEvent.VC_7, new JLabel("7"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_HOME, this.jlabelKeyboard.get(-NativeKeyEvent.VC_7));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_8, new JLabel("8"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_UP, this.jlabelKeyboard.get(-NativeKeyEvent.VC_8));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_9, new JLabel("9"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_PAGE_UP, this.jlabelKeyboard.get(-NativeKeyEvent.VC_9));
		this.jlabelKeyboard.put(InputsUI.VC_NUM_PLUS, new JLabel("+"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_DELETE, new JLabel("Del"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_END, new JLabel("End"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_PAGE_DOWN, new JLabel("P Dn"));
//
		this.jlabelKeyboard.put(NativeKeyEvent.VC_CAPS_LOCK, new JLabel("CapsLK"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_A, new JLabel("a"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_S, new JLabel("s"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_D, new JLabel("d"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_F, new JLabel("f"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_G, new JLabel("g"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_H, new JLabel("h"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_J, new JLabel("j"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_K, new JLabel("k"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_L, new JLabel("l"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_SEMICOLON, new JLabel(";"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_QUOTE, new JLabel("'"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_ENTER, new JLabel("Enter"));

		this.jlabelKeyboard.put(-NativeKeyEvent.VC_4, new JLabel("4"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_LEFT, this.jlabelKeyboard.get(-NativeKeyEvent.VC_4));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_5, new JLabel("5"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_CLEAR, this.jlabelKeyboard.get(-NativeKeyEvent.VC_5));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_6, new JLabel("6"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_RIGHT, this.jlabelKeyboard.get(-NativeKeyEvent.VC_6));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_SHIFT, new JLabel("Shift"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_Z, new JLabel("z"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_X, new JLabel("x"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_C, new JLabel("c"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_V, new JLabel("v"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_B, new JLabel("b"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_N, new JLabel("n"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_M, new JLabel("m"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_COMMA, new JLabel(","));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_PERIOD, new JLabel("."));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_SLASH, new JLabel("/"));
		this.jlabelKeyboard.put(InputsUI.VC_RSHIFT, new JLabel("Shift"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_UP, new JLabel(String.format("%c", (char) 8593)));

		this.jlabelKeyboard.put(-NativeKeyEvent.VC_1, new JLabel("1"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_END, this.jlabelKeyboard.get(-NativeKeyEvent.VC_1));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_2, new JLabel("2"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_DOWN, this.jlabelKeyboard.get(-NativeKeyEvent.VC_2));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_3, new JLabel("3"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_PAGE_DOWN, this.jlabelKeyboard.get(-NativeKeyEvent.VC_3));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_ENTER, new JLabel("Ent"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_CONTROL, new JLabel("Ctrl"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_META, new JLabel("Meta"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_ALT, new JLabel("Alt"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_SPACE, new JLabel("Space"));
		this.jlabelKeyboard.put(InputsUI.VC_RALT, new JLabel("Alt"));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_CONTEXT_MENU, new JLabel("Menu"));
		this.jlabelKeyboard.put(InputsUI.VC_RCONTROL, new JLabel("Ctrl"));

		this.jlabelKeyboard.put(NativeKeyEvent.VC_LEFT, new JLabel(String.format("%c", (char) 8592)));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_DOWN, new JLabel(String.format("%c", (char) 8595)));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_RIGHT, new JLabel(String.format("%c", (char) 8594)));

		this.jlabelKeyboard.put(-NativeKeyEvent.VC_0, new JLabel("0"));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_INSERT, this.jlabelKeyboard.get(-NativeKeyEvent.VC_0));
		this.jlabelKeyboard.put(NativeKeyEvent.VC_SEPARATOR, new JLabel("."));
		this.jlabelKeyboard.put(-NativeKeyEvent.VC_DELETE, this.jlabelKeyboard.get(NativeKeyEvent.VC_SEPARATOR));
		//</editor-fold>

		//<editor-fold defaultstate="collapsed" desc="set keyboard label layout">
		for (Integer keyCode : this.jlabelKeyboard.keySet()) {
			JLabel jlabel = this.jlabelKeyboard.get(keyCode);
			jlabel.setForeground(Color.BLACK);
			jlabel.setBackground(Color.RED);
			String text = jlabel.getText();
			if (text.length() == 1) {
				jlabel.setFont(singleFont);
			} else if (text.matches("^(F[0-9]{1,2})|((Tab)|(CapsLK)|(Shift)|(Enter)|(Ctrl)|(Meta)|(Alt)|(Space)|(Menu))$")) {
				jlabel.setFont(doubleFont);
			} else {
				jlabel.setFont(defaultFont);
			}
			jlabel.setHorizontalAlignment(JLabel.CENTER);
			jlabel.setVerticalAlignment(JLabel.CENTER);
			jlabel.setBorder(BorderFactory.createLineBorder(jlabel.getForeground(), 1));
		}
		//</editor-fold>

		//<editor-fold defaultstate="collapsed" desc="set keyboard labels position">
		int standardWidth = 40;
		int functionWidth = standardWidth * 11 / 8;
		int largerWidth = standardWidth * 3 / 2 + 2;
		int doubleWidth = standardWidth * 2 + 5;
		int moreLargerWidth = standardWidth * 5 / 2 + 7;
		int spaceWidth = standardWidth * 31 / 4;
		int standardHeight = 40;
		int spacing = 5;

		int width = 0;
		int height = 0;
		int x = spacing;
		int y = spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_ESCAPE).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 9;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F1).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F2).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F3).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F4).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 6;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F5).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F6).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F7).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F8).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 6;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F9).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F10).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F11).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F12).setBounds(x, y, standardWidth, standardHeight);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);

		x = spacing;
		y += standardHeight + spacing * 3;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_BACKQUOTE).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_1).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_2).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_3).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_4).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_5).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_6).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_7).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_8).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_9).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_0).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_MINUS).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_EQUALS).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_BACKSPACE).setBounds(x, y, doubleWidth, standardHeight);
		x += doubleWidth + spacing * 3;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_INSERT).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_HOME).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_PAGE_UP).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 3;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_NUM_LOCK).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_NUM_DIVIDE).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_PRINTSCREEN).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_NUM_MINUS).setBounds(x, y, standardWidth, standardHeight);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);

		x = spacing;
		y += standardHeight + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_TAB).setBounds(x, y, largerWidth, standardHeight);
		x += largerWidth + spacing + 1;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_Q).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_W).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_E).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_R).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_T).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_Y).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_U).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_I).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_O).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_P).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_OPEN_BRACKET).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_CLOSE_BRACKET).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_BACK_SLASH).setBounds(x, y, largerWidth, standardHeight);
		x += largerWidth + spacing * 3;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_DELETE).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_END).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_PAGE_DOWN).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 3;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_7).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_8).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_9).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_NUM_PLUS).setBounds(x, y, standardWidth, standardHeight * 2 + spacing);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);

		x = spacing;
		y += standardHeight + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_CAPS_LOCK).setBounds(x, y, doubleWidth, standardHeight);
		x += doubleWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_A).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_S).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_D).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_F).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_G).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_H).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_J).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_K).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_L).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_SEMICOLON).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_QUOTE).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_ENTER).setBounds(x, y, doubleWidth, standardHeight);
		x += doubleWidth + standardWidth * 3 + spacing * 8;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_4).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_5).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_6).setBounds(x, y, standardWidth, standardHeight);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);

		x = spacing;
		y += standardHeight + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_SHIFT).setBounds(x, y, moreLargerWidth, standardHeight);
		x += moreLargerWidth + spacing + 1;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_Z).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_X).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_C).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_V).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_B).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_N).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_M).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_COMMA).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_PERIOD).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_SLASH).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_RSHIFT).setBounds(x, y, moreLargerWidth, standardHeight);
		x += moreLargerWidth + standardWidth + spacing * 4;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_UP).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth * 2 + spacing * 4;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_1).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_2).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_3).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_ENTER).setBounds(x, y, standardWidth, standardHeight * 2 + spacing);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);

		x = spacing;
		y += standardHeight + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_CONTROL).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_META).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_ALT).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_SPACE).setBounds(x, y, spaceWidth, standardHeight);
		x += spaceWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_RALT).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_CONTEXT_MENU).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing;
		this.jlabelKeyboard.get(InputsUI.VC_RCONTROL).setBounds(x, y, functionWidth, standardHeight);
		x += functionWidth + spacing * 3;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_LEFT).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_DOWN).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_RIGHT).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing * 3;
		this.jlabelKeyboard.get(-NativeKeyEvent.VC_0).setBounds(x, y, doubleWidth, standardHeight);
		x += doubleWidth + spacing;
		this.jlabelKeyboard.get(NativeKeyEvent.VC_SEPARATOR).setBounds(x, y, standardWidth, standardHeight);
		width = Math.max(width, x + standardWidth);
		height = Math.max(height, y + standardHeight);
		//</editor-fold>

		JFrame jframeKeyboard = new JFrame("Java Keyboard Detector");
		jframeKeyboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeKeyboard.setLayout(null);
		jframeKeyboard.setBounds(jframeX, jframeY, width + spacing + 5, height + spacing + 30);
		for (Integer keyCode : this.jlabelKeyboard.keySet()) {
			jframeKeyboard.add(this.jlabelKeyboard.get(keyCode));
		}

		//<editor-fold defaultstate="collapsed" desc="initial mouse labels">
		this.jlabelMouse.put(NativeMouseEvent.BUTTON1, new JLabel("L"));
		this.jlabelMouse.put(family.name().equals(Family.WINDOWS.name()) ? NativeMouseEvent.BUTTON3 : NativeMouseEvent.BUTTON2, new JLabel("M"));
		this.jlabelMouse.put(family.name().equals(Family.WINDOWS.name()) ? NativeMouseEvent.BUTTON2 : NativeMouseEvent.BUTTON3, new JLabel("R"));
		//</editor-fold>

		//<editor-fold defaultstate="collapsed" desc="set mouse labels layout">
		for (Integer keyCode : this.jlabelMouse.keySet()) {
			JLabel jlabel = this.jlabelMouse.get(keyCode);
			jlabel.setForeground(Color.BLACK);
			jlabel.setBackground(Color.RED);
			String text = jlabel.getText();
			if (text.length() == 1) {
				jlabel.setFont(singleFont);
			} else if (text.matches("^(F[0-9]{1,2})|((Tab)|(CapsLK)|(Shift)|(Enter)|(Ctrl)|(Meta)|(Alt)|(Space)|(Menu))$")) {
				jlabel.setFont(doubleFont);
			} else {
				jlabel.setFont(defaultFont);
			}
			jlabel.setHorizontalAlignment(JLabel.CENTER);
			jlabel.setVerticalAlignment(JLabel.CENTER);
			jlabel.setBorder(BorderFactory.createLineBorder(jlabel.getForeground(), 1));
		}
		//</editor-fold>

		//<editor-fold defaultstate="collapsed" desc="set mouse labels postion">
		x = spacing;
		y = spacing;
		this.jlabelMouse.get(NativeMouseEvent.BUTTON1).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelMouse.get(family.name().equals(Family.WINDOWS.name()) ? NativeMouseEvent.BUTTON3 : NativeMouseEvent.BUTTON2).setBounds(x, y, standardWidth, standardHeight);
		x += standardWidth + spacing;
		this.jlabelMouse.get(family.name().equals(Family.WINDOWS.name()) ? NativeMouseEvent.BUTTON2 : NativeMouseEvent.BUTTON3).setBounds(x, y, standardWidth, standardHeight);
		//</editor-fold>

		JFrame jframeMouse = new JFrame("Java Mouse Detector");
		jframeMouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeMouse.setLayout(null);
		jframeMouse.setBounds(jframeX, jframeY, x + functionWidth + spacing + 5, y + standardWidth + spacing + 30);
		for (Integer keyCode : this.jlabelMouse.keySet()) {
			jframeMouse.add(this.jlabelMouse.get(keyCode));
		}

		width = 640;
		height = 120;
		this.jtaLog.setForeground(Color.BLACK);
		this.jtaLog.setBackground(Color.WHITE);
		this.jtaLog.setFont(new Font("courier", Font.PLAIN, 12));
		this.jtaLog.setBorder(BorderFactory.createLineBorder(this.jtaLog.getForeground(), 1));
		this.jtaLog.setEditable(false);
		this.jtaLog.setBounds(0, 0, width, height);

		x = spacing;
		y = spacing;
		JScrollPane jspLog = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspLog.setBounds(x, y, width, height);
		jspLog.setViewportView(this.jtaLog);

		y = height + spacing;
		JButton jbnExport = new JButton("Export");
		jbnExport.setFont(new Font("courier", Font.PLAIN, 12));
		jbnExport.setMargin(new Insets(2, 2, 2, 2));
		jbnExport.setBounds(x, y, 60, 30);

		JFrame jframeLog = new JFrame("Java Inputs Log");
		jframeLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeLog.setLayout(null);
		jframeLog.setBounds(jframeX, jframeY, x + width + spacing + 5, y + spacing + 60);
		jframeLog.add(jspLog);
		jframeLog.add(jbnExport);

		jbnExport.addActionListener(new JButtonExportListener(jframeLog, this.jtaLog));

		jframeKeyboard.setVisible(true);
		jframeMouse.setVisible(true);
		jframeLog.setVisible(true);
	}

	public static void main(String[] args) {
		new InputsUI();
	}
}
