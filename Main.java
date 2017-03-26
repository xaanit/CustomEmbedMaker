package me.xaanit.customembedmaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws Exception {
		String authorurl, authorname, title, color, authoricon, thumbnail, footertext, footericon, titleurl;
		authorurl = authorname = title = color = authoricon = thumbnail = footertext = footericon = titleurl = "";

		int curr = 0;
		List<Field> fields = new ArrayList<Field>();
		JOptionPane.showMessageDialog(null,
				"Welcome to the Auxilium customembed helper. Exit out of the \"option\" box at any time to exit the program entirely.");
		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in a colour?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			color = JOptionPane.showInputDialog(
					"Please enter in a valid hex code. This link might help: https://www.w3schools.com/colors/colors_picker.asp");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in an Author Icon?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			authoricon = JOptionPane.showInputDialog("Please enter in the link to a valid picture");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in an Author Name?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			authorname = JOptionPane.showInputDialog("Please enter in a name");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in an author URL?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			authorurl = JOptionPane.showInputDialog("Please enter in a valid URL");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in a title?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			title = JOptionPane.showInputDialog("Pleas enter in a title");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in a title URL?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			titleurl = JOptionPane.showInputDialog("Please enter in a valid URL");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in a thumbnail?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			thumbnail = JOptionPane.showInputDialog("Please enter in a valid picture URL");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in a footer icon?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			footericon = JOptionPane.showInputDialog("Please enter in a valid picture URL");
		}

		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in footer text?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			footertext = JOptionPane.showInputDialog("Please enter in some text");
		}
		curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in fields?", "Option", 0);
		if (curr == -1) {
			System.exit(0);
		} else if (curr == 0) {
			boolean done = false;
			while (!done) {
				curr = JOptionPane.showConfirmDialog(null, "Would you like to enter in another field?", "Option", 0);
				if (curr == 1) {
					done = true;
				} else {
					Field f = new Field();
					f.setTitle(JOptionPane.showInputDialog("Please enter in the field title."));
					f.setValue(JOptionPane.showInputDialog("Please enter in the field text."));
					fields.add(f);
				}
			}
		}

		String res = "";
		if (!color.equals(""))
			res += "{Color:" + color + "} ";
		if (!authoricon.equals(""))
			res += "{AuthorIcon:" + authoricon + "} ";
		if (!authorname.equals(""))
			res += "{AuthorName:" + authorname + "} ";
		if (!authorurl.equals(""))
			res += "{AuthorURL:" + authorurl + "} ";
		if (!title.equals(""))
			res += "{Title:" + title + "} ";
		if (!titleurl.equals(""))
			res += "{TitleURL:" + titleurl + "} ";
		if (!thumbnail.equals(""))
			res += "{Thumbnail:" + thumbnail + "} ";
		if (!footericon.equals(""))
			res += "{FooterIcon:" + footericon + "} ";
		if (!footertext.equals(""))
			res += "{FooterText:" + footertext + "} ";
		for (Field f : fields) {
			res += "{FieldTitle:" + f.getTitle() + " FieldText:" + f.getValue() + "} ";
		}
		File file = new File(System.getProperty("user.dir") + "\\customembed.txt");
		if(!file.exists())
			file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(res);
		JOptionPane.showMessageDialog(null, "File created with the code for your custom embed at " + file.getAbsolutePath());
	}

}
