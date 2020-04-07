
public class Cypher {
	static final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	static char letter;
	static int letterIn;
	
	

	static String encrypt(String wordIn,String wordOut,int key){
		for(int i=0;i<wordIn.length();i++) {
			letter=wordIn.charAt(i);
			
			if(letter==' '||letter=='.'||letter==','||letter=='?'||letter=='\''||letter==';'||letter=='!'||letter=='('||letter==')'||letter=='-') {
				wordOut+=letter;
			}
			else {
				for(int i1=0;letter!=alphabet[i1];) {
					i1++;
					letterIn=i1;
				}
				int letterOut=letterIn+key;
				letterIn=0;
				while(letterOut>25) {
					letterOut-=26;
				}
				
				wordOut+=alphabet[letterOut];
			}
			
		}
		return wordOut;
	}
	
	static String decrypt(String wordIn,String wordOut,int key){
		for(int i=0;i<wordIn.length();i++) {
			letter=wordIn.charAt(i);
			
			if(letter==' '||letter=='.'||letter==','||letter=='?'||letter=='\''||letter==';'||letter=='!'||letter=='('||letter==')'||letter=='-') {
				wordOut+=letter;
			}
			else {
				for(int i1=0;letter!=alphabet[i1];) {
					i1++;
					letterIn=i1;
				}
				
				int letterOut=letterIn-key;
				letterIn=0;
				while(letterOut<0) {
					letterOut+=26;
				}
				
				wordOut+=alphabet[letterOut];
			}
		}
		return wordOut;
	}
	
	Cypher(){
	}
	
}


