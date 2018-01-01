
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JButtonExportListener implements ActionListener {

	private JFrame jframeHost;
	private JTextArea jtaLog;

	public JButtonExportListener(JFrame jframeHost, JTextArea jtaLog) {
		this.jframeHost = jframeHost;
		this.jtaLog = jtaLog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfcFile = new JFileChooser(new File("."));
		if (jfcFile.showSaveDialog(this.jframeHost) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = jfcFile.getSelectedFile();
				boolean canWrite = true;
				if (file.exists()) {
					canWrite = (JOptionPane.showConfirmDialog(this.jframeHost, "Replace \"" + file.getAbsolutePath() + "\" ?", "Warning", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION);
				}
				if (canWrite) {
					FileOutputStream fos = new FileOutputStream(jfcFile.getSelectedFile());
					fos.write(this.jtaLog.getText().getBytes("UTF-8"));
					fos.close();
				}
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this.jframeHost, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
