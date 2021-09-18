package sub;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class CreateCookieValue {
	public String CreateValue() {
		
		UUID tmp = UUID.randomUUID();
		
		return tmp.toString();
	}
}
	

