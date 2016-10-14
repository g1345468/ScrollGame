import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileWriter;

public class BWriter {

    FileOutputStream fos;
    OutputStreamWriter ow;
    BufferedWriter bw;

    FileWriter fw;

    BWriter(String fileName) {
	try {
	    File file = new File(fileName);
	    fw = new FileWriter(file);
	    bw = new BufferedWriter(fw);

	    /*
	    fos = new FileOutputStream(fileName);
	    ow = new OutputStreamWriter(fos , "UTF-8");
	    bw = new BufferedWriter(ow);
	    */
	    
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
    
    void write(String string) {
	try { 
	    bw.write(string);
	    bw.newLine();
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }

    void close() {
	try {

	    bw.close();
	    fw.close();
	    /*
	    bw.close();
	    ow.close();
	    fos.close();
	    */
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
    
}
