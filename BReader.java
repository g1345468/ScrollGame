import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class BReader {

    BufferedReader br;

    BReader(String fileName) {
	try {
	    FileInputStream fis = new FileInputStream(fileName);
	    InputStreamReader ir = new InputStreamReader(fis , "UTF-8");
	    br = new BufferedReader(ir);
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
    
    String readLine() {
	try { 
	    return br.readLine();
	} catch(IOException e) {
	    e.printStackTrace();
	    return null;
	}
    }
    
}
